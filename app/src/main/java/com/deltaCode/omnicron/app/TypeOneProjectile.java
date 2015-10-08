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
import android.widget.Spinner;


public class TypeOneProjectile extends ActionBarActivity {
    EditText typeOneProjectileHeight;
    EditText typeOneProjectileVelocity;
    EditText typeOneProjectileTime;
    EditText typeOneProjectileDistance;
    Spinner Spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_one_projectile);
        typeOneProjectileHeight = (EditText) findViewById(R.id.typeOneProjectileHeight);
        typeOneProjectileVelocity = (EditText) findViewById(R.id.typeOneProjectileVelocity);
        typeOneProjectileTime = (EditText) findViewById(R.id.typeOneProjectileTime);
        typeOneProjectileDistance = (EditText) findViewById(R.id.typeOneProjectileDistance);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Spinner = (Spinner) findViewById(R.id.spinner);
        Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            boolean different=false;
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long row_id) {
                Intent intent = null;

                switch (position) {
                    case 2:
                        intent = new Intent(TypeOneProjectile.this, TypeTwoProjectile.class);
                        different=true;
                        break;
                    case 3:
                        intent = new Intent(TypeOneProjectile.this, TypeThreeProjectile.class);
                        different=true;
                        break;
                    case 4:
                        intent = new Intent(TypeOneProjectile.this, KinematicsHome.class);
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
        getMenuInflater().inflate(R.menu.menu_type_one_projectile, menu);
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
        typeOneProjectileDistance.setText("");
        typeOneProjectileHeight.setText("");
        typeOneProjectileTime.setText("");
        typeOneProjectileVelocity.setText("");
    }

    public void calculate(View view) {
        boolean Distance = !(typeOneProjectileDistance.getText().toString().isEmpty());
        boolean Height = !(typeOneProjectileHeight.getText().toString().isEmpty());
        boolean Time = !(typeOneProjectileTime.getText().toString().isEmpty());
        boolean Velocity = !(typeOneProjectileVelocity.getText().toString().isEmpty());
        fillEmpty();
        double d = Double.parseDouble(typeOneProjectileDistance.getText().toString());
        double h = Double.parseDouble(typeOneProjectileHeight.getText().toString());
        double t = Double.parseDouble(typeOneProjectileTime.getText().toString());
        double v = Double.parseDouble(typeOneProjectileVelocity.getText().toString());
        boolean cont = true;
        while (cont) {
            cont = false;
            if (!Velocity) {
                if (Distance && Time) {
                    Velocity = true;
                    cont = true;
                    v = d / t;
                }
            }
            if (!Distance) {
                if (Velocity && Time) {
                    Distance = true;
                    cont = true;
                    d = v * t;
                }

            }
            if (!Time) {
                if (Height) {
                    Time = true;
                    cont = true;
                    t = Math.sqrt(h / 9.8);
                }
                if (Velocity && Distance) {
                    Time = true;
                    cont = true;
                    t = d / v;
                }
            }
            if (!Height) {
                if (Time) {
                    Height = true;
                    cont = true;
                    h = t * t * 9.8;
                }
            }
            typeOneProjectileHeight.setText(Double.toString(round(h)) + " m");
            typeOneProjectileVelocity.setText(Double.toString(round(v)) + " m/s");
            typeOneProjectileTime.setText(Double.toString(round(t)) + " s");
            typeOneProjectileDistance.setText(Double.toString(round(d)) + " m");
            if (!(Height && Velocity && Time && Distance)) {
                typeOneProjectileHeight.setText("ERROR");
                typeOneProjectileVelocity.setText("ERROR");
                typeOneProjectileTime.setText("ERROR");
                typeOneProjectileDistance.setText("ERROR");
            }
        }
    }

    public void fillEmpty() {
        if (typeOneProjectileDistance.getText().toString().isEmpty())
            typeOneProjectileDistance.setText(new Double(0).toString());
        if (typeOneProjectileTime.getText().toString().isEmpty())
            typeOneProjectileTime.setText(new Double(0).toString());
        if (typeOneProjectileVelocity.getText().toString().isEmpty())
            typeOneProjectileVelocity.setText(new Double(0).toString());
        if (typeOneProjectileHeight.getText().toString().isEmpty())
            typeOneProjectileHeight.setText(new Double(0).toString());
    }

    public double round(double a) {
        return Math.floor(a * 1000) / 1000;
    }
}



