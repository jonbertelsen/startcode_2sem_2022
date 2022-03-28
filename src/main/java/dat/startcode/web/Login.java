package dat.startcode.web;

import dat.startcode.config.ApplicationStart;
import dat.startcode.entities.Bruger;
import dat.startcode.exceptions.DatabaseException;
import dat.startcode.persistence.BrugerMapper;
import dat.startcode.persistence.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "login", urlPatterns = {"/login"} )
public class Login extends HttpServlet
{
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // Man burde ikke havne her med et GET-request, så derfor sende man tilbage til forsiden
        doPost(request, response);
        response.sendRedirect("index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.setAttribute("bruger", null); // sætter session variabel
        BrugerMapper brugerMapper = new BrugerMapper(connectionPool);
        Bruger bruger = null;
        String email = request.getParameter("email");
        String kodeord = request.getParameter("kodeord");

        try
        {
            bruger = brugerMapper.login(email, kodeord);
            session = request.getSession();
            session.setAttribute("bruger", bruger); // sætter session variabel
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    public void destroy()
    {

    }
}