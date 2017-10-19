package com.example.andreyshklyaev.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.util.concurrent.locks.Lock;

public class MainActivity extends AppCompatActivity {

    private TextView numPreg;
    private TextView preg;
    private TextView punts;
    private TextView valoranos;
    private Button mFAL;
    private Button mTRU;
    private Button mVal;
    private Button Pista;
    private Button Ver;
    private Button noVer;
    private boolean[] respuestas;
    private int[] preguntas;
    private int[] pistas;
    private int contador;
    private double puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        respuestas = new boolean[3];
        preguntas = new int[3];
        pistas = new int[3];

        respuestas[0] = true;
        respuestas[1] = false;
        respuestas[2] = false;
        preguntas[0] = R.string.pregunta1;
        preguntas[1] = R.string.pregunta2;
        preguntas[2] = R.string.pregunta3;
        pistas[0] = R.string.pista1;
        pistas[1] = R.string.pista2;
        pistas[2] = R.string.pista3;

        valoranos = (TextView) findViewById(R.id.ValoraTxt);
        Ver = (Button) findViewById(R.id.Ver);
        noVer = (Button) findViewById(R.id.NoVer);
        Pista = (Button) findViewById(R.id.mPista);
        mVal = (Button) findViewById(R.id.mValorar);
        mVal.setVisibility(View.GONE);
        Ver.setVisibility(View.GONE);
        noVer.setVisibility(View.GONE);
        valoranos.setVisibility(View.GONE);
        mTRU = (Button) findViewById(R.id.TRU);
        mFAL = (Button) findViewById(R.id.FAL);
        preg = (TextView) findViewById(R.id.PREG);
        punts = (TextView) findViewById(R.id.PTS);
        numPreg = (TextView) findViewById(R.id.numPreg);
        numPreg.setText("Pregunta numero "+(contador+1));

        if (savedInstanceState != null){

            contador = savedInstanceState.getInt("Contador");
            puntos = savedInstanceState.getDouble("PTS");
            if (contador == 3){
                punts.setText(String.valueOf(puntos));
                endGame();
            }else {
                preg.setText(preguntas[contador]);
                punts.setText(String.valueOf(puntos));
                numPreg.setText("Pregunta numero " + (contador + 1));
            }

        }else {
            contador = 0;
            puntos = 0;
        }



        Pista.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mTRU.setVisibility(View.GONE);
                mFAL.setVisibility(View.GONE);
                Ver.setVisibility(View.VISIBLE);
                noVer.setVisibility(View.VISIBLE);

            }
        });

        Ver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                mTRU.setVisibility(View.VISIBLE);
                mFAL.setVisibility(View.VISIBLE);
                Ver.setVisibility(View.GONE);
                noVer.setVisibility(View.GONE);
                Intent myIntent = new Intent(MainActivity.this, Main3Activity.class);
                myIntent.putExtra("myText", contador);
                startActivityForResult(myIntent, 1);
                onActivityResult(getIntent().getIntExtra("resultado",RESULT_OK));

            }
        });

        noVer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                mTRU.setVisibility(View.VISIBLE);
                mFAL.setVisibility(View.VISIBLE);
                Ver.setVisibility(View.GONE);
                noVer.setVisibility(View.GONE);

            }
        });


        mTRU.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (respuestas[contador] == true) {
                    correcto();

                } else {
                    incorrecto();
                }
            }
        });

        mFAL.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (respuestas[contador] == false) {
                    correcto();
                } else {
                    incorrecto();
                }
            }
        });

        mVal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(myIntent);
            }
        });
    }

    public void endGame() {

        mTRU.setVisibility(View.GONE);
        mFAL.setVisibility(View.GONE);
        preg.setVisibility(View.GONE);
        mVal.setVisibility(View.VISIBLE);
        preg.setTextSize(50);
        punts.setTextSize(50);
        Pista.setVisibility(View.GONE);
        valoranos.setVisibility(View.VISIBLE);
        numPreg.setVisibility(View.GONE);

    }

    public void correcto() {

        Toast.makeText(MainActivity.this, R.string.cMensaje, Toast.LENGTH_SHORT).show();
        puntos = puntos + 1;
        punts.setText(String.valueOf(puntos));
        if (contador < respuestas.length - 1) {
            contador = contador + 1;
            preg.setText(preguntas[contador]);
            numPreg.setText("Pregunta numero "+(contador+1));
        } else {
            endGame();
            contador = contador +1;
        }

    }

    public void incorrecto() {

        Toast.makeText(MainActivity.this, R.string.iMensaje, Toast.LENGTH_SHORT).show();
        puntos = puntos - 1;
        punts.setText(String.valueOf(puntos));

    }

    public void onActivityResult(int resultCode) {

            if (resultCode == RESULT_OK) {
                puntos = puntos-0.5;

            }
    }

    @Override
    public void onSaveInstanceState (Bundle outState){
        super.onSaveInstanceState(outState);

        outState.putInt("Contador", contador);
        outState.putDouble("PTS", puntos);

    }
}


