package com.hkdilan.android.actionbardemo;

import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class SherlockActionBar extends SherlockActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//set layout xml file
		setContentView(R.layout.simple_actionbar);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		final MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.simple_menu, menu);
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
