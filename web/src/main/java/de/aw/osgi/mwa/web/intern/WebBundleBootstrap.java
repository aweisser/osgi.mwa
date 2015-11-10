package de.aw.osgi.mwa.web.intern;

import de.aw.osgi.mwa.greeter.Greeter;
import org.apache.felix.ipojo.annotations.*;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.HttpService;
import org.osgi.service.http.NamespaceException;
import org.osgi.service.log.LogService;

import java.io.File;

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
    private Greeter greeter;

    @Validate
    public void starting() throws NamespaceException {
        System.out.println("WebBundle is online via iPojo");
        System.out.println(greeter.greet("WebBundle"));
        logger.log(LOG_INFO, "WebBundle is online via iPojo");

        System.out.println("Registering static web resources to path " + WEB_ALIAS);
        httpService.registerResources(WEB_ALIAS, RELATIVE_DOCUMENT_ROOT, null);
    }

    @Invalidate
    public void stopping() {
        System.out.println("WebBundle is offline via iPojo");
        logger.log(LOG_INFO, "WebBundle is offline via iPojo");

        httpService.unregister("/mwa");
    }

}
