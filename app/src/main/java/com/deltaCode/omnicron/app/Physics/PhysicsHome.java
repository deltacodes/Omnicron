package com.deltaCode.omnicron.app.Physics;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.deltaCode.omnicron.app.Physics.Dynamics.DynamicsHome;
import com.deltaCode.omnicron.app.Physics.Kinematics.KinematicsHome;
import com.deltaCode.omnicron.app.R;


public class PhysicsHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics_home);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_physics_home, menu);
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
    public void ToKinematicsFromHomeMethod (View view){
        Intent intent=new Intent(this,KinematicsHome.class);
        this.startActivity(intent);
    }
    public void ToDynamicsFromHomeMethod (View view){
        Intent intent=new Intent(this,DynamicsHome.class);
        this.startActivity(intent);
    }
}
