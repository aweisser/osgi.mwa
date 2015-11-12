package de.aw.osgi.mwa.endpoint.greet.intern;


import de.aw.osgi.mwa.endpoint.registry.Endpoint;
import de.aw.osgi.mwa.greeter.Greeter;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Requires;

import java.rmi.RemoteException;

/**
 * @author armin.weisser
 */
@Component
@Provides
public class GreetEndpoint implements Endpoint {

    @Requires
    Greeter greeter;

    @Override
    public String getAlias() {
        return "greet";
    }

    @Override
    public Object handle(Object input) {
        return null;
    }
}
