package dto;

public class Affaire {
	
	private int id;
	
	private String nom;
	
	private String lieu;
	
	private String budget;
	
	private String commenditaire;
	
	private int statut;
	
	private int id_responsable;
	
	private int id_conducteur;
	
	private int id_chef;
	
	public Affaire(){
		
	}
	
	public Affaire(int id, String nom, String lieu, String budget, String commenditaire, int statut, int id_responsable, int id_conducteur, int id_chef) {
		this.id = id;
		this.nom = nom;
		this.lieu = lieu;
		this.budget = budget;
		this.commenditaire = commenditaire;
		this.statut = statut;
		this.id_responsable = id_responsable;
		this.id_conducteur = id_conducteur;
		this.id_chef = id_chef;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public String getBudget() {
		return budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getCommenditaire() {
		return commenditaire;
	}

	public void setCommenditaire(String commenditaire) {
		this.commenditaire = commenditaire;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public int getId_responsable() {
		return id_responsable;
	}

	public void setId_responsable(int id_responsable) {
		this.id_responsable = id_responsable;
	}

	public int getId_conducteur() {
		return id_conducteur;
	}

	public void setId_conducteur(int id_conducteur) {
		this.id_conducteur = id_conducteur;
	}

	public int getId_chef() {
		return id_chef;
	}

	public void setId_chef(int id_chef) {
		this.id_chef = id_chef;
	}
	
	@Override
	public String toString() {
		return "Affaire [id=" + id + ", nom=" + nom + ", lieu=" + lieu + ", budget=" + budget + ", commenditaire=" + commenditaire
				+ ", statut=" + statut + ", id_responsable=" + id_responsable + ", id_conducteur=" + id_conducteur + ", id_chef=" + id_chef + "]";
	}
}
