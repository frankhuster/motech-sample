package org.motechproject.sample.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity
public class NomDePlume {

    @Field(required = true)
    private String nom;

    public NomDePlume(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NomDePlume)) return false;

        NomDePlume nomDePlume = (NomDePlume) o;

        if (!nom.equals(nomDePlume.nom)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nom.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Nomdeplume{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
