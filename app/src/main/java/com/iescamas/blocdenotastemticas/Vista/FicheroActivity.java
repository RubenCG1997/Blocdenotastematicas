package com.iescamas.blocdenotastemticas.Vista;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.iescamas.blocdenotastemticas.Modelo.Tematicas;
import com.iescamas.blocdenotastemticas.R;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FicheroActivity extends AppCompatActivity {

    private MaterialToolbar materialToolbar;
    private EditText editText;
    private Tematicas tematica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichero);

        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);
        initComponent();
        leerDeFichero();
    }

    private void initComponent(){
        materialToolbar = findViewById(R.id.materialToolbar);
        editText = findViewById(R.id.txt);
        setSupportActionBar(materialToolbar);
        Intent intent = getIntent();
        tematica = (Tematicas) intent.getSerializableExtra("tematica");
        materialToolbar.setTitle(tematica.getTexto());
        materialToolbar.setBackgroundColor(tematica.getColor());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.validar) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            escribirEnFichero();
            finish();
        }
        return true;
    }

    private void escribirEnFichero() {
        try {

            OutputStreamWriter flujoSalida = new OutputStreamWriter(openFileOutput(tematica.getTexto() + ".txt", Activity.MODE_PRIVATE));
            flujoSalida.write(editText.getText().toString());
            flujoSalida.flush();
            flujoSalida.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void leerDeFichero() {
        try {

            InputStreamReader flujoEntrada = new InputStreamReader(openFileInput(tematica.getTexto() + ".txt"));
            BufferedReader buffer = new BufferedReader(flujoEntrada);
            String linea = buffer.readLine();
            StringBuilder textoLeido = new StringBuilder();
            while (linea != null) {
                textoLeido.append(linea).append("\n");
                linea = buffer.readLine();
            }
            buffer.close();
            flujoEntrada.close();
            editText.setText(textoLeido.toString());
        } catch (FileNotFoundException e) {
            escribirEnFichero();// Si el archivo no existe creamos uno vacío
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
