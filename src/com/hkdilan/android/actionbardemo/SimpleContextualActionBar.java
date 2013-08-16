package com.hkdilan.android.actionbardemo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/*
 * ActionMode is available api 11 or higher
 */
@SuppressLint("NewApi")
public class SimpleContextualActionBar extends Activity {
	private static final String TAG = SimpleContextualActionBar.class.getSimpleName();

	private ActionMode mActionMode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.v(TAG, "onCreate()");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_contextual_actionbar);
		
		final EditText editText = (EditText) findViewById(R.id.editText1);
		editText.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				if(mActionMode != null){
					return false;//pass event back to event flow.
				}
				
				mActionMode = SimpleContextualActionBar.this.startActionMode(mActionCallback);
				editText.setSelected(true);
				return true;//stop event flow
			}
		});
	}
	
	private ActionMode.Callback mActionCallback = new ActionMode.Callback() {
		
		// Called each time the action mode is shown. Always called after
	    // onCreateActionMode, but
	    // may be called multiple times if the mode is invalidated.
		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			Log.v(TAG, "onCreateActionMode()");
			return false;//false-nothing is done
		}
		
		@Override
		public void onDestroyActionMode(ActionMode mode) {
			Log.v(TAG, "onDestroyActionMode()");
			mActionMode = null;
		}
		
		// Called when the action mode is created; startActionMode() was called
		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			Log.v(TAG, "onCreateActionMode()");
			final MenuInflater inflater = getMenuInflater();
			inflater.inflate(R.menu.simple_contextual_menu, menu);
			return true;//true-created
		}
		
		// Called when the user selects a contextual menu item
		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			Log.v(TAG, "onDestroyActionMode()");
			switch (item.getItemId()) {
			case R.id.toast:
				Toast.makeText(getApplicationContext(), "CAB is working.", Toast.LENGTH_LONG).show();
				mode.finish();//action picked, so close the CAB
				return true;
			default:
				return false;
			}
		}
	};
}
