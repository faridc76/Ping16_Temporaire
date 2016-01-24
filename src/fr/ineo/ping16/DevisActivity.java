package fr.ineo.ping16;


import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import dto.Affaire;
import json.ListeDocumentRequete;
import android.widget.Button;
import android.widget.Spinner;

public class DevisActivity extends Activity {
	
	private Spinner devisspinner;
	private Button btnSubmit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_devis);
		
		
		
		addListenerOnButton();
		addListenerOnSpinnerItemSelection();
		
		
		SharedPreferences sharedPreferences = getSharedPreferences("mesPrefs", MODE_PRIVATE);
		Gson gson = new Gson();
		String jsonAffaire = sharedPreferences.getString("affaire", "");
		Affaire affaire = gson.fromJson(jsonAffaire, Affaire.class);
       
		new ListeDocumentRequete().execute(affaire, devisspinner, this.getApplicationContext());
	}
	// add items into spinner dynamically
	 

	  public void addListenerOnSpinnerItemSelection() {
		devisspinner = (Spinner) findViewById(R.id.devisspinner);
		devisspinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
	  }


	  // get the selected dropdown list value
	  public void addListenerOnButton() {

		devisspinner = (Spinner) findViewById(R.id.devisspinner);	
		btnSubmit = (Button) findViewById(R.id.btnSubmit);

		btnSubmit.setOnClickListener(new OnClickListener() {

		  @Override
		 
			  public void onClick(View v) {
				  
			 
			  	Intent intent = new Intent(DevisActivity.this, ChoixDevisActivity.class);
				startActivity(intent);
					   }
		    
		  
		  
		});
}
}
