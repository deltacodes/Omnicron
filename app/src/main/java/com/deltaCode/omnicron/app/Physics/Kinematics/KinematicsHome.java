package com.deltaCode.omnicron.app.Physics.Kinematics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.deltaCode.omnicron.app.Chemistry.ChemistryHome;
import com.deltaCode.omnicron.app.Physics.PhysicsHome;
import com.deltaCode.omnicron.app.R;


public class KinematicsHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinematics_home);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kinematics_home, menu);
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


    public void ToProjectilesFromKinematics(View view){
        Intent intent=new Intent(this,TypeOneProjectile.class);
        startActivity(intent);
    }
    public void ToMotionFromKinematics(View view){
        Intent intent=new Intent(this,Motion.class);
        startActivity(intent);
    }

}
