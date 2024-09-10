package com.example.chamadaactivity;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EnviarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar);

        String titulo = getIntent().getStringExtra("titulo");
        String conteudo = getIntent().getStringExtra("conteudo");

        ((TextView)findViewById(R.id.idTitulo)).setText(titulo);
        ((TextView)findViewById(R.id.idConteudo)).setText(conteudo);
    }

    private ActivityResultLauncher camera = registerForActivityResult(
            new ActivityResultContracts.TakePicturePreview(), new ActivityResultCallback<Bitmap>() {
                @Override
                public void onActivityResult(Bitmap result) {
                    ImageView foto = findViewById(R.id.foto);
                    foto.setImageBitmap(result);
                }
           });

    public void chamarCamera (View view){
        camera.launch(null);
    }

    public void compartilhar (View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT,
                ((TextView)findViewById(R.id.idTitulo)).getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT,
                ((TextView)findViewById(R.id.idConteudo)).getText().toString());
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent,
                "comparatilhando com..."));
    }
}