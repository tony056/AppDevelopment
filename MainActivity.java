package com.example;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.*;

public class MainActivity extends Activity {

    @SuppressLint({ "NewApi", "NewApi" })
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        DisplayMetrics dm = getResources().getDisplayMetrics();
        final int screenWidth = dm.widthPixels;  
        final int screenHeight = dm.heightPixels-50;
        
        final Button bu = (Button)findViewById(R.id.button1);
        final TextView text = (TextView)findViewById(R.id.textView1);
        
        
		
        
        
        bu.setOnTouchListener(new Button.OnTouchListener(){
        	
        	int lastX,lastY;  
            
              
      public boolean onTouch(View v, MotionEvent event) {  
    	  
    	  
     
             int ea=event.getAction();  
             Log.i("TAG", "Touch:"+ea);   
               
               
             switch(ea){  
             case MotionEvent.ACTION_DOWN:             
                
              lastX=(int)event.getRawX();
              lastY=(int)event.getRawY();             
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
            	 
            	 final int subX,subX2;
         		 final int subY,subY2;
            	 
            	 subX=(int)text.getLeft();
                 subX2=subX+text.getMeasuredWidth();
                 subY=(int)text.getTop();
                 subY2=subY+text.getMeasuredHeight();
            	 
            	 int midX,midY;
                 midX=(int)bu.getLeft()+(bu.getWidth())/2;
                 midY=(int)bu.getTop()+(bu.getHeight())/2;
                 if(subX<=midX  &&  subY <= midY  )
              		   {
                	 		if(midX<=subX2 && midY<=subY2)
                	 			bu.setText("fuck");
                	 			text.setText("X:"+subX+"  Y:"+subY+"\nx:"+subX2+"  y:"+subY2+"  "+midX+"  "+midY);
              	   				//setContentView(R.layout.test);
              		   } 
              break;            
             }
             
       
             
             
       return false;  
      }});  
        
        
       }  
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    
}
