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
import android.widget.EditText;

public class ManageApplianceActivity extends Activity {

	EditText Name_app = null;
	EditText Wattage = null;
	EditText StartTime = null;
	EditText EndTime = null;
	EditText RunTime = null;
	EditText Constraint = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_manage_appliance);

		Name_app = (EditText) findViewById(R.id.editText1);
		Wattage = (EditText) findViewById(R.id.editText2);
		StartTime = (EditText) findViewById(R.id.editText3);
		EndTime = (EditText) findViewById(R.id.editText4);
		RunTime = (EditText) findViewById(R.id.editText5);
		Constraint = (EditText) findViewById(R.id.editText6);

		Button add = (Button) findViewById(R.id.button1);
		Button edit = (Button) findViewById(R.id.button2);
		Button delete = (Button) findViewById(R.id.button3);
		Button home = (Button) findViewById(R.id.button4);

		add.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new AddTask().execute();

			}
		});
		edit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new EditTask().execute();
			}
		});
		delete.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				new DeleteTask().execute();

			}
		});
		home.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
	
	// Add Task
		private class AddTask extends AsyncTask<Void, Integer, Double> {
			String HadoopoutAdd;

			protected Double doInBackground(Void... voids) {
				postData();
				return null;
			}

			public void postData() {

				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://192.168.1.14/comm1.php");

				try {
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
							1);
					nameValuePairs.add(new BasicNameValuePair("Name", Name_app
							.getText().toString()));
					nameValuePairs.add(new BasicNameValuePair("Wattage", Wattage
							.getText().toString()));
					nameValuePairs.add(new BasicNameValuePair("StartTime",
							StartTime.getText().toString()));
					nameValuePairs.add(new BasicNameValuePair("EndTime", EndTime
							.getText().toString()));
					nameValuePairs.add(new BasicNameValuePair("RunTime", RunTime
							.getText().toString()));
					nameValuePairs.add(new BasicNameValuePair("Constraint",
							Constraint.getText().toString()));
					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					HttpResponse response = httpclient.execute(httppost);
					HttpEntity entity = response.getEntity();
					HadoopoutAdd = EntityUtils.toString(entity);

				} catch (Exception e) {
					Log.e("log_tag", "Error in http connection " + e.toString());
					return;
				}
			}

			protected void onPostExecute(Double result) {

				Name_app.setText("");
				Wattage.setText("");
				StartTime.setText("");
				EndTime.setText("");
				RunTime.setText("");
				Constraint.setText("");

			}

		}

		// Delete Task
		private class DeleteTask extends AsyncTask<Void, Integer, Double> {
			String HadoopoutDelete;

			protected Double doInBackground(Void... voids) {
				postData();
				return null;
			}

			public void postData() {

				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://192.168.1.14/comm4.php");

				try {
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
							1);
					nameValuePairs.add(new BasicNameValuePair("Name", Name_app
							.getText().toString()));
					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					HttpResponse response = httpclient.execute(httppost);
					HttpEntity entity = response.getEntity();
					HadoopoutDelete = EntityUtils.toString(entity);

				} catch (Exception e) {
					Log.e("log_tag", "Error in http connection " + e.toString());
					return;
				}
			}

			protected void onPostExecute(Double result) {
				Name_app.setText("");

			}

		}

		// Edit task

		private class EditTask extends AsyncTask<Void, Integer, Double> {
			String HadoopoutEdit;

			protected Double doInBackground(Void... voids) {
				postData();
				return null;
			}

			public void postData() {

				HttpClient httpclient = new DefaultHttpClient();
				HttpPost httppost = new HttpPost("http://192.168.1.14/comm5.php");

				try {
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
							1);
					nameValuePairs.add(new BasicNameValuePair("Name", Name_app
							.getText().toString()));
					nameValuePairs.add(new BasicNameValuePair("Wattage", Wattage
							.getText().toString()));
					nameValuePairs.add(new BasicNameValuePair("StartTime",
							StartTime.getText().toString()));
					nameValuePairs.add(new BasicNameValuePair("EndTime", EndTime
							.getText().toString()));
					nameValuePairs.add(new BasicNameValuePair("RunTime", RunTime
							.getText().toString()));
					nameValuePairs.add(new BasicNameValuePair("Constraint",
							Constraint.getText().toString()));
					httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					HttpResponse response = httpclient.execute(httppost);
					HttpEntity entity = response.getEntity();
					HadoopoutEdit = EntityUtils.toString(entity);

				} catch (Exception e) {
					Log.e("log_tag", "Error in http connection " + e.toString());
					return;
				}
			}

			protected void onPostExecute(Double result) {
				Name_app.setText("");
				Wattage.setText("");
				StartTime.setText("");
				EndTime.setText("");
				RunTime.setText("");
				Constraint.setText("");

			}

		}
	
	
}
