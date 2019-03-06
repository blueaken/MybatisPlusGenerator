package com.example.demo.observer;

import java.util.Observable;

public class WeatherData extends Observable {
    private double temperature;
    private double humidity;
    private double pressure;

    public WeatherData() {}

    /*向观察者发送数据*/
    public void measurementsChanged() {
        setChanged();		//向观察者发送数据之前必须先调用这个
        notifyObservers();	//notifyOberservers()会自动调用观察者的 update()方法
    }

    /*从数据源收到数据后，是先更新自己的数据，再把数据发给观察者*/
    public void setMeasurements(double temp,double humidity,double pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    /*留出接口给观察者获取数据*/
    public double getTemperature() {
        return temperature;
    }
    public double getHumidity() {
        return humidity;
    }
    public double getPressure() {
        return pressure;
    }

}
