package org.bskrecord;

//import android.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class OldData extends ListActivity {
	private  ArrayList<HashMap<String, String>> listItems;
	private ListView listView;
	private  SimpleAdapter listItemAdapter; 
	private Toast toast;
	int i=0;
	String[] name = {"","","","","","","","","",""};
	@Override
    public  void  onCreate(Bundle icicle) {
        super .onCreate(icicle);
        setContentView(R.layout.secondhalf);
        initListView();
        this .setListAdapter(listItemAdapter);
        
    }
	 private  void  initListView() {   
	        listItems = new  ArrayList<HashMap<String, String>>();
	        SQLite data = new SQLite(OldData.this,"data",null,1);
	        SQLiteDatabase DB = data.getWritableDatabase();
	        Cursor c = DB.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null);
	        
	        if(c.moveToFirst()){
	        	c.moveToNext();
				while (!c.isAfterLast()) {
					String str = c.getString(0);
					//name[i]=str;
					Cursor cu = DB.query(str, new String [] {"oppname","day","month"}, null, null, null, null, null);
					cu.moveToFirst();
					cu.moveToNext();
					//Log.d("OLDdataRecordname=", Integer.toString(indexRecordname));
					String ing = cu.getString(cu.getColumnIndexOrThrow("oppname"));
					String Month = Integer.toString(cu.getInt(cu.getColumnIndexOrThrow("month")));
					String Day = Integer.toString(cu.getInt(cu.getColumnIndexOrThrow("day")));
					HashMap<String, String> map = new  HashMap<String, String>();   
		            map.put( "txt1" ,"2012/"+ Month+"/"+Day);     //文字
		            map.put( "txt2" , ing);    //圖片   
		            listItems.add(map);
		            //cu.close();
		            i++;
					c.moveToNext();
				}
				c.close();
				DB.close();
			}
	          
	            	        //生成適配器的Item和動態數組對應的元素   
	        listItemAdapter = new  SimpleAdapter( this ,listItems,    // listItems數據源    
	                R.layout.listitem,   //ListItem的XML佈局實現  
	                new  String[] { "txt1" , "txt2" },      //動態數組與ImageItem對應的子項         
	                new  int [ ] {R.id.txt1, R.id.txt2}       //list_item.xml佈局文件裡面的一個ImageView的ID,一個TextView的ID  
	        );   
	}
	 protected void onListItemClick(ListView l , View v, int position , long id){
		 super.onListItemClick(l, v, position, id);
		 //toast.makeText(getApplicationContext(), ((TextView)v.findViewById(R.id.txt1)).getText().toString(), Toast.LENGTH_SHORT).show();
		 Intent InData = new Intent();
		 InData.setClass(OldData.this, Indata.class);
		 String tablename = ((TextView)v.findViewById(R.id.txt2)).getText().toString()+"2012"+del(((TextView)v.findViewById(R.id.txt1)).getText().toString());
		 String tableName = ((TextView)v.findViewById(R.id.txt2)).getText().toString()+((TextView)v.findViewById(R.id.txt1)).getText().toString();
		 Bundle bundle = new Bundle();
		 bundle.putString("Tablename",tablename);
		 
		 InData.putExtras(bundle);
		 startActivity(InData);
		 OldData.this.finish();
	 }
	 @Override
	 public void onBackPressed(){
		 Intent it = new Intent();
		 it.setClass(OldData.this, BasketRecordActivity.class);
		 startActivity(it);
		 OldData.this.finish();
	 }
	 public String del(String str){
		 int start=0,stop=0,record=0;
		 char[] repo = str.toCharArray();
		 StringBuilder ans = new StringBuilder("");
		 for(int i=0;i<str.length();i++){
			 if(repo[i]=='/'&&record==0){
				 start=i+1;
				 while(repo[start]!='/'){
					 ans.append(repo[start]);
					 start++;
				 }
				 stop=start+1;
				 while(stop<(str.length())){
					 ans.append(repo[stop]);
					 stop++;
				 }
				 break;
			 }
			 
		 }
		 return ans.toString();
	 }
	 /*public void hah(View v){
		 //Button buu = (Button)findViewById(R.id.buu);
		 Intent InData = new Intent();
	    	InData.setClass(OldData.this, Indata.class);
	    	startActivity(InData); 
	 }*/
	 /*protected void create(File file,String datain){
	    	File parentPath = file.getParentFile();
	    	if (!isSDExist()){
				Toast.makeText(this, 
						"SD Not Found!", Toast.LENGTH_LONG).show();
				return;
			}
	        try {
	            if(!parentPath.exists())
	            	parentPath.mkdirs();
	            if(file.exists())
	            	file.delete();
	            OutputStream os = new FileOutputStream(file);
	            byte[] data = new byte[datain.length()];
	            //is.read(data);
	            os.write(data);
	            //tvMsg.setText(getString(R.string.saveFileTo) + file.toString());
	            //is.close();
	            os.close();  
	        } catch (IOException e) {
	            Log.e("ExternalStorageEx", e.toString());
	        }	
	        
	        String[] paths = {file.toString()};
	        callMediaScanner(paths);
		}*/
	 private boolean isSDExist() { 
			String state = Environment.getExternalStorageState();
			
			if (state.equals(Environment.MEDIA_MOUNTED))
				return true;
			else			
				return false;		
		}
	 
}
