package com.deltaCode.omnicron.app.Physics.Dynamics;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import com.deltaCode.omnicron.app.Chemistry.ChemistryHome;
import com.deltaCode.omnicron.app.Physics.Kinematics.KinematicsHome;
import com.deltaCode.omnicron.app.Physics.Kinematics.TypeThreeProjectile;
import com.deltaCode.omnicron.app.Physics.Kinematics.TypeTwoProjectile;
import com.deltaCode.omnicron.app.Physics.PhysicsHome;
import com.deltaCode.omnicron.app.R;

public class NetForces extends ActionBarActivity {
    Spinner VectorSpinner1;
    Spinner VectorSpinner2;
    Spinner VectorSpinner3;
    Spinner VectorSpinner4;
    Spinner VectorSpinnerAnswer;

    EditText Vector1_1;
    EditText Vector1_2;
    EditText Vector2_1;
    EditText Vector2_2;
    EditText Vector3_1;
    EditText Vector3_2;
    EditText Vector4_1;
    EditText Vector4_2;

    Button add1;
    Button add2;
    Button add3;

    Button remove1;
    Button remove2;
    Button remove3;

    Button Calculate;
    Button Clear;
    Button Reset;

    TextView Answer;

    boolean Spinner1=false;
    boolean Spinner2=false;
    boolean Spinner3=false;
    boolean Spinner4=false;
    boolean answerSpinner=false;

