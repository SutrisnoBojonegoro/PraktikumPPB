package com.example.sutrisno.praktikumppb.modul2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sutrisno.praktikumppb.R;

public class Modul2_Activity extends AppCompatActivity {

    int change = 1;
    float font = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul2_);

        final TextView t = (TextView) findViewById(R.id.textView);

        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        Button btn4 = (Button) findViewById(R.id.button4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setTextSize(font);
                font = font + 5;
                if(font == 50){
                    font = 30;
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (change){
                    case 1 :
                        t.setTextColor(Color.RED);
                        break;

                    case 2 :
                        t.setTextColor(Color.GREEN);
                        break;

                    case 3 :
                        t.setTextColor(Color.BLUE);
                        break;

                    case 4 :
                        t.setTextColor(Color.CYAN);
                        break;
                    case 5 :
                        t.setTextColor(Color.MAGENTA);
                        break;
                }
                change++;
                if(change==6){
                    change=1;
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (change){
                    case 1 :
                        t.setText("Senin");
                        break;

                    case 2 :
                        t.setText("Selasa");;
                        break;

                    case 3 :
                        t.setText("Rabu");
                        break;

                    case 4 :
                        t.setText("Kamis");
                        break;
                    case 5 :
                        t.setText("Jumat");
                        break;
                    case 6 :
                        t.setText("Sabtu");
                        break;
                    case 7 :
                        t.setText("Minggu");
                        break;
                }
                change++;
                if(change==8){
                    change=1;
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Modul2_Activity.this,Modul2_isiActivity.class);
                startActivity(intent);
            }
        });
    }
}
