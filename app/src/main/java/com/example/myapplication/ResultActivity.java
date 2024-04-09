package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textViewResultado = findViewById(R.id.textViewResultado);
        Button buttonCompartilhar = findViewById(R.id.buttonCompartilhar);

        Intent intent = getIntent();
        if (intent != null) {
            String nome = intent.getStringExtra("nome");
            double renda = intent.getDoubleExtra("renda", 0);
            double imposto = intent.getDoubleExtra("imposto", 0);

            String resultado = nome + ", com renda mensal de R$ " + renda;

            if (imposto == 0) {
                resultado += ", não precisa pagar imposto de renda.";
            } else {
                resultado += ", deve pagar R$ " + imposto + " de imposto de renda.";
            }

            textViewResultado.setText(resultado);
        }

        buttonCompartilhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resultado = textViewResultado.getText().toString();

                // Crie uma Intent para compartilhamento
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, resultado);

                // Inicie a atividade de compartilhamento
                startActivity(Intent.createChooser(intent, "Compartilhar via")); }
        });
    }
}

















