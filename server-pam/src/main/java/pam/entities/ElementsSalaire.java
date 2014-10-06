package pam.entities;

import java.io.Serializable;

public class ElementsSalaire implements Serializable {

	private static final long serialVersionUID = 1L;
	// champs privés
	private double salaireBase;
	private double cotisationsSociales;
	private double indemnitesEntretien;
	private double indemnitesRepas;
	private double salaireNet;

	// constructeurs
	public ElementsSalaire() {

	}

	public ElementsSalaire(double salaireBase, double cotisationsSociales, double indemnitesEntretien, double indemnitesRepas, double salaireNet) {
		setSalaireBase(salaireBase);
		setCotisationsSociales(cotisationsSociales);
		setIndemnitesEntretien(indemnitesEntretien);
		setIndemnitesRepas(indemnitesRepas);
		setSalaireNet(salaireNet);
	}

	// toString
	@Override
	public String toString() {
		return "[salaire base=" + salaireBase + ",cotisations sociales=" + cotisationsSociales + ",indemnités d'entretien=" + indemnitesEntretien
				+ ",indemnités de repas=" + indemnitesRepas + ",salaire net=" + salaireNet + "]";
	}

	// accesseurs publics
	public double getCotisationsSociales() {
		return cotisationsSociales;
	}

	public void setCotisationsSociales(double cotisationsSociales) {
		this.cotisationsSociales = cotisationsSociales;
	}

	public double getIndemnitesEntretien() {
		return indemnitesEntretien;
	}

	public void setIndemnitesEntretien(double indemnitesEntretien) {
		this.indemnitesEntretien = indemnitesEntretien;
	}

	public double getIndemnitesRepas() {
		return indemnitesRepas;
	}

	public void setIndemnitesRepas(double indemnitesRepas) {
		this.indemnitesRepas = indemnitesRepas;
	}

	public double getSalaireBase() {
		return salaireBase;
	}

	public void setSalaireBase(double salaireBase) {
		this.salaireBase = salaireBase;
	}

	public double getSalaireNet() {
		return salaireNet;
	}

	public void setSalaireNet(double salaireNet) {
		this.salaireNet = salaireNet;
	}

}
