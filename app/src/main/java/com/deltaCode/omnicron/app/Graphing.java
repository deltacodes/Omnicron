package com.deltaCode.omnicron.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.deltaCode.omnicron.app.Physics.Kinematics.TypeOneProjectile;
import com.jjoe64.graphview.*;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.lang.reflect.Type;


public class Graphing extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphing);
        double height = TypeOneProjectile.h;
        double VelocityX = TypeOneProjectile.v;
        double VelocityY = 0;
        int time = (int) Math.floor(TypeOneProjectile.t);
        double y = height;
        double x = 0;
        DataPoint[] points = new DataPoint[time+1];
        for(int t = 0; t<time+1; t++){
            x = t * VelocityX;
            y = height + VelocityY * t - 4.9 * t * t;
            points[t] = new DataPoint(x, y);
        }
        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(points);
        graph.addSeries(series);
    }






    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_graphing, menu);
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
