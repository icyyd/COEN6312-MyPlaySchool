package com.example.myplayschool;



import com.example.myplayschool.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Home extends Activity implements OnClickListener{

	Button learnbtn,quizbtn,quitbtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_page);
		
		learnbtn=(Button) findViewById(R.id.startlearnbtn);
		quizbtn=(Button)findViewById(R.id.startquizbtn);
		quitbtn=(Button)findViewById(R.id.quitbtn);

		learnbtn.setOnClickListener(this);
		quizbtn.setOnClickListener(this);
		quitbtn.setOnClickListener(this);
		Bundle bundle = getIntent().getExtras();

		//Extract the data…
		int score=0;
		try{
		score = bundle.getInt("SCORE");
		}
		catch(NullPointerException e)
		{
			
		}
		System.out.println("SCore------------------"+score);
	
}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
		case R.id.startlearnbtn:
			
			Intent inplay=new Intent(getApplicationContext(),AlphabetList.class);
			startActivity(inplay);

			break;
		case R.id.startquizbtn:
			
			Intent inquiz=new Intent(getApplicationContext(),Quiz.class);
			startActivity(inquiz);

			break;
		case R.id.quitbtn:
			finish();

			break;

		default:
			break;
		}

	}
}