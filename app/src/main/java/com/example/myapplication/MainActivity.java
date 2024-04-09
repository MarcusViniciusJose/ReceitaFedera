package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome, editTextRenda;
    private Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextRenda = findViewById(R.id.editTextRenda);
        buttonCalcular = findViewById(R.id.buttonCalcular);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString().trim();
                double renda = Double.parseDouble(editTextRenda.getText().toString());

                // Calcular o imposto de renda
                double imposto = calcularImposto(renda);

                // Passar para a próxima Activity com os dados do usuário
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("nome", nome);
                intent.putExtra("renda", renda);
                intent.putExtra("imposto", imposto);
                startActivity(intent);
            }
        });
    }

    private double calcularImposto(double renda) {
        // Implemente aqui o cálculo do imposto de renda com base na tabela fornecida
        // Neste exemplo, apenas retornaremos 0 como imposto
        return 0;
    }
}
