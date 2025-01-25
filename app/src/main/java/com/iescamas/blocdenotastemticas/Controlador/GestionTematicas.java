package com.iescamas.blocdenotastemticas.Controlador;

import android.content.Context;

import com.iescamas.blocdenotastemticas.Modelo.Tematicas;
import com.iescamas.blocdenotastemticas.R;

import java.util.ArrayList;
import java.util.List;

public class GestionTematicas {

    public static List<Tematicas>listaTematicas;

    public static List<Tematicas> getListaTematicas() {
        return listaTematicas;
    }

    public static void initListaTematicas(Context context){

        listaTematicas = new ArrayList<>();

        listaTematicas.add(new Tematicas(R.drawable.urgente,context.getResources().getString(R.string.lbl1),context.getColor(R.color.color_Urgente)));
        listaTematicas.add(new Tematicas(R.drawable.viajes,context.getResources().getString(R.string.lbl2),context.getColor(R.color.color_Viajes)));
        listaTematicas.add(new Tematicas(R.drawable.conciertos,context.getResources().getString(R.string.lbl3),context.getColor(R.color.color_Conciertos)));
        listaTematicas.add(new Tematicas(R.drawable.familia,context.getResources().getString(R.string.lbl4),context.getColor(R.color.color_Familia)));
        listaTematicas.add(new Tematicas(R.drawable.amigos,context.getResources().getString(R.string.lbl5),context.getColor(R.color.color_Amigos)));
        listaTematicas.add(new Tematicas(R.drawable.deportes,context.getResources().getString(R.string.lbl6),context.getColor(R.color.color_Deportes)));
        listaTematicas.add(new Tematicas(R.drawable.cultura,context.getResources().getString(R.string.lbl7),context.getColor(R.color.color_Cultura)));
        listaTematicas.add(new Tematicas(R.drawable.comida,context.getResources().getString(R.string.lbl8),context.getColor(R.color.color_Comida)));
        listaTematicas.add(new Tematicas(R.drawable.internet,context.getResources().getString(R.string.lbl9),context.getColor(R.color.color_Internet)));
        listaTematicas.add(new Tematicas(R.drawable.cine,context.getResources().getString(R.string.lbl10),context.getColor(R.color.color_Cine)));

    }
}
