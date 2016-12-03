package com.example.myplayschool;

import java.util.ArrayList;

import com.example.myplayschool.R;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;


public class Learning extends Activity implements OnGestureListener, OnClickListener 
{
	ImageView imges;
	ViewGroup mContainer;
	ImageView mImageView,back,next,informations;
	private PopupWindow mpopup;
	GestureDetector gDetector;
	int position=0;
	private static final String LOGID = "CHECKTHISOUT";
	private static final int SWIPE_MIN_DISTANCE = 120;
	private static final int SWIPE_MAX_OFF_PATH = 250;
	private static final int SWIPE_THRESHOLD_VELOCITY = 300;
	// Names of the photos we show in the list
	ArrayList<Integer> imgs=new ArrayList<Integer>();
	ArrayList<Integer> PHOTOS1=new ArrayList<Integer>();
	ArrayList<Integer> PHOTOS_RESOURCES1=new ArrayList<Integer>();
	ArrayList<Integer> arrabc=new ArrayList<Integer>();

	MediaPlayer mp=new MediaPlayer();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		Intent IntentGetFromIndexList = getIntent();
		position = IntentGetFromIndexList.getIntExtra("keyForPostion", 0);

		informations = (ImageView)findViewById(R.id.inform);

		mContainer = (ViewGroup) findViewById(R.id.container);



		informations.setOnClickListener(new OnClickListener() 
		{            
			public void onClick(View arg0) 
			{
				View popUpView = getLayoutInflater().inflate(R.layout.popup_info, (ViewGroup) findViewById(R.layout.main)); // inflating popup layout
				mpopup = new PopupWindow(popUpView, LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, true); //Creation of popup
				mpopup.setAnimationStyle(android.R.style.Animation_Dialog);   
				mpopup.showAtLocation(popUpView, Gravity.CENTER, 0, 0);    // Displaying popup


				ImageView btnOk = (ImageView)popUpView.findViewById(R.id.closebutton);
				btnOk.setOnClickListener(new OnClickListener() 
				{                    
					public void onClick(View v) 
					{
						mpopup.dismiss();  //dismissing the popup
					}
				});



			}
		});  


		PHOTOS1.add(R.drawable.a);
		PHOTOS1.add(R.drawable.b);
		PHOTOS1.add(R.drawable.c);
		PHOTOS1.add(R.drawable.d);
		PHOTOS1.add(R.drawable.e);
		PHOTOS1.add(R.drawable.f);
		PHOTOS1.add(R.drawable.g);
		PHOTOS1.add(R.drawable.h);
		PHOTOS1.add(R.drawable.i);
		PHOTOS1.add(R.drawable.j);
		PHOTOS1.add(R.drawable.k);
		PHOTOS1.add(R.drawable.l);
		PHOTOS1.add(R.drawable.m);
		PHOTOS1.add(R.drawable.n);
		PHOTOS1.add(R.drawable.o);
		PHOTOS1.add(R.drawable.p);
		PHOTOS1.add(R.drawable.q);
		PHOTOS1.add(R.drawable.r);
		PHOTOS1.add(R.drawable.s);
		PHOTOS1.add(R.drawable.t);
		PHOTOS1.add(R.drawable.u);
		PHOTOS1.add(R.drawable.v);
		PHOTOS1.add(R.drawable.w);
		PHOTOS1.add(R.drawable.x);
		PHOTOS1.add(R.drawable.y);
		PHOTOS1.add(R.drawable.z);


		PHOTOS_RESOURCES1.add(R.drawable.awall);
		PHOTOS_RESOURCES1.add(R.drawable.bwall);
		PHOTOS_RESOURCES1.add(R.drawable.cwall);
		PHOTOS_RESOURCES1.add(R.drawable.dwall);
		PHOTOS_RESOURCES1.add(R.drawable.ewall);
		PHOTOS_RESOURCES1.add(R.drawable.fwall);
		PHOTOS_RESOURCES1.add(R.drawable.gwall);
		PHOTOS_RESOURCES1.add(R.drawable.hwall);
		PHOTOS_RESOURCES1.add(R.drawable.iwall);
		PHOTOS_RESOURCES1.add(R.drawable.jwall);	
		PHOTOS_RESOURCES1.add(R.drawable.kwall);
		PHOTOS_RESOURCES1.add(R.drawable.lwall);
		PHOTOS_RESOURCES1.add(R.drawable.mwall);
		PHOTOS_RESOURCES1.add(R.drawable.nwall);
		PHOTOS_RESOURCES1.add(R.drawable.owall);
		PHOTOS_RESOURCES1.add(R.drawable.pwall);
		PHOTOS_RESOURCES1.add(R.drawable.qwall);
		PHOTOS_RESOURCES1.add(R.drawable.rwall);
		PHOTOS_RESOURCES1.add(R.drawable.swall);
		PHOTOS_RESOURCES1.add(R.drawable.twall);
		PHOTOS_RESOURCES1.add(R.drawable.uwall);
		PHOTOS_RESOURCES1.add(R.drawable.vwall);
		PHOTOS_RESOURCES1.add(R.drawable.wall);
		PHOTOS_RESOURCES1.add(R.drawable.xwall);
		PHOTOS_RESOURCES1.add(R.drawable.ywall);
		PHOTOS_RESOURCES1.add(R.drawable.zwall);




