package Controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class CreateUser extends HttpServlet {

    public static final String CHAMP_NOM = "nom";
    public static final String CHAMP_PRENOM = "prenom";
    public static final String CHAMP_TEL = "telephone";
    public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_MOTDEPASS = "password";
    public static final String CHAMP_PHOTO = "photo";
    public static final String CHAMP_PAYS = "pays";
    public static final String CHAMP_PROVINCE = "province";
    public static final String CHAMP_VILLE = "ville";
    public static final String CHAMP_MUNICIPALITE = "municipalite";
    public static final String CHAMP_RUE = "numerorue";
    public static final String CHAMP_CODEPOSTAL = "codepostal";
    public static final String CHAMP_ROLE = "usager";

    public static String USER_JSON_PATH = "/home/spectro/Downloads/INF3005-TP1/web/WEB-INF/data/usager.json";

    public static List<User> usagers;
    private final String CHEMIN = "img";

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
       
       // USER_JSON_PATH = getServletContext().getRealPath("/WEB-INF/data/usager.json");
        
        String uploadFolder = getServletContext().getRealPath("")
                + File.separator + CHEMIN;

        User user = new User();

        SauverImage im = new SauverImage(request, CHAMP_PHOTO, uploadFolder);

        //String image = im.getTof();
        if (im.getNomFichier() != null) {
            user.setPhoto(im.getNomFichier());
        }

        //récupération des champs du formulaire
        user.setNom(request.getParameter(CHAMP_NOM));
        user.setPrenom(request.getParameter(CHAMP_PRENOM));
        user.setTelephone(request.getParameter(CHAMP_TEL));

        user.setCourriel(request.getParameter(CHAMP_EMAIL));
        user.setMot_de_passe(request.getParameter(CHAMP_MOTDEPASS));
        user.setPays(request.getParameter(CHAMP_PAYS));
        user.setVille(request.getParameter(CHAMP_VILLE));
        user.setMunicipalite(request.getParameter(CHAMP_MUNICIPALITE));
        user.setRue(request.getParameter(CHAMP_RUE));
        user.setCodePostal(request.getParameter(CHAMP_CODEPOSTAL));
        user.setRole(CHAMP_ROLE);

        // Enregistrement du user dans le fichier        
        chargeUsers();
        usagers.add(user);
        saveUsers();
    }

    public static void saveUsers() {
        FileRecorder.addRecord(usagers, USER_JSON_PATH);
    }

    public static void chargeUsers() {
        usagers = new ArrayList();
        List<User> temp = FileRecorder.getRecord(USER_JSON_PATH);
        if (!temp.isEmpty()) {
            usagers = temp;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Cree un utilisateur a partir des champs du formulaire d'inscription";
    }// </editor-fold>
}
