package de.aw.osgi.mwa.endpoint.registry.intern;

import de.aw.osgi.mwa.endpoint.registry.Endpoint;
import de.aw.osgi.mwa.endpoint.registry.EndpointNotFoundException;
import de.aw.osgi.mwa.endpoint.registry.EndpointRegistry;
import org.apache.felix.ipojo.annotations.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author armin.weisser
 */
@Component
@Provides
@Instantiate
public class SimpleEndpointRegistry implements EndpointRegistry {

    private final Collection<Endpoint> registeredEndpoints = new HashSet<>();

    @Override
    public Collection<Endpoint> list() {
        return Collections.unmodifiableCollection(registeredEndpoints);
    }

    @Override
    @Bind(aggregate=true)
    public boolean register(Endpoint endpoint) {
        System.out.println("New endpoint registered: "+endpoint);
        return registeredEndpoints.add(endpoint);
    }

    @Override
    @Unbind
    public boolean unregister(Endpoint endpoint) {
        System.out.println("Endpoint removed: "+endpoint);
        return registeredEndpoints.remove(endpoint);
    }

    @Override
    public synchronized Endpoint get(String alias) {
        for(Endpoint endpoint: list()) {
            if(endpoint.getAlias().equals(alias)) {
                return endpoint;
            }
        }
        return null;
    }
}
