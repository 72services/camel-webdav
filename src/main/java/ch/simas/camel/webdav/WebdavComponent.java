package ch.simas.camel.webdav;

import java.util.Map;
import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

public class WebdavComponent extends DefaultComponent {

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected Endpoint createEndpoint(String uri, String remaining, Map parameters) throws Exception {
        return new WebdavEndpoint(uri, remaining, this);
    }

}
