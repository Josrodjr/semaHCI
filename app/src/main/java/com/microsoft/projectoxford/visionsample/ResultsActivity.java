package com.microsoft.projectoxford.visionsample;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView txtPrueba;
    Button btn;
    String test;
    Float operation;

    //los otros botones
    Button btnEnergy;
    Button btnGrasas;
    Button btnAzucar;
    Button btnSal;

    //Textviews de todos excepto grasas saturadas
    TextView txtEnergy;
    TextView txtGrasas;
    TextView txtAzucar;
    TextView txtSal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //mapeo de botones y textview de grasas saturadas
        txtPrueba = (TextView)findViewById(R.id.textViewPrueba);
        btn=(Button)findViewById(R.id.button2);
        btnEnergy =(Button)findViewById(R.id.btnEnergia);
        btnGrasas = (Button)findViewById(R.id.btnGrasas);
        btnAzucar = (Button)findViewById(R.id.btnAzucar);
        btnSal = (Button)findViewById(R.id.btnSal);

        //mapeo de textviews
        txtEnergy = (TextView)findViewById(R.id.txtEnergia);
        txtGrasas = (TextView)findViewById(R.id.txtGrasas);
        txtAzucar = (TextView)findViewById(R.id.txtAzucar);
        txtSal = (TextView)findViewById(R.id.txtSal);


        btnEnergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtEnergy.setText("BITCONNEEEEEECT");
            }
        });

        btnGrasas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtGrasas.setText("Funciona");

            }
        });

        btnAzucar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAzucar.setText("YEAH BOIIII");
            }
        });

        btnSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSal.setText("Dota");
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test = InputActivity.MyBundle.getString("3");
                operation = Float.parseFloat(test);
                operation = operation*0.5f;
                test = String.valueOf(operation);
                txtPrueba.setText(test);
            }
        });



            }


}
