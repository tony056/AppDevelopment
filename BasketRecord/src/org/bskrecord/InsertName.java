package org.bskrecord;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertName extends Activity {
	public int i = 0;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertnew);
	}
	public void insertCall(View v){
		InsertFragment fuck = (InsertFragment)getFragmentManager().findFragmentById(R.id.insert);
		EditText name = (EditText)fuck.getView().findViewById(R.id.inplayerName);
		EditText number = (EditText)fuck.getView().findViewById(R.id.inplayerNumber);
		InsertDataFragment getArray = (InsertDataFragment)getFragmentManager().findFragmentById(R.id.showinsert);
		if(i<15){
			getArray.names[i] = name.getText().toString();
			getArray.numbers[i] = number.getText().toString();
			getArray.setView();
			i++;
			Toast.makeText(InsertName.this, Integer.toString(i), Toast.LENGTH_LONG).show();
			
		}
		else{
			Toast.makeText(InsertName.this, "超過人數上限！！", Toast.LENGTH_LONG).show();
			i=0;
		}
	}
}
