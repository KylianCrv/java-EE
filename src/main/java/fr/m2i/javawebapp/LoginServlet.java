package fr.m2i.javawebapp;

import fr.m2i.javawebapp.session.User;
import static fr.m2i.javawebapp.session.UserDb.checkUser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (checkUser(email, password) != null) {

            request.setAttribute("errorMessage", null);
            HttpSession session = request.getSession();
            User user = checkUser(email, password);
            session.setAttribute("user", user);
            this.getServletContext().getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request, response);

        } else {

            request.setAttribute("errorMessage", "Une erreur est survenue lors de la connexion");
            this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
