package json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.StrictMode;
import dao.IUtilisateurDB;
import dto.Utilisateur;

public class UtilisateurDB implements IUtilisateurDB {

	
	public static String MY_PREFS_NAME = "Pref_pour_apli_mohamed";
	public final static String CHEF_DE_CHANTIER = "Chef de chantier";
	public final static String CONDUCTEUR_DE_TRAVAUX = "Conducteur de travaux";
	public final static String RESPONSABLE_DAFFAIRES = "Responsable d'affaires";
	public final static String GOOD_RESULT = "True";
	
	public final static String DOMAINE = "http://gestineo.free.fr/";
	
	@Override
	public boolean AjoutPersonne(Utilisateur u) {
		String result = "";
		int id = 0;
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		try {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy); 
			URL url = new URL(DOMAINE + "ajoutUtilisateur.php");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true); // Pour pouvoir envoyer des donn�es
			connection.setRequestMethod("POST"); 
			writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write("matricule=" + u.getMatricule() + "&nom=" + u.getNom() + "&prenom=" + u.getPrenom() + "&numero=" + u.getNumero() + "&bureau=" + u.getBureau() + "&mail=" + u.getMail() + "&password=" + u.getPassword());
			writer.flush();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String ligne;
			while ((ligne = reader.readLine()) != null) {
				result += ligne;
			}
			id = Integer.parseInt(result);
			u.setId(id);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{writer.close();}catch(Exception e){}
			try{reader.close();}catch(Exception e){}
		}
		return (id != 0);
	}

	@Override
	public Utilisateur checkLogin(String matricule, String password) {
		String result = "";
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		try {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy); 
			URL url = new URL(DOMAINE + "checkLogin.php");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true); // Pour pouvoir envoyer des donn�es
			connection.setRequestMethod("POST"); 
			writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write("matricule=" + matricule + "&password=" + password);
			writer.flush();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String ligne;
			while ((ligne = reader.readLine()) != null) {
				System.out.println(ligne);
				result += ligne;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try{writer.close();}catch(Exception e){}
			try{reader.close();}catch(Exception e){}
		}
		if (result.equals(GOOD_RESULT)) {
			return getUtilisateurFromMatricule(matricule);
		} else {
			return null;
		}
	}

	@Override
	public boolean isMatriculeFree(String matricule) {
		String result = "";
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		try {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy); 
			URL url = new URL(DOMAINE + "matriculeFree.php");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true); // Pour pouvoir envoyer des donn�es
			connection.setRequestMethod("POST"); 
			writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write("matricule=" + matricule);
			writer.flush();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String ligne;
			while ((ligne = reader.readLine()) != null) {
				result += ligne;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{writer.close();}catch(Exception e){}
			try{reader.close();}catch(Exception e){}
		}
		return result.equals(GOOD_RESULT);
	}

	@Override
	public Utilisateur getUtilisateurFromMatricule(String matricule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getUtilisateurFromId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getUtilisateur(String mode, String valeur) {
		// TODO Auto-generated method stub
		return null;
	}

}
