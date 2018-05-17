//
// Copyright (c) Microsoft. All rights reserved.
// Licensed under the MIT license.
//
// Microsoft Cognitive Services (formerly Project Oxford): https://www.microsoft.com/cognitive-services
//
// Microsoft Cognitive Services (formerly Project Oxford) GitHub:
// https://github.com/Microsoft/Cognitive-Vision-Android
//
// Copyright (c) Microsoft Corporation
// All rights reserved.
//
// MIT License:
// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation files (the
// "Software"), to deal in the Software without restriction, including
// without limitation the rights to use, copy, modify, merge, publish,
// distribute, sublicense, and/or sell copies of the Software, and to
// permit persons to whom the Software is furnished to do so, subject to
// the following conditions:
//
// The above copyright notice and this permission notice shall be
// included in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED ""AS IS"", WITHOUT WARRANTY OF ANY KIND,
// EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
// MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
// NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
// LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
// OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
// WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
//
package com.microsoft.projectoxford.visionsample;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Console;

public class MainActivity extends ActionBarActivity {

    public static Bundle MyBundle3 = new Bundle();

    Button btn;
    Button btn2;
    Button btnIngesta;

    AutoCompleteTextView txtIngesta;

    String Ingesta;

    Float Peace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button)findViewById(R.id.button_input);
        btn2 = (Button)findViewById(R.id.button_recognize);

        btnIngesta = (Button)findViewById(R.id.btnIngesta);

        txtIngesta = (AutoCompleteTextView) findViewById(R.id.TxtIngesta);
        String[] diets = getResources().getStringArray(R.array.diets);

            btnIngesta.setEnabled(true);
            txtIngesta.setEnabled(true);
            btnIngesta.setVisibility(View.VISIBLE);
            txtIngesta.setVisibility(View.VISIBLE);


        btn.setEnabled(false);
        btn2.setEnabled(false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, diets);
        txtIngesta.setAdapter(adapter);

        btnIngesta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Peace = Float.valueOf(txtIngesta.getText().toString());
                    Ingesta = String.valueOf(Peace);
                    MainActivity.MyBundle3.putString("0",Ingesta);
                    txtIngesta.setText("");
                    Toast.makeText(MainActivity.this,"Datos tomados con éxito!",Toast.LENGTH_SHORT).show();


                    btn.setEnabled(true);
                    btn2.setEnabled(true);


                }catch (Exception e){
                    Toast.makeText(MainActivity.this,"Ingresa algo en el campo superior por favor",Toast.LENGTH_SHORT).show();
                }
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityInput();

            }
        });

        if (getString(R.string.subscription_key).startsWith("Please")) {
            new AlertDialog.Builder(this)
                    .setTitle(getString(R.string.add_subscription_key_tip_title))
                    .setMessage(getString(R.string.add_subscription_key_tip))
                    .setCancelable(false)
                    .show();
        }

    }


    @Override


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void activityAnalyze(View v) {
        Intent intent = new Intent(this, AnalyzeActivity.class);
        startActivity(intent);
    }

    public void activityAnalyzeInDomain(View v) {
        Intent intent = new Intent(this, AnalyzeInDomainActivity.class);
        startActivity(intent);
    }

    public void activityDescribe(View v) {
        Intent intent = new Intent(this, DescribeActivity.class);
        startActivity(intent);
    }

    public void activityHandwriting(View v)
    {
        Intent intent =new Intent(this, HandwritingRecognizeActivity.class);
        startActivity(intent);
    }

    public void activityRecognize(View v) {
        Intent intent = new Intent(this, RecognizeActivity.class);
        startActivity(intent);
    }

    public void activityThumbnail(View v) {
        Intent intent = new Intent(this, ThumbnailActivity.class);
        startActivity(intent);
    }

    public void activityInput() {
        Intent intent = new Intent(this, InputActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
