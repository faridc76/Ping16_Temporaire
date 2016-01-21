package fr.ineo.ping16;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class ChantierActivity extends Activity {

	private Spinner chantierspinner;
	private Button btnSubmit_ch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chantier);



		addListenerOnButton();
		addListenerOnSpinnerItemSelection();

	}
	// add items into spinner dynamically


	public void addListenerOnSpinnerItemSelection() {
		chantierspinner = (Spinner) findViewById(R.id.chantierspinner);
		chantierspinner.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}

		});

	}


	// get the selected dropdown list value
	public void addListenerOnButton() {

		chantierspinner = (Spinner) findViewById(R.id.chantierspinner);	
		btnSubmit_ch = (Button) findViewById(R.id.btnSubmit_ch);

		btnSubmit_ch.setOnClickListener(new OnClickListener() {

			@Override

			public void onClick(View v) {


				Intent intent = new Intent(ChantierActivity.this, MenuActivity.class);
				startActivity(intent);
			}

		});
	}
}
