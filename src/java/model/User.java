package model;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Emmanuel FANGUE FANE31078301
 * @author Justin Fotue KAMGA FOTJ23097901
 * @author Jude SEIDE SEIJ04019006
 */
public class User {

    private String nom = "";
    private String prenom = "";
    private String telephone = "";
    private String courriel = "";
    private String mot_de_passe = "";
    private String photo = "";
    private String pays = "";
    private String province = "";
    private String ville = "";
    private String municipalite = "";
    private String rue = "";
    private String codePostal = "";
    private String role = "usager";
    private Map<String, ArrayList<String>> categories;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getMunicipalite() {
        return municipalite;
    }

    public void setMunicipalite(String municipalite) {
        this.municipalite = municipalite;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if ((this.courriel == null) ? (other.courriel != null) : !this.courriel.equals(other.courriel)) {
            return false;
        }
        return !((this.mot_de_passe == null) ? (other.mot_de_passe != null) : !this.mot_de_passe.equals(other.mot_de_passe));
    }

    public Map<String, ArrayList<String>> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, ArrayList<String>> categories) {
        this.categories = categories;
    }

}
