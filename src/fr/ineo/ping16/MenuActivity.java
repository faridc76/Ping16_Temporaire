package fr.ineo.ping16;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import dto.Utilisateur;

public class MenuActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		TextView tv = (TextView) findViewById(R.id.bienvenue);
		
		SharedPreferences sharedPreferences = getSharedPreferences("mesPrefs", MODE_PRIVATE);
		Gson gson = new Gson();
		String jsonUtilisateur = sharedPreferences.getString("utilisateur", "");
		Utilisateur utilisateur = gson.fromJson(jsonUtilisateur, Utilisateur.class);
		
		tv.setText(utilisateur.getPrenom() + " " + utilisateur.getNom());
		
		 final Button Devisbutton = (Button) findViewById(R.id.Devis);
		  Devisbutton.setOnClickListener(new OnClickListener() {
		
			  public void onClick(View v) {
			    Intent intent = new Intent(MenuActivity.this, DevisActivity.class);
			    startActivity(intent);
			    }
		  });
	}
	
	
}
