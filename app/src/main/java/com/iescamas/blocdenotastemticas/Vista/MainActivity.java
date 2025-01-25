package com.iescamas.blocdenotastemticas.Vista;

import static android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.iescamas.blocdenotastemticas.Controlador.GestionTematicas;
import com.iescamas.blocdenotastemticas.Modelo.Tematicas;
import com.iescamas.blocdenotastemticas.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Integer>listaIdImg = Arrays.asList(R.id.img1,R.id.img2,R.id.img3,R.id.img4,R.id.img5,R.id.img6,
            R.id.img7,R.id.img8,R.id.img9,R.id.img10);

    private final List<Integer>listaIdLbl = Arrays.asList(R.id.lbl1,R.id.lbl2,R.id.lbl3,R.id.lbl4,R.id.lbl5,R.id.lbl6,
            R.id.lbl7,R.id.lbl8,R.id.lbl9,R.id.lbl10);

    private List<ImageView> listaImageView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(SCREEN_ORIENTATION_PORTRAIT);

        initComponentes();

        listaImageView.get(0).setOnClickListener(v ->cambiarActivity(GestionTematicas.getListaTematicas().get(0)));
        listaImageView.get(1).setOnClickListener(v ->cambiarActivity(GestionTematicas.getListaTematicas().get(1)));
        listaImageView.get(2).setOnClickListener(v ->cambiarActivity(GestionTematicas.getListaTematicas().get(2)));
        listaImageView.get(3).setOnClickListener(v ->cambiarActivity(GestionTematicas.getListaTematicas().get(3)));
        listaImageView.get(4).setOnClickListener(v ->cambiarActivity(GestionTematicas.getListaTematicas().get(4)));
        listaImageView.get(5).setOnClickListener(v ->cambiarActivity(GestionTematicas.getListaTematicas().get(5)));
        listaImageView.get(6).setOnClickListener(v ->cambiarActivity(GestionTematicas.getListaTematicas().get(6)));
        listaImageView.get(7).setOnClickListener(v ->cambiarActivity(GestionTematicas.getListaTematicas().get(7)));
        listaImageView.get(8).setOnClickListener(v ->cambiarActivity(GestionTematicas.getListaTematicas().get(8)));
        listaImageView.get(9).setOnClickListener(v ->cambiarActivity(GestionTematicas.getListaTematicas().get(9)));


    }

    private void initComponentes(){

        listaImageView = new ArrayList<>();
        GestionTematicas.initListaTematicas(getApplicationContext());

        for (int i = 0;i<listaIdImg.size();i++){

            ImageView imageView = findViewById(listaIdImg.get(i));
            TextView textView = findViewById(listaIdLbl.get(i));

            imageView.setImageResource(GestionTematicas.getListaTematicas().get(i).getImg());
            textView.setText(GestionTematicas.getListaTematicas().get(i).getTexto());
            listaImageView.add(imageView);
        }
    }

    private void cambiarActivity(Tematicas tematica){
        Intent intent = new Intent(getApplicationContext(),FicheroActivity.class);
        intent.putExtra("tematica",tematica);
        startActivity(intent);
        finish();
    }


}