package com.pesante;

import java.util.ArrayList;

/**
 * Created by joepesante on 6/26/17.
 */
public class Handgun {

    private String manufacturer;
    private String model;
    private String caliber;
    private Slide slide;
    private Frame frame;
    private Magazine magazine;
    private ArrayList<Handgun> handgunList;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public String getCaliber() {
        return caliber;
    }



    public Handgun(String manufacturer, String model, String caliber, Slide slide, Frame frame, Magazine magazine) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.caliber = caliber;
        this.slide = slide;
        this.frame = frame;
        this.magazine = magazine;
        this.handgunList = new ArrayList<>();
    }

    public void getReady(){

        slide.rack();
    }

    public void fire(){
        if (!magazine.magEmpty) {
            System.out.println("Handgun -> fired...");
            magazine.roundCount();
        }
        else {
            System.out.println("Handgun did not fire... no ammo");
        }

    }

    public void getSpecs(){
        System.out.println("Your current handgun is a " + manufacturer + " " + model + " " + " in " + caliber);

    }

    public void triggerControl(){
        frame.triggerPulled();
        System.out.println("handgun.triggerControl() called");
    }

    public void loadMagazine() { magazine.loadMag();
        System.out.println("handgun.loadMagazine() called. " + "Loaded " + magazine.getMagCapacity() + " " + caliber + "rounds");}

    public void insertMagazine(){
        magazine.insertMag();
    }


//    public void addHandgun(String handgunName) {
//        this.handgunList.add(new Handgun(String manufacturer, String model, String caliber, Slide slide, Frame frame, Magazine magazine));
//    }


    @Override
    public String toString() {
        return "Handgun{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", caliber='" + caliber + '\'' +
                ", slide=" + slide +
                ", frame=" + frame +
                ", magazine=" + magazine +
                ", handgunList=" + handgunList +
                '}';
    }
}
