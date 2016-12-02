package com.example.myplayschool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myplayschool.R;

public class Regsitration extends Activity
{
	EditText editTextUserName,editTextPassword,editTextConfirmPassword;
	Button btnCreateAccount;
	Database db;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.signup);

		// get Instance  of Database Adapter
	
		
		db = new Database(this);
		
		// Get Refferences of Views
		editTextUserName=(EditText)findViewById(R.id.editTextUserName);
		editTextPassword=(EditText)findViewById(R.id.editTextPassword);
		editTextConfirmPassword=(EditText)findViewById(R.id.editTextConfirmPassword);

		btnCreateAccount=(Button)findViewById(R.id.buttonCreateAccount);
		btnCreateAccount.setOnClickListener(new View.OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub

			String userName=editTextUserName.getText().toString();
			String password=editTextPassword.getText().toString();
			String confirmPassword=editTextConfirmPassword.getText().toString();

			// check if any of the fields are vaccant
			if(userName.equals("")||password.equals("")||confirmPassword.equals(""))
			{
					Toast.makeText(getApplicationContext(), "Field Vaccant", Toast.LENGTH_LONG).show();
					return;
			}
			// check if both password matches
			if(!password.equals(confirmPassword))
			{
				Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
				return;
			}
			else
			{
			    // Save the Data in Database
				

			    db.addContact(userName, password);
			    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
			   Intent intent=new Intent(Regsitration.this,WelcomeScreen.class);
			   startActivity(intent);
			    finish();
			}
		}
	});
}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		
	}
}