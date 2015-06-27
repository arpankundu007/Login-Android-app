package com.example.registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Redirect extends MainActivity {
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.redirect);
	String user = getIntent().getStringExtra("User");
	Button lo = (Button) findViewById(R.id.logout);
	lo.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(Redirect.this, MainActivity.class);
			startActivity(i);
			
		}
	});
	TextView tv = (TextView) findViewById(R.id.textView2);
	tv.setText(user);
	
}
}
