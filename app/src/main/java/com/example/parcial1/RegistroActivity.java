package com.example.parcial1;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.stream.Stream;

public class RegistroActivity extends AppCompatActivity {

    EditText ednombreRe, edEmailRe, edDireccionRe, edTelefonoRe, edFechaRe, edContrasenaRe;

    Button btEnviarRe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);

        ednombreRe = findViewById(R.id.ednombreRe);
        edEmailRe = findViewById(R.id.edEmailRe);
        edDireccionRe = findViewById(R.id.edDireccionRe);
        edTelefonoRe = findViewById(R.id.edTelefonoRe);
        edFechaRe = findViewById(R.id.edFechaRe);
        edContrasenaRe = findViewById(R.id.edContrasenaRe);

        btEnviarRe = findViewById(R.id.btEnviarRe);

        edFechaRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        btEnviarRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Enviar();
            }
        });
    }


    private void Enviar(){
        String nombre = ednombreRe.getText().toString();
        String correo = edEmailRe.getText().toString();
        String direccion = edDireccionRe.getText().toString();
        String telefono = edTelefonoRe.getText().toString();
        String cumpleaños = edFechaRe.getText().toString();
        String contrasena = edContrasenaRe.getText().toString();

        if (!nombre.isEmpty()){
            if (!correo.isEmpty()){
                if (!direccion.isEmpty()){
                    if (!telefono.isEmpty()){
                        if (!cumpleaños.isEmpty()){
                            if (!contrasena.isEmpty()){
                                onClickregitro();
                            }else {
                                edContrasenaRe.setError("Campo requerido");
                            }
                        }else {
                            edFechaRe.setError("Campo requerido");
                        }
                    }else {
                        edTelefonoRe.setError("Campo requerido");
                    }
                }else {
                    edDireccionRe.setError("Campo requerido");
                }
            }else {
                edEmailRe.setError("Campo requerido");
            }
        }else {
            ednombreRe.setError("Campo requerido");
        }
    }

    private void onClickregitro(){
        AlertDialog.Builder alert = new AlertDialog.Builder(RegistroActivity.this);
        alert.setTitle("CONFIRMACIÓN")
                .setMessage("Sus datos son correctos")
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String Usuario = edEmailRe.getText().toString();
                        Intent intent = new Intent(RegistroActivity.this, InicioActivity.class);
                        intent.putExtra("Usuario", Usuario);

                        startActivity(intent);
                    }
                })
                .setNegativeButton("NO", null)
                .setCancelable(false)
                .setIcon(R.drawable.confirmacion)
                .show();
    }

    private void showDatePickerDialog(){
        android.icu.util.Calendar calendar = android.icu.util.Calendar.getInstance();
        int year = calendar.get(android.icu.util.Calendar.YEAR);
        int month = calendar.get(android.icu.util.Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(RegistroActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edFechaRe.setText(dayOfMonth + "-" + (month+1) + "-" + year);
            }
        },year,month,dayOfMonth);
        dialog.setCancelable(false);
        dialog.show();
    }
}