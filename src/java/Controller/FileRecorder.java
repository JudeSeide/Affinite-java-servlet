package Controller;

/**
 * @author Emmanuel FANGUE FANE31078301
 * @author Justin Fotue KAMGA FOTJ23097901
 * @author Jude SEIDE SEIJ04019006
 */
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import org.apache.commons.io.IOUtils;

public class FileRecorder {

    public static void addRecord(List<User> user, String file_path) {

        Gson gson = new Gson();
        String json = gson.toJson(user);

        try {
            FileWriter writer = new FileWriter(file_path, false);
            writer.write(json);
            writer.close();

        } catch (IOException e) {

        }

    }

    private static void writeAdmin(String json, String file_path) {

        try {
            FileWriter writer = new FileWriter(file_path, false);
            writer.write(json);
            writer.close();

        } catch (IOException e) {

        }

    }

    public static List<User> getRecord(String file_path) {
        List<User> list = null;
        try {
            Gson gson = new Gson();
            String json = loadFileIntoString(file_path, "UTF-8");

            if (json == null || json.isEmpty()) {
                String admin = "[{\"nom\":\"doe\",\"prenom\":\"john\",\"telephone\":\"0000000000\",\"courriel\":\"admin@email.bd\",\"mot_de_passe\":\"admin1234\",\"pays\":\"na\",\"ville\":\"na\",\"municipalite\":\"na\",\"rue\":\"na\",\"codePostal\":\"na\",\"role\":\"admin\"}]";
                writeAdmin(admin, file_path);
            }

            Type collectionType = new TypeToken<List<User>>() {
            }.getType();
            list = gson.fromJson(json, collectionType);
        } catch (IOException ex) {
            Logger.getLogger(FileRecorder.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    public static String loadFileIntoString(String filePath, String fileEncoding) throws FileNotFoundException, IOException {
        return IOUtils.toString(new FileInputStream(filePath), fileEncoding);
    }

}
