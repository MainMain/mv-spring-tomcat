package pam.client.entities;

import java.io.Serializable;

public class Cotisation implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private int version;
	private double csgrds;
	private double csgd;
	private double secu;
	private double retraite;

	/** Creates a new instance of Cotisation */
	public Cotisation() {
	}

	public Cotisation(double csgrds, double csgd, double secu, double retraite) {
		setCsgrds(csgrds);
		setCsgd(csgd);
		setSecu(secu);
		setRetraite(retraite);
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
		if (!(object instanceof Cotisation)) {
			return false;
		}
		Cotisation other = (Cotisation) object;
		if (this.getId() != other.getId() && (this.getId() == null || !this.getId().equals(other.getId())))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cotisation[id=" + getId() + ",version=" + getVersion() + ",csgrds=" + getCsgrds() + "" + ",csgd=" + getCsgd() + ",secu=" + getSecu()
				+ ",retraite=" + getRetraite() + "]";
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
