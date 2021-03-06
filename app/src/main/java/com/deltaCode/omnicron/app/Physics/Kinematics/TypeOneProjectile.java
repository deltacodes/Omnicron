package com.deltaCode.omnicron.app.Physics.Kinematics;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import com.deltaCode.omnicron.app.Chemistry.ChemistryHome;
import com.deltaCode.omnicron.app.Graphing;
import com.deltaCode.omnicron.app.Physics.PhysicsHome;
import com.deltaCode.omnicron.app.R;


public class TypeOneProjectile extends AppCompatActivity {
    EditText typeOneProjectileHeight;
    EditText typeOneProjectileVelocity;
    EditText typeOneProjectileTime;
    EditText typeOneProjectileDistance;
    Spinner Spinner;
    public static double d = 0;
    public static double h = 0;
    public static double t = 0;
    public static double v = 0;

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
        switch (item.getItemId()) {
            case R.id.action_toPhysicsHome:
                // EITHER CALL THE METHOD HERE OR DO THE FUNCTION DIRECTLY
                ToPhysics();
                return true;
            case R.id.action_toChemistryHome:
                // EITHER CALL THE METHOD HERE OR DO THE FUNCTION DIRECTLY
                ToChemistry();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public void ToPhysics(){
        Intent intent=new Intent(this,PhysicsHome.class);
        startActivity(intent);
    }
    public void ToChemistry(){
        Intent intent=new Intent(this,ChemistryHome.class);
        startActivity(intent);
    }


    public void clear(View view) {
        typeOneProjectileDistance.setText("");
        typeOneProjectileHeight.setText("");
        typeOneProjectileTime.setText("");
        typeOneProjectileVelocity.setText("");
    }

    public void calculate(View view) {
        calc();
    }
    public void calc(){
        boolean Distance = !(typeOneProjectileDistance.getText().toString().isEmpty());
        boolean Height = !(typeOneProjectileHeight.getText().toString().isEmpty());
        boolean Time = !(typeOneProjectileTime.getText().toString().isEmpty());
        boolean Velocity = !(typeOneProjectileVelocity.getText().toString().isEmpty());
        fillEmpty();
         d = Double.parseDouble(typeOneProjectileDistance.getText().toString());
         h = Double.parseDouble(typeOneProjectileHeight.getText().toString());
         t = Double.parseDouble(typeOneProjectileTime.getText().toString());
         v = Double.parseDouble(typeOneProjectileVelocity.getText().toString());
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
                else if (Velocity && Distance) {
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

    public void fillEmpty() {
        if (typeOneProjectileDistance.getText().toString().isEmpty())
            typeOneProjectileDistance.setText(Double.toString(0));
        if (typeOneProjectileTime.getText().toString().isEmpty())
            typeOneProjectileTime.setText(Double.toString(0));
        if (typeOneProjectileVelocity.getText().toString().isEmpty())
            typeOneProjectileVelocity.setText(Double.toString(0));
        if (typeOneProjectileHeight.getText().toString().isEmpty())
            typeOneProjectileHeight.setText(Double.toString(0));
    }

    public double round(double a) {
        return Math.floor(a * 1000) / 1000;
    }


    public void toGraph(View view){
        calc();
        Intent intent = new Intent(this, Graphing.class);
        /*
        Bundle bun = new Bundle();
        bun.putDouble("Height", h);
        bun.putDouble("VelocityX", v);
        bun.putDouble("VelocityY", 0);
        bun.putDouble("Time", t);
        intent.putExtra("Bundle", bun);*/
        startActivity(intent);



    }
}



