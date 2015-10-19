package com.deltaCode.omnicron.app.Physics.Kinematics;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import android.widget.*;
import android.content.*;
import com.deltaCode.omnicron.app.R;


public class TypeTwoProjectile extends AppCompatActivity {
    EditText typeTwoProjectileMaxHeight;
    EditText typeTwoProjectileVelocity;
    EditText typeTwoProjectileTime;
    EditText typeTwoProjectileDistance;
    EditText typeTwoProjectileAngle;
    Spinner Spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_two_projectile);
        typeTwoProjectileMaxHeight = (EditText) findViewById(R.id.typeTwoProjectileMaxHeight);
        typeTwoProjectileVelocity = (EditText) findViewById(R.id.typeTwoProjectileVelocity);
        typeTwoProjectileTime = (EditText) findViewById(R.id.typeTwoProjectileTime);
        typeTwoProjectileDistance = (EditText) findViewById(R.id.typeTwoProjectileDistance);
        typeTwoProjectileAngle = (EditText) findViewById(R.id.typeTwoProjectileAngle);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Spinner = (Spinner) findViewById(R.id.spinner2);
        Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean different = false;

            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long row_id) {
                Intent intent = null;

                switch (position) {
                    case 1:
                        intent = new Intent(TypeTwoProjectile.this, TypeOneProjectile.class);
                        different = true;
                        break;
                    case 3:
                        intent = new Intent(TypeTwoProjectile.this, TypeThreeProjectile.class);
                        different = true;
                        break;
                    case 4:
                        intent = new Intent(TypeTwoProjectile.this, KinematicsHome.class);
                        different = true;
                        break;
// and so on
// .....

                }

                if (different)
                    startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_type_two_projectile, menu);
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
        typeTwoProjectileDistance.setText("");
        typeTwoProjectileMaxHeight.setText("");
        typeTwoProjectileTime.setText("");
        typeTwoProjectileVelocity.setText("");
        typeTwoProjectileAngle.setText("");
    }

    public void calculate(View view) {


        boolean Distance = !(typeTwoProjectileDistance.getText().toString().isEmpty());
        boolean MaxHeight = !(typeTwoProjectileMaxHeight.getText().toString().isEmpty());
        boolean Time = !(typeTwoProjectileTime.getText().toString().isEmpty());
        boolean Velocity = !(typeTwoProjectileVelocity.getText().toString().isEmpty());
        boolean Angle = !(typeTwoProjectileAngle.getText().toString().isEmpty());
        boolean vxb = false;
        boolean vyb = false;
        fillEmpty();
        double d = Double.parseDouble(typeTwoProjectileDistance.getText().toString());
        double hm = Double.parseDouble(typeTwoProjectileMaxHeight.getText().toString());
        double t = Double.parseDouble(typeTwoProjectileTime.getText().toString());
        double v = Double.parseDouble(typeTwoProjectileVelocity.getText().toString());
        double a = Double.parseDouble(typeTwoProjectileAngle.getText().toString());
        a = Math.toRadians(a);
        double vx = 0;
        double vy = 0;
        boolean cont = true;
        while (cont) {
            cont = false;
            if (!Velocity) {
                if (vxb && vyb) {
                    v = Math.sqrt(vx * vx + vy * vy);
                    cont = true;
                    Velocity = true;
                } else if (Distance && Angle) {
                    Velocity = true;
                    cont = true;
                    v = Math.sqrt((9.8 * d) / Math.sin(2 * a));
                }
            }
            if (!Distance) {
                if (vxb && Time) {
                    d = vx * t;
                    cont = true;
                    Distance = true;
                } else if (Velocity && Angle) {
                    d = Math.sin(2 * a) * v * v / 9.8;
                    cont = true;
                    Distance = true;
                }
            }
            if (!Angle) {
                if (vxb && vyb) {
                    Angle = true;
                    cont = true;
                    a = Math.atan(vy / vx);
                } else if (Distance && Velocity) {
                    Angle = true;
                    cont = true;
                    a = 0.5 * Math.asin((d * 9.8 / (v * v)));
                }
            }
            if (!Time) {
                if (vyb) {
                    t = (2 * vy) / 9.8;
                    cont = true;
                    Time = true;
                } else if (vxb && Distance) {
                    t = d / vx;
                    cont = true;
                    Time = true;
                }

            }
            if (!MaxHeight) {
                if (Time) {
                    hm = (t * t *1.225);
                    cont = true;
                    MaxHeight = true;
                } else if (vyb) {
                    hm = vy * vy / 19.8;
                    cont = true;
                    MaxHeight = true;
                }
            }
            if (!vyb) {
                if (Velocity && Angle) {
                    vy = Math.sin(a) * v;
                    cont = true;
                    vyb = true;
                } else if (Angle && vxb) {
                    vy = vx * Math.tan(a);
                    cont = true;
                    vyb = true;
                } else if (Velocity && vxb) {
                    vy = v * v - vx * vx;
                    cont = true;
                    vyb = true;
                } else if (Time) {
                    vy = 4.9 * t;
                    vyb = true;
                    cont = true;
                } else if (MaxHeight) {
                    vy = Math.sqrt(2 * hm * 9.8);
                    vyb = true;
                    cont = true;
                }
            }
            if (!vxb) {
                if (Velocity && Angle) {
                    vx = Math.cos(a) * v;
                    cont = true;
                    vxb = true;
                } else if (Angle && vyb) {
                    vx = vy / (Math.sin(a) / Math.cos(a));
                    cont = true;
                    vxb = true;
                } else if (Velocity && vyb) {
                    vx = Math.sqrt((v * v) - (vy * vy));
                    cont = true;
                    vxb = true;
                } else if (Distance && Time) {
                    vx = d / t;
                    vxb = true;
                    cont = true;
                }
            }
        }

        if (!(MaxHeight && Velocity && Time && Distance && Angle)) {
            typeTwoProjectileMaxHeight.setText("ERROR");
            typeTwoProjectileVelocity.setText("ERROR");
            typeTwoProjectileTime.setText("ERROR");
            typeTwoProjectileDistance.setText("ERROR");
            typeTwoProjectileAngle.setText("ERROR");
        } else {
            typeTwoProjectileMaxHeight.setText(Double.toString(round(hm)) + " m");
            typeTwoProjectileAngle.setText(Double.toString(round(Math.toDegrees(a))) + " �");
            typeTwoProjectileVelocity.setText(Double.toString(round(v)) + " m/s");
            typeTwoProjectileTime.setText(Double.toString(round(t)) + " s");
            typeTwoProjectileDistance.setText(Double.toString(round(d)) + " m");
        }
    }


    public void fillEmpty() {
        if (typeTwoProjectileDistance.getText().toString().isEmpty())
            typeTwoProjectileDistance.setText(Double.toString(0));
        if (typeTwoProjectileTime.getText().toString().isEmpty())
            typeTwoProjectileTime.setText(Double.toString(0));
        if (typeTwoProjectileVelocity.getText().toString().isEmpty())
            typeTwoProjectileVelocity.setText(Double.toString(0));
        if (typeTwoProjectileMaxHeight.getText().toString().isEmpty())
            typeTwoProjectileMaxHeight.setText(Double.toString(0));
        if (typeTwoProjectileAngle.getText().toString().isEmpty())
            typeTwoProjectileAngle.setText(Double.toString(0));
    }

    public double round(double a) {
        return Math.floor(a * 1000) / 1000;
    }
}

