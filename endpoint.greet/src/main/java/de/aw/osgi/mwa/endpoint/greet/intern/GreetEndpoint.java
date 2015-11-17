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
@Instantiate
@Provides
public class GreetEndpoint implements Endpoint<String, String> {

    @Requires
    Greeter greeter;

    @Override
    public String getAlias() {
        return "/greet";
    }

    @Override
    public String handle(String name) {
        return greeter.greet(name);
    }

    @Override
    public String toString() {
        return "GreeterEnpoint at " + getAlias();
    }
}
