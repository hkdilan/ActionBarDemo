package com.hkdilan.android.actionbardemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.ActionMode;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class SherlockContexualActionBar extends SherlockActivity {
	private static final String TAG = SherlockContexualActionBar.class.getSimpleName();
	
	private ActionMode mActionMode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple_contextual_actionbar);
		
		final EditText editText = (EditText) findViewById(R.id.editText1);
		editText.setOnLongClickListener(new View.OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				if(mActionMode != null){
					return false;//continue to super
				}
				
				mActionMode = SherlockContexualActionBar.this.startActionMode(mActionCallBack);
				return true;//handled
			}
		});
	}
	
	private ActionMode.Callback mActionCallBack = new ActionMode.Callback() {
		
		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			Log.v(TAG, "onCreateActionMode()");
			return false;
		}
		
		@Override
		public void onDestroyActionMode(ActionMode mode) {
			Log.v(TAG, "onDestroyActionMode()");
			mActionMode = null;
		}
		
		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			Log.v(TAG, "onCreateActionMode()");
			final MenuInflater inflater = getSupportMenuInflater();
			inflater.inflate(R.menu.simple_contextual_menu, menu);
			return true;//handled
		}
		
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
