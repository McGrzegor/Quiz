package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {




    private ArrayList<Pytanie> listaPytan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //repozytorium z pytaniami

    }

    private void wypelnijpytania(){
        listaPytan.add(new Pytanie("Czy sekwoja może mieć 100 metrów wysokości?",
                "Sekowje są bardzo wysokie",
                true
        ));


        listaPytan.add(new Pytanie(
                "Czy najbrubsze drzewo ma obwód 10 metrów",
                "Obwód pnia najgrubszego dzrzewa to 44metry",
                true

        ));


        listaPytan.add(new Pytanie(
                "Czy drzewa sa pochłaniaczami tlenu",
                "Zastanów sie na czym polega fotosynteza",
                false

        ));



    }
}