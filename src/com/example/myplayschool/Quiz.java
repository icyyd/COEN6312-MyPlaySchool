package com.example.myplayschool;

import com.example.myplayschool.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Quiz extends Activity implements OnClickListener{

	Button opt1,opt2,opt3,next;
	int i=0; // postion of array
	static int score;
	String number;
	ImageView itemimg;
//	public static int getScore()
//	{
//		return score;
//	}
//	public static void setScore()
//	{
//		score++;
//	}
	Integer imgview[] = {
			R.drawable.qa,R.drawable.qb,R.drawable.qc,
			R.drawable.qd,R.drawable.qf,R.drawable.qi,
			R.drawable.ql,R.drawable.qm,R.drawable.qo,
			R.drawable.qr,R.drawable.qu,R.drawable.qw,			
			R.drawable.qt,R.drawable.qh,R.drawable.qss,
			R.drawable.qaa,R.drawable.qoo,R.drawable.qcc,
			R.drawable.qpp,R.drawable.pencil
	};
	String buttons[] = {
			"Apple","Ball","Cat","Dog",
			"Fish","Ice cream","Lion","Mango","Orange","Rose",
			"Umbrella","Watermelon","Tomato","Hat","Shirt","Aeroplane",
			"Onion","capsicum","Peas","pencil"
	};


	int ans[]=    {0,1,2, 3,4,5, 6, 7,8,9, 10,11,12,13,14,15,16,17,18,19};  
	int option1[]={6,3,11,6,2,5, 18,7,12,9, 15,19,12, 0,14,1, 2,3, 7,19};
	int option2[]={0,4,12,3,1,0,6, 16,18,10,10,15,8,13,2,15,16,4,18,11};
	int option3[]={4,1,2, 7,4,17,13, 11,8,11,18,11,17,7,3,17,13,17,12,17};
	MediaPlayer clap ,wrong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quiz_play_page);

		clap=MediaPlayer.create(this, R.raw.applause);
		wrong=MediaPlayer.create(this, R.raw.wrong);
		itemimg = (ImageView)findViewById(R.id.items);

	//	score=0;
		next = (Button)findViewById(R.id.next);
		opt1 = (Button)findViewById(R.id.opt1);
		opt2 = (Button)findViewById(R.id.opt2);
		opt3 = (Button)findViewById(R.id.opt3);
		itemimg.setImageResource(imgview[0]);
		opt1.setText(buttons[option1[0]]);
		opt2.setText(buttons[option2[0]]);
		opt3.setText(buttons[option3[0]]);
		opt1.setOnClickListener(this);
		opt2.setOnClickListener(this);
		opt3.setOnClickListener(this);
		next.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				opt1.setEnabled(true);
				opt2.setEnabled(true);
				opt3.setEnabled(true);
				opt1.setVisibility(View.VISIBLE);
				opt2.setVisibility(View.VISIBLE);
				opt3.setVisibility(View.VISIBLE);
				next.setVisibility(View.GONE);

				if(i<=18)
				{
					i++;
					itemimg.setImageResource(imgview[i]);
					opt1.setText(buttons[option1[i]]);
					opt2.setText(buttons[option2[i]]);
					opt3.setText(buttons[option3[i]]);


				}
				if(i==19)
				{
					itemimg.setImageResource(imgview[i]);
					opt1.setText(buttons[option1[i]]);
					opt2.setText(buttons[option2[i]]);
					opt3.setText(buttons[option3[i]]);

					//next.setVisibility(View.VISIBLE);
					next.setOnClickListener(new OnClickListener() {

						public void onClick(View v) {
							// TODO Auto-generated method stub
							
							ScoreDialoge dialog = new ScoreDialoge();
							dialog.show(getFragmentManager(), "MyDialogFragmentTag");
							
							
							
//							Intent intent = new Intent(getApplicationContext(),HomeScreen.class);
//							//intent.putExtra("SCORE", score);
//							
//							Bundle bundle = new Bundle();
//
//							//Add your data to bundle
//							bundle.putInt("SCORE", score);
//
//							//Add the bundle to the intent
//							intent.putExtras(bundle);
//							
//							startActivity(intent);
//							finish();
						}
					});

				}
			}
		});

	}
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.opt1:

			if(option1[i]==ans[i])
			{

				clap.start();
				next.setVisibility(View.VISIBLE);
			//	score=score+5;
				opt1.setEnabled(false);
				opt2.setEnabled(false);
				opt3.setEnabled(false);
				Toast.makeText(getApplicationContext(), "Hurray!!", 2000).show();
				score++;
				System.out.println(" score -----------------   "+score);
			//	this.setScore();
			}

			else
			{
				Toast.makeText(getApplicationContext(), "Wrong!!", 2000).show();
				wrong.start();

				if(option2[i]==ans[i])
				{

					next.setVisibility(View.VISIBLE);

					opt1.setEnabled(false);
					opt2.setEnabled(false);
					opt3.setEnabled(false);

					//alert_wrng.setVisibility(View.VISIBLE);

				}

				else if(option3[i]==ans[i])
				{

					next.setVisibility(View.VISIBLE);

					opt1.setEnabled(false);
					opt2.setEnabled(false);
					opt3.setEnabled(false);

					//alert_wrng.setVisibility(View.VISIBLE);
				}
				else
				{

					Toast.makeText(getApplicationContext(), "Wrong!!", 2000).show();
				}
				//Toast.makeText(getApplicationContext(), "//wrong", 2000).show();
			}


			break;
		case R.id.opt2:



			if(option2[i]==ans[i])
			{
				clap.start();
				next.setVisibility(View.VISIBLE);
				//score= score+5;
				opt1.setEnabled(false);
				opt2.setEnabled(false);
				opt3.setEnabled(false);
				//alert.setVisibility(View.VISIBLE);
				score++;
				Toast.makeText(getApplicationContext(), "Hurray!!", 2000).show();
				//Toast.makeText(getApplicationContext(), "score"+score, 2000).show();
			}

			else

			{
				wrong.start();
				if(option1[i]==ans[i])
				{

					next.setVisibility(View.VISIBLE);
					opt1.setEnabled(false);
					opt2.setEnabled(false);
					opt3.setEnabled(false);
					//Toast.makeText(getApplicationContext(), "Alas!!", 2000).show();
					//alert_wrng.setVisibility(View.VISIBLE);
				}
				else if(option3[i]==ans[i])
				{
					next.setVisibility(View.VISIBLE);
					opt1.setEnabled(false);
					opt2.setEnabled(false);
					opt3.setEnabled(false);

					//alert_wrng.setVisibility(View.VISIBLE);
				}
				Toast.makeText(getApplicationContext(), "Wrong!!", 2000).show();
				//Toast.makeText(getApplicationContext(), "//wrong", 2000).show();
			}

			break;
		case R.id.opt3:

			//Toast.makeText(getApplicationContext(), "Hurray!!", 2000).show();

			if(option3[i]==ans[i])
			{
				clap.start();

				next.setVisibility(View.VISIBLE);
				//score= score+5;
				opt1.setEnabled(false);
				opt2.setEnabled(false);
				opt3.setEnabled(false);
				Toast.makeText(getApplicationContext(), "Hurray!!", 2000).show();
				score++;
				//alert.setVisibility(View.VISIBLE);
				//  Toast.makeText(getApplicationContext(), "score"+score, 2000).show();
			}
			else

			{
				wrong.start();
				if(option1[i]==ans[i])
				{

					next.setVisibility(View.VISIBLE);
					opt1.setEnabled(false);
					opt2.setEnabled(false);
					opt3.setEnabled(false);
					//alert_wrng.setVisibility(View.VISIBLE);
				}
				else if(option2[i]==ans[i])
				{

					next.setVisibility(View.VISIBLE);
					opt1.setEnabled(false);
					opt2.setEnabled(false);
					opt3.setEnabled(false);

					//alert_wrng.setVisibility(View.VISIBLE);
				}
				Toast.makeText(getApplicationContext(), "Wrong!!", 2000).show();
				//Toast.makeText(getApplicationContext(), "//wrong", 2000).show();
			}

			break;

		default:
			break;
		}
	}

	@Override
	public void onBackPressed(){

		finish();
	}

}




