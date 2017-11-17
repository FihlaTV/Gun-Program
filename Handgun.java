package com.pesante;

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
        System.out.println("This handgun is a " + manufacturer + " " + model + " " + " in " + caliber);

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




}
