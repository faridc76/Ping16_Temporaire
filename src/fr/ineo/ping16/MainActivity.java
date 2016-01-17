package fr.ineo.ping16;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import dao.IUtilisateurDB;
import dto.Utilisateur;
import json.MatriculeRequete;
import json.UtilisateurDB;

public class MainActivity extends Activity implements OnClickListener{

	private Button connexion = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		connexion = (Button) findViewById(R.id.btnCnx);
		connexion.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v == connexion){
			EditText matricule = (EditText) findViewById(R.id.matricule);
			EditText password = (EditText) findViewById(R.id.password);
			IUtilisateurDB utilisateurDB = new UtilisateurDB();
			Utilisateur utilisateur = null;
			// Pour tester le matricule
			new MatriculeRequete().execute(matricule.getText().toString(), this.getApplicationContext());
			// Il faudra mettre le checkLogin à la place !
		}
		
	}

	
}
