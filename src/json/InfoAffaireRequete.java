package json;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import dao.IAffaireDB;
import dto.Affaire;
import json.db.AffaireDB;

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
			}
			else {
				Toast.makeText(context, String.valueOf("nomAffaire ne doit pas être null"), Toast.LENGTH_SHORT).show();
			}
		}
		
	}

}

