package com.example.myplayschool;

import com.example.myplayschool.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;


public class AlphabetList extends Activity implements OnItemClickListener{
	ListView listview;
	Button done;
	Boolean set=true;
	String[] arrName={"Apple","Ball","Car","Dog","Egg","Fish","Grapes","House","Ice-Cream","Jug","Kite","Lock","Mango","Nest","Orange","Pencil","Quill","Rose","Sunflower","Tomato","Umbrella","Violin","Watermalen","Xylophone","Yak","Zebra"};
	Integer[] alphabetImage={R.drawable.aa,R.drawable.bb,R.drawable.cc,R.drawable.dd,R.drawable.ee,R.drawable.ff,R.drawable.gg,R.drawable.hh,R.drawable.ii,R.drawable.jj,R.drawable.kk,R.drawable.ll,R.drawable.mm,R.drawable.nn,R.drawable.oo,R.drawable.pp,R.drawable.qq,R.drawable.rr,R.drawable.ss,R.drawable.tt,R.drawable.uu,R.drawable.vv,R.drawable.ww,R.drawable.xx,R.drawable.yy,R.drawable.zz,};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);

		

		listview = (ListView)	findViewById(R.id.indexlist);
		listview.setAdapter(new ListAdapter(this));
		listview.setOnItemClickListener(this);

	}

	public class ListAdapter extends BaseAdapter{

		private LayoutInflater inflater = null;
		//private Context mContext;

		public ListAdapter(Context c) {
			inflater = LayoutInflater.from(c);
			//mContext = c;
			Log.i("function addToList", "ListAdapter");
		}

		public int getCount() {
			return alphabetImage.length;

		}

		public Object getItem(int position) {
			return null;
		}

		public long getItemId(int position) {
			return 0;
		}

		//view holder//
		class ViewHolder{        	 

			TextView txtgettimeframe;
			ImageView imgdelete;
		}

		// create a new ImageView for each item referenced by the Adapter
		public View getView(final int position, View convertView, ViewGroup parent) {

			ViewHolder vh;
			//ImageView imageView;
			// if it's not recycled, initialize some attributes

			vh = new ViewHolder();
			convertView = inflater.inflate(R.layout.cust, null);
			vh.imgdelete 		   = (ImageView) convertView.findViewById(R.id.indexlogo);
			vh.txtgettimeframe = (TextView) convertView.findViewById(R.id.contentname);
			vh.imgdelete.setImageResource(alphabetImage[position]);
			vh.txtgettimeframe.setText(arrName[position]);



			return convertView;
		}


	}

	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
			Intent IntentForABCMain = new Intent(getApplicationContext(),Learning.class);
			IntentForABCMain.putExtra("keyForPostion", arg2);
			startActivity(IntentForABCMain);
		
	}
}
