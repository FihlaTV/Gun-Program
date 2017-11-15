package com.pesante;

/**
 * Created by joepesante on 6/26/17.
 */
public class Slide {
    private String slide; //one piece or two piece
    private int spring; // how many springs?
    private boolean firingPin; // yes or no
    private double barrelLength;
    private boolean rifledBarrel; // yes or no
    private boolean compensatedBarrel; //yes or no

    public String getSlide() {
        return slide;
    }

    public int getSpring() {
        return spring;
    }

    public boolean isFiringPin() {
        return firingPin;
    }

    public double getBarrelLength() {
        return barrelLength;
    }

    public boolean isRifledBarrel() {
        return rifledBarrel;
    }

    public boolean isCompensatedBarrel() {
        return compensatedBarrel;
    }

    public Slide(String slide, int spring, boolean firingPin, double barrelLength, boolean rifledBarrel, boolean compensatedBarrel) {
        this.slide = slide;
        this.spring = spring;
        this.firingPin = firingPin;
        this.barrelLength = barrelLength;
        this.rifledBarrel = rifledBarrel;
        this.compensatedBarrel = compensatedBarrel;


    }

    public void rack(){
        System.out.println("slide.rack() called. " + "Slide -> racked...");

    }


}
