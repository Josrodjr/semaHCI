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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        txtPrueba = (TextView)findViewById(R.id.textViewPrueba);
        btn=(Button)findViewById(R.id.button2);

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
