package json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.StrictMode;
import dao.IAffaireDB;

public class AffaireDB implements IAffaireDB {
	
	public final static String DOMAINE = "http://faridchouakria.free.fr/webservices/";
	
	@Override
	public List<String> listeAffaire(int id_utilisateur) {
		String result = "";
		OutputStreamWriter writer = null;
		BufferedReader reader = null;
		ArrayList<String> list = null;
		try {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
			StrictMode.setThreadPolicy(policy); 
			
			URL url = new URL(DOMAINE + "recup_affaire_utilisateur.php");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true); // Pour pouvoir envoyer des donn�es
			connection.setRequestMethod("POST");
			writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write("id_utilisateur=" + String.valueOf(id_utilisateur));
			writer.flush();
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String ligne;
			while ((ligne = reader.readLine()) != null) {
				System.out.println(ligne);
				result += ligne;
			}
			list = new ArrayList<String>();
			JSONObject obj = new JSONObject(result);
			JSONArray jsonArray = obj.getJSONArray("amodifier");
			if (jsonArray != null) { 
					int len = jsonArray.length();
					for (int i=0;i<len;i++) { 
						list.add(jsonArray.get(i).toString());
				   } 
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try{writer.close();}catch(Exception e){}
			try{reader.close();}catch(Exception e){}
		}
		return list;
	}

}
