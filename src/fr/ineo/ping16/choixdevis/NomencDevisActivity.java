package fr.ineo.ping16.choixdevis;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NomencDevisActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TextView textview = new TextView(this);
		textview.setText("Nomenclature");
		setContentView(textview);
	}

}