		arrabc.add(R.raw.a);
		arrabc.add(R.raw.b);
		arrabc.add(R.raw.c);
		arrabc.add(R.raw.d);
		arrabc.add(R.raw.e);
		arrabc.add(R.raw.f);
		arrabc.add(R.raw.g);
		arrabc.add(R.raw.h);
		arrabc.add(R.raw.i);
		arrabc.add(R.raw.j);
		arrabc.add(R.raw.k);
		arrabc.add(R.raw.l);
		arrabc.add(R.raw.m);
		arrabc.add(R.raw.n);
		arrabc.add(R.raw.o);
		arrabc.add(R.raw.p);
		arrabc.add(R.raw.q);
		arrabc.add(R.raw.r);
		arrabc.add(R.raw.s);
		arrabc.add(R.raw.t);	
		arrabc.add(R.raw.u);
		arrabc.add(R.raw.v);
		arrabc.add(R.raw.w);
		arrabc.add(R.raw.x);
		arrabc.add(R.raw.y);
		arrabc.add(R.raw.z);







		mp = MediaPlayer.create(this,arrabc.get(position));
		mp.start();

		imges = (ImageView) findViewById(R.id.img);
		mImageView = (ImageView) findViewById(R.id.picture);
		back = (ImageView) findViewById(R.id.backbtn);
		next = (ImageView) findViewById(R.id.nextbtn);




