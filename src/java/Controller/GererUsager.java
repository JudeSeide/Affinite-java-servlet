package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 * @author Emmanuel FANGUE FANE31078301
 * @author Justin Fotue KAMGA FOTJ23097901
 * @author Jude SEIDE SEIJ04019006
 */
public class GererUsager extends HttpServlet {

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

        String email = request.getParameter(CreateUser.CHAMP_EMAIL);
        String nom = request.getParameter(CreateUser.CHAMP_NOM);
        String prenom = request.getParameter(CreateUser.CHAMP_PRENOM);
        String tel = request.getParameter(CreateUser.CHAMP_TEL);
        String pass = request.getParameter(CreateUser.CHAMP_MOTDEPASS);
        String photo = request.getParameter(CreateUser.CHAMP_PHOTO);
        String pays = request.getParameter(CreateUser.CHAMP_PAYS);
        String province = request.getParameter(CreateUser.CHAMP_PROVINCE);
        String ville = request.getParameter(CreateUser.CHAMP_VILLE);
        String municipalite = request.getParameter(CreateUser.CHAMP_MUNICIPALITE);
        String rue = request.getParameter(CreateUser.CHAMP_RUE);
        String codeP = request.getParameter(CreateUser.CHAMP_CODEPOSTAL);
        String role = request.getParameter(CreateUser.CHAMP_ROLE);

        User user = new User(); // l'utlisateur a chercher
        user.setNom(nom);
        user.setPrenom(prenom);
        user.setTelephone(tel);
        user.setCourriel(email);
        user.setMot_de_passe(pass);
        user.setPhoto(photo);
        user.setPays(pays);
        user.setProvince(province);
        user.setVille(ville);
        user.setMunicipalite(municipalite);
        user.setRue(rue);
        user.setCodePostal(codeP);
        user.setRole(role);

        //CreateUser.chargeUsers();
        if (CreateUser.usagers.contains(user)) {
            CreateUser.usagers.remove(user);
            CreateUser.usagers.add(user);
            CreateUser.saveUsers();
        } else {
            CreateUser.usagers.add(user);
            CreateUser.saveUsers();
        }

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
