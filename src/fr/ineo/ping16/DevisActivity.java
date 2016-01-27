package fr.ineo.ping16;

import com.google.gson.Gson;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import dto.Affaire;
import json.DownloadTask;
import json.ListeDocumentRequete;
import android.widget.Button;
import android.widget.Spinner;

public class DevisActivity extends Activity implements OnClickListener{

	private Spinner devisspinner;
	private Button btnSubmit;

	private ProgressDialog mProgressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_devis);



		addListenerOnButton();
		devisspinner = (Spinner) findViewById(R.id.devisspinner);


		SharedPreferences sharedPreferences = getSharedPreferences("mesPrefs", MODE_PRIVATE);
		Gson gson = new Gson();
		String jsonAffaire = sharedPreferences.getString("affaire", "");
		Affaire affaire = gson.fromJson(jsonAffaire, Affaire.class);

		new ListeDocumentRequete().execute(affaire, devisspinner, this.getApplicationContext());
		Button downloadButton = (Button) findViewById(R.id.downloadButton);
		downloadButton.setOnClickListener(this);
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

	@Override
	public void onClick(View v) {

		// instantiate it within the onCreate method
		mProgressDialog = new ProgressDialog(this);
		mProgressDialog.setMessage("Please wait ...");
		mProgressDialog.setIndeterminate(true);
		mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		mProgressDialog.setCancelable(true);
		
		SharedPreferences sharedPreferences = getSharedPreferences("mesPrefs", MODE_PRIVATE);
		Gson gson = new Gson();
		String jsonAffaire = sharedPreferences.getString("affaire", "");
		Affaire affaire = gson.fromJson(jsonAffaire, Affaire.class);
		
		// execute this when the downloader must be fired
		final DownloadTask downloadTask = new DownloadTask(this, mProgressDialog);
		downloadTask.execute(affaire.getNom(), devisspinner.getSelectedItem().toString());

		mProgressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
			@Override
			public void onCancel(DialogInterface dialog) {
				downloadTask.cancel(true);
			}
		});
	}
}
