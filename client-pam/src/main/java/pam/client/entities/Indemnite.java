package pam.client.entities;

import java.io.Serializable;

public class Indemnite implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private int version;
	private int indice;
	private double baseHeure;
	private double entretienJour;
	private double repasJour;
	private double indemnitesCp;

	public Indemnite() {
	}

	public Indemnite(int indice, double baseHeure, double entretienJour, double repasJour, double indemnitesCP) {
		setIndice(indice);
		setBaseHeure(baseHeure);
		setEntretienJour(entretienJour);
		setRepasJour(repasJour);
		setIndemnitesCP(indemnitesCP);
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
		// TODO: Warning - this method won't work in the case the id fields are not
		// set
		if (!(object instanceof Indemnite)) {
			return false;
		}
		Indemnite other = (Indemnite) object;
		if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId())))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Indemnite[id=" + getId() + ",version=" + getVersion() + ",indice=" + getIndice() + ",base heure=" + getBaseHeure()
				+ ",entretien jour=" + getEntretienJour() + ",repas jour=" + getRepasJour() + ",indemnités CP=" + getIndemnitesCP() + "]";
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public double getBaseHeure() {
		return baseHeure;
	}

	public void setBaseHeure(double baseHeure) {
		this.baseHeure = baseHeure;
	}

	public double getEntretienJour() {
		return entretienJour;
	}

	public void setEntretienJour(double entretienJour) {
		this.entretienJour = entretienJour;
	}

	public double getRepasJour() {
		return repasJour;
	}

	public void setRepasJour(double repasJour) {
		this.repasJour = repasJour;
	}

	public double getIndemnitesCP() {
		return indemnitesCp;
	}

	public void setIndemnitesCP(double indemnitesCP) {
		this.indemnitesCp = indemnitesCP;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
