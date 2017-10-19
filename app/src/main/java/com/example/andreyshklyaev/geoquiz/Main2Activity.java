package com.example.andreyshklyaev.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends MainActivity {

    private RatingBar RatingBar;
    private Button mEnviar;
    private TextView mGrax;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RatingBar = (RatingBar) findViewById(R.id.ratingBar);
        mEnviar = (Button) findViewById(R.id.send);
        mGrax = (TextView) findViewById(R.id.grax);

        mGrax.setVisibility(View.GONE);

        mEnviar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {

                Toast.makeText(Main2Activity.this, String.valueOf(RatingBar.getRating()), Toast.LENGTH_SHORT).show();

                RatingBar.setVisibility(View.GONE);
                mEnviar.setVisibility(View.GONE);
                mGrax.setTextSize(20);
                mGrax.setVisibility(View.VISIBLE);

            }
        });

    }
}
