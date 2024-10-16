package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pytanie> listaPytan = new ArrayList<>();

    private TextView textView;

    private int aktualnepytanie;

    private Button buttonNastepne;

    private Button buttonTak;

    private Button buttonNie;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wypelnijpytania();
        textView = findViewById(R.id.textViewTrescPytania);
        aktualnepytanie = 0;
        wstawPytanie(aktualnepytanie);


        buttonTak = findViewById(R.id.button);
        buttonTak.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzToPytanie(true);
                    }
                }
        );



        buttonNie = findViewById(R.id.button2);
        buttonNie.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sprawdzToPytanie(false);
                    }
                }
        );



        buttonNastepne = findViewById(R.id.button4);
        buttonNastepne.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualnepytanie++;
                            if (aktualnepytanie == listaPytan.size()){
                                buttonNastepne.setVisibility(View.INVISIBLE);
                                buttonTak.setVisibility(View.INVISIBLE);
                                buttonNie.setVisibility(View.INVISIBLE);
                                textView.setText("Koniec testu otrzymano ..... punktow");
                                int ile = podliczPunkty();
                                        textView.setText("Zakonczono test twoja liczba punktow wynosi "+String.valueOf(ile)+ " punktow");
                            }
                            else{
                                wstawPytanie(aktualnepytanie);
                            }
                    }
                }
        );

        //repozytorium z pytaniami

    }


    private void sprawdzToPytanie(boolean odpowiedzuzytkownika){
        if (listaPytan.get(aktualnepytanie).isPoprawna() == true){
            listaPytan.get(aktualnepytanie).setUdzielonoPoprawnaOdpowidz(true);
        }
    }

    private void wstawPytanie(int i){
        Pytanie pytanie = listaPytan.get(i);
        textView.setText(pytanie.getTresc());
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

    private int podliczPunkty() {
        int ilepunktow = 0;

        for (Pytanie pytanie : listaPytan) {
            if (pytanie.isUdzielonoPoprawnaOdpowidz()) {
                ilepunktow++;
            }

        }

        return ilepunktow;
    }

}