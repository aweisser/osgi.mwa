package de.aw.osgi.mwa.web.intern;

import de.aw.osgi.mwa.endpoint.registry.Endpoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author armin.weisser
 */
public class GreeterServlet extends HttpServlet {

    private Endpoint<String, String> greeterEndpoint;

    public void setEndpoint(Endpoint greeterEndpoint) {
        this.greeterEndpoint = greeterEndpoint;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String input = req.getRequestURI().replaceFirst(req.getServletPath() + "/", "");
        String salutation = greeterEndpoint.handle(input);
        resp.getWriter().write(salutation);
    }
}
