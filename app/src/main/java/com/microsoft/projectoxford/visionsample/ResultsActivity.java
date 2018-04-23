package com.microsoft.projectoxford.visionsample;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    //los otros botones
    Button btnEnergy;
    Button btnGrasas;
    Button btnSaturadas;
    Button btnAzucar;
    Button btnSal;


    //Textviews de todos excepto grasas saturadas
    TextView txtEnergy;
    TextView txtGrasas;
    TextView txtSaturadas;
    TextView txtAzucar;
    TextView txtSal;

    //valor de kJ totales que vamos a poner globales y editables mas tarde
    float dieta = 8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);



        //mapeo de botones y textview de grasas saturadas
        btnEnergy =(Button)findViewById(R.id.btnEnergia);
        btnGrasas = (Button)findViewById(R.id.btnGrasas);
        btnSaturadas=(Button)findViewById(R.id.btnSaturadas);
        btnAzucar = (Button)findViewById(R.id.btnAzucar);
        btnSal = (Button)findViewById(R.id.btnSal);

        btnSaturadas.setBackgroundResource(R.drawable.doge);

        //mapeo de textviews
        txtEnergy = (TextView)findViewById(R.id.txtEnergia);
        txtGrasas = (TextView)findViewById(R.id.txtGrasas);
        txtSaturadas = (TextView)findViewById(R.id.txtSaturadas);
        txtAzucar = (TextView)findViewById(R.id.txtAzucar);
        txtSal = (TextView)findViewById(R.id.txtSal);

/*
        String kjenergia = InputActivity.MyBundle.getString("1");
        Float openergia = Float.parseFloat(kjenergia);

        openergia = (openergia  * 100)/dieta;

        txtEnergy.setText("El porcentaje de Energia de producto es: " + openergia);
*/

        btnEnergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String kjenergia = InputActivity.MyBundle.getString("1");
               Float openergia = Float.parseFloat(kjenergia);

               openergia = (openergia  * 100)/dieta;

               txtEnergy.setText("El porcentaje de Energia de producto es: " + openergia);
            }
        });

        btnGrasas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String grgrasas = InputActivity.MyBundle.getString("2");
                Float kjgrasas = Float.parseFloat(grgrasas);
                kjgrasas = (kjgrasas * 37 * 100)/dieta;

                txtGrasas.setText("El porcentaje de grasas de este producto es: " + kjgrasas);
            }
        });

        btnSaturadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String grsaturadas = InputActivity.MyBundle.getString("3");
                Float kjsaturadas = Float.parseFloat(grsaturadas);
                kjsaturadas = (kjsaturadas * 25 * 100)/dieta;

                txtSaturadas.setText("El porcentaje de grasas saturadas de este producto es: " + kjsaturadas);

            }
        });

        btnAzucar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String grazucares = InputActivity.MyBundle.getString("4");
                Float kjazucares = Float.parseFloat(grazucares);
                kjazucares = (kjazucares * 17 * 100)/dieta;

                txtAzucar.setText("El porcentaje de azucares de este producto es: " + kjazucares);

            }
        });

        btnSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String grsal = InputActivity.MyBundle.getString("5");
                Float kjsal = Float.parseFloat(grsal);
                kjsal = (kjsal * 37 * 100)/dieta;

                txtSal.setText("El porcentaje de sodio de este producto es: " + kjsal);

            }
        });


            }


}
