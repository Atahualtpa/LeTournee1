package com.example.diego.letournee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class Usuarios extends ListActivity {
    public static final String C_MODO  = "modo" ;
    public static final int C_VISUALIZAR = 551 ;
    public static final int C_CREAR = 552 ;

    private LeTourneeDbAdapter dbAdapter;
    private Cursor cursor;
    private LeTourneeCursorAdapter LeTourneeAdapter ;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);
        lista = (ListView) findViewById(android.R.id.list);

        dbAdapter = new LeTourneeDbAdapter(this);
        dbAdapter.abrir();

        consultar();
    }

    private void consultar()
    {
        cursor = dbAdapter.getCursor();
        startManagingCursor(cursor);
        LeTourneeAdapter = new LeTourneeCursorAdapter(this, cursor);
        lista.setAdapter(LeTourneeAdapter);
    }
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item)
    {
        Intent i;

        switch (item.getItemId())
        {
            case R.id.menu_crear:
                i = new Intent(Usuarios.this, Perfil.class);
                i.putExtra(C_MODO, C_CREAR);
                startActivityForResult(i, C_CREAR);
                return true;
        }
        return super.onMenuItemSelected(featureId, item);
    }

    private void visualizar(long id)
    {
        // Llamamos a la Actividad HipotecaFormulario indicando el modo visualización y el identificador del registro
        Intent i = new Intent(Usuarios.this, Perfil.class);
        i.putExtra(C_MODO, C_VISUALIZAR);
        i.putExtra(LeTourneeDbAdapter.C_COLUMNA_ID_USER, id);

        startActivityForResult(i, C_VISUALIZAR);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position, id);

        visualizar(id);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        //
        // Nos aseguramos que es la petición que hemos realizado
        //
        switch(requestCode)
        {
            case C_CREAR:
                if (resultCode == RESULT_OK)
                    consultar();

            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
