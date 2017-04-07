package com.example.diego.letournee;

/**
 * Created by Diego on 02/04/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LeTourneeDbAdapter {
    /**
     * Definimos constante con el nombre de la tabla
     */
    public static final String C_TABLA = "LOGIN" ;

    /**
     * Definimos constantes con el nombre de las columnas de la tabla
     */
    public static final String C_COLUMNA_ID_USER   = "id_user";
    public static final String C_COLUMNA_NAME = "name";
    public static final String C_COLUMNA_AP_PATERNO = "ap_paterno";
    public static final String C_COLUMNA_AP_MATERNO = "ap_materno";
    public static final String C_COLUMNA_ACCOUNT_NAME = "account_name";
    public static final String C_COLUMNA_AGE = "age";
    public static final String C_COLUMNA_EMAIL = "email";
    public static final String C_COLUMNA_PASSWORD = "password";

    private Context contexto;
    private LetourneeDbHelper dbHelper;
    private SQLiteDatabase db;
    /**
     * Definimos lista de columnas de la tabla para utilizarla en las consultas a la base de datos
     */
    private String[] columnas = new String[]{ C_COLUMNA_ID_USER, C_COLUMNA_NAME, C_COLUMNA_AP_PATERNO, C_COLUMNA_AP_MATERNO, C_COLUMNA_ACCOUNT_NAME, C_COLUMNA_AGE, C_COLUMNA_EMAIL, C_COLUMNA_PASSWORD} ;

    public LeTourneeDbAdapter(Context context)
    {
        this.contexto = context;
    }

    public LeTourneeDbAdapter abrir() throws SQLException
    {
        dbHelper = new LetourneeDbHelper(contexto);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void cerrar()
    {
        dbHelper.close();
    }
    /**
     * Devuelve cursor con todos las columnas de la tabla
     */
    public Cursor getCursor() throws SQLException
    {
        Cursor c = db.query( true, C_TABLA, columnas, null, null, null, null, null, null);

        return c;
    }
    /**
     * Devuelve cursor con todos las columnas del registro
     */
    public Cursor getRegistro(long id) throws SQLException
    {
        Cursor c = db.query( true, C_TABLA, columnas, C_COLUMNA_ID_USER + "=" + id, null, null, null, null, null);

        //Nos movemos al primer registro de la consulta
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }
    /**
     * Inserta los valores en un registro de la tabla
     */
    public long insert(ContentValues reg)
    {
        if (db == null)
            abrir();

        return db.insert(C_TABLA, null, reg);
    }

}
