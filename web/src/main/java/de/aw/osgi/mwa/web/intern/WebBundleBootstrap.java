package de.aw.osgi.mwa.web.intern;

import de.aw.osgi.mwa.greeter.Greeter;
import org.apache.felix.ipojo.annotations.*;
import org.osgi.service.log.LogService;

import static org.osgi.service.log.LogService.LOG_INFO;

/**
 * @author armin.weisser
 */
@Component
@Instantiate
public class WebBundleBootstrap {

    @Requires
    private LogService logger;

    @Requires
    private Greeter greeter;

    @Validate
    public void starting() {
        System.out.println("WebBundle is online via iPojo");
        System.out.println(greeter.greet("WebBundle"));
        logger.log(LOG_INFO, "WebBundle is online via iPojo");
    }

    @Invalidate
    public void stopping() {
        System.out.println("WebBundle is offline via iPojo");
        logger.log(LOG_INFO, "WebBundle is offline via iPojo");
    }

}
