package istia.st.json;

public class Personne {
	// data
	private String nom;
	private String prenom;
	private int age;

	// constructeurs
	public Personne() {

	}

	public Personne(String nom, String prénom, int âge) {
		this.nom = nom;
		this.prenom = prénom;
		this.age = âge;
	}

	// signature
	public String toString() {
		return String.format("Personne[%s, %s, %d]", nom, prenom, age);
	}

	// getters et setters

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
