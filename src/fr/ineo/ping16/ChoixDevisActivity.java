package fr.ineo.ping16;


import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class ChoixDevisActivity extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {         

		super.onCreate(savedInstanceState);    
		setContentView(R.layout.activity_choixdevis);

		Resources ressources = getResources(); 
		TabHost tabHost = getTabHost(); 

		// Android tab
		Intent intentMetre = new Intent().setClass(this, fr.ineo.ping16.choixdevis.MetreDevisActivity.class);
		TabSpec tabSpecMetre = tabHost
				.newTabSpec("Metre")
				.setContent(intentMetre);

		// Apple tab
		Intent intentDetail = new Intent().setClass(this, fr.ineo.ping16.choixdevis.DetailDevisActivity.class);
		TabSpec tabSpecDetail = tabHost
				.newTabSpec("Detail")
				.setContent(intentDetail);

		// Windows tab
		Intent intentRemise = new Intent().setClass(this, fr.ineo.ping16.choixdevis.RemiseDevisActivity.class);
		TabSpec tabSpecRemise = tabHost
				.newTabSpec("Remise")
				.setContent(intentRemise);

		// Blackberry tab
		Intent intentCoef = new Intent().setClass(this, fr.ineo.ping16.choixdevis.CoefDevisActivity.class);
		TabSpec tabSpecCoef = tabHost
				.newTabSpec("Coef")
				.setContent(intentCoef);

		// Blackberry tab
		Intent intentClient = new Intent().setClass(this, fr.ineo.ping16.choixdevis.ClientDevisActivity.class);
		TabSpec tabSpecClient = tabHost
				.newTabSpec("Client")
				.setContent(intentClient);

		// Blackberry tab
		Intent intentTrav = new Intent().setClass(this, fr.ineo.ping16.choixdevis.TravDevisActivity.class);
		TabSpec tabSpecTrav = tabHost
				.newTabSpec("Trav")
				.setContent(intentTrav);

		// Blackberry tab
		Intent intentNomenc = new Intent().setClass(this, fr.ineo.ping16.choixdevis.NomencDevisActivity.class);
		TabSpec tabSpecNomenc = tabHost
				.newTabSpec("Nomenc")
				.setContent(intentNomenc);

		// add all tabs 
		tabHost.addTab(tabSpecMetre);
		tabHost.addTab(tabSpecDetail);
		tabHost.addTab(tabSpecRemise);
		tabHost.addTab(tabSpecCoef);
		tabHost.addTab(tabSpecClient);
		tabHost.addTab(tabSpecTrav);
		tabHost.addTab(tabSpecNomenc);


		//set Windows tab as default (zero based)
		tabHost.setCurrentTab(2);
	}

}