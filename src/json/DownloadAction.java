package json;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.Toast;
import dto.Affaire;

public class DownloadAction extends AsyncTask<Object, Integer, String> {

    private Context context;
    public final static String DOCUMENT = "http://faridchouakria.free.fr/documents/";

    @Override
    protected String doInBackground(Object... params) {
    	context = (Context) params[1];
    	
        InputStream input = null;
        OutputStream output = null;
        HttpURLConnection connection = null;
        
        SharedPreferences sharedPreferences = context.getSharedPreferences("mesPrefs", context.MODE_PRIVATE);
		Gson gson = new Gson();
		String jsonAffaire = sharedPreferences.getString("affaire", "");
		Affaire affaire = gson.fromJson(jsonAffaire, Affaire.class);
		
        try {
            URL url = new URL(DOCUMENT + affaire.getNom() + "/" + (String) params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                return "Server returned HTTP " + connection.getResponseCode()
                        + " " + connection.getResponseMessage();
            }


            // download the file
            input = connection.getInputStream();
            
            File directory = new File(Environment.getExternalStorageDirectory().getPath() + "/" + affaire.getNom() + "/");
            directory.mkdirs();
            
            System.out.println(Environment.getExternalStorageDirectory().getPath() + "/" + affaire.getNom() + "/");
            output = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + "/" + (String) params[0]);

            byte data[] = new byte[4096];
            int count;
            while ((count = input.read(data)) != -1) {
                // allow canceling with back button
                if (isCancelled()) {
                    input.close();
                    return null;
                }
                
                output.write(data, 0, count);
            }
        } catch (Exception e) {
            return e.toString();
        } finally {
            try {
                if (output != null)
                    output.close();
                if (input != null)
                    input.close();
            } catch (IOException ignored) {
            }

            if (connection != null)
                connection.disconnect();
        }
        return null;
    }
    
    @Override
	protected void onPostExecute(final String result) {
		if(context != null) {
			if(result != null) {
				Toast.makeText(context, String.valueOf(result), Toast.LENGTH_SHORT).show();
				System.out.println(result);
			}
		}
	}
}