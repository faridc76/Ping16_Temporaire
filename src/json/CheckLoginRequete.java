package json;

import com.google.gson.Gson;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.widget.Toast;
import dao.IUtilisateurDB;
import dto.Utilisateur;
import fr.ineo.ping16.MenuActivity;
import json.db.UtilisateurDB;

public class CheckLoginRequete extends AsyncTask<Object, Void, Utilisateur> {
	
	private Context context = null;
	private String matricule = null;
	private String password = null;
	
	@Override
	protected Utilisateur doInBackground(Object... params) {
		matricule = (String)params[0];
		password = (String)params[1];
		context = (Context)params[2];
		IUtilisateurDB utilisateurDB = new UtilisateurDB();
		
		return utilisateurDB.checkLogin(matricule, password);
	}

	@Override
	protected void onPostExecute(Utilisateur result) {
		if(context != null && matricule != null) {
			if(result != null) {
				Toast.makeText(context, String.valueOf("Vous �tes connect�s en tant que " + result.getPrenom() + " " + result.getNom()), Toast.LENGTH_SHORT).show();
				
				SharedPreferences sharedPreferences = context.getSharedPreferences("mesPrefs", context.MODE_PRIVATE);
				Editor editor = sharedPreferences.edit();
				Gson gson = new Gson();
				editor.putString("utilisateur", gson.toJson(result));
				editor.commit();
				
				Intent intent = new Intent(context, MenuActivity.class);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				
				context.startActivity(intent);
				//Intent...
			}
			else {
				Toast.makeText(context, String.valueOf("Identifiants incorrects"), Toast.LENGTH_SHORT).show();
			}
		}
		
	}

}

