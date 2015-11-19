package de.aw.osgi.mwa.endpoint.registry;

/**
 * @author armin.weisser
 */
public class EndpointNotFoundException extends Exception {

    private String alias;
    public EndpointNotFoundException(String alias) {
        super("No Endpoint for found for alias "+alias);
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
}
