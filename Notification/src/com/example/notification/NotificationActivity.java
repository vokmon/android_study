package com.example.notification;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class NotificationActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notification);
		TextView textView = (TextView)findViewById(R.id.textViewNotification);
		textView.setText("Hi, Your Detailed notification view goes here................");
	}
}
