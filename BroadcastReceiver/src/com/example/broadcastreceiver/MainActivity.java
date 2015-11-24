package com.example.broadcastreceiver;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	/**
	 * application itself should generate and send custom intents
	 * 
	 * @param view
	 */
	public void broadcastIntent(View view) {
		Intent intent = new Intent();
		intent.setAction("com.tutorialspoint.CUSTOM_INTENT");
		sendBroadcast(intent);
	}
}
