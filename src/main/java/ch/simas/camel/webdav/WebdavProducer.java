package ch.simas.camel.webdav;

import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;
import org.apache.camel.Endpoint;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;

public class WebdavProducer extends DefaultProducer {

    private final String host;
    private final String fileName;
    private final String charset;
    private final Sardine sardine;

    public WebdavProducer(Endpoint endpoint, String host, String username, String password, String fileName, String charset) {
        super(endpoint);
        this.host = host;
        sardine = SardineFactory.begin(username, password);
        this.fileName = fileName;
        this.charset = charset;
    }

    @Override
    public void process(Exchange exchng) throws Exception {
        String csv = (String) exchng.getIn().getBody();
        byte[] bytes = csv.getBytes(charset);
        
        String path = "https://" + host;
        
        // This is a because we need to authenticate before put
        sardine.list(path);
        
        sardine.put(path + "/" + fileName, bytes);
    }
}
