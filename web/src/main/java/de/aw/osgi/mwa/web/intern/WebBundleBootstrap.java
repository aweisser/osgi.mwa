package de.aw.osgi.mwa.web.intern;

import de.aw.osgi.mwa.endpoint.registry.EndpointRegistry;
import org.apache.felix.ipojo.annotations.*;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.osgi.service.log.LogService;

import javax.servlet.ServletException;

import static org.osgi.service.log.LogService.LOG_INFO;

/**
 * @author armin.weisser
 */
@Component
@Instantiate
public class WebBundleBootstrap {

    private static final String WEB_ALIAS = "/mwa";
    private static final String RELATIVE_DOCUMENT_ROOT = "/";

    @Requires
    private LogService logger;

    @Requires
    HttpService httpService;

    @Requires
    private EndpointRegistry endpointRegistry;

    @Validate
    public void starting() throws NamespaceException, ServletException {
        System.out.println("WebBundle is online via iPojo");
        logger.log(LOG_INFO, "WebBundle is online via iPojo");

        System.out.println("Registering static web resources to path " + WEB_ALIAS);
        httpService.registerResources(WEB_ALIAS, RELATIVE_DOCUMENT_ROOT, null);

        GreeterServlet greeterServlet = new GreeterServlet(endpointRegistry, "/greet");
        httpService.registerServlet(WEB_ALIAS + greeterServlet.getAlias(), greeterServlet, null, null);

    }

    @Invalidate
    public void stopping() {
        System.out.println("WebBundle is offline via iPojo");
        logger.log(LOG_INFO, "WebBundle is offline via iPojo");

        httpService.unregister(WEB_ALIAS);
        httpService.unregister(WEB_ALIAS+"/greet");
    }

}
