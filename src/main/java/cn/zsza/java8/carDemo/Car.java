package cn.zsza.java8.carDemo;

/**
 * Created by zs on 2017/6/5.
 * 16:47
 */
public class Car {
    private String make;
    private String model;
    private int year;

    public Car(String theMake, String theModel, int yearOfMake) {
        make = theMake;
        model = theModel;
        year = yearOfMake;
    }

    public String getMake(){
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
}
