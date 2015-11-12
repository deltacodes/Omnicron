package com.deltaCode.omnicron.app.Physics.Dynamics;

/**
 * Created by mr767 on 11/4/15.
 */
public class Vector {
    private double ComponentX;
    private double ComponentY;
    private double Magnitude;
    private double Direction;

    public Vector (boolean component, double box1, double box2){
        if(component){
            ComponentX = box1;
            ComponentY = box2;
            Magnitude = Math.sqrt(box1*box1+box2*box2);
            Direction = Math.atan(box2/box1);
        }
        else{
            Magnitude = box1;
            Direction = Math.toRadians(box2);
            ComponentX = Math.cos(Direction)*Magnitude;
            ComponentY = Math.sin(Direction)*Magnitude;
        }
    }
    public double getComponentX (){
        return ComponentX;
    }
    public double getComponentY (){
        return ComponentY;
    }
    public double getMagnitude (){
        return Magnitude;
    }
    public double getDirection (){ return Direction;  }
}
