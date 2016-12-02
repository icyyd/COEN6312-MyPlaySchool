package com.example.myplayschool;



import java.util.Arrays;
import com.example.myplayschool.R;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.LoginButton;
import com.facebook.widget.LoginButton.UserInfoChangedCallback;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class WelcomeScreen extends FragmentActivity {

	Button Signin_btn,Fb_signinbtn,Sign_up_btn;

	
	String userName,password;
	Database db;
	EditText editTextUserName,editTextPassword;
	
	
	private LoginButton loginBtn;
	private TextView username;
	private UiLifecycleHelper uiHelper;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		uiHelper = new UiLifecycleHelper(this, statusCallback);
		uiHelper.onCreate(savedInstanceState);
		
		setContentView(R.layout.signin);
		
		Signin_btn=(Button)findViewById(R.id.signin_btn);
	
		Sign_up_btn=(Button)findViewById(R.id.signup_btn);
	
		 db = new Database(this);
		 
		
	     editTextUserName=(EditText)findViewById(R.id.email_edttxt);
		 editTextPassword=(EditText)findViewById(R.id.password_edttxt);
		 
			loginBtn = (LoginButton) findViewById(R.id.fb_login_button);
			loginBtn.setReadPermissions(Arrays.asList("email"));
			loginBtn.setUserInfoChangedCallback(new UserInfoChangedCallback() {
				@Override
				public void onUserInfoFetched(GraphUser user) {
					if (user != null) {
						//username.setText("You are currently logged in as " + user.getName());
						Toast.makeText(WelcomeScreen.this, "Congrats: You are logged in as "+user.getName(), Toast.LENGTH_LONG).show();
						Intent intent=new Intent(WelcomeScreen.this,Home.class);
						startActivity(intent);
						finish();
						
					} else {
						//username.setText("You are not logged in.");
					}
				}
			});
	     
		
		
		Signin_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// get The User name and Password
				userName=editTextUserName.getText().toString();
			     password=editTextPassword.getText().toString();

				// fetch the Password form database for respective user name
				String storedPassword=db.getUser(userName);
				
				System.out.println("Stored Password======================================================"+storedPassword);
				// check if the Stored password matches with  Password entered by user
				if(password.equals(storedPassword) && !password.equals(""))
				{
					
					Toast.makeText(WelcomeScreen.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
					Intent intent=new Intent(WelcomeScreen.this,Home.class);
					startActivity(intent);
					finish();
					
				}
				else
				{
					System.out.println("demo=-======================================================"+password);
					
					Toast.makeText(WelcomeScreen.this, "User Name or Password does not match", Toast.LENGTH_LONG).show();
				
				}
			}
		});
		
		
		Sign_up_btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(WelcomeScreen.this,Regsitration.class);
				startActivity(intent);
				finish();
			}
		});

		
		
		
	

	
	
	
	
	
	
		
	

		
		
		
	}
	
	private Session.StatusCallback statusCallback = new Session.StatusCallback() {
		@Override
		public void call(Session session, SessionState state,
				Exception exception) {
			if (state.isOpened()) {
				Log.d("MainActivity", "Facebook session opened.");
			} else if (state.isClosed()) {
				Log.d("MainActivity", "Facebook session closed.");
			}
		}
	};
	
	@Override
	public void onResume() {
		super.onResume();
		uiHelper.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();
		uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		uiHelper.onDestroy();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onSaveInstanceState(Bundle savedState) {
		super.onSaveInstanceState(savedState);
		uiHelper.onSaveInstanceState(savedState);
	}
	
}
