package com.example.bmicalculator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText weight, height;
    private TextView resultText;
    private Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        weight=findViewById(R.id.Weight);
        height = findViewById(R.id.Height);
        resultText = findViewById(R.id.Result);
        calculate=findViewById(R.id.button);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcualteBmi();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

   public void calcualteBmi(){
        String heightString = height.getText().toString();
        String weightString = weight.getText().toString();

        if(!heightString.isEmpty() && !weightString.isEmpty()){
            float heightValue= Float.parseFloat(heightString)/100;
            float weightValue = Float.parseFloat(weightString);

            float bmi = weightValue/(heightValue*heightValue);

            displayBmi(bmi);
        }
   }

   private void displayBmi(float value){
        String bmiLabel= "";

        if(Float.compare(value, 15f)<=0)
            bmiLabel=getString(R.string.starved);
        else if(Float.compare(value, 15f)>0&&  Float.compare(value, 16f) <= 0)
            bmiLabel=getString(R.string.emaciation);
        else if(Float.compare(value, 16f)>0&&  Float.compare(value, 18.5f) <= 0)
            bmiLabel=getString(R.string.underweight);
        else if(Float.compare(value, 18.5f)>0&&  Float.compare(value, 25f) <= 0)
            bmiLabel=getString(R.string.optimal);
        else if(Float.compare(value, 25f)>0&&  Float.compare(value, 30f) <= 0)
            bmiLabel=getString(R.string.overweight);
        else if(Float.compare(value, 30f)>0&&  Float.compare(value, 35f) <= 0)
            bmiLabel=getString(R.string.obesity_level_I);
        else if(Float.compare(value, 35f)>0&&  Float.compare(value, 40f) <= 0)
            bmiLabel=getString(R.string.obesity_level_II);
        else if(Float.compare(value, 40f)>0)
            bmiLabel=getString(R.string.obesity_level_III);

        bmiLabel=value+"\n\n"+bmiLabel;
        resultText.setText(bmiLabel);
   }
}
