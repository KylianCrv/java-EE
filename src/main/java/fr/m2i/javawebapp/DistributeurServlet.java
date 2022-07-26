package fr.m2i.javawebapp;

import distributeur.Distributeur;
import distributeur.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DistributeurServlet extends HttpServlet {

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

        Distributeur distributeur = Distributeur.getInstance();

        request.setAttribute("stock", distributeur.getStock());
        request.setAttribute("credit", distributeur.getCredit());

        this.getServletContext().getRequestDispatcher("/WEB-INF/distributeur.jsp").forward(request, response);
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

        Distributeur distributeur = Distributeur.getInstance();

        if (request.getParameter("addOneCredit") != null) {
            distributeur.insererArgent(1);
        }

        if (request.getParameter("addTwoCredit") != null) {
            distributeur.insererArgent(2);
        }

        if (request.getParameter("buyProduct") != null) {
            distributeur.commanderProduit(Integer.parseInt(request.getParameter("idProduct")));
        }

        request.setAttribute("stock", distributeur.getStock());
        request.setAttribute("credit", distributeur.getCredit());

        this.getServletContext().getRequestDispatcher("/WEB-INF/distributeur.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
