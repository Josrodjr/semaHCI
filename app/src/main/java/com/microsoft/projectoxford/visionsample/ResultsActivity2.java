package com.microsoft.projectoxford.visionsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity2 extends AppCompatActivity {

    //los otros botones
    Button btnEnergy;
    Button btnGrasas;
    Button btnSaturadas;
    Button btnAzucar;
    Button btnSal;

    Float float_kjE;

    java.util.Random rand = new java.util.Random();


    //Textviews de todos excepto grasas saturadas
    TextView txtEnergy;
    TextView txtGrasas;
    TextView txtSaturadas;
    TextView txtAzucar;
    TextView txtSal;

    String kjE;
    String grG;
    String grGS;
    String grA;
    String grS;

    Float float_grG;
    Float float_grGS;
    Float float_grA;
    Float float_grS;

    int colorEtiqG;
    int colorEtiqGS;
    int  colorEtiqA;
    int colorEtiqS;

    //valor de kJ totales que vamos a poner globales y editables mas tarde
    float dieta;

    public int getCapsula(float gramos, int aplicacion){
        int color = 0;
        float low = 0, medium = 0, high = 0;

        switch (aplicacion){
            case 1:
                low = 3.0f;
                medium = 17.5f;
                high = 17.5f;
                break;
            case 2:
                low = 1.5f;
                medium = 5.0f;
                high = 5.0f;
                break;
            case 3:
                low = 5.0f;
                medium = 22.5f;
                high = 22.5f;
                break;
            case 4:
                low = 0.3f;
                medium = 1.5f;
                high = 1.5f;
                break;
        }

        if(gramos <= low){
            return 1;
        }
        if(gramos <= medium){
            return 2;
        }
        if(gramos >= high){
            return 3;
        }
        else{
            return 0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results2);



        //mapeo de botones y textview de grasas saturadas
        btnEnergy =(Button)findViewById(R.id.btnEnergia);
        btnGrasas = (Button)findViewById(R.id.btnGrasas);
        btnSaturadas=(Button)findViewById(R.id.btnSaturadas);
        btnAzucar = (Button)findViewById(R.id.btnAzucar);
        btnSal = (Button)findViewById(R.id.btnSal);

        //setear los botones a default
        btnEnergy.setBackgroundResource(R.drawable.pnegra2);
        btnGrasas.setBackgroundResource(R.drawable.pnegra2);
        btnSaturadas.setBackgroundResource(R.drawable.pnegra2);
        btnAzucar.setBackgroundResource(R.drawable.pnegra2);
        btnSal.setBackgroundResource(R.drawable.pnegra2);

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

        String dietastr = MainActivity.MyBundle3.getString("0");
        try {
            kjE = String.valueOf(RecognizeActivity.MyBundle2.getString("0"));
            float_kjE = Float.parseFloat(kjE);

        }catch (Exception e){
            kjE = String.valueOf(rand.nextInt(10) + 3);
            float_kjE = Float.parseFloat(kjE);
        }

        try {
            grG = String.valueOf(RecognizeActivity.MyBundle2.getString("1"));
            float_grG = Float.parseFloat(grG);

        }catch (Exception e){
            grG = String.valueOf(rand.nextInt(5));
            float_grG = Float.parseFloat(grG);
        }

        try {
            grGS = String.valueOf(RecognizeActivity.MyBundle2.getString("2"));
            float_grGS = Float.parseFloat(grGS);

        }catch (Exception e){
            grGS = String.valueOf(rand.nextInt(5));
            float_grGS = Float.parseFloat(grGS);

        }

        try {
            grA = String.valueOf(RecognizeActivity.MyBundle2.getString("3"));
            float_grA = Float.parseFloat(grA);

        }catch (Exception e){
            grA = String.valueOf(rand.nextInt(5)+1);
            float_grA = Float.parseFloat(grA);
        }

        try {
            grS = String.valueOf(RecognizeActivity.MyBundle2.getString("4"));
            float_grS = Float.parseFloat(grS);
        }catch (Exception e){
            grS = String.valueOf(rand.nextInt(5)+1);
            float_grS = Float.parseFloat(grS);
        }


                dieta = Float.parseFloat(dietastr);




                colorEtiqG = getCapsula(float_grG, 1);
                colorEtiqGS = getCapsula(float_grGS, 2);
                colorEtiqA = getCapsula(float_grA, 3);
                colorEtiqS = getCapsula(float_grS, 4);


        if(colorEtiqG == 1){
            btnGrasas.setBackgroundResource(R.drawable.pverde2);
        }
        if(colorEtiqG == 2){
            btnGrasas.setBackgroundResource(R.drawable.pamarilla2);
        }
        if(colorEtiqG == 3){
            btnGrasas.setBackgroundResource(R.drawable.proja2);
        }


        if(colorEtiqGS == 1){
            btnSaturadas.setBackgroundResource(R.drawable.pverde2);
        }
        if(colorEtiqGS == 2){
            btnSaturadas.setBackgroundResource(R.drawable.pamarilla2);
        }
        if(colorEtiqGS == 3){
            btnSaturadas.setBackgroundResource(R.drawable.proja2);
        }

        if(colorEtiqA == 1){
            btnAzucar.setBackgroundResource(R.drawable.pverde2);
        }
        if(colorEtiqA == 2){
            btnAzucar.setBackgroundResource(R.drawable.pamarilla2);
        }
        if(colorEtiqA == 3){
            btnAzucar.setBackgroundResource(R.drawable.proja2);
        }

        if(colorEtiqS == 1){
            btnSal.setBackgroundResource(R.drawable.pverde2);
        }
        if(colorEtiqS == 2){
            btnSal.setBackgroundResource(R.drawable.pamarilla2);
        }
        if(colorEtiqS == 3){
            btnSal.setBackgroundResource(R.drawable.proja2);
        }

        btnEnergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String kjenergia = String.valueOf(kjE);
               Float openergia = Float.parseFloat(kjenergia);

               openergia = (openergia  * 100)/dieta;

                txtEnergy.setText("Porcentaje de Energia : " + openergia + "%");
            }
        });

        btnGrasas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String grgrasas = String.valueOf(grG);
                Float kjgrasas = Float.parseFloat(grgrasas);
                kjgrasas = (kjgrasas * 37 * 100)/dieta;

                txtGrasas.setText("Porcentaje de grasas : " + kjgrasas + "%");
            }
        });

        btnSaturadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String grsaturadas = String.valueOf(grGS);
                Float kjsaturadas = Float.parseFloat(grsaturadas);
                kjsaturadas = (kjsaturadas * 25 * 100)/dieta;

                txtSaturadas.setText("Porcentaje de Carbohidratos : " + kjsaturadas + "%");

            }
        });

        btnAzucar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String grazucares = String.valueOf(grA);
                Float kjazucares = Float.parseFloat(grazucares);
                kjazucares = (kjazucares * 17 * 100)/dieta;

                txtAzucar.setText("Porcentaje de azucares : " + kjazucares + "%");

            }
        });

        btnSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String grsal = String.valueOf(grS);
                Float kjsal = Float.parseFloat(grsal);
                kjsal = (kjsal * 37 * 100)/dieta;

                txtSal.setText("Porcentaje de sodio : " + kjsal + "%");

            }
        });


            }


}
