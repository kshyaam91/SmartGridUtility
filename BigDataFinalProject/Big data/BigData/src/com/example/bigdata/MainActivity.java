package com.example.bigdatakruti;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button viewAppliance = (Button) findViewById(R.id.button1);
		Button manageAppliance = (Button) findViewById(R.id.button2);
		Button viewSchedule = (Button) findViewById(R.id.button3);
		Button ScheduleFromUtility = (Button) findViewById(R.id.button4);

		viewAppliance.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent1 = new Intent(MainActivity.this,ViewApplianceActivity.class);
				startActivity(intent1);

			}
		});

		manageAppliance.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent2 = new Intent(MainActivity.this,ManageApplianceActivity.class);
				startActivity(intent2);

			}
		});

		viewSchedule.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent3 = new Intent(MainActivity.this,ViewScheduleActivity.class);
				startActivity(intent3);
			}
		});
		ScheduleFromUtility.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent4 = new Intent(MainActivity.this,ScheduleFromUtilityActivity.class);
				startActivity(intent4);
			}
		});
	}
}
