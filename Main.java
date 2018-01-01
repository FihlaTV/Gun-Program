package com.pesante;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static  List<Handgun> handguns = new ArrayList<Handgun>();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean b_shooterReady = false;
    private static boolean b_magLoaded = false;
    private static boolean b_magInserted = false;
    private static boolean b_racked = false;
    private static boolean firstPrompt = true;

    private static boolean isValidMenuOption(int option) {
        if (option < 0 || option > 6) {
            System.out.println("Enter a valid option");

        }
        return option >= 0 && option <= 6;

    }

    private static boolean isValidSecondMenuOption(int option) {
        if (option < 1 || option > 2) {
            System.out.println("Enter a valid option");

        }
        return option >= 1 && option <= 2;

    }

    public static void main(String[] args) {
        //Handgun handgun = new Handgun(Slide,Frame ,Magazine,"Glock","G19","9mm")


        Slide slide = new Slide("Standard", 1, true, 4, true, false);
        Frame frame = new Frame(1, "Ambidextrous", false);
        Magazine magazine = new Magazine(16);
        Handgun handgun = new Handgun("Glock", "19 Gen 5", "9mm", slide, frame);
        Magazine magazine2 = new Magazine(10);
        Handgun handgun2 = new Handgun("Heckler and Koch", "VP9", ".40", slide, frame);


        Slide arPistolUpper = new Slide("Standard", 1, true, 14.5, true, true);
        Frame arPistolLower = new Frame(1, "Right handed", true);
        Magazine arMagazine = new Magazine(30);
        //ARPistol arpistol = new Handgun("DPMS","Panther",".223 / 5.56", arPistolUpper, arPistolLower,arMagazine);
        Handgun arPistol = new ARPistol("DPMS", "Panther", ".223 / 5.56", arPistolUpper, arPistolLower);
        //arPistol.getSpecs();
        // testing adding a list of handguns.
        handguns.add(handgun);
        handguns.add(handgun2);
        handguns.add(arPistol);
        printList(handguns);
        handgun.getSpecs();

        //handguns.add(new Handgun("HK","V","9mm",slide,frame,magazine));

        boolean quit = false;
        int choice;
        boolean reloaded = false;
        while (!quit) {

            do {
                System.out.println("Enter your choice: " + " Enter 0 to see the menu options");

                while (!scanner.hasNextInt()) {
                    System.out.println("Error! Integer only please");
                    System.out.println("Enter your choice: " + " Enter 0 to see the menu options");
                  scanner.next();
                }
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        menuOptions();
                        break;
                    case 1:
                        secondMenuOption();
                        break;
                    case 2:
                        // Currently, if you reload the mag, you can move directly to handgun.fire, which is not the correct logic.
                        // If entering case 2 a second time, require a insert magazine command (case 3), rack the slide (case 4, then fire.

                        if (b_shooterReady) {

                            Magazine newMag = new Magazine(16); // note: newMag isn't in the handgun constructor
                            newMag.loadMag();

                            b_magLoaded = true;


                        } else {
                            System.out.println(handgun + " - " + "shooter must be ready");
                        }
                        break;

                    case 3:

                            if (b_shooterReady && b_magLoaded) {
                                b_magInserted = true;

                                Magazine.insertMag(); // this method inserts the magazine into the frame.
                            } else {
                                System.out.println(handgun + " - " + " shooter must be ready and magazine must be loaded and inserted");
                            }
                            break;

                    case 4:

                        if (b_shooterReady && b_magInserted) {
                            b_racked = true;
                            handgun.getReady(); //this method racks the slide.

                        } else {
                            System.out.println(handgun + " - " + " magazine not inserted");
                                    }


                        break;
                    case 5:
                            if (b_shooterReady && b_magInserted && b_racked) {
                                handgun.triggerControl(); // this method pulls the trigger
                                handgun.fire(); // this method shows the gun has fired

                                if(Magazine.magCapacity == 0) {
                                    b_magInserted = false;
                                    b_racked = false;
                                }

                               // *** need to reset booleans, however they should be reset after entering case 5 for the first time.
                               // I could reset them with a round verification to round == 0, but if I reload when there are still 5 rounds
                               // in the mag, it creates a bug in my logic.
                               // b_magInserted = false;
                               // b_racked = false;


                            } else {
                                System.out.println(handgun + " - " + " no round chambered, cannot fire");
                            }

                        break;
                    case 6:

                        System.out.println("See you soon!");
                        quit = true;
                        System.exit(0);
                        break;

                }
            } while (isValidMenuOption(choice));
        }
    }


    public static void menuOptions() {
        System.out.println(" 0. Options");
        System.out.println(" 1. Confirm ready");
        System.out.println(" 2. Load Magazine"); // added logic 10/24/17. How can the handgun fire if the magazine wasn't loaded with ammo in the first place??
        System.out.println(" 3. Insert Magazine");
        System.out.println(" 4. Rack the slide");
        System.out.println(" 5. Fire the gun");
        System.out.println(" 6. Quit program");

    }

    private static void secondMenuOption() {

        int choice;

        do{
            System.out.println("Shooter ready? " + "Enter (1) for Yes or (2) for No?");

            while (!scanner.hasNextInt()) {
                System.out.println("Error! Integer only please");
                System.out.println("Shooter ready? Enter (1) for Yes or (2) for No?");
                scanner.next();
            }
           choice = scanner.nextInt();
           scanner.nextLine();

            switch (choice) {

                case 1:
                    b_shooterReady = true;
//                    b_magInserted = true;   // removed these two and added further logic to menuOptions switch case 2-5
//                    b_racked = true;
                    GunSafety.practiceSafety();
                    break;

                case 2:
                    b_shooterReady = false;
//                    b_magInserted = false;  // // removed these two and added further logic to menuOptions switch case 2-5
//                    b_racked = false;
                    break;

            }


        } while (!isValidSecondMenuOption(choice));

    }

    public static void printList(List<Handgun> list) {
        Iterator iterator = list.iterator();
        System.out.println("===========");
        System.out.println("You have " + handguns.size() + " guns saved to your list...\n" +
                " "  + iterator.next().toString());
        while(iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
        System.out.println("===========");

    }

}


// Note:  Make it so when the slide is racked, one round is removed from the magazine ie. 16 rounds in mag
// is now 15.  Also, when the handgun is fired reduce magazine count by one. I'll need to use a simple int , with the sum minus the sum is incremented.







