package com.lafleur.alexandre.revisionpersonnelle;

/**
 * Created by laflo on 2017-12-05.
 */

public class RowClass {
    private int adresseImage;
    private String texte;
    private String message = "allo";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getAdresseImage() {
        return adresseImage;
    }

    public void setAdresseImage(int adresseImage) {
        this.adresseImage = adresseImage;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public RowClass(int adresseImage, String texte) {

        this.adresseImage = adresseImage;
        this.texte = texte;
    }
}