		gDetector = new GestureDetector(this);
		imges.setImageResource(PHOTOS1.get(position));
		mImageView.setOnClickListener(this);
		try {

			next.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					position++;
					if(position==PHOTOS1.size())
					{

						Intent intent=new Intent(getApplicationContext(),AlphabetList.class);
						startActivity(intent);
						finish();

					}
					else if(position!=PHOTOS1.size())
					{
						imges.setImageResource(PHOTOS1.get(position));
						mp = MediaPlayer.create(getApplicationContext(),arrabc.get(position));
						mp.start();
					}

				}
			});
			back.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					// TODO Auto-generated method stub
					position--;
					if(position<0)
					{
						//position=PHOTOS1.size()-1;

						Intent inten=new Intent(getApplicationContext(),AlphabetList.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
						startActivity(inten);
						finish();
					}
					else if(position>=0)
					{
						imges.setImageResource(PHOTOS1.get(position));
						mp = MediaPlayer.create(getApplicationContext() ,arrabc.get(position));
						mp.start();
					}
				}
			});

		} catch (Exception e) {
			// TODO: handle exception
		}



	}

	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		// TODO Auto-generated method stub



		try {
			if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
				return false;
			// right to left swipe
			if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {


				position++;
				if(position==PHOTOS1.size())
				{
					Intent inter=new Intent(getApplicationContext(),AlphabetList.class);
					startActivity(inter);
					finish();

				}
				imges.setImageResource(PHOTOS1.get(position));
				mp = MediaPlayer.create(this,arrabc.get(position));
				mp.start();
				Log.v(LOGID,"right to left swipe detected");

				// Toast.makeText(getApplicationContext(), "Please Follows the link", 2000).show();


			} // left to right swipe 
			else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {

				position--;
				if(position<0)
				{
					//position=PHOTOS1.size()-1;

					Intent inte=new Intent(getApplicationContext(),AlphabetList.class).setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
					startActivity(inte);
					finish();
				}
				else if(position>=0)
				{
					imges.setImageResource(PHOTOS1.get(position));
					mp = MediaPlayer.create(this,arrabc.get(position));
					mp.start();
					Log.v(LOGID,"left to right swipe detected");                    
				}

			}
		} catch (Exception e) {
			// nothing
		}
		return true;
	}

	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub

	}


	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub

		if(position==0)
		{
			//	Toast.makeText(getApplicationContext(), "first Click", 1000).show();
			mContainer.setPersistentDrawingCache(ViewGroup.PERSISTENT_ANIMATION_CACHE);
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.apple);
			mp.start();

		}
		if(position==1)
		{
			//	Toast.makeText(getApplicationContext(), "second Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.boll);
			mp.start();
		}
		if(position==2)
		{
			//	Toast.makeText(getApplicationContext(), "third Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.car);
			mp.start();
		}
		if(position == 3){
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.dog);
			mp.start();
		}
		if(position==4)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.egg);
			mp.start();
		}
		if(position==5)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.fish);
			mp.start();
		}
		if(position==6)
		{
			//	Toast.makeText(getApplicationContext(), "second Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.grapes);
			mp.start();
		}
		if(position==7)
		{
			//	Toast.makeText(getApplicationContext(), "third Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.house);
			mp.start();
		}
		if(position==8)
		{
			//	Toast.makeText(getApplicationContext(), "fourth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.icecream);
			mp.start();
		}
		if(position==9)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.jug);
			mp.start();
		}
		if(position==10)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.kite);
			mp.start();
		}

		if(position==11)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.loc);
			mp.start();
		}

		if(position==12)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.mango);
			mp.start();
		}
		if(position==13)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.nest);
			mp.start();
		}
		if(position==14)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.orange);
			mp.start();
		}
		if(position==15)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.pencil);
			mp.start();
		}
		if(position==16)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.quil);
			mp.start();
		}
		if(position==17)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.rose);
			mp.start();
		}
		if(position==18)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.sunflower);
			mp.start();
		}
		if(position==19)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.tomato);
			mp.start();
		}
		if(position==20)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.umbrala);
			mp.start();
		}
		if(position==21)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.violin);
			mp.start();
		}
		if(position==22)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.watermelon);
			mp.start();
		}
		if(position==23)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.xylophone);
			mp.start();
		}
		if(position==24)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.yalk);
			mp.start();
		}
		if(position==25)
		{
			//	Toast.makeText(getApplicationContext(), "fifth Click", 1000).show();
			mImageView.setImageResource(PHOTOS_RESOURCES1.get(position));
			applyRotation(position, 0, 90);
			mp = MediaPlayer.create(this, R.raw.zebra);
			mp.start();
		}




		return true;
	}
	private void applyRotation(int position, float start, float end) {
		// Find the center of the container
		final float centerX = mContainer.getWidth() / 2.0f;
		final float centerY = mContainer.getHeight() / 2.0f;

		// Create a new 3D rotation with the supplied parameter
		// The animation listener is used to trigger the next animation
		final Rotate3dAnimation rotation =
			new Rotate3dAnimation(start, end, centerX, centerY, 310.0f, true);
		rotation.setDuration(500);
		rotation.setFillAfter(true);
		rotation.setInterpolator(new AccelerateInterpolator());
		rotation.setAnimationListener(new DisplayNextView(position));

		mContainer.startAnimation(rotation);
	}

	@Override
	public boolean onTouchEvent(MotionEvent me) {
		return gDetector.onTouchEvent(me);
	}

	final class DisplayNextView implements Animation.AnimationListener {
		private final int mPosition;

		DisplayNextView(int position) {
			mPosition = position;
		}

		public void onAnimationStart(Animation animation) {
		}

		public void onAnimationEnd(Animation animation) {

			mContainer.post(new SwapViews(mPosition));
		}

		public void onAnimationRepeat(Animation animation) {
		}
	}
	final class SwapViews implements Runnable {
		private final int mPosition;

		public SwapViews(int position) {
			mPosition = position;
		}

		public void run() {

			final float centerX = mContainer.getWidth() / 2.0f;
			final float centerY = mContainer.getHeight() / 2.0f;
			Rotate3dAnimation rotation;

			if (mPosition > -1) {
				imges.setVisibility(View.GONE);
				mImageView.setVisibility(View.VISIBLE);
				mImageView.requestFocus();
				next.setVisibility(View.GONE);
				back.setVisibility(View.GONE);
				Toast.makeText(getApplicationContext(), "Click here again to go back", 5000).show();

				rotation = new Rotate3dAnimation(90, 180, centerX, centerY, 310.0f, false);
			} else {
				mImageView.setVisibility(View.GONE);
				imges.setVisibility(View.VISIBLE);
				imges.requestFocus();
				next.setVisibility(View.VISIBLE);
				back.setVisibility(View.VISIBLE);

				rotation = new Rotate3dAnimation(90, 0, centerX, centerY, 310.0f, false);
			}

			rotation.setDuration(500);
			rotation.setFillAfter(true);
			rotation.setInterpolator(new DecelerateInterpolator());

			mContainer.startAnimation(rotation);
		}
	}
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		if(position==0)
		{
			//	Toast.makeText(getApplicationContext(), "img Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==1)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==2)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==3)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==4)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==5)
		{
			//	Toast.makeText(getApplicationContext(), "img Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==6)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==7)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==8)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==9)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==10)
		{
			//	Toast.makeText(getApplicationContext(), "img Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==11)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==12)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==13)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==14)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==15)
		{
			//	Toast.makeText(getApplicationContext(), "img Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==16)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==17)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==18)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==19)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==20)
		{
			//	Toast.makeText(getApplicationContext(), "img Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==21)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==22)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==23)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==24)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}
		if(position==25)
		{
			//	Toast.makeText(getApplicationContext(), "image2 Click", 1000).show();
			applyRotation(-1, 180, 90);
			next.setVisibility(View.VISIBLE);
			back.setVisibility(View.VISIBLE);
		}


	}
}