package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 * @author Emmanuel FANGUE FANE31078301
 * @author Justin Fotue KAMGA FOTJ23097901
 * @author Jude SEIDE SEIJ04019006
 */
public class Connexion extends HttpServlet {

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
        String password = request.getParameter(CreateUser.CHAMP_MOTDEPASS);

        User user = new User(); // l'utlisateur a chercher
        user.setCourriel(email);
        user.setMot_de_passe(password);

        CreateUser.chargeUsers();
        if (!CreateUser.usagers.contains(user)) {
            response.sendRedirect("inscription.jsp");

        } else {

            int index = CreateUser.usagers.indexOf(user);
            user = CreateUser.usagers.get(index);
            
            //creation de session et suite
            request.getSession(true).setAttribute("email", user.getCourriel());
            request.getSession(true).setAttribute("password", user.getMot_de_passe());

            InitialiserCategories.getInstance().chargeCategory();

            if ((user.getRole()).compareTo("admin") != 0) {

                response.setContentType("text/html;charset=UTF-8");
                PrintWriter out = response.getWriter();
                try {

                    out.println(header(user));
                    // utilisateur compatible
                    out.println(userCompatible(user));

                    out.println(beforeTab());
                    // category
                    out.println(listCategory());

                    out.println(afterTab());

                } finally {
                    out.close();
                }

            } else {

                String url = "/administrateur.jsp";
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
                dispatcher.forward(request, response);
            }
        }

    }

    private String listCategory() {
        String result = "";

        Map<String, ArrayList<String>> stock = InitialiserCategories.getInstance().getStockCategories();
        Set cles = stock.keySet();

        Iterator<String> iter = cles.iterator();
        while (iter.hasNext()) {
            String temp = iter.next();
            result += "<li><a href=\"#" + temp;
            result += "\"><span>" + temp;
            result += "</span></a></li>";
        }

        result += "</ul>\n"
                + "\n"
                + "                    <div class=\"panes\">";

        iter = cles.iterator();
        int j = 1;
        while (iter.hasNext()) {
            String cat = iter.next();
            result += "<div id=\"" + cat + "\">\n"
                    + "                            </br>\n"
                    + "                            </br>";

            String motcle = "";
            ArrayList<String> mot = stock.get(cat);
            Iterator<String> iter2 = mot.iterator();
            while (iter2.hasNext()) {
                String temp = iter2.next();
                motcle += "<option name=\"" + temp + "\" value=\"" + temp + "\">" + temp + "</option>";
            }

            for (int i = 1; i <= 3; i++) {

                result += "choix" + i + " : ";
                result += "<select name=\"categorie" + j++ + "\" form=\"category\">";
                result += motcle;
                result += "</select>\n"
                        + "                            </br>\n"
                        + "                            </br>";
            }

            result += " </div>";
        }

        return result;
    }

    private String header(User user) {
        String result = "<!doctype html>\n"
                + "<html class=\"no-js\">\n"
                + "\n"
                + "    <head>\n"
                + "        <meta charset=\"utf-8\"/>\n"
                + "        <title>AFFINITE|usager</title>\n"
                + "        <link rel=\"stylesheet\" media=\"all\" href=\"css/style.css\"/>\n"
                + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\n"
                + "        <!-- Adding \"maximum-scale=1\" fixes the Mobile Safari auto-zoom bug: http://filamentgroup.com/examples/iosScaleBug/ -->\n"
                + "\n"
                + "\n"
                + "        <!-- JS -->\n"
                + "        <script src=\"js/jquery-1.6.4.min.js\"></script>\n"
                + "        <script src=\"js/css3-mediaqueries.js\"></script>\n"
                + "        <script src=\"js/custom.js\"></script>\n"
                + "        <script src=\"js/tabs.js\"></script>\n"
                + "\n"
                + "        <!-- superfish -->\n"
                + "        <link rel=\"stylesheet\" media=\"screen\" href=\"css/superfish.css\" /> \n"
                + "        <script  src=\"js/superfish-1.4.8/js/hoverIntent.js\"></script>\n"
                + "        <script  src=\"js/superfish-1.4.8/js/superfish.js\"></script>\n"
                + "        <script  src=\"js/superfish-1.4.8/js/supersubs.js\"></script>\n"
                + "        <!-- ENDS superfish -->\n"
                + "\n"
                + "        <!-- poshytip -->\n"
                + "        <link rel=\"stylesheet\" href=\"js/poshytip-1.1/src/tip-twitter/tip-twitter.css\"  />\n"
                + "        <link rel=\"stylesheet\" href=\"js/poshytip-1.1/src/tip-yellowsimple/tip-yellowsimple.css\"  />\n"
                + "        <script  src=\"js/poshytip-1.1/src/jquery.poshytip.min.js\"></script>\n"
                + "        <!-- ENDS poshytip -->\n"
                + "\n"
                + "        <!-- GOOGLE FONTS -->\n"
                + "        <link href='http://fonts.googleapis.com/css?family=Arvo:400,700' rel='stylesheet' type='text/css'>\n"
                + "\n"
                + "        <!-- Flex Slider -->\n"
                + "        <link rel=\"stylesheet\" href=\"css/flexslider.css\" >\n"
                + "        <script src=\"js/jquery.flexslider-min.js\"></script>\n"
                + "        <!-- ENDS Flex Slider -->\n"
                + "\n"
                + "        <!-- Masonry -->\n"
                + "        <script src=\"js/masonry.min.js\" ></script>\n"
                + "        <script src=\"js/imagesloaded.js\" ></script>\n"
                + "        <!-- ENDS Masonry -->\n"
                + "\n"
                + "        <!-- Less framework -->\n"
                + "        <link rel=\"stylesheet\" media=\"all\" href=\"css/lessframework.css\"/>\n"
                + "\n"
                + "        <!-- modernizr -->\n"
                + "        <script src=\"js/modernizr.js\"></script>\n"
                + "\n"
                + "        <!-- SKIN -->\n"
                + "        <link rel=\"stylesheet\" media=\"all\" href=\"css/skin.css\"/>\n"
                + "\n"
                + "\n"
                + "    </head>\n"
                + "\n"
                + "    <body lang=\"en\">\n"
                + "\n"
                + "\n"
                + "\n"
                + "        <header>\n"
                + "            <div class=\"wrapper clearfix\">\n"
                + "\n"
                + "                <div id=\"logo\">\n"
                + "                    <a href=\"index.jsp\"><img  src=\"img/logo.png\" alt=\"Simpler\"></a>\n"
                + "                </div>\n"
                + "\n"
                + "                <!-- nav -->\n"
                + "                <ul id=\"nav\" class=\"sf-menu\">\n"
                + "                    <li><a href=\"index.jsp\">Accueil</a></li>\n"
                + "                    <li><a href=\"inscription.jsp\">Inscription</a></li>\n"
                + "                    <li class=\"current-menu-item\"><a href=\"connexion.jsp\">Usager</a>\n"
                + "                        <ul>\n"
                + "                            <li><a href=\"connexion.jsp\">Administrateur</a></li>\n"
                + "                        </ul>					\n"
                + "                    </li>\n"
                + "                    <li><a href=\"contact.jsp\">Contact</a></li>\n"
                + "                    <li><a href=\"connexion.jsp\">Connexion</a>\n"
                + "                        <ul>\n"
                + "                            <li>\n"
                + "                                <form id=\"deconnexionForm\" action=\"Deconnexion\" method=\"post\">\n"
                + "                                    <input type=\"submit\" value=\"Deconnexion\" name=\"\"/>                                   \n"
                + "                                </form>\n"
                + "                            </li>\n"
                + "                        </ul>							\n"
                + "                    </li>\n"
                + "                </ul>\n"
                + "                <!-- ends nav -->\n"
                + "\n"
                + "                <!-- comboNav -->\n"
                + "                <select id=\"comboNav\">\n"
                + "                    <option value=\"index.jsp\">Accueil</option>\n"
                + "                    <option value=\"inscription.jsp\">Inscription</option>\n"
                + "                    <option value=\"connexion.jsp\" selected=\"selected\">Usager</option>\n"
                + "                    <option value=\"connexion.jsp\">Administrateur</option>\n"
                + "                    <option value=\"contact.jsp\">Contact</option>\n"
                + "                    <option value=\"connexion.jsp\">Connexion</option>\n"
                + "                    <option value=\"#deconnexionForm\">Deconnexion</option>\n"
                + "                </select>\n"
                + "                <!-- comboNav -->	\n"
                + "\n"
                + "            </div>\n"
                + "        </header>\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "        <!-- MAIN -->\n"
                + "        <div id=\"main\">	\n"
                + "            <div class=\"wrapper clearfix\">\n"
                + "\n"
                + "                <!-- masthead -->\n"
                + "                <div class=\"masthead clearfix\">\n"
                + "                    <h1>" + user.getPrenom() + " " + user.getNom() + "</h1><span class=\"subheading\">Bienvenue sur votre page de profil</span>\n"
                + "                </div>\n"
                + "                <div class='mh-div'></div>\n"
                + "                <!-- ENDS masthead -->\n"
                + "\n"
                + "\n"
                + "                <!-- widgets -->\n"
                + "                <ul  class=\"widget-cols clearfix\">\n";
        return result;
    }

    private String userCompatible(User user) {
        String result = "";

        if (user.getCategories() != null) {

            Affinity affinity = new Affinity(user, CreateUser.usagers);

            Map<User, Integer> compatible = affinity.getListUserAffinity();
            Iterator<User> keySetIterator = compatible.keySet().iterator();

            result += "                    <li class=\"first-col\">\n"
                    + "\n"
                    + "                        <div class=\"widget-block\">\n";

            while (keySetIterator.hasNext()) {
                User temp = keySetIterator.next();
                result += "<div class=\"recent-post clearfix\">\n"
                        + "                                <a href=\"#\" class=\"thumb\"><img src=\"";
                result += temp.getPhoto();
                result += "\" alt=\"Post\" /></a>\n"
                        + "                                <div class=\"post-head\">";
                result += "<span>";
                result += temp.getNom();
                result += "</span><span>";
                result += temp.getPrenom();
                result += "</span><a href=\"contact.jsp\">";
                result += temp.getCourriel();
                result += "</a><span>";
                result += "Pourcentage : " + compatible.get(temp) + "</span>";
                result += "</div>\n"
                        + "                            </div>";
            }

            result += "         \n"
                    + "                        </div>\n"
                    + "                    </li>\n"
                    + "\n"
                    + "\n"
                    + "                    <li class=\"second-col\">\n"
                    + "\n"
                    + "                        <div class=\"widget-block\">\n"
                    + "                            <h4>AFFINITE COMMUNE</h4>\n"
                    + "                            <p>Ce ceci est la liste des trois usagers partageant le plus d'affinite avec vous. Pour en contacter un, veuillez cliquez sur son email.</p>\n"
                    + "                        </div>\n"
                    + "\n"
                    + "                    </li>	\n"
                    + "                </ul>\n"
                    + "                <!-- ENDS widgets -->\n";
        }

        return result;
    }

    private String beforeTab() {
        return "\n"
                + "                <!-- page content -->\n"
                + "                <div id=\"page-content\" class=\"clearfix\">        	\n"
                + "\n"
                + "\n"
                + "\n"
                + "                    <!-- Tabs -->\n"
                + "                    <h3 class=\"heading\">Categories</h3><span class=\"subheading\">Selectionnez les categories definissant vos affinites selon votre priorite</span>\n"
                + "</br></br>"
                + "                    <ul class=\"tabs\">";
    }

    private String afterTab() {
        return " \n"
                + "\n"
                + "                    </div>\n"
                + "                    <!-- ENDS TABS -->\n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "                    <form action=\"AjouterCategorieUser\" method=\"post\" id=\"category\">\n"
                + "                        </br>\n"
                + "                        <input type=\"submit\" value=\"Envoyez\" name=\"submit\" id=\"submit\" />\n"
                + "                    </form>                    \n"
                + "\n"
                + "\n"
                + "\n"
                + "\n"
                + "                </div>\n"
                + "                <!-- ENDS page content -->\n"
                + "\n"
                + "\n"
                + "\n"
                + "                <!-- Fold image -->\n"
                + "                <div id=\"fold\"></div>\n"
                + "            </div>\n"
                + "\n"
                + "        </div>\n"
                + "        <!-- ENDS MAIN -->\n"
                + "\n"
                + "        <footer>	\n"
                + "\n"
                + "            <div class=\"wrapper clearfix\">\n"
                + "\n"
                + "                <!-- widgets -->\n"
                + "                <ul  class=\"widget-cols clearfix\">\n"
                + "                    <li class=\"first-col\">						\n"
                + "\n"
                + "                    </li>					\n"
                + "\n"
                + "                </ul>\n"
                + "                <!-- ENDS widgets -->	\n"
                + "\n"
                + "            </div>\n"
                + "        </footer>\n"
                + "\n"
                + "\n"
                + "    </body>\n"
                + "\n"
                + "</html>";
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
        processRequest(request, response);
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
        return "Connexion de l'usager et creation de sa session";
    }// </editor-fold>
}
