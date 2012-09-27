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
import android.widget.TextView;
import android.view.*;

public class MainActivity extends Activity {
	int number =10;
	int lastX,lastY;  
	int tempX,tempY;
	int tempX2,tempY2;
	int[] tmpX = new int[3]; 
	int[] tmpY = new int[3]; 
	int[] tmpX2 = new int[3]; 
	int[] tmpY2 = new int[3]; 
	Button[] btn = new Button[3];
	int startX,endX;
	int startY,endY;
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
        for(int y = 0;y<3;y++){
        	int id = getResources().getIdentifier("button"+(y+3), "id", getPackageName());
        	btn[y] = (Button)findViewById(id);
        }
        //final int number = 10;
        bu.setText(number+" !!");
        bu2.setText((number+10)+" ??");
        bu.setOnTouchListener(new Button.OnTouchListener(){
        	public boolean onTouch(View v,MotionEvent event){
        		int ea = event.getAction();
        		boolean df = func(ea,event,v,screenWidth,screenHeight,btn,bu);
        		return df;
        	}
        });
       
        btn[0].setOnTouchListener(new Button.OnTouchListener(){
        	
        	
              
      public boolean onTouch(View v, MotionEvent event) {  
    	  
    	  
    	  	 //int number = 10;
             int ea=event.getAction();  
             Log.i("TAG", "Touch:"+ea);   
             boolean df=func(ea,event,v,screenWidth,screenHeight,btn,btn[0]);
       return df;  
      }});  
        btn[1].setOnTouchListener(new Button.OnTouchListener(){
        	
        	
            
            public boolean onTouch(View v, MotionEvent event) {  
          	  
          	  
          	  	 //int number = 10;
                   int ea=event.getAction();  
                   Log.i("TAG", "Touch:"+ea);   
                   boolean df=func(ea,event,v,screenWidth,screenHeight,btn,btn[1]);
             return df;  
            }});  
        btn[2].setOnTouchListener(new Button.OnTouchListener(){
        	
        	
            
            public boolean onTouch(View v, MotionEvent event) {  
          	  
          	  
          	  	 //int number = 10;
                   int ea=event.getAction();  
                   Log.i("TAG", "Touch:"+ea);   
                   boolean df=func(ea,event,v,screenWidth,screenHeight,btn,btn[2]);
             return df;  
            }});  

/*bu2.setOnTouchListener(new Button.OnTouchListener(){*/
        	
        	/*int lastX,lastY;  
        	int tempX,tempY;
        	int tempX2,tempY2;*/
              
      /*public boolean onTouch(View v, MotionEvent event) {  
    	  
    	  
    	  	 //int number = 10;
             int ea=event.getAction();  
             Log.i("TAG", "Touch:"+ea);   
             
               
             /*switch(ea){  
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
              	   				number--;
              	   				bu.setText(number+" !!");
                	 			String str = bu.getText().toString();
                	 			bu.setText(bu2.getText().toString());
                	 			bu2.setText(str);
                	 		}
              		   } 
              break;            
             }*/
        /*boolean df = func(ea,event,v,bu,bu2,screenWidth,screenHeight,btn);
                          
             
       return df;  
      }});*/
        	


        
       }  
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    public boolean func(int ea,MotionEvent event,View v,int screenWidth,int screenHeight,Button btn[],Button bu){
    	
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
        	endX=(int)event.getRawX();
        	endY=(int)event.getRawY();
       	 	lastX=(int)event.getRawX();  
            lastY=(int)event.getRawY();  
       	 	final int subX,subX2;
    		final int subY,subY2;
    		if(startX==endX&&startY==endY){
    			TextView vi = (TextView)findViewById(R.id.textView1);
    			vi.setText("fuck");
    			/*for(int y=0;y<3;y++){
    				if(btn[y]==bu){
    					if(y==0){
    						h3(v);
    					}
    					if(y==1){
    						h4(v);
    					}
    					if(y==2){
    						h5(v);
    					}
    				}
    			}*/
    		}else{
            //subX=(int)bu2.getLeft();
            //subX2=subX+bu2.getMeasuredWidth();
            //subY=(int)bu2.getTop();
            //subY2=subY+bu2.getMeasuredHeight();
            int midX,midY;
            for(int h=0;h<3;h++){
           	 tmpX[h] = (int)btn[h].getLeft();
           	 tmpY[h] = (int)btn[h].getTop();
           	 tmpX2[h] = (int)tmpX[h]+btn[h].getMeasuredWidth();
           	 tmpY2[h] = (int)tmpY[h]+btn[h].getMeasuredHeight();
            }
            midX=(int)bu.getLeft()+(bu.getWidth())/2;
            midY=(int)bu.getTop()+(bu.getHeight())/2;
           
            /*if(subX<=midX  &&  subY <= midY  )
            {
           	 	if(midX<=subX2 && midY<=subY2){
         	   				number--;
         	   				bu.setText(number+" !!");
           	 		String str = bu2.getText().toString();
           	 		bu2.setText(bu.getText().toString());
           	 		bu.setText(str);
           	 	}
         	}*/
            for(int g =0;g<3;g++){
            		if(tmpX[g]<=midX && tmpY[g]<=midY){
            			if(midX<=tmpX2[g] && midY<=tmpY2[g]){
            			String str = btn[g].getText().toString();
               	 		btn[g].setText(bu.getText( ).toString());
               	 		bu.setText(Integer.toString(g));
               	 		break;
            			}
            			
            		}
            		
            }
    		}
         break;            
        }
   	 return false;
   }
   /* public void h3 (View v){
    	btn[0].setText("work!!");
    }
    public void h4 (View v){
    	btn[1].setText("star!!");
    }
    public void h5 (View v){
    	btn[2].setText("done!!");
    }*/
}
