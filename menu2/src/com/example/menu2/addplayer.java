package com.example.menu2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class Addplayer extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add);
    }
	public void findView(){
		EditText playerNum = (EditText)findViewById(R.id.playernum);
		EditText playerName = (EditText)findViewById(R.id.playername);
	}
	
   
    
}
