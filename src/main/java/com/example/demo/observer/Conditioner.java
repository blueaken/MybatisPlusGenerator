package com.example.demo.observer;

import java.util.Observable;
import java.util.Observer;

public class Conditioner implements Observer {
    private double temperature;
    private double humidity;
    private double pressure;
    private String name;
    private Observable observable;		//	任何数据源的引用

    /*当构建观察者时，必须指定其 数据源*/
    public Conditioner(Observable observable,String name) {
        this.observable = observable;
        observable.addObserver(this);	//注册
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData) {
            WeatherData w = (WeatherData)o;
            this.temperature = w.getTemperature();
            this.humidity = w.getHumidity();
            this.pressure = w.getPressure();

            System.out.println("temperature:"+temperature+"  humidity:"+humidity+"  pressure:"+pressure);
        }
    }

}
