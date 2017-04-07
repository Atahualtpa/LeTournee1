package com.example.diego.letournee;

/**
 * Created by Diego on 02/04/2017.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class LetourneeDbHelper extends SQLiteOpenHelper{

    private static int version = 1;
    private static String name = "LetourneeDb" ;
    private static CursorFactory factory = null;

    public LetourneeDbHelper(Context context) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.i(this.getClass().toString(), "Creando base de datos");

        db.execSQL( "CREATE TABLE LOGIN(" +
                " id_user INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name TEXT NOT NULL, " +
                " ap_paterno TEXT, " +
                " ap_materno TEXT," +
                " account_name TEXT," +
                " age INTEGER," +
                " email TEXT," +
                " password TEXT)" );

        db.execSQL( "CREATE UNIQUE INDEX id_user ON LOGIN(id_user ASC)" );

        Log.i(this.getClass().toString(), "Tabla LOGIN creada");

        /*
    * Insertamos datos iniciales
    */
        db.execSQL("INSERT INTO LOGIN(name,ap_paterno,ap_materno,account_name,age,email,password) VALUES('Diego','Hernandez','Lopez','DDHL97',19,'diego_08_1997@hotmail.com','toto')");
        db.execSQL("INSERT INTO LOGIN(name,ap_paterno,ap_materno,account_name,age,email,password) VALUES('Karla','Terrazas','Lopez','KSTL04',19,'1715110631@utec-tgo.edu.mx','toby)");
        db.execSQL("INSERT INTO LOGIN(name,ap_paterno,ap_materno,account_name,age,email,password) VALUES('Liz','Hernandez','Lopez','LG22',21,'aome_22@hotmail.com','chapulin')");
        db.execSQL("INSERT INTO LOGIN(name,ap_paterno,ap_materno,account_name,age,email,password) VALUES('Laura', 'Hernandez', 'Lopez','LEHL22',13,'lauriz_22_12@hotmail.com','andromeda')");
        db.execSQL("INSERT INTO LOGIN(name,ap_paterno,ap_materno,account_name,age,email,password) VALUES('Cris','Mercado','Lechuga','CML19',20,'mercado_19@hotmail.com','cris')");
        db.execSQL("INSERT INTO LOGIN(name,ap_paterno,ap_materno,account_name,age,email,password) VALUES('Blanca','Guzman','Soto','CGS',19,'blansh_12@hotmail.com','blansh')");
        db.execSQL("INSERT INTO LOGIN(name,ap_paterno,ap_materno,account_name,age,email,password) VALUES('Samantha','Lopez','Terrazas','Sam04',19,'samy_04@hotmail.com','samy')");

        Log.i(this.getClass().toString(), "Datos iniciales HIPOTECA insertados");

        Log.i(this.getClass().toString(), "Base de datos creada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
