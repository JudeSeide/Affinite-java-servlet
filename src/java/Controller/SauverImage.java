package Controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author Emmanuel FANGUE FANE31078301
 * @author Justin Fotue KAMGA FOTJ23097901
 * @author Jude SEIDE SEIJ04019006
 */
public class SauverImage extends HttpServlet {

    private static final int TAIL_MEMOIRE = 1024 * 1024 * 2;
    private static final int TAIL_OBJET = 1024 * 1024 * 2;
    private String nomFichier;

    public SauverImage(HttpServletRequest request, String foto, String url) throws ServletException, IOException {
        this.nomFichier = EnregistrementImage(request, foto, url);
    }

    private String EnregistrementImage(HttpServletRequest request, String foto, String url)
            throws ServletException, IOException {

        // Check that we have a file upload request
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (!isMultipart) {
            return null;
        }
        String photo = null;
        // Create a factory for disk-based file list
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Sets the size threshold beyond which files are written directly to
        // disk.
        factory.setSizeThreshold(TAIL_MEMOIRE);

        // Sets the directory used to temporarily store files that are larger
        // than the configured size threshold. We use temporary directory for
        // java
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        // constructs the folder where uploaded file will be stored
        //String url = getServletContext().getRealPath("")
        //        + File.separator + DATA_DIRECTORY;
        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);

        // Set overall request size constraint
        upload.setSizeMax(TAIL_OBJET);

        try {
            // Parse the request
            List list = upload.parseRequest(request);
            Iterator iter = list.iterator();
            while (iter.hasNext()) {
                FileItem champ = (FileItem) iter.next();
                System.out.println("nom du champ : " + champ.getFieldName());

                //System.out.println("nom du champ : "+champ.getFieldName());
                if (champ.getFieldName().equals("file")) {
                    String fileName = new File(champ.getName()).getName();
                    String filePath = url + File.separator + fileName;
                    File uploadedFile = new File(filePath);
                    champ.write(uploadedFile);
                    photo = fileName;
                    System.out.println("chemin : " + filePath);
                }

            }

            System.out.println("debut de l'ecriture : " + photo);
        } catch (FileUploadException ex) {
            throw new ServletException(ex);
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
        return photo;
    }

    /**
     * @return the nomFichier
     */
    public String getNomFichier() {
        return nomFichier;
    }

    /**
     * @param nomFichier the nomFichier to set
     */
    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

}
