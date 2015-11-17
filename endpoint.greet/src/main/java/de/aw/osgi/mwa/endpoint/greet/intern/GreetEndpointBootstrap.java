package de.aw.osgi.mwa.endpoint.greet.intern;

import org.apache.felix.ipojo.annotations.*;

/**
 * @author armin.weisser
 */
@Component
@Instantiate
public class GreetEndpointBootstrap {

    @Validate
    public void starting() {
        System.out.println("GreetEndpoint is online");
    }

    @Invalidate
    public void stopping() {
        System.out.println("GreetEndpoint is offline.");
    }

}
