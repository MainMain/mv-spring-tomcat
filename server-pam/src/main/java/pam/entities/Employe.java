package pam.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYES")
public class Employe extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String SS;
    private String nom;
    private String prenom;
    private String adresse;
    private String ville;
    private String codePostal;

    // entité pointée par la clé étrangère
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INDEMNITE_ID", referencedColumnName = "ID")
    private Indemnite indemnite;

    // clé étrangère
    @Column(name = "INDEMNITE_ID", insertable = false, updatable = false)
    private long idIndemnite;

    public Employe() {
    }

    public Employe(String SS, String nom, String prenom, String adresse, String ville, String codePostal, Indemnite indemnite) {
        setSS(SS);
        setNom(nom);
        setPrenom(prenom);
        setAdresse(adresse);
        setVille(ville);
        setCodePostal(codePostal);
        setIndemnite(indemnite);
    }

    @Override
    public String toString() {
        return "jpa.Employe[id=" + getId()
                + ",version=" + getVersion()
                + ",SS=" + getSS()
                + ",nom=" + getNom()
                + ",prenom=" + getPrenom()
                + ",adresse=" + getAdresse()
                + ",ville=" + getVille()
                + ",code postal=" + getCodePostal()
                + ",idIndemnite=" + getIdIndemnite()
                + "]";
    }

    public String toString2() {
        return "jpa.Employe[id=" + getId()
                + ",version=" + getVersion()
                + ",SS=" + getSS()
                + ",nom=" + getNom()
                + ",prenom=" + getPrenom()
                + ",adresse=" + getAdresse()
                + ",ville=" + getVille()
                + ",code postal=" + getCodePostal()
                + ",indemnite=" + getIndemnite()
                + "]";
    }

    public String getSS() {
        return SS;
    }

    public void setSS(String SS) {
        this.SS = SS;
    }

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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Indemnite getIndemnite() {
        return indemnite;
    }

    public void setIndemnite(Indemnite indemnite) {
        this.indemnite = indemnite;
    }

    public long getIdIndemnite() {
        return idIndemnite;
    }

    public void setIdIndemnite(long idIndemnite) {

        this.idIndemnite = idIndemnite;
    }
}
