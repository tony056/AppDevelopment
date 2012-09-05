package com.example.menu2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
    
    public void addname(View view){
    	Intent it = new Intent();
    	it.setClass(MainActivity.this,Addplayer.class);
    	startActivity(it);
    	MainActivity.this.finish();
    }
    
    public void info(View view){
    	Intent it = new Intent();
    	it.setClass(MainActivity.this,Info.class);
    	startActivity(it);
    	MainActivity.this.finish();
    }
}
