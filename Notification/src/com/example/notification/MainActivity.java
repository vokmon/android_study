package com.example.notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button b1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		b1 = (Button) findViewById(R.id.button);
		b1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Notify("Notification Alert, Click Me!", "Hi, This is Android Notification Detail!");
			}
		});
	}

	private void Notify(String notificationTitle, String notificationMessage) {
		//Step 1 - Create Notification Builder
		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
		
		//Step 2 - Setting Notification Properties
		mBuilder.setSmallIcon(R.drawable.ic_launcher);
		mBuilder.setContentTitle(notificationTitle);
		mBuilder.setContentText(notificationMessage);
		
		//Step 3 - Attach Actions
		Intent resultIntent = new Intent(this, NotificationActivity.class);
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		stackBuilder.addParentStack(NotificationActivity.class);
		
		// Adds the Intent that starts the Activity to the top of the stack
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(resultPendingIntent);
		
		NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		// notificationID allows you to update the notification later on.
		int notificationID = 0;
		mNotificationManager.notify(notificationID, mBuilder.build());
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
