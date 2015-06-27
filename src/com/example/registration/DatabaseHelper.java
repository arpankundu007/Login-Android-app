package com.example.registration;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

	public DatabaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	SQLiteDatabase db;
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "contacts.db";
	private static final String TABLE_NAME = "contacts";
	private static final String COLUMN_ID = "id";
	private static final String COLUMN_NAME = "name";
	private static final String COLUMN_EMAIL = "email";
	private static final String COLUMN_UNAME = "uname";
	private static final String COLUMN_PASS = "pass";
	private static final String TABLE_CREATE = "create table if not exists contacts (id integer primary key not null, name text not null, email text not null, uname text not null, pass text name not null);";
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME,null,DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TABLE_CREATE);
		this.db = db;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
		db.execSQL(query);
		this.onCreate(db);
	}
	public void insertContact(Contact c)
	{
		db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		String query = "select * from contacts";
		Cursor cu = db.rawQuery(query, null);
		int count = cu.getCount();
		
		values.put(COLUMN_ID, count);
		
		values.put(COLUMN_NAME, c.getName());
		values.put(COLUMN_EMAIL, c.getEmail());
		values.put(COLUMN_UNAME, c.getUname());
		values.put(COLUMN_PASS, c.getPass());
		db.insert(TABLE_NAME, null, values);
		db.close();
	}
	public String searchPass(String uname)
	{
		db = this.getReadableDatabase();
		String query = "select uname, pass from "+ TABLE_NAME;
		Cursor cu = db.rawQuery(query, null);
		String a,b = null;
		if(cu.moveToFirst())
		{
			do{
				a = cu.getString(0);
				
				if(a.equals(uname))
				{
					b = cu.getString(1);
					break;
				}
			}
			while(cu.moveToNext());
			
		}
		return b;
		
	}

}
