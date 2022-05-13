package zhimingzhang.deakin.lostandfoundapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static  String Table_Name="Userdetails";
    private static  String name ="name";
    private static  String type="type";
    private static final String  date="date";
    private static final String phone="phone";
    private static final String description="description";
    private static final String location="location";



    public DatabaseHelper(@Nullable Context context) {


        super(context,Table_Name,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        String create="CREATE TABLE " +Table_Name+" ("+ name +" TEXT  PRIMARY KEY , "+type +" TEXT ,"+date+ " TEXT , "+phone+" TEXT ,"+description+" TEXT, "+location+" TEXT )";
        //DB.execSQL("create Table Userdetails(name TEXT primary key,type TEXT,date TEXT,phone TEXT,description TEXT,location TEXT)");
        DB.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");
    }
    public Boolean insertData(String names,String types,String dates,String phones,String descriptions,String locations){
        SQLiteDatabase DB=this.getWritableDatabase();
        ContentValues vals=new ContentValues();
        vals.put(name,names);
        vals.put(type,types);
        vals.put(date,dates);
        vals.put(phone,phones);
        vals.put(description,descriptions);
        vals.put(location,locations);

        long result=DB.insert("Userdetails",null,vals);
        if(result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String q="SELECT * FROM "+Table_Name;
        Cursor data=db.rawQuery(q,null);
        return data;
    }
    public void deleteItem(String names,String types,String dates,String phones,String descriptions,String locations){
        SQLiteDatabase db=this.getWritableDatabase();
        String q=" DELETE FROM "+Table_Name+" WHERE " +name +" = '"+names+"'"+" AND "+type+" = '"+ types+"'";//+" AND "+date+" = '"+ dates+"'"+" AND "+phone+" = '"+ phones+"'"+" AND "+location+" = '"+ locations+"'";

        db.execSQL(q);
    }


}
