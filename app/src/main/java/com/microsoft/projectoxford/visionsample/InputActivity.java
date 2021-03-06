package com.microsoft.projectoxford.visionsample;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InputActivity extends ActionBarActivity {

    float energy, fat, saturates, sugars,salt;

    EditText EnergyInput;
    EditText FatInput;
    EditText SaturatedInput;
    EditText SugarInput;
    EditText SaltInput;

    //Volver visible nuevamente el EditText y Boton de MainActivity encargado de Ingreso calorias
    EditText txtIngest;
    Button btnIngest;


    Button ResultsButton;

    //Los spinners

    Spinner spinnerE;
    Spinner spinnerG;
    Spinner spinnerGR;
    Spinner spinnerA;
    Spinner spinnerS;


    public static Bundle MyBundle = new Bundle();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        EnergyInput = (EditText)findViewById(R.id.EnergyInput);
        FatInput = (EditText)findViewById(R.id.FatInput);
        SaturatedInput = (EditText)findViewById(R.id.SaturatedInput);
        SugarInput = (EditText)findViewById(R.id.SugarInput);
        SaltInput =(EditText)findViewById(R.id.SaltInput);

       InputActivity.MyBundle.putString("90","1");

        spinnerE = (Spinner)findViewById(R.id.spinnerE);
        spinnerG = (Spinner)findViewById(R.id.spinnerG);
        spinnerGR = (Spinner)findViewById(R.id.spinnerGR);
        spinnerA = (Spinner)findViewById(R.id.spinnerA);
        spinnerS = (Spinner)findViewById(R.id.spinnerS);

        String[] itemsEnergy = new String[]{"kJ", "J"};

        String[] itemsgr = new String[]{"g", "dg", "cg", "mg"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsEnergy);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsgr);

        spinnerE.setAdapter(adapter);
        spinnerG.setAdapter(adapter2);
        spinnerGR.setAdapter(adapter2);
        spinnerA.setAdapter(adapter2);
        spinnerS.setAdapter(adapter2);

        //prueba a ver si jala el id del boton en ResultsActivity


        ResultsButton = (Button)findViewById(R.id.button);
        ResultsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    energy = Float.parseFloat(EnergyInput.getText().toString());
                    fat = Float.parseFloat(FatInput.getText().toString());
                    saturates = Float.parseFloat(SaturatedInput.getText().toString());
                    sugars = Float.parseFloat(SugarInput.getText().toString());
                    salt = Float.parseFloat(SaltInput.getText().toString());



                    InputActivity.MyBundle.putString("1",String.valueOf(energy));
                    InputActivity.MyBundle.putString("2",String.valueOf(fat));
                    InputActivity.MyBundle.putString("3",String.valueOf(saturates));
                    InputActivity.MyBundle.putString("4",String.valueOf(sugars));
                    InputActivity.MyBundle.putString("5",String.valueOf(salt));

                    openResulstsActivity();

                   // showToast(String.valueOf(energy));
                   // showToast(String.valueOf(fat));
                   // showToast(String.valueOf(saturates));
                   // showToast(String.valueOf(sugars));
                   // showToast(String.valueOf(salt));

                }catch (Exception e){

                    showToast("Hay campos en blanco");

                    return;

                }
            }
        });

    }

    public void openResulstsActivity() {

        Intent intent =new Intent(this,ResultsActivity.class);
        startActivity(intent);

    }

    private void showToast(String text){

        Toast.makeText(InputActivity.this,text,Toast.LENGTH_SHORT).show();

    }
}
