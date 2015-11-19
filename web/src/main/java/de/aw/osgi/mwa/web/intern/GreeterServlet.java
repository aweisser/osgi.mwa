package de.aw.osgi.mwa.web.intern;

import de.aw.osgi.mwa.endpoint.registry.Endpoint;
import de.aw.osgi.mwa.endpoint.registry.EndpointRegistry;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.apache.felix.ipojo.annotations.Requires;
import org.codehaus.groovy.runtime.StringGroovyMethods;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author armin.weisser
 */
public class GreeterServlet extends HttpServlet {

    private final EndpointRegistry endpointRegistry;
    private final String alias;

    public GreeterServlet(EndpointRegistry endpointRegistry, String alias) {
        this.endpointRegistry = endpointRegistry;
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Endpoint endpoint = endpointRegistry.get(getAlias());
        if(endpoint != null) {
            String input = StringGroovyMethods.minus(req.getRequestURI(), (req.getServletPath() + "/"));
            String salutation = (String) endpoint.handle(input);
            resp.getWriter().write(salutation);
        } else {
            resp.getWriter().write("Sorry. The feature is currently not available");
        }
    }

}
