package Controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Emmanuel FANGUE FANE31078301
 * @author Justin Fotue KAMGA FOTJ23097901
 * @author Jude SEIDE SEIJ04019006
 */
public class AjouterCategorie extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String categorie = request.getParameter("type");
        String mot1 = request.getParameter("mot1");
        String mot2 = request.getParameter("mot2");
        String mot3 = request.getParameter("mot3");
        String mot4 = request.getParameter("mot4");
        String mot5 = request.getParameter("mot5");
        String mot6 = request.getParameter("mot6");
        String mot7 = request.getParameter("mot7");
        String mot8 = request.getParameter("mot8");
        String mot9 = request.getParameter("mot9");
        String mot10 = request.getParameter("mot10");

        ArrayList<String> liste = new ArrayList<String>();

        liste.add(mot1);
        liste.add(mot2);
        liste.add(mot3);
        liste.add(mot4);
        liste.add(mot5);
        liste.add(mot6);
        liste.add(mot7);
        liste.add(mot8);
        liste.add(mot9);
        liste.add(mot10);

        InitialiserCategories.getInstance().getStockCategories().put(categorie, liste);
        InitialiserCategories.getInstance().saveCategory();

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        doPost(request, response);
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
        processRequest(request, response);
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
