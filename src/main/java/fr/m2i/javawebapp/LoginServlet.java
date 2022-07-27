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

        //on récup les param du form
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //on essaye de connecter le user avec les identifiants envoyés
        User user = checkUser(email, password);

        //si user == null => invalide + afficher message erreur
        if (user == null) {
            request.setAttribute("error", "Veuillez vérifier vos identifiants !");
            this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        //Je crée une nouvelle session avec le param true
        HttpSession session = request.getSession(true);
        //on stock l'user connecté
        session.setAttribute("user", user);

        this.getServletContext().getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request, response);
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
