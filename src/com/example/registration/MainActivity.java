package com.example.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	DatabaseHelper helper = new DatabaseHelper(this);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText et1 = (EditText) findViewById(R.id.name);
		final EditText et2 = (EditText) findViewById(R.id.password1);
		Button login = (Button) findViewById(R.id.register);
		Button signup = (Button) findViewById(R.id.signup);
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String str = et1.getText().toString();
				String pass = et2.getText().toString();
				
				String password = helper.searchPass(str);
				if(pass.equals(password))
				{
					Intent i = new Intent(MainActivity.this,Redirect.class);
					i.putExtra("User",str);
					startActivity(i);
				}
				else
					Toast.makeText(getBaseContext(), "Login Failed! Please Signup or check your credentials", Toast.LENGTH_LONG).show();
				
			}
		});
		signup.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i2 = new Intent(MainActivity.this,Signup.class);
				startActivity(i2);
			}
		});
	}

}
