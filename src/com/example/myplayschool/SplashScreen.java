package com.example.myplayschool;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.example.myplayschool.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashScreen extends Activity {
	
	private ProgressBar progressBar;
	 private int progressStatus = 0;
	 private Handler handler = new Handler();

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);
		
		 progressBar = (ProgressBar) findViewById(R.id.progressBar1);

		
		
		 new Thread(new Runnable() {
		     public void run() {
		        while (progressStatus < 100) {
		           progressStatus += 2;
		    
		    handler.post(new Runnable() {
		    public void run() {
		       progressBar.setProgress(progressStatus);
		       
		    }
		        });
		        try {
		           
		           Thread.sleep(100);
		        } catch (InterruptedException e) {
		           e.printStackTrace();
		        }
		     }
		        
		        Intent in=new Intent(SplashScreen.this,WelcomeScreen.class);
				startActivity(in);
				finish();
		  }
		  }).start();
		
		
//		new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run() {
//            	
//            }
//        }, 2000);
		
		


	

	
	
	}
}