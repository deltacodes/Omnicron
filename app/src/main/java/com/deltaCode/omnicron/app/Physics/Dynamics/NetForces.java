package com.deltaCode.omnicron.app.Physics.Dynamics;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.deltaCode.omnicron.app.R;

public class NetForces extends ActionBarActivity {
    Spinner Vector1Spinner;
    Spinner Vector2Spinner;
    Spinner Vector3Spinner;
    Spinner Vector4Spinner;

    EditText Vector1_1;
    EditText Vector1_2;
    EditText Vector2_1;
    EditText Vector2_2;
    EditText Vector3_1;
    EditText Vector3_2;
    EditText Vector4_1;
    EditText Vector4_2;

    Button Vector1Button;
    Button Vector2Button;
    Button Vector3Button;
    Button Vector4Button;

    Button Calculate;
    Button Clear;
    Button Reset;
    //hello
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_forces);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_net_forces, menu);
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

}
