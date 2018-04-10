package com.example.sutrisno.praktikumppb.Modul3;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sutrisno.praktikumppb.R;
import com.example.sutrisno.praktikumppb.modul2.Modul2_isiActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Modul3_Activity extends AppCompatActivity {

    //inisialisasi widget
    private EditText edit_nama, edit_nim,edit_kota,edit_tgl,edit_hobi;
    private AutoCompleteTextView auto_kota; //autocomplate
    private Spinner spinner_jur;
    private Button btn_submit, btn_tanggal;

    //array
    String [] jur_array = {"Teknik Informatika", "Teknik Industri","Teknik Elektro","Sistem Informasi"};
    String nama, nim, jur, kota, tglLahir, hobi;

    //array utk autocomplatetextView
    String [] ArrayKota = {"Bojonegoro","Bandung","Bogor","Bangkalan",
            "Semarang","Surabaya", "Sabang", "Sidoarjo"};

    //kalender
    SimpleDateFormat dateFormat;

    //function kalender

    public void showDateDialog(){
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(Modul3_Activity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance ();
                newDate.set ( year, month, dayOfMonth );

                edit_tgl.setText ( dateFormat.format ( newDate.getTime () ) );
            }
        }, calendar.get ( Calendar.YEAR ), calendar.get ( Calendar.MONTH ), calendar.get ( Calendar.DAY_OF_MONTH ));
        datePickerDialog.show ();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul3_);

        //find
        edit_nama = (EditText) findViewById(R.id.editText_nama);
        edit_nim = (EditText) findViewById(R.id.editText_nim);
        spinner_jur = (Spinner) findViewById(R.id.spiner_jur);
        auto_kota = (AutoCompleteTextView) findViewById(R.id.auto_kota);
        edit_hobi = (EditText) findViewById(R.id.editText_hobi);
        edit_tgl = (EditText) findViewById(R.id.editText_tanggal);
        btn_submit = (Button) findViewById(R.id.btn_submit);

        //kalender
        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        edit_tgl = (EditText) findViewById(R.id.editText_tanggal);
        btn_tanggal = (Button) findViewById(R.id.btn_tanggal);

        //arrayAdapter jurusan
        ArrayAdapter adapter = new ArrayAdapter(Modul3_Activity.this,android.R.layout.simple_list_item_1, jur_array);
        spinner_jur.setAdapter(adapter);


        //mmbuat arrayAdapter kota
        ArrayAdapter<String> adapterKota =
                new ArrayAdapter<String>(Modul3_Activity.this,
                        android.R.layout.select_dialog_item,ArrayKota);

        //mendapat instansi dari autocomplatetextview kota
        AutoCompleteTextView AutoComplate = (AutoCompleteTextView) findViewById(R.id.auto_kota);
        AutoComplate.setThreshold(1); //akan bekerja saat karakter pertama
        AutoComplate.setAdapter(adapterKota); //mensetting data adapter ke dlm autocomplatetextview
        AutoComplate.setTextColor(Color.BLUE);

        //ketika button submit diklik
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama = edit_nama.getText().toString();
                nim = edit_nim.getText().toString();
                jur = spinner_jur.getSelectedItem().toString();
                kota = auto_kota.getText().toString();
                tglLahir = edit_tgl.getText().toString();
                hobi = edit_hobi.getText().toString();

                Intent intent = new Intent(Modul3_Activity.this,Modul3_isiActivity.class);

                //tampung ke dlm intent
                intent.putExtra("nama_key", nama);
                intent.putExtra("nim_key", nim);
                intent.putExtra("jur_key", jur);
                intent.putExtra("kota_key", kota);
                intent.putExtra("tgllahir_key", tglLahir);
                intent.putExtra("hobi_key", hobi);
                startActivity(intent);

            }
        });


        //kalender
        dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        edit_tgl = (EditText) findViewById(R.id.editText_tanggal);
        btn_tanggal = (Button) findViewById(R.id.btn_tanggal);

        btn_tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog();
            }
        });
    }
}
