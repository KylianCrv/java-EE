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

    private final Distributeur distributeur = Distributeur.getInstance();

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

        setDistributorAttributes(request);

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

        addCredit(request);
        buyProduct(request);
        setDistributorAttributes(request);
        this.getServletContext().getRequestDispatcher("/WEB-INF/distributeur.jsp").forward(request, response);
    }

    private void addCredit(HttpServletRequest request) {

        String addCredit = request.getParameter("addCredit");

        if (addCredit == null) {
            return;
        }

        int amount = Integer.parseInt(addCredit);

        distributeur.insererArgent(amount);
    }

    private void buyProduct(HttpServletRequest request) {
        String productId = request.getParameter("productId");
        if (productId == null || "".equals(productId)) {
            return;
        }
        distributeur.commanderProduit(Integer.parseInt(productId));

    }

    private void setDistributorAttributes(HttpServletRequest request) {
        request.setAttribute("stock", distributeur.getStock());
        request.setAttribute("credit", distributeur.getCredit());
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
