package com.deltaCode.omnicron.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Kinematics extends ActionBarActivity {
    EditText KinematicAcceleration;
    EditText KinematicVelocityI;
    EditText KinematicVelocityF;
    EditText KinematicTime;
    EditText KinematicDistance;
    public final double g = 9.8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KinematicAcceleration = (EditText) findViewById(R.id.KinematicAcceleration);
        KinematicVelocityI = (EditText) findViewById(R.id.KinematicVelocityI);
        KinematicVelocityF = (EditText) findViewById(R.id.KinematicVelocityF);
        KinematicTime = (EditText) findViewById(R.id.KinematicTime);
        KinematicDistance = (EditText) findViewById(R.id.KinematicDistance);
        setContentView(R.layout.activity_kinematics);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kinematics, menu);
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

    public void clear(View view) {
        KinematicDistance.setText("");
        KinematicAcceleration.setText("");
        KinematicTime.setText("");
        KinematicVelocityI.setText("");
        KinematicVelocityF.setText("");
    }

    public void calculate(View view) {
        boolean Distance = !(KinematicDistance.getText().toString().isEmpty());
        boolean Acceleration = !(KinematicAcceleration.getText().toString().isEmpty());
        boolean Time = !(KinematicTime.getText().toString().isEmpty());
        boolean VelocityI = !(KinematicVelocityI.getText().toString().isEmpty());
        boolean VelocityF = !(KinematicVelocityF.getText().toString().isEmpty());
        fillEmpty();
        double d = Double.parseDouble(KinematicDistance.getText().toString());
        double a = Double.parseDouble(KinematicAcceleration.getText().toString());
        double t = Double.parseDouble(KinematicTime.getText().toString());
        double vi = Double.parseDouble(KinematicVelocityI.getText().toString());
        double vf = Double.parseDouble(KinematicVelocityF.getText().toString());
        boolean cont = true;
        while (cont) {
            cont = false;
            if (!Distance) {
                if (VelocityF && VelocityI && Time) {
                    d = (vf + vi) * t / 2;
                    Distance = true;
                    cont = true;
                }
                if (VelocityF && VelocityI && Acceleration) {
                    d = (vf * vf - vi * vi) / (a * 2);
                    Distance = true;
                    cont = true;
                }
            }
            if (!Acceleration) {
                if (VelocityF && VelocityI && Time) {
                    a = (vf - vi) / t;
                    Acceleration = true;
                    cont = true;
                }
                if (VelocityF && VelocityI && Distance) {
                    a = (vf * vf - vi * vi) / (2 * d);
                    Acceleration = true;
                    cont = true;
                }
                if (Distance && VelocityI && Time) {
                    a = ((d - (vi * t)) / (t * t)) * 2;
                }
            }
            if (!Time) {
                if (VelocityF && VelocityI && Acceleration) {
                    t = (vf - vi) / a;
                    Time = true;
                    cont = true;
                }
                if (Distance && VelocityI && Acceleration) {
                    t = (-vi + Math.sqrt(vi * vi + 2 * g * d)) / g;
                }
            }
            if (!VelocityI) {
                if (VelocityF && Acceleration && Time) {
                    vi = (vf - (a * t));
                    VelocityI = true;
                    cont = true;
                }
                if (VelocityF && Distance && Acceleration) {
                    vi = (vf * vf)+2*a*d;
                    Distance = true;
                    cont = true;
                }

            }
            if (!VelocityF) {
                if (VelocityI && Acceleration && Time) {
                    vi = (vf + (a * t));
                    VelocityF = true;
                    cont = true;
                }
                if (VelocityI && Distance && Acceleration) {
                    vf = (vi * vi)+2*a*d;
                    Distance = true;
                    cont = true;
                }
            }
        }
        if (!(VelocityF && VelocityI && Time && Distance && Acceleration)) {
            KinematicDistance.setText("ERROR");
            KinematicAcceleration.setText("ERROR");
            KinematicTime.setText("ERROR");
            KinematicVelocityI.setText("ERROR");
            KinematicVelocityF.setText("ERROR");
        }

        else{
            KinematicDistance.setText(Double.toString(round(d)) + " m");
            KinematicAcceleration.setText(Double.toString(round(a)) + " m/s^2");
            KinematicTime.setText(Double.toString(round(t)) + " s");
            KinematicVelocityF.setText(Double.toString(round(vf)) + " m/s");
            KinematicVelocityI.setText(Double.toString(round(vi)) + " m/s");
        }
    }


    public void fillEmpty() {
        if (KinematicDistance.getText().toString().isEmpty())
            KinematicDistance.setText(new Double(0).toString());
        if (KinematicTime.getText().toString().isEmpty())
            KinematicTime.setText(new Double(0).toString());
        if (KinematicVelocityI.getText().toString().isEmpty())
            KinematicVelocityI.setText(new Double(0).toString());
        if (KinematicVelocityF.getText().toString().isEmpty())
            KinematicVelocityF.setText(new Double(0).toString());
        if (KinematicAcceleration.getText().toString().isEmpty())
            KinematicAcceleration.setText(new Double(0).toString());
    }
    public double round(double a) {
        return Math.floor(a * 1000) / 1000;
    }
}
