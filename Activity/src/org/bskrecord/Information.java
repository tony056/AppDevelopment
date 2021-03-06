package org.bskrecord;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Information extends Activity{
	private int Nmonth;
	private int Nday;
	private int Nyear;
	
	@Override 
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.information);
		showView();
	}
	public void showView(){
		EditText date = (EditText)findViewById(R.id.date);
		final Calendar c = Calendar.getInstance(); 
		Nyear = c.get(Calendar.YEAR);
		Nmonth = c.get(Calendar.MONTH);
		Nday = c.get(Calendar.DATE);
		date.setText(Integer.toString(Nyear)+"/"+Integer.toString(Nmonth+1)+"/"+Integer.toString(Nday));
	}
	public void sendinfo(View v){
		EditText oppName = (EditText)findViewById(R.id.oppname);
		EditText recorder = (EditText)findViewById(R.id.recorder);
		Bundle infoForTb = new Bundle();
		infoForTb.putString("oppname", oppName.getText().toString());
		infoForTb.putString("recorder",recorder.getText().toString());
		infoForTb.putInt("year", Nyear);
		infoForTb.putInt("month", Nmonth);
		infoForTb.putInt("day", Nday);
		Intent toName = new Intent();
		toName.putExtras(infoForTb);
		toName.setClass(Information.this, InsertName.class);
		startActivity(toName);
		Information.this.finish();
		//SQLiteDatabase XD = QQ.getWritableDatabase();
		
	}
}
