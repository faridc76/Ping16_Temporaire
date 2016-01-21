package dao;

import java.util.List;

import dto.Affaire;

public interface IAffaireDB {

	public List<String> listeAffaire(int id_utilisateur);

	public Affaire recupAffaire(String affaire);

}
