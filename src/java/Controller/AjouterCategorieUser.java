package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
public class AjouterCategorieUser extends HttpServlet {

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

        // Recupere la session
        HttpSession session = request.getSession(true);
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");
        
        User user = new User();
        user.setCourriel(email);
        user.setMot_de_passe(password);

        String musique = "Musique";
        String musique1 = request.getParameter("categorie1");
        String musique2 = request.getParameter("categorie2");
        String musique3 = request.getParameter("categorie3");

        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        list.add(musique1);
        list.add(musique2);
        list.add(musique3);
        map.put(musique, list);

        String lecture = "Lecture";
        String lect1 = request.getParameter("categorie4");
        String lect2 = request.getParameter("categorie5");
        String lect3 = request.getParameter("categorie6");
        
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add(lect1);
        list1.add(lect2);
        list1.add(lect3);
        map.put(lecture, list1);

        String cinema = "Cinema";
        String cinema1 = request.getParameter("categorie7");
        String cinema2 = request.getParameter("categorie8");
        String cinema3 = request.getParameter("categorie9");
        
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add(cinema1);
        list2.add(cinema2);
        list2.add(cinema3);
        map.put(cinema, list2);

        String voyage = "Voyage";
        String voyage1 = request.getParameter("categorie10");
        String voyage2 = request.getParameter("categorie11");
        String voyage3 = request.getParameter("categorie12");
        
        ArrayList<String> list3 = new ArrayList<String>();
        list3.add(voyage1);
        list3.add(voyage2);
        list3.add(voyage3);
        map.put(voyage, list3);

        String sport = "Sport";
        String sport1 = request.getParameter("categorie13");
        String sport2 = request.getParameter("categorie14");
        String sport3 = request.getParameter("categorie15");
        
        ArrayList<String> list4 = new ArrayList<String>();
        list4.add(sport1);
        list4.add(sport2);
        list4.add(sport3);
        map.put(sport, list4);

        if (CreateUser.usagers.contains(user)) {
            int index = CreateUser.usagers.indexOf(user);
            User temp = CreateUser.usagers.remove(index);
            
            temp.setCategories(map);
            CreateUser.usagers.add(temp);
            CreateUser.saveUsers();
            response.sendRedirect("index.jsp");
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
        return "Short description";
    }// </editor-fold>
}
