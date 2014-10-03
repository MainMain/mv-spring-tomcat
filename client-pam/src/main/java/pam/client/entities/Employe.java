package pam.client.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Employe implements Serializable {

  private static final long serialVersionUID = 1L;
  private Long id;
  private int version;
  private String SS;
  private String nom;
  private String prenom;
  private String adresse;
  private String ville;
  private String codePostal;
  private int idIndemnite;
  private Indemnite indemnite;

  public Employe() {
  }

  public Employe(String SS, String nom, String prenom, String adresse, String ville, String codePostal, Indemnite indemnite) {
    setSS(SS);
    setNom(nom);
    setPrenom(prenom);
    setAdresse(adresse);
    setVille(ville);
    setCodePostal(codePostal);
    setIndemnites(indemnite);
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (this.getId() != null ? this.getId().hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof Employe)) {
      return false;
    }
    Employe other = (Employe) object;
    if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId())))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Employe[id=" + getId() + ",version=" + getVersion() + ",SS=" + getSS() + ",nom=" + getNom() + ",prenom=" + getPrenom() + ",adresse="
      + getAdresse() + ",ville=" + getVille() + ",code postal=" + getCodePostal() + ", indemnités=" + indemnite + "]";
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

  public void setIndemnites(Indemnite indemnites) {
    this.indemnite = indemnites;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(int version) {
    this.version = version;
  }

  public int getIdIndemnite() {
    return idIndemnite;
  }

  public void setIdIndemnite(int idIndemnite) {
    this.idIndemnite = idIndemnite;
  }
}
