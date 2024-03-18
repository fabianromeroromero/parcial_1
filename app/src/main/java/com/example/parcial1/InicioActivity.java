package com.example.parcial1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class InicioActivity extends AppCompatActivity {

    ImageView imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);

        imgUrl = findViewById(R.id.imgUrl);

        Picasso.get().
                load("https://firebasestorage.googleapis.com/v0/b/primer-proyecto-b27bf.appspot.com/o/descarga.png?alt=media&token=25c46eb9-55a2-4c48-a31e-31198e8874d2 ").
                placeholder(R.drawable.loading).
                error(R.drawable.error).
                into(imgUrl);

        TextView textoUsuario = findViewById(R.id.txtUsuario);
        String Usuario = getIntent().getStringExtra("Usuario");
        String mensaje = "Bienvenido " + Usuario;
        textoUsuario.setText(mensaje);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_inicio,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int idItem = item.getItemId();
        if(idItem ==R.id.itemCerrarsecion){
            clickEnCerrarSesion();
        }else if (idItem == R.id.itemNosotros){
            clickEnNosotros();
        }
        return super.onOptionsItemSelected(item);
    }

    private void clickEnCerrarSesion(){
        Toast.makeText(this, "Cerrar Sesión", Toast.LENGTH_SHORT).show();
    }

    private void clickEnNosotros(){
        Toast.makeText(this, "Nosotros", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent (this,NosotrosActivity.class);
        startActivity(intent);

    }
}