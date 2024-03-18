package com.example.parcial1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edEmailLog,edPasswordLog;

    Button btingresar, btregistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edEmailLog = findViewById(R.id.edEmailLog);
        edPasswordLog = findViewById(R.id.edPasswordLog);

        btingresar = findViewById(R.id.btingresar);
        btregistro = findViewById(R.id.btregistro);

        btingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickIniciarSecion();
            }
        });

        btregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRegistrar();
            }
        });

    }

    private void onClickIniciarSecion(){
        String email = edEmailLog.getText().toString();
        String password = edPasswordLog.getText().toString();

        if (!email.isEmpty()){
            if (!password.isEmpty()){
                onClickIngreso();
            }else {
                edPasswordLog.setError("Campo requerido");
            }
        }else {
            edEmailLog.setError("Campo requerido");
        }
    }

    private  void onClickIngreso(){
        String Usuario = edEmailLog.getText().toString();
        Intent intent = new Intent(this, InicioActivity.class);
        intent.putExtra("Usuario", Usuario);
        startActivity(intent);
    }

    private  void onClickRegistrar(){
        Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
}