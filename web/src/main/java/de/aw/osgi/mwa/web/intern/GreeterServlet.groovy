package de.aw.osgi.mwa.web.intern

import de.aw.osgi.mwa.endpoint.registry.Endpoint

import javax.servlet.ServletException
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * @author armin.weisser
 */
public class GreeterServlet extends HttpServlet {

    Endpoint endpoint;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String input = req.getRequestURI() - (req.getServletPath() + "/");
        String salutation = endpoint.handle(input);
        resp.getWriter().write(salutation);
    }
}
