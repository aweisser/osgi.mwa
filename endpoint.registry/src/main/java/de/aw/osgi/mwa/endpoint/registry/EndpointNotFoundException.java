package de.aw.osgi.mwa.endpoint.registry;

/**
 * @author armin.weisser
 */
public class EndpointNotFoundException extends Exception {

    public EndpointNotFoundException(String alias) {
        super("No Endpoint for found for alias "+alias);
    }
}
