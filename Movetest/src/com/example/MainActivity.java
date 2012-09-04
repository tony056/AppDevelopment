package com.example;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.view.*;

public class MainActivity extends Activity {
	int number =10;
    @SuppressLint({ "NewApi", "NewApi" })
	@Override
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        DisplayMetrics dm = getResources().getDisplayMetrics();
        final int screenWidth = dm.widthPixels;  
        final int screenHeight = dm.heightPixels-50;
        
        final Button bu = (Button)findViewById(R.id.button1);
        final Button bu2 = (Button)findViewById(R.id.button2);
        final View text = (View)findViewById(R.id.textView1);
        //final int number = 10;
        bu.setText(number+" !!");
        bu2.setText((number+10)+" ??");
        
        bu.setOnTouchListener(new Button.OnTouchListener(){
        	
        	int lastX,lastY;  
        	int tempX,tempY;
        	int tempX2,tempY2;
              
      public boolean onTouch(View v, MotionEvent event) {  
    	  
    	  
    	  	 //int number = 10;
             int ea=event.getAction();  
             Log.i("TAG", "Touch:"+ea);   
             
               
             switch(ea){  
             case MotionEvent.ACTION_DOWN:             
                
              lastX=(int)event.getRawX();
              lastY=(int)event.getRawY();
              tempX = (int)bu.getLeft();
              tempY = (int)bu.getTop();
              tempX2 = (int)bu2.getLeft();
              tempY2 = (int)bu2.getTop();
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
            	 final int subX,subX2;
         		final int subY,subY2;
                 subX=(int)bu2.getLeft();
                 subX2=subX+bu2.getMeasuredWidth();
                 subY=(int)bu2.getTop();
                 subY2=subY+bu2.getMeasuredHeight();
            	 int midX,midY;
                 midX=(int)bu.getLeft()+(bu.getWidth())/2;
                 midY=(int)bu.getTop()+(bu.getHeight())/2;
                
                 if(subX<=midX  &&  subY <= midY  )
              		   {
                	 		if(midX<=subX2 && midY<=subY2){
              	   				/*number--;
              	   				bu.setText(number+" !!");*/
                	 			String str = bu2.getText().toString();
                	 			bu2.setText(bu.getText().toString());
                	 			bu.setText(str);
                	 		}
              		   } 
              break;            
             }

                          
             
       return false;  
      }});  
bu2.setOnTouchListener(new Button.OnTouchListener(){
        	
        	int lastX,lastY;  
        	int tempX,tempY;
        	int tempX2,tempY2;
              
      public boolean onTouch(View v, MotionEvent event) {  
    	  
    	  
    	  	 //int number = 10;
             int ea=event.getAction();  
             Log.i("TAG", "Touch:"+ea);   
             
               
             switch(ea){  
             case MotionEvent.ACTION_DOWN:             
                
              lastX=(int)event.getRawX();
              lastY=(int)event.getRawY();
              tempX = (int)bu.getLeft();
              tempY = (int)bu.getTop();
              tempX2 = (int)bu2.getLeft();
              tempY2 = (int)bu2.getTop();
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
            	 final int subX,subX2;
         		final int subY,subY2;
                 subX=(int)bu.getLeft();
                 subX2=subX+bu.getMeasuredWidth();
                 subY=(int)bu.getTop();
                 subY2=subY+bu.getMeasuredHeight();
            	 int midX,midY;
                 midX=(int)bu2.getLeft()+(bu2.getWidth())/2;
                 midY=(int)bu2.getTop()+(bu2.getHeight())/2;
                
                 if(subX<=midX  &&  subY <= midY  )
              		   {
                	 		if(midX<=subX2 && midY<=subY2){
              	   				/*number--;
              	   				bu.setText(number+" !!");*/
                	 			String str = bu.getText().toString();
                	 			bu.setText(bu2.getText().toString());
                	 			bu2.setText(str);
                	 		}
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
