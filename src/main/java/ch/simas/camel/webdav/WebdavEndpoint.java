package ch.simas.camel.webdav;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;

public class WebdavEndpoint extends DefaultEndpoint {

    private final String host;
    private String username;
    private String password;
    private String fileName;
    private String charset;

    protected WebdavEndpoint(String uri, String host, WebdavComponent component) {
        super(uri, component);
        this.host = host;
    }

    @Override
    public Producer createProducer() throws Exception {
        return new WebdavProducer(this, host, username, password, fileName, charset);
    }

    @Override
    public Consumer createConsumer(Processor prcsr) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

}
