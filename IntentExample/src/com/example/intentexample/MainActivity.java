package com.example.intentexample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
	Button b1,b2,b3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        
        b1.setOnClickListener(new View.OnClickListener() {
        
           @Override
           public void onClick(View v) {
        	   //Need to select the launcher
              Intent i = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("http://www.example.com"));
              startActivity(i);
           }
        });
        
        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
        
           @Override
           public void onClick(View v) {
        	  //show the url to the activity
              Intent i = new Intent("com.example.intentexample.customactivity.LAUNCH",Uri.parse("http://www.example.com"));
        	   
              startActivity(i);
           }
        });
        
        b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
        
           @Override
           public void onClick(View v) {
        	   // error because the scheme is http but defined as https
              Intent i = new Intent("com.example.intentexample.customactivity.LAUNCH",Uri.parse("https://www.example.com"));
              startActivity(i);
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
