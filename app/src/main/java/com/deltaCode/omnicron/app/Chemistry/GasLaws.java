package com.deltaCode.omnicron.app.Chemistry;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import com.deltaCode.omnicron.app.R;

public class GasLaws extends AppCompatActivity {
    EditText pressuretext;
    EditText volumetext;
    EditText molestext; 
    EditText temperaturetext;
    private final double r = 0.08206;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gas_laws);
        pressuretext = (EditText) findViewById(R.id.pressuretext);
        volumetext = (EditText) findViewById(R.id.volumetext);
        molestext = (EditText) findViewById(R.id.molestext);
        temperaturetext = (EditText) findViewById(R.id.temperaturetext);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gas_laws, menu);
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

    public void clear(View view)
    {
        pressuretext.setText("");
        volumetext.setText("");
        molestext.setText("");
        temperaturetext.setText("");
    }

    public void calculate (View view)
    {
        boolean Pressure = !(pressuretext.getText().toString().isEmpty());
        boolean Volume = !(volumetext.getText().toString().isEmpty());
        boolean Moles = !(molestext.getText().toString().isEmpty());
        boolean Temperature = !(temperaturetext.getText().toString().isEmpty());
        fillEmpty();
        double p = Double.parseDouble(pressuretext.getText().toString());
        double v = Double.parseDouble(volumetext.getText().toString());
        double n = Double.parseDouble(molestext.getText().toString());
        double t = Double.parseDouble(temperaturetext.getText().toString());

        boolean cont = true;
                    if(!Pressure) {
                if(Volume && Moles && Temperature) {
                    Pressure = true;

                    p = (n * r * t) / v;
                }
            }
            if(!Volume) {
                if(Pressure && Moles && Temperature) {
                    Volume = true;
                    v = (n * r * t) / p;
                }
            }
            if(!Moles) {
                if(Pressure && Volume && Temperature) {

                    n = (p * v) / (r * t);
                }
            }
            if(!Temperature) {
                if(Pressure && Volume && Moles) {

                    t = (p * v)/(n * r);
                }
            }

            pressuretext.setText(Double.toString(round(p)) + " atm");
            volumetext.setText(Double.toString(round(v)) + " L");
            molestext.setText(Double.toString(round(n)) + "");
            temperaturetext.setText(Double.toString(round(t)) + " K");
            if (!(Pressure && Volume && Moles && Temperature)) {
                pressuretext.setText("ERROR");
                volumetext.setText("ERROR");
                molestext.setText("ERROR");
                temperaturetext.setText("ERROR");
            }
        }


    public void fillEmpty() {
        if (pressuretext.getText().toString().isEmpty())
            pressuretext.setText(Double.toString(0));
        if (volumetext.getText().toString().isEmpty())
            volumetext.setText(Double.toString(0));
        if (molestext.getText().toString().isEmpty())
            molestext.setText(Double.toString(0));
        if (temperaturetext.getText().toString().isEmpty())
            temperaturetext.setText(Double.toString(0));
    }
    public double round(double a) {
        return Math.floor(a * 1000) / 1000;
    }
}
