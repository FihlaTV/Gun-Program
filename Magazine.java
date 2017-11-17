package com.pesante;

/**
 * Created by joepesante on 6/26/17.
 */
public class Magazine {

    private int magCapacity; //how many rounds does it hold
    private boolean magInserted;
    public boolean magEmpty =false;

    public int getMagCapacity() {
        return magCapacity;
    }

    public boolean isMagInserted() {
        return magInserted;
    }

    public Magazine(int magCapacity, boolean magInserted) {
        this.magCapacity = magCapacity;
        this.magInserted = magInserted;


    }

    public void loadMag() { // Note that I am using this app to practice composition and polymorphism

            System.out.println("magazine.loadMag() called. " + "Magazine is loaded, it holds " + magCapacity + " rounds");
    }

    public void insertMag(){
        if (magInserted)
        System.out.println("magazine.insertMag() called. " + "Magazine is inserted");
    }

    public void roundCount() {

        System.out.println(magCapacity + " rounds left in mag");
        if (magCapacity <= 0) {
            magCapacity = 0;
            magEmpty = true;
            System.out.println("mag empty");

        } else {
            magCapacity = magCapacity - 1;
        }

    }

}
