package com.example.myplayschool;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "loginDetails";

	// Contacts table name
	private static final String TABLE_CONTACTS = "login";

	// Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "email";
	
	private static final String KEY_PASSWORD = "password";

	public Database(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
				+ KEY_PASSWORD + " TEXT" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new contact
	void addContact(String login_email,String Password) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, login_email); // Contact Name
		values.put(KEY_PASSWORD, Password); // Contact Phone
		
		
		System.out.println("data======================================================"+values);
		

		// Inserting Row
		db.insert(TABLE_CONTACTS, null, values);
		db.close(); // Closing database connection
	}

	// Getting single contact
	public String getUser(String id) {
		SQLiteDatabase db = this.getReadableDatabase();

//		Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_E_ID,
//				 KEY_PASSWORD }, KEY_E_ID + "=?",
//				new String[] { id }, null, null, null, null);
//		if (cursor != null)
//			cursor.moveToFirst();
		
		
	//	 final String TABLE_NAME = "login";
		
		String password="";
		
		try{
		
		
		Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
				KEY_NAME, KEY_PASSWORD }, KEY_NAME + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null){
			cursor.moveToFirst();
		

//		    String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
//		   
//		    Cursor cursor      = db.rawQuery(selectQuery, null);
		   // String[] data      = null;
		    System.out.println("Cursor======================================================"+cursor.getCount());
		
//		    if (cursor != null)
//				cursor.moveToFirst();
		password=cursor.getString(2);
		System.out.println("Password-------------------------"+password);
		}
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Exception----------   "+e);
		}
		return password;
	}
	
//	// Getting All Contacts
//	public List<Contact> getAllContacts() {
//		List<Contact> contactList = new ArrayList<Contact>();
//		// Select All Query
//		String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
//
//		SQLiteDatabase db = this.getWritableDatabase();
//		Cursor cursor = db.rawQuery(selectQuery, null);
//
//		// looping through all rows and adding to list
//		if (cursor.moveToFirst()) {
//			do {
//				Contact contact = new Contact();
//				contact.setID(Integer.parseInt(cursor.getString(0)));
//				contact.setName(cursor.getString(1));
//				contact.setPhoneNumber(cursor.getString(2));
//				// Adding contact to list
//				contactList.add(contact);
//			} while (cursor.moveToNext());
//		}
//
//		// return contact list
//		return contactList;
//	}

//	// Updating single contact
//	public int updateContact(Contact contact) {
//		SQLiteDatabase db = this.getWritableDatabase();
//
//		ContentValues values = new ContentValues();
//		values.put(KEY_NAME, contact.getName());
//		values.put(KEY_PH_NO, contact.getPhoneNumber());
//
//		// updating row
//		return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
//				new String[] { String.valueOf(contact.getID()) });
//	}
//
//	// Deleting single contact
//	public void deleteContact(Contact contact) {
//		SQLiteDatabase db = this.getWritableDatabase();
//		db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
//				new String[] { String.valueOf(contact.getID()) });
//		db.close();
//	}


//	// Getting contacts Count
//	public int getContactsCount() {
//		String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
//		SQLiteDatabase db = this.getReadableDatabase();
//		Cursor cursor = db.rawQuery(countQuery, null);
//		cursor.close();
//
//		// return count
//		return cursor.getCount();
//	}

}
