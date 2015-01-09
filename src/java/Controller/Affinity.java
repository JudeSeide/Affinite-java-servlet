package Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import model.User;

/**
 * @author Emmanuel FANGUE FANE31078301
 * @author Justin Fotue KAMGA FOTJ23097901
 * @author Jude SEIDE SEIJ04019006
 */
public class Affinity {

    private final int POURCENPAYS = 5;
    private final int POURCENPROVINCE = 5;
    private final int POURCENVILLE = 15;
    private final int POURCENMICU = 15;
    private final int POURCENRUE = 20;
    private final int POURCENCATEGO = 10;
    private final int POURCENMOTCLE = 30;

    // private List<User> listUserAffinity;
    private Map<User, Integer> listUser = new HashMap<User, Integer>();
    private Map<User, Integer> listUserAffinity = new HashMap<User, Integer>();

    public Affinity() {
    }

    public Affinity(User _user, List<User> lis) {
        Iterator<User> iter = lis.listIterator();
        while (iter.hasNext()) {
            User use = iter.next();
            System.out.println("affinity :" + use.getNom());
        }
        list3User(_user, lis);
    }

    /**
     * @return the listUserAffinity
     */
    public Map<User, Integer> getListUserAffinity() {
        return listUserAffinity;
    }

    /**
     * @param listUserAffinity the listUserAffinity to set
     */
    public void setListUserAffinity(List<User> listUserAffinity) {
        this.listUserAffinity = (Map<User, Integer>) listUserAffinity;
    }

    private void calculAffinity(User _user, List<User> usagers) {

        List<User> users = usagers;

        Iterator<User> iter = users.listIterator();
        int affinity = 0;
        while (iter.hasNext()) {
            User user = iter.next();
            if (!(_user.getCourriel().equalsIgnoreCase(user.getCourriel()))) {
                if (user.getPays().equalsIgnoreCase(_user.getPays()) && _user.getPays() != null && user.getPays() != null) {
                    affinity += POURCENPAYS;
                    System.out.println(user.getPays());
                    if (_user.getProvince() != null && user.getProvince() != null && user.getProvince().equalsIgnoreCase(_user.getProvince())) {
                        affinity += POURCENPROVINCE;
                        if (user.getVille().equalsIgnoreCase(_user.getVille()) && _user.getVille() != null && user.getVille() != null) {
                            affinity += POURCENVILLE;
                            if (user.getMunicipalite().equalsIgnoreCase(_user.getMunicipalite()) && _user.getMunicipalite() != null && user.getMunicipalite() != null) {
                                affinity += POURCENMICU;
                                if (user.getRue().equalsIgnoreCase(_user.getRue()) && _user.getRue() != null && user.getRue() != null) {
                                    affinity += POURCENRUE;
                                }
                            }
                        }
                    }
                }

                Map map = user.getCategories();
                if (map != null) {
                    Iterator<String> keySetIterator = map.keySet().iterator();

                    while (keySetIterator.hasNext()) {
                        String key = keySetIterator.next();
                        if (_user.getCategories().containsKey(key)) {
                            affinity += POURCENCATEGO;
                        }
                        List<String> mot = (List<String>) map.get(key);
                        for (String mt : mot) {
                            if (_user.getCategories().get(key).contains(mt)) {
                                affinity += POURCENMOTCLE;
                                break;
                            }
                        }

                    }

                }
                if (affinity != 0) {
                    this.listUser.put(user, affinity);
                    System.out.println("voici le pourcentage :" + affinity);
                }
            }
            affinity = 0;
        }
    }

    /**
     * @return the listUser
     */
    public Map<User, Integer> getListUser() {
        return listUser;
    }

    /**
     * @param listUser the listUser to set
     */
    public void setListUser(Map<User, Integer> listUser) {
        this.listUser = listUser;
    }

    private void list3User(User _user, List<User> list) {
        calculAffinity(_user, list);
        Map<User, Integer> listUser3 = new HashMap<User, Integer>();
        final ArrayList<Entry<User, Integer>> entries = new ArrayList<Entry<User, Integer>>(listUser.entrySet());

        Collections.sort(entries, new Comparator<Entry<User, Integer>>() {
            public int compare(final Entry<User, Integer> e1, final Entry<User, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        int i = 0;
        for (final Entry<User, Integer> entry : entries) {
            if (!entry.getKey().getCourriel().equalsIgnoreCase(_user.getCourriel())) {
                listUserAffinity.put(entry.getKey(), entry.getValue());

                if (i >= 3) {
                    break;
                }
                i++;
            }
            System.out.println(entry.getKey().getNom() + " " + entry.getValue());
        }
    }

}
