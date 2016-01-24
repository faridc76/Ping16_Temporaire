package fr.ineo.ping16;

import android.app.Activity;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import json.AutoCompleteContactRequete;

public class ContactActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {         

		super.onCreate(savedInstanceState);    
		setContentView(R.layout.activity_contact);
		
		new AutoCompleteContactRequete().execute(findViewById(R.id.selectContact), this.getApplicationContext());
	}

}
