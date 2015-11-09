package de.aw.osgi.mwa.greeter.intern;

import org.apache.felix.ipojo.annotations.*;
import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;

import static org.osgi.service.log.LogService.*;

/**
 * @author armin.weisser
 */
@Component
@Instantiate
public class GreeterService { //implements BundleActivator {

    @Requires
    private LogService logger;

    /**
     * Implements BundleActivator.start().
     * @param bundleContext - the framework context for the bundle.
     **/
    public void start(BundleContext bundleContext) {
        logger.log(LOG_INFO, "Greeter Service is online");
    }

    @Validate
    public void starting() {
        System.out.println("Greeter Service is online via via iPojo");
        logger.log(LOG_INFO, "Greeter Service is online via iPojo");
    }

    /**
     * Implements BundleActivator.stop()
     * @param bundleContext - the framework context for the bundle.
     **/
    public void stop(BundleContext bundleContext) {
        logger.log(LOG_INFO, "Greeter Service is offline");
    }

    @Invalidate
    public void stopping() {
        System.out.println("Greeter Service is offline via via iPojo");
        logger.log(LOG_INFO, "Greeter Service is offline via iPojo");
    }
}

