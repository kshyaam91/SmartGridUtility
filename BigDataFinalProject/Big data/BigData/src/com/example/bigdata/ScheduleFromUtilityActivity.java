package com.example.bigdatakruti;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScheduleFromUtilityActivity extends Activity {
	TextView text = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schedule_from_utility);
		
		text = (TextView)findViewById(R.id.textView2);
		new ScheduleFromUtilityTask().execute();
		
		Button Rechedule = (Button)findViewById(R.id.button2);
		Rechedule.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	
	private class ScheduleFromUtilityTask extends AsyncTask<Void, Void, Void> {
		String Hadoopout;

		protected Void doInBackground(Void... voids) {
			postData();
			return null;
		}

		public void postData() {

			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://192.168.1.36/schedulefromutility.php");

			try {

				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				Hadoopout = EntityUtils.toString(entity);

			} catch (Exception e) {
				Log.e("log_tag", "Error in http connection " + e.toString());
				return;
			}
		}

		protected void onPostExecute(Void result) {
			text.setText(Hadoopout);

		}

	}
}
