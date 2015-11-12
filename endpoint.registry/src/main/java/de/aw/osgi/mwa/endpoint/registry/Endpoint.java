package de.aw.osgi.mwa.endpoint.registry;

/**
 * @author armin.weisser
 */
public interface Endpoint<IN, OUT> {

    String getAlias();

    OUT handle(IN input);

}
