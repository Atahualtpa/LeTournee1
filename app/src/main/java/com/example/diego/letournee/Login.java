package com.example.diego.letournee;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    Button btn_iniciar;
    TextView tv_user, tv_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tv_user = (TextView) findViewById(R.id.user);
        tv_password = (TextView) findViewById(R.id.password);
        btn_iniciar = (Button) findViewById(R.id.btn_iniciar);
        btn_iniciar.setOnClickListener(onClickListener);

    }
    private  View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            if (v == btn_iniciar) {
                entrar();
            }
        }
    };
    public void entrar(){
        Intent intent = new Intent(this, Usuarios.class);
        startActivity(intent);
        finish();
    }

}
