package com.example.listaplanetas;

import java.util.ArrayList;

public class PlanetaDAO {
    ArrayList<Planeta> planetas;

    public PlanetaDAO() {
        planetas = new ArrayList<>();
        planetas.add(new Planeta("Mercurio",R.drawable.mercury));
        planetas.add(new Planeta("Venus",R.drawable.venus));
        planetas.add(new Planeta("Terra",R.drawable.earth));
    }
    public ArrayList<Planeta> getPlanetas() {
        return planetas;
    }
}