    //hello
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_forces);
        VectorSpinner1=(Spinner)findViewById(R.id.VectorSpinner1);
        VectorSpinner2=(Spinner)findViewById(R.id.VectorSpinner2);
        VectorSpinner3=(Spinner)findViewById(R.id.VectorSpinner3);
        VectorSpinner4=(Spinner)findViewById(R.id.VectorSpinner4);
        VectorSpinnerAnswer=(Spinner)findViewById(R.id.AnswerSpinner);

        Vector1_1=(EditText)findViewById(R.id.Vector1_1);
        Vector1_2=(EditText)findViewById(R.id.Vector1_2);

        Vector2_1=(EditText)findViewById(R.id.Vector2_1);
        Vector2_2=(EditText)findViewById(R.id.Vector2_2);

        Vector3_1=(EditText)findViewById(R.id.Vector3_1);
        Vector3_2=(EditText)findViewById(R.id.Vector3_2);

        Vector4_1=(EditText)findViewById(R.id.Vector4_1);
        Vector4_2=(EditText)findViewById(R.id.Vector4_2);

        Answer = (TextView)findViewById(R.id.answerview);

        add1=(Button)findViewById(R.id.add1);
        add2=(Button)findViewById(R.id.add2);
        add3=(Button)findViewById(R.id.add3);

        remove1=(Button)findViewById(R.id.remove1);
        remove2=(Button)findViewById(R.id.remove2);
        remove3=(Button)findViewById(R.id.remove3);


        VectorSpinner2.setVisibility(View.INVISIBLE);
        VectorSpinner3.setVisibility(View.INVISIBLE);
        VectorSpinner4.setVisibility(View.INVISIBLE);
        Vector2_1.setVisibility(View.INVISIBLE);
        Vector2_2.setVisibility(View.INVISIBLE);
        Vector3_1.setVisibility(View.INVISIBLE);
        Vector3_2.setVisibility(View.INVISIBLE);
        Vector4_1.setVisibility(View.INVISIBLE);
        Vector4_2.setVisibility(View.INVISIBLE);

        add2.setVisibility(View.INVISIBLE);
        add3.setVisibility(View.INVISIBLE);
        remove1.setVisibility(View.INVISIBLE);
        remove2.setVisibility(View.INVISIBLE);
        remove3.setVisibility(View.INVISIBLE);

        VectorSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long row_id) {
                switch (position) {
                    case 0:
                        Spinner1=false;
                        break;
                    case 1:
                        Spinner1=true;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }});

        VectorSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long row_id) {
                switch (position) {
                    case 0:
                        Spinner2=false;
                        break;
                    case 1:
                        Spinner2=true;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }});

        VectorSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long row_id) {
                switch (position) {
                    case 0:
                        Spinner3=false;
                        break;
                    case 1:
                        Spinner3=true;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }});

        VectorSpinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long row_id) {
                switch (position) {
                    case 0:
                        Spinner4=false;
                        break;
                    case 1:
                        Spinner4=true;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }});

        VectorSpinnerAnswer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long row_id) {
                switch (position) {
                    case 0:
                        answerSpinner=false;
                        break;
                    case 1:
                        answerSpinner=true;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }});




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

    public void add1 (View view){
        add1.setVisibility(View.INVISIBLE);
        VectorSpinner2.setVisibility(View.VISIBLE);
        Vector2_1.setVisibility(View.VISIBLE);
        Vector2_2.setVisibility(View.VISIBLE);
        remove1.setVisibility(View.VISIBLE);
        add2.setVisibility(View.VISIBLE);
    }
    public void add2 (View view){
        add2.setVisibility(View.INVISIBLE);
        remove1.setVisibility(View.INVISIBLE);
        VectorSpinner3.setVisibility(View.VISIBLE);
        Vector3_1.setVisibility(View.VISIBLE);
        Vector3_2.setVisibility(View.VISIBLE);
        remove2.setVisibility(View.VISIBLE);
        add3.setVisibility(View.VISIBLE);
    }
    public void add3 (View view){
        add3.setVisibility(View.INVISIBLE);
        remove2.setVisibility(View.INVISIBLE);
        VectorSpinner4.setVisibility(View.VISIBLE);
        Vector4_1.setVisibility(View.VISIBLE);
        Vector4_2.setVisibility(View.VISIBLE);
        remove3.setVisibility(View.VISIBLE);
    }
    public void remove1 (View view){
        add1.setVisibility(View.VISIBLE);
        VectorSpinner2.setVisibility(View.INVISIBLE);
        Vector2_1.setVisibility(View.INVISIBLE);
        Vector2_2.setVisibility(View.INVISIBLE);
        Vector2_1.setText("");
        Vector2_2.setText("");
        remove1.setVisibility(View.INVISIBLE);
        add2.setVisibility(View.INVISIBLE);
    }
    public void remove2 (View view){
        add2.setVisibility(View.VISIBLE);
        remove1.setVisibility(View.VISIBLE);
        VectorSpinner3.setVisibility(View.INVISIBLE);
        Vector3_1.setVisibility(View.INVISIBLE);
        Vector3_2.setVisibility(View.INVISIBLE);
        Vector3_1.setText("");
        Vector3_2.setText("");
        remove2.setVisibility(View.INVISIBLE);
        add3.setVisibility(View.INVISIBLE);
    }
    public void remove3 (View view){
        add3.setVisibility(View.VISIBLE);
        remove2.setVisibility(View.VISIBLE);
        VectorSpinner4.setVisibility(View.INVISIBLE);
        Vector4_1.setVisibility(View.INVISIBLE);
        Vector4_2.setVisibility(View.INVISIBLE);
        Vector4_1.setText("");
        Vector4_2.setText("");
        remove3.setVisibility(View.INVISIBLE);
    }












    public void ToPhysics() {
        Intent intent = new Intent(this, PhysicsHome.class);
        startActivity(intent);
    }

    public void ToChemistry() {
        Intent intent = new Intent(this, ChemistryHome.class);
        startActivity(intent);
    }
    public void MotionCalculate(View view){
        double xTotal=0;
        double yTotal=0;
        fillEmpty();
        if(Spinner1){
            xTotal+=new Double(Vector1_1.getText().toString());
            yTotal+=new Double(Vector1_2.getText().toString());
        }
        else{
            double magnitude= new Double(Vector1_1.getText().toString());
            double angle= Math.toRadians(new Double(Vector1_2.getText().toString()));
            xTotal+=magnitude*Math.cos(angle);
            yTotal+=magnitude*Math.sin(angle);
        }
        if(Spinner2){
            xTotal+=new Double(Vector2_1.getText().toString());
            yTotal+=new Double(Vector2_2.getText().toString());
        }
        else{
            double magnitude= new Double(Vector2_1.getText().toString());
            double angle= Math.toRadians(new Double(Vector2_2.getText().toString()));
            xTotal+=magnitude*Math.cos(angle);
            yTotal+=magnitude*Math.sin(angle);
        }
        if(Spinner3){
            xTotal+=new Double(Vector3_1.getText().toString());
            yTotal+=new Double(Vector3_2.getText().toString());
        }
        else{
            double magnitude= new Double(Vector3_1.getText().toString());
            double angle= Math.toRadians(new Double(Vector3_2.getText().toString()));
            xTotal+=magnitude*Math.cos(angle);
            yTotal+=magnitude*Math.sin(angle);
        }
        if(Spinner4){
            xTotal+=new Double(Vector4_1.getText().toString());
            yTotal+=new Double(Vector4_2.getText().toString());
        }
        else{
            double magnitude= new Double(Vector4_1.getText().toString());
            double angle= Math.toRadians(new Double(Vector4_2.getText().toString()));
            xTotal+=magnitude*Math.cos(angle);
            yTotal+=magnitude*Math.sin(angle);
        }


        if(answerSpinner){
            xTotal=round(xTotal);
            yTotal=round(yTotal);
            String answer = xTotal + "I" + "\n" + yTotal + "J";
            Answer.setText(answer);
        }
        else{
            double angle=Math.atan((yTotal/xTotal));
            angle=Math.toDegrees(angle);
            angle=round(angle);
            double magnitude = Math.sqrt(xTotal*xTotal+yTotal*yTotal);
            magnitude=round(magnitude);
            String answer = "Magnitude: "+ magnitude + "\n Angle: " + angle;
            Answer.setText(answer);
        }


    }
    public void fillEmpty() {
        if (Vector1_1.getText().toString().isEmpty())
            Vector1_1.setText(Double.toString(0));
        if (Vector1_2.getText().toString().isEmpty())
            Vector1_2.setText(Double.toString(0));
        if (Vector2_1.getText().toString().isEmpty())
            Vector2_1.setText(Double.toString(0));
        if (Vector2_2.getText().toString().isEmpty())
            Vector2_2.setText(Double.toString(0));
        if (Vector3_1.getText().toString().isEmpty())
            Vector3_1.setText(Double.toString(0));
        if (Vector3_2.getText().toString().isEmpty())
            Vector3_2.setText(Double.toString(0));
        if (Vector4_1.getText().toString().isEmpty())
            Vector4_1.setText(Double.toString(0));
        if (Vector4_2.getText().toString().isEmpty())
            Vector4_2.setText(Double.toString(0));
    }
    public double round(double d){
        return Math.floor(d*1000)/1000;
    }
}
