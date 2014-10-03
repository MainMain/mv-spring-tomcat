package pam.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "COTISATIONS")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cotisation extends AbstractEntity implements Serializable {

  private double csgrds;
  private double csgd;
  private double secu;
  private double retraite;

  public Cotisation() {
  }

  public Cotisation(double csgrds, double csgd, double secu, double retraite) {
    setCsgrds(csgrds);
    setCsgd(csgd);
    setSecu(secu);
    setRetraite(retraite);
  }

  @Override
  public String toString() {
    return "jpa.Cotisation[id=" + getId() + ",version=" + getVersion() + ",csgrds=" + getCsgrds() + "" +
      ",csgd=" + getCsgd() + ",secu=" + getSecu() + ",retraite=" + getRetraite() + "]";
  }

  // getters et setters
  public double getCsgrds() {
    return csgrds;
  }

  public void setCsgrds(double csgrds) {
    this.csgrds = csgrds;
  }

  public double getCsgd() {
    return csgd;
  }

  public void setCsgd(double csgd) {
    this.csgd = csgd;
  }

  public double getSecu() {
    return secu;
  }

  public void setSecu(double secu) {
    this.secu = secu;
  }

  public double getRetraite() {
    return retraite;
  }

  public void setRetraite(double retraite) {
    this.retraite = retraite;
  }
}
