package com.deltaCode.omnicron.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.deltaCode.omnicron.app.R.id.ToKinematicsFromHome;

public class MainActivity extends Activity {
Button toKinematics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toKinematics=(Button)findViewById(ToKinematicsFromHome);
    }
    public void ToKinematicsFromHomeMethod (View view){
        Intent intent=new Intent(this,KinematicsHome.class);
        this.startActivity(intent);
    }
}
