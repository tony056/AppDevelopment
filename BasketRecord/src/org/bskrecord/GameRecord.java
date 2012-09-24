package org.bskrecord;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameRecord extends Activity{
	Cursor team = null;
	Cursor player =null;
	int twomdIndex,twoapIndex ;
	int threemdIndex,threeapIndex;
	int freemdIndex,freeapIndex;
	int ptsIndex,astIndex,rebIndex,stlIndex,flIndex,toIndex,blkIndex;
	int selfptIndex,oppIndex;
	SQLite qq=null;
	SQLiteDatabase data = null;
	SQLiteDatabase data2 = null;
	String table = "";
	String num = "";
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detailpage);
		Bundle getdata = this.getIntent().getExtras();
		qq = new SQLite(GameRecord.this,"data",null,1);
		data = qq.getWritableDatabase();
		data2 = qq.getWritableDatabase();
		table = getdata.getString("table");
		num = getdata.getString("number");
		String[] column = {"selfpts","opppts"};
		String selection = "number LIKE "+num;
		team = data2.query(table, column, null, null, null, null, null);
		player = data.query(table,null , selection, null, null, null, null);
		TextView namenum = (TextView)findViewById(R.id.Playerinfo);
		int nameIndex = player.getColumnIndexOrThrow("name");
		namenum.setText(num+"  "+player.getString(nameIndex));
		twomdIndex = player.getColumnIndexOrThrow(SQLite.TWOMD);
		twoapIndex = player.getColumnIndexOrThrow(SQLite.THREEAP);
		threemdIndex = player.getColumnIndexOrThrow(SQLite.THREEMD);
		threeapIndex = player.getColumnIndexOrThrow(SQLite.THREEAP);
		freemdIndex = player.getColumnIndexOrThrow(SQLite.FREEMD);
		freeapIndex = player.getColumnIndexOrThrow(SQLite.FREEAP);
		ptsIndex = player.getColumnIndexOrThrow(SQLite.PTS);
		astIndex = player.getColumnIndexOrThrow(SQLite.ASTS);
		rebIndex = player.getColumnIndexOrThrow(SQLite.RBS);
		stlIndex = player.getColumnIndexOrThrow(SQLite.STLS);
		flIndex = player.getColumnIndexOrThrow(SQLite.FLS);
		toIndex = player.getColumnIndexOrThrow(SQLite.TOS);
		blkIndex = player.getColumnIndexOrThrow(SQLite.BLKS);
		selfptIndex = team.getColumnIndexOrThrow(SQLite.SELFPTS);
		oppIndex = team.getColumnIndexOrThrow(SQLite.OPPPTS);
		team.moveToFirst();
		/*Button twoin = (Button)findViewById(R.id.btnTwopIn);
		Button twoout = (Button)findViewById(R.id.btnTwopOut);
		Button threein = (Button)findViewById(R.id.btnThreepIn);
		Button threeout = (Button)findViewById(R.id.btnThreepOut);
		Button freein = (Button)findViewById(R.id.btnFreethrowIn);
		Button freeout = (Button)findViewById(R.id.btnFreethrowOut);
		Button reb = (Button)findViewById(R.id.btnReb);*/
		
	}
	public void bfuncTwopIn(View v){
		int md = player.getInt(twomdIndex);
		md++;
		int ap = player.getInt(twoapIndex);
		ap++;
		int pts = player.getInt(ptsIndex);
		pts = pts + 2;
		int selfpt = team.getInt(selfptIndex);
		selfpt = selfpt + 2;
		ContentValues teamV = new ContentValues();
		teamV.put(SQLite.SELFPTS, selfpt);
		data2.update(table, teamV, null, null);
		ContentValues values = new ContentValues();
		values.put(SQLite.THREEAP, ap);
		values.put(SQLite.THREEMD, md);
		values.put(SQLite.PTS,pts);
		data.update(table, values, "number = "+num, null);
		twoShow(ap,md);
		goBack();
	}
	public void bfuncTwopOut(View v){
		int ap = player.getInt(twoapIndex);
		ap++;
		int md = player.getInt(threemdIndex);
		twoShow(ap,md);
		ContentValues values = new ContentValues();
		values.put(SQLite.THREEAP, ap);
		data.update(table, values, "number = "+num, null);
		
		goBack();
	}
	public void bfuncThreepIn(View v){
		int md = player.getInt(threemdIndex);
		md++;
		int ap = player.getInt(threeapIndex);
		ap++;
		int pts = player.getInt(ptsIndex);
		pts =pts + 3;
		int selfpt = team.getInt(selfptIndex);
		selfpt = selfpt + 3;
		ContentValues values = new ContentValues();
		values.put(SQLite.THREEAP, ap);
		values.put(SQLite.THREEMD, md);
		values.put(SQLite.PTS, pts);
		data.update(table, values, "number = "+num, null);
		ContentValues teamV = new ContentValues();
		teamV.put(SQLite.SELFPTS, selfpt);
		data2.update(table, teamV, null, null);
		goBack();
	}
	public void bfuncThreepOut(View v){
		int ap = player.getInt(threeapIndex);
		ap++;
		ContentValues values = new ContentValues();
		values.put(SQLite.THREEAP, ap);
		data.update(table, values, "number = "+num, null);
		goBack();
	}
	public void bfuncFreethrowIn(View v){
		int md = player.getInt(freemdIndex);
		md++;
		int ap = player.getInt(freeapIndex);
		ap++;
		int pts = player.getInt(ptsIndex);
		pts++;
		int selfpt = team.getInt(selfptIndex);
		selfpt++;
		ContentValues values = new ContentValues();
		values.put(SQLite.FREEMD, md);
		values.put(SQLite.FREEAP, ap);
		values.put(SQLite.PTS, pts);
		data.update(table, values, "number = "+num, null);
		ContentValues teamV = new ContentValues();
		teamV.put(SQLite.SELFPTS, selfpt);
		data2.update(table, teamV, null, null);
		goBack();
	}
	public void bfuncFreethrowOut(View v){
		int ap = player.getInt(freemdIndex);
		ap++;
		ContentValues values = new ContentValues();
		values.put(SQLite.FREEAP, ap);
		data.update(table, values, "number = "+num, null);
		goBack();
	}
	public void bfuncReb(View v){
		int reb = player.getInt(rebIndex);
		reb++;
		ContentValues values = new ContentValues();
		values.put(SQLite.RBS, reb);
		data.update(table, values, "number = "+num, null);
		goBack();
	}
	public void bfuncAst(View v){
		int ast = player.getInt(astIndex);
		ast++;
		ContentValues values = new ContentValues();
		values.put(SQLite.ASTS, ast);
		data.update(table, values, "number = "+num, null);
		goBack();
	}
	public void bfuncStl(View v){
		int stl = player.getInt(stlIndex);
		stl++;
		ContentValues values = new ContentValues();
		values.put(SQLite.STLS, stl);
		data.update(table, values, "number = "+num, null);
		goBack();
	}
	public void bfuncBlk(View v){
		int blk = player.getInt(blkIndex);
		blk++;
		ContentValues values = new ContentValues();
		values.put(SQLite.BLKS, blk);
		data.update(table, values,"number = "+num, null);
		goBack();
	}
	public void bfuncTo(View v){
		int to = player.getInt(toIndex);
		to++;
		ContentValues values = new ContentValues();
		values.put(SQLite.TOS, to);
		data.update(table, values, "number = "+num, null);
		goBack();
	}
	public void btnFoul(View v){
		int fl = player.getInt(flIndex);
		fl++;
		if(fl==4){
			Toast.makeText(GameRecord.this, "Wacth out!! 4th Personal Foul", Toast.LENGTH_SHORT);
		}
		if(fl>5){
			Toast.makeText(GameRecord.this, "already 5th Personal Foul", Toast.LENGTH_LONG);
			fl=5;
		}
		ContentValues values = new ContentValues();
		values.put(SQLite.FLS, fl);
		data.update(table, values, "number = "+num, null);
		goBack();
	}
	public void bfuncDelete(){
		
	}
	public void goBack(){
		Intent back = new Intent();
		back.setClass(GameRecord.this, Recording.class);
		startActivity(back);
		GameRecord.this.finish();
		data.close();
		data2.close();
		player.close();
		team.close();
	}
	public void twoShow(int ap,int md){
		TextView two = (TextView)findViewById(R.id.Twop);
		two.setText(two.getText().toString()+" "+md+"/"+ap);
	}
}
