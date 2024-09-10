package com.example.chamadaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enviar (View view){
        Intent intent = new Intent(getApplicationContext(),EnviarActivity.class);
        intent.putExtra("titulo", ((EditText)findViewById(R.id.idTitulo)).getText().toString());
        intent.putExtra("conteudo", ((EditText)findViewById(R.id.idConteudo)).getText().toString());
        startActivity(intent);
    }
}