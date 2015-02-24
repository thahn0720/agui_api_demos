package thahn.java.agui.test.sqlite;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import thahn.java.agui.Global;
import thahn.java.agui.app.Context;
import thahn.java.agui.sqlite.ContentValues;
import thahn.java.agui.sqlite.Cursor;
import thahn.java.agui.sqlite.SQLiteDatabase;
import thahn.java.agui.sqlite.SQLiteOpenHelper;
import thahn.java.agui.utils.Log;


public class LocationDBHelper extends SQLiteOpenHelper {

	private static final String 										TAG				= "LocationDBHelper";
	private static final String 										DB_NAME 		= "location_list.db";
	private static final String 										TABLE_NAME 		= "favoriteLocation";
	private static final String 										RAW_ID 			= "_id";
	private static final String 										NAME			= "name";
	private static final String 										LONGITUDE		= "longitude";
	private static final String 										LATITUDE		= "latitude";
	private static int 													DB_VERSION 		= 1;
	private static final String											ALTITUDE		= "altitude";

	public LocationDBHelper(Context context) {
		super(context, Global.projectPath+"/"+DB_NAME, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase ruleDB) {
		Log.i(TAG, "onCreate");
		StringBuilder myRule = new StringBuilder();

		myRule.append("CREATE TABLE IF NOT EXISTS ").append(TABLE_NAME)
				.append(" ( ").append(RAW_ID)
				.append(" INTEGER PRIMARY KEY AUTOINCREMENT , ")
				.append(NAME).append(" TEXT , ")
				.append(LONGITUDE).append(" INTEGER DEFAULT 0 , ")
				.append(LATITUDE).append(" INTEGER DEFAULT 0 , ")
				.append(ALTITUDE).append(" INTEGER DEFAULT 0 , ")
				.append(TAG).append(" TEXT ")
				.append(" ); ");

		try {
			ruleDB.execSQL(myRule.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.i(TAG, "onUpgrade");
	}
	
	public List<LocationData> select() {
		SQLiteDatabase dbHandler = this.getWritableDatabase();
		Cursor c = dbHandler.query(false, TABLE_NAME, new String[] {RAW_ID, NAME, LONGITUDE, LATITUDE}
			, null, null, null, null, null, null);
		List<LocationData> ret = new ArrayList<LocationData>();
		c.moveToFirst();
		for (int i = 0; i < c.getCount(); i++) {
//		while(c.moveToNext()) {
			LocationData data = new LocationData();
			data.rawId = c.getInt(c.getColumnIndexOrThrow(RAW_ID));
			data.name = c.getString(c.getColumnIndexOrThrow(NAME));
			data.longitude = c.getFloat(c.getColumnIndexOrThrow(LONGITUDE));
			data.latitude = c.getFloat(c.getColumnIndexOrThrow(LATITUDE));
			ret.add(data);
			c.moveToNext();
		}
		
		return ret;
	}
	
	public void insert(LocationData data){
		insert(data.name, data.longitude, data.latitude ,(String)data.tag);
	}
	
	public void insert(String name, double longitude, double latitude, String tag){
		SQLiteDatabase dbHandler = this.getWritableDatabase();
//		dbHandler.beginTransaction();
		ContentValues value = new ContentValues();
		value.put(NAME, name);
		value.put(LONGITUDE, longitude);
		value.put(LATITUDE, latitude);
		value.put(TAG, tag);
		dbHandler.insert(TABLE_NAME, null, value);
//		dbHandler.setTransactionSuccessful();
//		dbHandler.endTransaction();
//		dbHandler.close();
	}
	
	public void update(int rawId, String name, long longitude, long latitude, String tag){
		 SQLiteDatabase db = this.getWritableDatabase();
		 ContentValues values = new ContentValues();
		 values.put(RAW_ID, rawId);
		 values.put(NAME, name);
		 values.put(LONGITUDE, longitude);
		 values.put(LATITUDE, latitude);
		 values.put(TAG, tag);
		 try {
			db.update(TABLE_NAME, values, RAW_ID + " = ?", new String[] { String.valueOf(rawId) });
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		 db.close();
		 Log.d(TAG, "Edit Location, location name = "+name);
	}
	
	public void delete(int rawId) {
		  SQLiteDatabase db = this.getWritableDatabase();
          try {
			db.delete(TABLE_NAME, RAW_ID + " = ?", new String[] { String.valueOf(rawId) });
		} catch (SQLException e) {
			e.printStackTrace();
		}
//          db.close();
          Log.d(TAG, "location  "+rawId+" is deleted.");
	}
	
	@Override
	public void onOpen(SQLiteDatabase assistNaviDB) {
		super.onOpen(assistNaviDB);
	}
}
