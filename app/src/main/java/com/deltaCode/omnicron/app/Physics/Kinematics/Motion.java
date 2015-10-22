package com.deltaCode.omnicron.app.Physics.Kinematics;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.deltaCode.omnicron.app.R;

public class Motion extends ActionBarActivity {
    EditText MotionAcceleration;
    EditText MotionVelocityI;
    EditText MotionTime;
    EditText MotionDistance;
    EditText MotionVelocityF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motion);
        MotionAcceleration = (EditText) findViewById(R.id.MotionAcceleration);
        MotionVelocityI = (EditText) findViewById(R.id.MotionVelocityI);
        MotionTime = (EditText) findViewById(R.id.MotionTime);
        MotionDistance = (EditText) findViewById(R.id.MotionDistance);
        MotionVelocityF = (EditText) findViewById(R.id.MotionVelocityF);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_motion, menu);
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
        MotionDistance.setText("");
        MotionVelocityI.setText("");
        MotionTime.setText("");
        MotionVelocityF.setText("");
        MotionAcceleration.setText("");
    }

    public void calculate(View view) {


        boolean Distance = !(MotionDistance.getText().toString().isEmpty());
        boolean Acceleration = !(MotionAcceleration.getText().toString().isEmpty());
        boolean Time = !(MotionTime.getText().toString().isEmpty());
        boolean VelocityF = !(MotionVelocityF.getText().toString().isEmpty());
        boolean VelocityI = !(MotionVelocityI.getText().toString().isEmpty());

        fillEmpty();
        double d = Double.parseDouble(MotionDistance.getText().toString());
        double a = Double.parseDouble(MotionAcceleration.getText().toString());
        double t = Double.parseDouble(MotionTime.getText().toString());
        double vi = Double.parseDouble(MotionVelocityI.getText().toString());
        double vf = Double.parseDouble(MotionVelocityF.getText().toString());
        boolean cont = true;
        while (cont) {
            cont = false;
            if (!Distance) {
                if (VelocityI && Time && Acceleration) {
                    cont = true;
                    Distance = true;
                    d = vi * t + 0.5 * a * t * t;
                } else if (VelocityF && VelocityI && Time) {
                    cont = true;
                    Distance = true;
                    d = (vf + vi) / 2 * t;
                } else if (VelocityF && VelocityI && Acceleration) {
                    cont = true;
                    Distance = true;
                    d = (vf * vf - vi * vi) / (2 * a);
                }
            }
            if (!Acceleration) {
                if (VelocityF && VelocityI && Time) {
                    cont = true;
                    Acceleration = true;
                    a = (vf - vi) / t;
                } else if (VelocityF && VelocityI && Distance) {
                    cont = true;
                    Acceleration = true;
                    a = (vf * vf - vi * vi) / (2 * d);
                } else if (Time && Distance && VelocityI) {
                    cont = true;
                    Acceleration = true;
                    a = d - (vi * t) / (0.5 * t * t);
                }

            }
            if (!Time) {
                if (VelocityF && VelocityI && Acceleration) {
                    cont = true;
                    Time = true;
                    t = (vf - vi) / t;
                } else if (VelocityI && Distance && Acceleration) {
                    cont = true;
                    Time = true;
                    t = (-vi + Math.sqrt(vi * vi - (4) * (0.5 * a) * (-d))) / a;
                }
            }
            if (!VelocityF) {
                if (VelocityF && Acceleration && Time) {
                    cont = true;
                    VelocityF = true;
                    vf = vi + a * t;

                } else if (VelocityI && Distance && Acceleration) {
                    cont = true;
                    VelocityF = true;
                    vf = Math.sqrt(vi * vi + 2 * a * t);
                } else if (Distance && VelocityI && Time)
                    cont = true;
                VelocityF = true;
                vf = d / t * 2 - vi;
            }
            if (!VelocityI) {
                if (VelocityI && Acceleration && Time) {
                    cont = true;
                    VelocityI = true;
                    vi = vf - a * t;

                } else if (VelocityI && Distance && Acceleration) {
                    cont = true;
                    VelocityI = true;
                    vi = Math.sqrt(vf * vf - 2 * a * t);
                } else if (Distance && VelocityI && Time) {
                    cont = true;
                    VelocityI = true;
                    vi = vf - (d / t * 2);
                }
            }
        }
            if(!(Distance&&VelocityI&&Acceleration&&VelocityF&&Time&&Distance)){
                MotionDistance.setText("ERROR");
                MotionVelocityF.setText("ERROR");
                MotionTime.setText("ERROR");
                MotionVelocityI.setText("ERROR");
                MotionAcceleration.setText("ERROR");
            }
            else{
                MotionVelocityF.setText(Double.toString(trim(vf)));
                MotionVelocityI.setText(Double.toString(trim(vi)));
                MotionAcceleration.setText(Double.toString(trim(a)));
                MotionTime.setText(Double.toString(trim(t)));
                MotionDistance.setText(Double.toString(trim(d)));
            }



        }


    public void fillEmpty() {
        if (MotionDistance.getText().toString().isEmpty())
            MotionDistance.setText(Double.toString(0));
        if (MotionTime.getText().toString().isEmpty())
            MotionTime.setText(Double.toString(0));
        if (MotionVelocityF.getText().toString().isEmpty())
            MotionVelocityF.setText(Double.toString(0));
        if (MotionVelocityI.getText().toString().isEmpty())
            MotionVelocityI.setText(Double.toString(0));
        if (MotionAcceleration.getText().toString().isEmpty())
            MotionAcceleration.setText(Double.toString(0));
    }

    public double trim(double a) {
        return Math.floor(a * 1000) / 1000;
    }

}
