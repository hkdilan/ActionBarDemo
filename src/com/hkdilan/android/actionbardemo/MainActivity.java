package com.hkdilan.android.actionbardemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/*
 * if you want sherlock then application theme should be as android:theme="@style/Theme.Sherlock"
 * unless it should be as android:theme="@style/AppTheme"
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//11 or higher
		//simple action bar; no action bar only context menu for less than 11
		final Button btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, ActionBar11Greater.class));
			}
		});
		
		//simple CAB; 11 or higher
		final Button btn2 = (Button) findViewById(R.id.button2);
		btn2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.HONEYCOMB){
					startActivity(new Intent(MainActivity.this, ContextualActionBar11Greater.class));
				}else{
					Toast.makeText(MainActivity.this, "android version level is less than 11. need support library v7", Toast.LENGTH_LONG).show();
				}
			}
		});
		
		
		//support library
		//simple action bar with support library v7
		
		//CAB with support library v7
		
		//sherlock
		//simple sherlock action bar
		final Button btn3 = (Button) findViewById(R.id.button3);
		btn3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, SherlockActionBar.class));
			}
		});
		
		//CAB with sherlock
		final Button btn4 = (Button) findViewById(R.id.button4);
		btn4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this, SherlockContexualActionBar.class));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
