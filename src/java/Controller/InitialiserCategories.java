package Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;

/**
 * @author Emmanuel FANGUE FANE31078301
 * @author Justin Fotue KAMGA FOTJ23097901
 * @author Jude SEIDE SEIJ04019006
 */
public class InitialiserCategories {

    private ArrayList<String> musique;
    private ArrayList<String> sport;
    private ArrayList<String> cinema;
    private ArrayList<String> voyage;
    private ArrayList<String> lecture;
    private ArrayList<String> hobby;

    private final String CATEGORY_JSON_PATH = "/home/spectro/Downloads/INF3005-TP1/web/WEB-INF/data/category.json";

    private Map<String, ArrayList<String>> stockCategories;

    private static InitialiserCategories instance = null;

    private InitialiserCategories() {
        initialStock();
    }

    public synchronized static InitialiserCategories getInstance() {
        if (instance == null) {
            instance = new InitialiserCategories();
        }
        return instance;
    }

    public Map<String, ArrayList<String>> getStockCategories() {
        return stockCategories;
    }

    private void initialStock() {
        this.stockCategories = new HashMap<String, ArrayList<String>>();
        this.stockCategories.put("Sport", initialiserSport());
        this.stockCategories.put("Musique", initialiserMusique());
        this.stockCategories.put("Cinema", initialiserCinema());
        this.stockCategories.put("Voyage", initialiserVoyage());
        this.stockCategories.put("Lecture", initialiserLecture());
    }

    private ArrayList<String> initialiserSport() {
        sport = new ArrayList<String>();
        sport.add("Foot-ball");
        sport.add("Hand-ball");
        sport.add("Basket-ball");
        sport.add("Volley-ball");
        sport.add("Tennis");
        sport.add("Natation");
        sport.add("Rugby");
        sport.add("Sprint");
        sport.add("Hockey");
        sport.add("Boxe");
        return sport;
    }

    private ArrayList<String> initialiserMusique() {
        musique = new ArrayList<String>();
        musique.add("Jazz");
        musique.add("Rock");
        musique.add("Pop");
        musique.add("Acoustique");
        musique.add("Classique");
        musique.add("Raggae");
        musique.add("Soul");
        musique.add("Funk");
        musique.add("Afropop");
        musique.add("Religieuse");
        return musique;
    }

    private ArrayList<String> initialiserVoyage() {
        voyage = new ArrayList<String>();
        voyage.add("Citadin");
        voyage.add("Croisiere");
        voyage.add("Groupe");
        voyage.add("Seule");
        voyage.add("En famile");
        voyage.add("En amour");
        voyage.add("En train");
        voyage.add("Avion");
        voyage.add("Auto");
        voyage.add("Echangiste");
        return voyage;
    }

    private ArrayList<String> initialiserCinema() {
        cinema = new ArrayList<String>();
        cinema.add("Films d'horreurs");
        cinema.add("Fils pour enfants");
        cinema.add("Films de combat");
        cinema.add("Films de guerre");
        cinema.add("Documentaires");
        cinema.add("Film de dance");
        cinema.add("Documentaire fiction");
        cinema.add("Film d'action");
        cinema.add("Film d'aventure");
        cinema.add("Film pornographique");
        return cinema;
    }

    private ArrayList<String> initialiserLecture() {
        lecture = new ArrayList<String>();
        lecture.add("Romans courtois");
        lecture.add("Romans historiques");
        lecture.add("Romans d'avanture");
        lecture.add("Science fiction");
        lecture.add("Fantaisie");
        lecture.add("Fantastique");
        lecture.add("Biographie");
        lecture.add("Compte");
        lecture.add("Epopee");
        lecture.add("Nouveautés");
        return lecture;
    }

    public void saveCategory() {

        Gson gson = new Gson();
        String json = gson.toJson(stockCategories);

        try {
            FileWriter writer = new FileWriter(CATEGORY_JSON_PATH, false);
            writer.write(json);
            writer.close();

        } catch (IOException e) {

        }

    }

    public void chargeCategory() {
        try {
            Gson gson = new Gson();
            String json = loadFileIntoString(CATEGORY_JSON_PATH, "UTF-8");

            if (json == null || json.isEmpty()) {
                getInstance();
                saveCategory();
            } else {

                Type collectionType = new TypeToken<Map<String, ArrayList<String>>>() {
                }.getType();
                stockCategories = gson.fromJson(json, collectionType);
            }

        } catch (IOException ex) {
            Logger.getLogger(FileRecorder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String loadFileIntoString(String filePath, String fileEncoding) throws FileNotFoundException, IOException {
        return IOUtils.toString(new FileInputStream(filePath), fileEncoding);
    }
}
