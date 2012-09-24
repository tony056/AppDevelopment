package org.bskrecord;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Recording extends Activity {
	Button[] mBtn = new Button[5];
	Button[] bBtn = new Button[10];
	String[] mNum = new String[5];
	String[] bNum = new String[10];
	int lastX,lastY;
	int k=0,n=0;
	int[] tmpX = new int[10];
	int[] tmpY = new int[10];
	int[] tmpX2 = new int[10];
	int[] tmpY2 = new int[10];
	int flag =0 ;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.recordpage);
		Bundle getname = this.getIntent().getExtras();
		String table = getname.getString("table");
		String[] columns = {"number"};
		DisplayMetrics dm = getResources().getDisplayMetrics();
        final int screenWidth = dm.widthPixels;  
        final int screenHeight = dm.heightPixels-50;
        SQLite qq = new SQLite(Recording.this,"data",null,1);
        SQLiteDatabase ha = qq.getWritableDatabase();
        Cursor c = ha.query(table, columns, null, null, null, null, null);
        int numIndex = c.getColumnIndexOrThrow("number");
        c.moveToFirst();
		for(int i=0;i<5;i++){
			int getmName = getResources().getIdentifier("mainplayer"+(i+1), "id", getPackageName());
			mBtn[i] = (Button)findViewById(getmName);
			mBtn[i].setText(c.getString(numIndex));
			mNum[i] = mBtn[i].getText().toString();
			c.moveToNext();
		}
		for(int j=0;j<10;j++){
			int getbName = getResources().getIdentifier("benchplayer"+(j+1), "id", getPackageName());
			bBtn[j] = (Button)findViewById(getbName);
			if(!c.isAfterLast()){
				bBtn[j].setText(c.getString(numIndex));
				bNum[j] = bBtn[j].getText().toString();
				c.moveToNext();
			}
			else{
				 flag = j;
			}
		}
		for(k=0;k<5;k++){
			mBtn[k].setOnTouchListener(new Button.OnTouchListener(){
				public boolean onTouch(View v, MotionEvent event) {
					int ea=event.getAction();  
		             Log.i("TAG", "Touch:"+ea);   
		             boolean df=func(ea,event,v,screenWidth,screenHeight,bBtn,mBtn[k]);
		             return df;  
				}
			});
		}
		for(n=0;n<10;n++){
			bBtn[n].setOnTouchListener(new Button.OnTouchListener(){
				public boolean onTouch(View v, MotionEvent event) {
					int ea=event.getAction();  
		             Log.i("TAG", "Touch:"+ea);   
		             boolean df=func(ea,event,v,screenWidth,screenHeight,mBtn,bBtn[n]);
		             return df;  
				}
			});
		}
	}
	
	public void monebtn(View v){
		toBtnpage(mNum[0]);
	}
	public void mtwobtn(View v){
		toBtnpage(mNum[1]);
	}
	public void mthreebtn(View v){
		toBtnpage(mNum[2]);
	}
	public void mfourbtn(View v){
		toBtnpage(mNum[3]);
	}
	public void mfivebtn(View v){
		toBtnpage(mNum[4]);
	}
	public void toBtnpage(String number){
		Bundle table = this.getIntent().getExtras();
		Intent btnpg = new Intent();
		Bundle getData = new Bundle();
		getData.putString("number", number);
		getData.putString("table", table.getString("table"));
		btnpg.putExtras(getData);
		btnpg.setClass(Recording.this, GameRecord.class);
		startActivity(btnpg);
		
	}
	@Override
	public void onBackPressed(){
		
	}
	public boolean func(int ea,MotionEvent event,View v,int screenWidth,int screenHeight,Button btn[],Button bu){
    	int startX;
    	int startY;
   	 switch(ea){  
        case MotionEvent.ACTION_DOWN:             
         startX = (int)event.getRawX();
         startY = (int)event.getRawY();
         lastX=(int)event.getRawX();
         lastY=(int)event.getRawY();
         //tempX = (int)bu.getLeft();
         //tempY = (int)bu.getTop();
         //tempX2 = (int)bu2.getLeft();
         //tempY2 = (int)bu2.getTop();
         
         break;  
         
        case MotionEvent.ACTION_MOVE:  
         int dx=(int)event.getRawX()-lastX;  
         int dy=(int)event.getRawY()-lastY;             
         
         
         int l=v.getLeft()+dx;   
         int b=v.getBottom()+dy;  
         int r=v.getRight()+dx;  
         int t=v.getTop()+dy;  


         if(l<0){  
          l=0;      
          r=l+v.getWidth();  
         }  
           
         if(t<0){  
          t=0;  
          b=t+v.getHeight();  
         }  
           
         if(r>screenWidth){  
          r=screenWidth;  
          l=r-v.getWidth();  
         }  
          
         if(b>screenHeight){  
          b=screenHeight;  
          t=b-v.getHeight();  
         }  
         v.layout(l, t, r, b);  
           
         lastX=(int)event.getRawX();  
         lastY=(int)event.getRawY();  
         v.postInvalidate();             
         break;  
        case MotionEvent.ACTION_UP:
       	 	lastX=(int)event.getRawX();  
            lastY=(int)event.getRawY();
            int midX,midY;
            midX=(int)bu.getLeft()+(bu.getWidth())/2;
            midY=(int)bu.getTop()+(bu.getHeight())/2;
            if(btn[0]==mBtn[0]){
            	for(int h=0;h<5;h++){
                  	 tmpX[h] = (int)btn[h].getLeft();
                  	 tmpY[h] = (int)btn[h].getTop();
                  	 tmpX2[h] = (int)tmpX[h]+btn[h].getMeasuredWidth();
                  	 tmpY2[h] = (int)tmpY[h]+btn[h].getMeasuredHeight();
                   }
            	for(int g =0;g<5;g++){
            		if(tmpX[g]<=midX && tmpY[g]<=midY){
            			if(midX<=tmpX2[g] && midY<=tmpY2[g]){
            			String str = btn[g].getText().toString();
               	 		btn[g].setText(bu.getText( ).toString());
               	 		bu.setText(str);
            			}
            			
            		}		
            	}
            }
            if(btn[0]==bBtn[0]){
            	for(int h=0;h<10;h++){
                 	 tmpX[h] = (int)btn[h].getLeft();
                 	 tmpY[h] = (int)btn[h].getTop();
                 	 tmpX2[h] = (int)tmpX[h]+btn[h].getMeasuredWidth();
                 	 tmpY2[h] = (int)tmpY[h]+btn[h].getMeasuredHeight();
                  }
            	for(int g =0;g<10;g++){
            		if(tmpX[g]<=midX && tmpY[g]<=midY){
            			if(midX<=tmpX2[g] && midY<=tmpY2[g]){
            			String str = btn[g].getText().toString();
               	 		btn[g].setText(bu.getText( ).toString());
               	 		bu.setText(str);
            			}
            			
            		}
            	}
            }    
         break;            
        }
   	 return false;
   }
}
