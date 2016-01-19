package json;

import java.util.List;

import com.google.gson.Gson;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import dao.IAffaireDB;
import dao.IUtilisateurDB;
import dto.Utilisateur;
import fr.ineo.ping16.MenuActivity;

public class ListeAffaireRequete extends AsyncTask<Object, Void, List<String>> {
	
	private Context context = null;
	private int id_utilisateur;
	private Spinner spinner;
	
	@Override
	protected List<String> doInBackground(Object... params) {
		id_utilisateur = (Integer) params[0];
		spinner = (Spinner) params[1];
		context = (Context) params[2];
		IAffaireDB affaireDB = new AffaireDB();
		
		return affaireDB.listeAffaire(id_utilisateur);
	}

	@Override
	protected void onPostExecute(List<String> result) {
		if(context != null && spinner != null) {
			if(result != null) {
				ArrayAdapter<String> adp1 = new ArrayAdapter<String>(context.getApplicationContext(), android.R.layout.simple_spinner_item, result);
				adp1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				spinner.setAdapter(adp1);
			}
			else {
				Toast.makeText(context, String.valueOf("Impossible de récupérer la liste des affaires"), Toast.LENGTH_SHORT).show();
			}
		}
	}
}

