package json;

import com.google.gson.Gson;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.widget.Toast;
import dao.IAffaireDB;
import dto.Affaire;
import json.db.AffaireDB;

/**
 * Classe permettant de récupérer toutes les infos sur une affaire à partir de son nom fournit en paramètre
 * @author Ping16
 *
 */

public class InfoAffaireRequete extends AsyncTask<Object, Void, Affaire> {
	
	private Context context = null;
	private String nomAffaire = null;
	
	@Override
	protected Affaire doInBackground(Object... params) {
		nomAffaire = (String)params[0];
		context = (Context)params[1];
		IAffaireDB affaireDB = new AffaireDB();
		
		return affaireDB.recupAffaire(nomAffaire);
	}

	@Override
	protected void onPostExecute(Affaire result) {
		if(context != null && nomAffaire != null) {
			if(result != null) {
				Toast.makeText(context, String.valueOf(result), Toast.LENGTH_SHORT).show();
				SharedPreferences sharedPreferences = context.getSharedPreferences("mesPrefs", context.MODE_PRIVATE);
				Editor editor = sharedPreferences.edit();
				Gson gson = new Gson();
				editor.putString("affaire", gson.toJson(result));
				editor.commit();
			}
			else {
				Toast.makeText(context, String.valueOf("nomAffaire ne doit pas être null"), Toast.LENGTH_SHORT).show();
			}
		}
		
	}

}

