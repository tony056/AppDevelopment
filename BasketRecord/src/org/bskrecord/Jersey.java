package org.bskrecord;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Jersey extends Activity{
	RadioButton blue,green,red,orange,white;
	int style=0;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.choose);
		RadioGroup choose = (RadioGroup)findViewById(R.id.choose);
		 blue = (RadioButton)findViewById(R.id.chooseblue);
		 green = (RadioButton)findViewById(R.id.choosegreen);
		 white = (RadioButton)findViewById(R.id.choosewhite);
		 red = (RadioButton)findViewById(R.id.choosered);
		 orange = (RadioButton)findViewById(R.id.chooseorange);
		choose.setOnCheckedChangeListener(changeradio);
		
	}
	private RadioGroup.OnCheckedChangeListener changeradio = new RadioGroup.OnCheckedChangeListener() {
		
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub
			if(checkedId==blue.getId()){
				style=1;
			}
			else if(checkedId==green.getId()){
				style=2;
			}
			else if(checkedId==white.getId()){
				style=3;
			}
			else if(checkedId==red.getId()){
				style=4;
			}
			else if(checkedId==orange.getId()){
				style=5;
			}
		}
	};
	public void backmenu(View v){
		Intent tomenu = new Intent();
		Bundle getJer = new Bundle();
		getJer.putInt("style", style);
		tomenu.putExtras(getJer);
		tomenu.setClass(Jersey.this, Mainmenu.class);
		startActivity(tomenu);
		Jersey.this.finish();
	}
}
