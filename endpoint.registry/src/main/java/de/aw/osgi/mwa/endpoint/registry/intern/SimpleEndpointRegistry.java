package de.aw.osgi.mwa.endpoint.registry.intern;

import de.aw.osgi.mwa.endpoint.registry.Endpoint;
import de.aw.osgi.mwa.endpoint.registry.EndpointRegistry;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Provides;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author armin.weisser
 */
@Component
@Provides
public class SimpleEndpointRegistry implements EndpointRegistry {

    private Collection<Endpoint> registeredEndpoints = new HashSet<Endpoint>();

    @Override
    public Collection<Endpoint> list() {
        return registeredEndpoints;
    }

    @Override
    public boolean register(Endpoint endpoint) {
        return registeredEndpoints.add(endpoint);
    }

    @Override
    public boolean unregister(Endpoint endpoint) {
        return registeredEndpoints.remove(endpoint);
    }
}
