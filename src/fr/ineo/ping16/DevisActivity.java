package fr.ineo.ping16;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class DevisActivity extends Activity {
	
	private Spinner devisspinner;
	private Button btnSubmit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_devis);
		
	
		
		addListenerOnButton();
		addListenerOnSpinnerItemSelection();
       
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
