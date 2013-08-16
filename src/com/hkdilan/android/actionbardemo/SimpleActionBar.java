package com.hkdilan.android.actionbardemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

/**
 * works only for api 11 or higher
 * @author UnicornDCH
 *
 */
public class SimpleActionBar extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//set layout xml file
		setContentView(R.layout.simple_actionbar);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		//creae menu inflater
		final MenuInflater inflater = getMenuInflater();
		
		//inflate
		inflater.inflate(R.menu.simple_menu, menu);
		
		//tell that menu is created.
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch(item.getItemId()){
		case R.id.action_add:
			Toast.makeText(this, "Action Add selected", Toast.LENGTH_LONG).show();
			break;
		case R.id.action_setting:
			Toast.makeText(this, "Action setting selected", Toast.LENGTH_LONG).show();
		}
		
		return true;
	}
}
