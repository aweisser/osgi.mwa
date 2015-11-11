package de.aw.osgi.mwa.greeter.intern;

import de.aw.osgi.mwa.greeter.Greeter;
import org.apache.felix.ipojo.annotations.*;
import org.osgi.service.log.LogService;

import static org.osgi.service.log.LogService.LOG_INFO;

/**
 * @author armin.weisser
 */
@Component
@Instantiate
@Provides
public class FriendlyGreeter implements Greeter {


    @Requires private LogService logger;

    public String greet(String name) {
        return "Hello "+name+". Good to see you =)";
    }

    @Validate
    public void starting() {
        System.out.println("FriendlyGreeter is online via iPojo");
        logger.log(LOG_INFO, "FriendlyGreeter is online via iPojo");
    }

    @Invalidate
    public void stopping() {
        System.out.println("FriendlyGreeter is offline via iPojo");
        logger.log(LOG_INFO, "FriendlyGreeter is offline via iPojo");
    }

}
