package com.deltaCode.omnicron.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.deltaCode.omnicron.app.Chemistry.ChemistryHome;
import com.deltaCode.omnicron.app.Physics.PhysicsHome;

import static com.deltaCode.omnicron.app.R.id.ToKinematicsFromHome;

public class MainActivity extends Activity {
Button toKinematics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toKinematics=(Button)findViewById(ToKinematicsFromHome);
    }
    public void ToPhysicsFromHomeMethod (View view){
        Intent intent=new Intent(this,PhysicsHome.class);
        this.startActivity(intent);
    }
    public void ToChemistryFromHomeMethod (View view){
        Intent intent=new Intent(this,ChemistryHome.class);
        this.startActivity(intent);
    }
}
