package Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import model.User;

/**
 * @author Emmanuel FANGUE FANE31078301
 * @author Justin Fotue KAMGA FOTJ23097901
 * @author Jude SEIDE SEIJ04019006
 */
public class GererCategories {

    public static User modifierMotClesUser(Map<String, ArrayList<String>> StockMotsCles, User user) {
        Map<String, ArrayList<String>> stockUser = user.getCategories();
        if(stockUser != null){
        ArrayList<String> list;

        Set cles = StockMotsCles.keySet();
        Iterator<String> it = cles.iterator();
        while (it.hasNext()) {
            String cat = it.next();
            list = StockMotsCles.get(cat);
            if (stockUser.get(cat).isEmpty()) {
                stockUser.put(cat, list);
            } else {
                ArrayList<String> temp = stockUser.get(cat);
                while (list.iterator().hasNext()) {
                    temp.add(list.iterator().next());
                }
                stockUser.put(cat, temp);
            }
        }
        }
        user.setCategories(stockUser);
        return user;
    }

    public User supprimerMotClesUser(Map<String, ArrayList<String>> StockMotsCles, User user) {
        Map<String, ArrayList<String>> stockUser = user.getCategories();
        Set cles = stockUser.keySet();
        Set clesAsupp = StockMotsCles.keySet();
        Iterator<String> iter = cles.iterator();
        Iterator<String> it = clesAsupp.iterator();
        while (it.hasNext()) {
            String catAsupp = it.next();
            while (iter.hasNext()) {
                String catUser = it.next();
                if (catAsupp.compareTo(catUser) == 0) {
                    stockUser.get(catAsupp).removeAll(StockMotsCles.get(catAsupp));
                }
            }
        }
        user.setCategories(stockUser);
        return user;
    }

    public Map<String, ArrayList<String>> ajouterCategorieAuStock(Map<String, ArrayList<String>> StockMotsCles,
            Map<String, ArrayList<String>> aAjouter) {
        StockMotsCles.putAll(aAjouter);
        return StockMotsCles;
    }

    public Map<String, ArrayList<String>> supprimerCategorieAuStock(Map<String, ArrayList<String>> StockMotsCles, Map<String, ArrayList<String>> aAsupprimer) {

        Set cles = StockMotsCles.keySet();
        Set clesAsupp = aAsupprimer.keySet();
        Iterator<String> iter = cles.iterator();
        Iterator<String> it = clesAsupp.iterator();
        while (it.hasNext()) {
            String catAsupp = it.next();
            while (iter.hasNext()) {
                String catUser = it.next();
                if (catAsupp.compareTo(catUser) == 0) {
                    supprimerListe(StockMotsCles.get(catAsupp), aAsupprimer.get(catAsupp));
                }
            }
        }
        return StockMotsCles;
    }

    public void modifierCategorieAuStock(Map<String, ArrayList<String>> StockMotsCles, Map<String, ArrayList<String>> aAjouter) {
        Set cles = StockMotsCles.keySet();
        Set clesAsupp = aAjouter.keySet();
        Iterator<String> iter = cles.iterator();
        Iterator<String> it = clesAsupp.iterator();
        while (it.hasNext()) {
            String catAsupp = it.next();
            while (iter.hasNext()) {
                String catUser = it.next();
                if (catAsupp.compareTo(catUser) == 0) {
                    insererListe(StockMotsCles.get(catUser), StockMotsCles.get(catAsupp));
                }
            }
        }

    }

    private void insererListe(ArrayList<String> liste, ArrayList<String> listeAinserer) {

        Iterator<String> it = listeAinserer.iterator();
        while (it.hasNext()) {
            liste.add(it.next());
        }

    }

    private void supprimerListe(ArrayList<String> liste, ArrayList<String> listeAsupp) {

        Iterator<String> it = listeAsupp.iterator();
        while (it.hasNext()) {
            liste.remove(it.next());
        }

    }
}
