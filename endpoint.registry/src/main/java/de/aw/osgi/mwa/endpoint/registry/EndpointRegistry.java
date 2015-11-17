package de.aw.osgi.mwa.endpoint.registry;

import java.util.Collection;

/**
 * @author armin.weisser
 */
public interface EndpointRegistry {

    Collection<Endpoint> list();

    boolean register(Endpoint endpoint);

    boolean unregister(Endpoint endpoint);

    Endpoint get(String alias) throws EndpointNotFoundException;
}
