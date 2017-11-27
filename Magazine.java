package com.pesante;

/**
 * Created by joepesante on 6/26/17.
 */
public class Magazine {

    public static int magCapacity; //how many rounds does it hold
    // private boolean isMagInserted;
    public static boolean isMagEmpty = true;


    public int getMagCapacity() {

        return this.magCapacity;
    }


    public Magazine(int magCapacity) {// boolean magInserted) {
        this.magCapacity = magCapacity;
        // this.isMagInserted = magInserted;


    }

    public static void loadMag() {
        //  isMagEmpty = false;
        System.out.println("magazine.loadMag() called. " + "Magazine is loaded, it holds " + magCapacity + " rounds");

    }

    public static void insertMag() {
        //if (isMagInserted)
        System.out.println("magazine.insertMag() called. " + "Magazine is inserted");
    }

    public static void roundVerification() {

        if (magCapacity <= 0) {
            magCapacity = 0;

        }

    }
}
