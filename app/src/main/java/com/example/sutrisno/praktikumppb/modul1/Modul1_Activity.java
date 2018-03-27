package com.example.sutrisno.praktikumppb.modul1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.sutrisno.praktikumppb.R;

public class Modul1_Activity extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul1_);
        button = (Button) findViewById(R.id.btn_pdmodul1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Modul1_Activity.this,IsiModul1_Activity.class);
                Toast.makeText(Modul1_Activity.this, "Hallo Nama Saya SUTRISNO (140411100060)", Toast.LENGTH_SHORT).show();

                startActivity(intent);
            }
        });
    }
}
