package dao;

import dto.Utilisateur;

public interface IUtilisateurDB {
	
	public boolean AjoutPersonne(Utilisateur u);
	
	public Utilisateur checkLogin(String matricule, String password);
	
	public boolean isMatriculeFree(String matricule);
	
	public Utilisateur getUtilisateurFromMatricule(String matricule);
	
	public Utilisateur getUtilisateurFromId(int id);
	
	public Utilisateur getUtilisateur(String mode, String valeur);

}
