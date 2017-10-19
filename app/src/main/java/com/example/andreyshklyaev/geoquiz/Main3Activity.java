package com.example.andreyshklyaev.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    ImageView mImageView;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mImageView = (ImageView) findViewById(R.id.imageView);
        contador = (getIntent().getIntExtra("myText",0));

        switch (contador){
            case 0:
                mImageView.setImageResource(R.drawable.p1);
                break;
            case 1:
                mImageView.setImageResource(R.drawable.p2);
                break;
            case 2:
                mImageView.setImageResource(R.drawable.p3);
                break;
        }
        Intent returnIntent = new Intent();
        returnIntent.putExtra("resultado",RESULT_OK);

    }
}
