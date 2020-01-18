package com.example.bigdatakruti;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewScheduleActivity extends Activity {

	TextView text;
	TextView text1;
	String HadoopoutRPS;
	public static String[] data2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_schedule);

		text = (TextView) findViewById(R.id.textView2);
		text1 = (TextView) findViewById(R.id.textView3);

		Button RPS = (Button) findViewById(R.id.button1);
		Button sendtoUtility = (Button) findViewById(R.id.button2);
		Button home2 = (Button) findViewById(R.id.button3);

		new ScheduleTask().execute();
		home2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		sendtoUtility.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new UtilityTask().execute();
			}
		});

		RPS.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new RPSTask().execute();
			}
		});

	}
	private class ScheduleTask extends AsyncTask<Void, Void, Void> {
		String HadoopoutSchedule;

		protected Void doInBackground(Void... voids) {
			postData();
			return null;
		}

		public void postData() {

			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://192.168.1.14/comm2.php");

			try {

				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				HadoopoutSchedule = EntityUtils.toString(entity);
				Log.d("tag", HadoopoutSchedule);

			} catch (Exception e) {
				Log.e("log_tag", "Error in http connection " + e.toString());
				return;
			}
		}

		protected void onPostExecute(Void result) {
			text.setText(HadoopoutSchedule);

		}
	}

	private class RPSTask extends AsyncTask<Void, Void, Void> {
		// String HadoopoutRPS;
		String HadoopoutPrint;

		protected Void doInBackground(Void... voids) {
			postData();
			return null;
		}

		public void postData() {

			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost("http://192.168.1.14/RPS.php");

			try {
				
				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				HadoopoutRPS = EntityUtils.toString(entity);
				String data = HadoopoutRPS.replace("[", "");
				String data1 = data.replace("]", "");
				String data3 = data1.replace(" ", "");
				data2 = data3.split(",");

				
				/*HttpResponse response1 = httpclient.execute(httppost);
				HttpEntity entity1 = response1.getEntity();
				HadoopoutPrint = EntityUtils.toString(entity1);
*/
			} catch (Exception e) {
				Log.e("log_tag", "Error in http connection " + e.toString());
				return;
			}
		}

		protected void onPostExecute(Void result) {
			text1.setText(HadoopoutRPS);

		}

	}

	private class UtilityTask extends AsyncTask<Void, Void, Void> {
		String Hadoopout1;

		protected Void doInBackground(Void... voids) {
			postData();
			return null;
		}

		public void postData() {

			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(
					"http://192.168.1.14/utilityServer.php");

			try {
				
				
				
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
						1);
				nameValuePairs.add(new BasicNameValuePair("zero", data2[23]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("one", data2[22]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("two", data2[21]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("three", data2[20]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("four", data2[19]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("five", data2[18]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("six", data2[17]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("seven", data2[16]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("eight", data2[15]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("nine", data2[14]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("ten", data2[13]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("eleven", data2[12]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("twelve", data2[11]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("thirteen", data2[10]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("fourteen", data2[9]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("fifteen", data2[8]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("sixteen", data2[7]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("seventeen", data2[6]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("eighteen", data2[5]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("nineteen", data2[4]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("twenty", data2[3]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("twentyone", data2[2]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("twentytwo", data2[1]
						.toString()));
				nameValuePairs.add(new BasicNameValuePair("twentythree",
						data2[0].toString()));
				httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

				HttpResponse response = httpclient.execute(httppost);
				HttpEntity entity = response.getEntity();
				Hadoopout1 = EntityUtils.toString(entity);

			} catch (Exception e) {
				Log.e("log_tag", "Error in http connection " + e.toString());
				return;
			}
		}

	}
	
	
	
}
