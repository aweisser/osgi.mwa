package de.aw.osgi.mwa.web.intern;

import de.aw.osgi.mwa.greeter.Greeter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author armin.weisser
 */
public class GreeterServlet extends HttpServlet {

    private Greeter greeter;

    public void setGreeter(Greeter greeter) {
        this.greeter = greeter;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String input = req.getRequestURI() - (req.getServletPath() + "/");
        String salutation = greeter.greet(input);
        resp.getWriter().write(salutation);
    }
}
