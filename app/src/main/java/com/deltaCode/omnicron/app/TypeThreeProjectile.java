package com.deltaCode.omnicron.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;


public class TypeThreeProjectile extends ActionBarActivity {
    EditText typeThreeProjectileHeight;
    EditText typeThreeProjectileVelocity;
    EditText typeThreeProjectileTime;
    EditText typeThreeProjectileDistance;
    EditText typeThreeProjectileAngle;
    EditText typeThreeProjectileMaxHeight;
    Spinner Spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_three_projectile);
        typeThreeProjectileVelocity = (EditText) findViewById(R.id.typeThreeProjectileVelocity);
        typeThreeProjectileAngle = (EditText) findViewById(R.id.typeThreeProjectileAngle);
        typeThreeProjectileTime = (EditText) findViewById(R.id.typeThreeProjectileTime);
        typeThreeProjectileDistance = (EditText) findViewById(R.id.typeThreeProjectileDistance);
        typeThreeProjectileMaxHeight = (EditText) findViewById(R.id.typeThreeProjectileMaxHeight);
        typeThreeProjectileHeight = (EditText) findViewById(R.id.typeThreeProjectileHeight);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Spinner = (Spinner) findViewById(R.id.spinner3);
        Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean different=false;
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long row_id) {
                Intent intent = null;

                switch (position) {
                    case 1:
                        intent = new Intent(TypeThreeProjectile.this, TypeOneProjectile.class);
                        different=true;
                        break;
                    case 2:
                        intent = new Intent(TypeThreeProjectile.this, TypeTwoProjectile.class);
                        different=true;
                        break;
                    case 4:
                        intent = new Intent(TypeThreeProjectile.this, KinematicsHome.class);
                        different=true;
                        break;

// and so on
// .....

                }

                if(different)
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
       getMenuInflater().inflate(R.menu.menu_type_three_projectile, menu);
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



    public void calculate(View view) {

        boolean Distance = !(typeThreeProjectileDistance.getText().toString().isEmpty());
        boolean MaxHeight = !(typeThreeProjectileMaxHeight.getText().toString().isEmpty());
        boolean Height = !(typeThreeProjectileHeight.getText().toString().isEmpty());
        boolean Time = !(typeThreeProjectileTime.getText().toString().isEmpty());
        boolean Velocity = !(typeThreeProjectileVelocity.getText().toString().isEmpty());
        boolean Angle = !(typeThreeProjectileAngle.getText().toString().isEmpty());
        boolean vxb = false;
        boolean vyb = false;
        fillEmpty();
        double d = Double.parseDouble(typeThreeProjectileDistance.getText().toString());
        double h = Double.parseDouble(typeThreeProjectileHeight.getText().toString());
        double hm = Double.parseDouble(typeThreeProjectileMaxHeight.getText().toString());
        double t = Double.parseDouble(typeThreeProjectileTime.getText().toString());
        double v = Double.parseDouble(typeThreeProjectileVelocity.getText().toString());
        double a = Double.parseDouble(typeThreeProjectileAngle.getText().toString());
        a = Math.toRadians(a);
        double vx = 0;
        double vy = 0;
        boolean cont = true;
        while (cont) {
            cont = false;
            if (!vxb) {
                if (Velocity && Angle) {
                    cont = true;
                    vxb = true;
                    vx = Math.cos(a) * v;
                }
                else if (Distance && Time) {
                    cont = true;
                    vxb = true;
                    vx = d / t;
                }
                else if (Velocity && vyb) {
                    cont = true;
                    vxb = true;
                    vx = Math.sqrt(v * v - vy * vy);
                }
                else if (vyb && Angle) {
                    cont = true;
                    vxb = true;
                    vx = vx / Math.tan(a);
                }
            }
            if (!vyb) {
                if (Velocity && Angle) {
                    cont = true;
                    vyb = true;
                    vy = Math.sin(a) * v;
                }
                else if (Height && Time) {
                    cont = true;
                    vyb = true;
                    vy = (-h + 4.9 * t * t) / t;
                }
                else if (Height && MaxHeight) {
                    cont = true;
                    vyb = true;
                    vy = Math.sqrt(19.6 * (hm - h));
                }
                else if (Velocity && vxb) {
                    cont = true;
                    vyb = true;
                    vy = Math.sqrt(v * v - vx * vx);
                }
                else if(Angle &&vxb){
                    cont = true;
                    vyb = true;
                    vy=vx*Math.tan(a);
                }
            }
            if (!Angle) {
                if (vyb && vxb) {
                    cont = true;
                    Angle = true;
                    a = Math.atan2(vy, vx);
                }
                else if (Velocity && vxb) {
                    cont = true;
                    Angle = true;
                    a = Math.acos(vx / v);
                }
                else if (Velocity && vyb) {
                    cont = true;
                    Angle = true;
                    a = Math.asin(vy / v);
                }
            }
            if (!Time) {
                if (Distance && vxb) {
                    cont = true;
                    Time = true;
                    t = d / vx;
                }
                else if (vyb && Height) {
                    cont = true;
                    Time = true;
                    t = (vy + Math.sqrt(vy * vy + 4 * 4.9 * h)) / 9.8;
                }
                else if(Velocity&&Angle&&Height){
                    cont = true;
                    Time = true;
                    t=((v*Math.sin(a)/9.8)+((Math.sqrt(v*v*Math.sin(a)*Math.sin(a)+19.6*h))/9.8));
                }
            }
            if (!Distance) {
                if (Time && vxb) {
                    cont = true;
                    Distance = true;
                    d = t * vx;
                }
                else if(Velocity&&Angle&&Height){
                    cont = true;
                    Distance = true;
                    d=(((v*Math.cos(a))/9.8)*(v*Math.sin(a))+Math.sqrt(v*v*Math.sin(a)*Math.sin(a)+19.6*h));
                }
            }
            if (!Velocity) {
                if (vxb && vyb) {
                    cont = true;
                    Velocity = true;
                    v = Math.sqrt(vx * vx + vy * vy);
                }
                else if (Angle && vxb) {
                    cont = true;
                    Velocity = true;
                    v = vx / Math.cos(a);
                }
                else if (Angle && vyb) {
                    cont = true;
                    Velocity = true;
                    v = vy / Math.sin(a);
                }

            }
            if (!Height) {
                if (Time && vyb) {
                    cont = true;
                    Height = true;
                    h = -(vy * t - 4.9 * t * t);
                }
                else if (vyb && MaxHeight) {
                    cont = true;
                    Height = true;
                    h = hm - ((vy * vy) / 4.9);
                }
            }
            if (!MaxHeight) {
                if (vyb && Height) {
                    cont = true;
                    MaxHeight = true;
                    hm = h + ((vy * vy) / 4.9);
                }
            }
        }

        typeThreeProjectileHeight.setText(new Double(trim(h)).toString());
        typeThreeProjectileVelocity.setText(new Double(trim(v)).toString());
        typeThreeProjectileAngle.setText(new Double(trim(Math.toDegrees(a))).toString());
        typeThreeProjectileMaxHeight.setText(new Double(trim(hm)).toString());
        typeThreeProjectileTime.setText(new Double(trim(t)).toString());
        typeThreeProjectileDistance.setText(new Double(trim(d)).toString());

        if(!(Height&&Velocity&&Angle&&MaxHeight&&Time&&Distance)){
            typeThreeProjectileDistance.setText("ERROR");
            typeThreeProjectileMaxHeight.setText("ERROR");
            typeThreeProjectileTime.setText("ERROR");
            typeThreeProjectileVelocity.setText("ERROR");
            typeThreeProjectileAngle.setText("ERROR");
            typeThreeProjectileHeight.setText("ERROR");
        }
    }


    public void fillEmpty() {
        if (typeThreeProjectileDistance.getText().toString().isEmpty())
            typeThreeProjectileDistance.setText(new Double(0).toString());
        if (typeThreeProjectileTime.getText().toString().isEmpty())
            typeThreeProjectileTime.setText(new Double(0).toString());
        if (typeThreeProjectileVelocity.getText().toString().isEmpty())
            typeThreeProjectileVelocity.setText(new Double(0).toString());
        if (typeThreeProjectileMaxHeight.getText().toString().isEmpty())
            typeThreeProjectileMaxHeight.setText(new Double(0).toString());
        if (typeThreeProjectileAngle.getText().toString().isEmpty())
            typeThreeProjectileAngle.setText(new Double(0).toString());
        if (typeThreeProjectileHeight.getText().toString().isEmpty())
            typeThreeProjectileHeight.setText(new Double(0).toString());

    }

    public void clear(View view) {
        typeThreeProjectileDistance.setText("");
        typeThreeProjectileMaxHeight.setText("");
        typeThreeProjectileTime.setText("");
        typeThreeProjectileVelocity.setText("");
        typeThreeProjectileAngle.setText("");
        typeThreeProjectileHeight.setText("");

    }

    public double trim(double a) {
        return Math.floor(a * 1000) / 1000;
    }


}
