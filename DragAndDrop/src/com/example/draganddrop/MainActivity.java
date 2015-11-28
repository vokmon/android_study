package com.example.draganddrop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

@SuppressLint("ClickableViewAccessibility") public class MainActivity extends Activity {
	private ImageView img;
	private String msg;
	private android.widget.RelativeLayout.LayoutParams layoutParams;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
	      setContentView(R.layout.activity_main);
	      img=(ImageView)findViewById(R.id.imageView);
	      
	      img.setOnLongClickListener(new View.OnLongClickListener() {
	         @Override
	         public boolean onLongClick(View v) {
	            ClipData.Item item = new ClipData.Item((CharSequence)v.getTag());
	            String[] mimeTypes = {ClipDescription.MIMETYPE_TEXT_PLAIN};
	            
	            ClipData dragData = new ClipData(v.getTag().toString(),mimeTypes, item);
	            View.DragShadowBuilder myShadow = new View.DragShadowBuilder(img);
	            
	            v.startDrag(dragData,myShadow,null,0);
	            return true;
	         }
	      });
	      
	      img.setOnDragListener(new View.OnDragListener() {
	         @Override
	         public boolean onDrag(View v, DragEvent event) {
	            switch(event.getAction())
	            {
	               case DragEvent.ACTION_DRAG_STARTED:
	               layoutParams = (RelativeLayout.LayoutParams)v.getLayoutParams();
	               Log.d(msg, "Action is DragEvent.ACTION_DRAG_STARTED");
	               
	               // Do nothing
	               break;
	               
	               case DragEvent.ACTION_DRAG_ENTERED:
	               Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENTERED");
	               int x_cord = (int) event.getX();
	               int y_cord = (int) event.getY();
	               break;
	               
	               case DragEvent.ACTION_DRAG_EXITED :
	               Log.d(msg, "Action is DragEvent.ACTION_DRAG_EXITED");
	               x_cord = (int) event.getX();
	               y_cord = (int) event.getY();
//	               layoutParams.leftMargin = x_cord;
//	               layoutParams.topMargin = y_cord;
//	               v.setLayoutParams(layoutParams);
	               v.setX(x_cord - (v.getWidth() / 2));
	               v.setY(y_cord - (float)(v.getHeight()* 1.5 / 2));
	               
	               break;
	               
	               case DragEvent.ACTION_DRAG_LOCATION  :
	               Log.d(msg, "Action is DragEvent.ACTION_DRAG_LOCATION");
	               x_cord = (int) event.getX();
	               y_cord = (int) event.getY();
	               break;
	               
	               case DragEvent.ACTION_DRAG_ENDED   :
	               Log.d(msg, "Action is DragEvent.ACTION_DRAG_ENDED");
	               
	               // Do nothing
	               break;
	               
	               case DragEvent.ACTION_DROP:
	               Log.d(msg, "ACTION_DROP event");
	               
	               // Do nothing
	               break;
	               default: break;
	            }
	            return true;
	         }
	      });
	      
	      img.setOnTouchListener(new View.OnTouchListener() {
	         @Override
	         public boolean onTouch(View v, MotionEvent event) {
	            if (event.getAction() == MotionEvent.ACTION_DOWN) {
	               ClipData data = ClipData.newPlainText("", "");
	               View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(img);
	               
	               img.startDrag(data, shadowBuilder, img, 0);
//	               img.setVisibility(View.INVISIBLE);
	               return true;
	            }
	            else
	            {
	               return false;
	            }
	         }
	      });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
