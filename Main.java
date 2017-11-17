package com.pesante;
import java.util.Scanner;

public class Main {
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
        Magazine magazine = new Magazine(16, true);
        Handgun handgun = new Handgun("Glock", "19 Gen 5", "9mm", slide, frame, magazine);
        Magazine magazine2 = new Magazine(10, false);
        Handgun handgun2 = new Handgun("Heckler and Koch", "VP9", ".40", slide, frame, magazine);

        Slide arPistolUpper = new Slide("Standard", 1, true, 14.5, true, true);
        Frame arPistolLower = new Frame(1, "Right handed", true);
        Magazine arMagazine = new Magazine(30, true);
        //ARPistol arpistol = new Handgun("DPMS","Panther",".223 / 5.56", arPistolUpper, arPistolLower,arMagazine);
        Handgun arPistol = new ARPistol("DPMS", "Panther", ".223 / 5.56", arPistolUpper, arPistolLower, arMagazine);
        //arPistol.getSpecs();
        handgun.getSpecs();


        boolean quit = false;
        int choice;
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
                        if (b_shooterReady) {
                            //handgun.loadMagazine(); // this method loads the magazine with ammo
                            magazine.loadMag();
                            Magazine newMag = new Magazine(16,true);
                            newMag.loadMag();
                            b_magLoaded = true;

                        } else {
                            System.out.println(handgun + " - " + "shooter must be ready");
                        }
                        break;
                    case 3:
                        if
                                (b_shooterReady && b_magLoaded) {
                            b_magInserted = true;
                            handgun.insertMagazine(); // this method inserts the magazine
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
                       // int roundCount = 16;
                        if (b_shooterReady && b_magInserted && b_racked) {
                            handgun.triggerControl(); // this method pulls the trigger
                            handgun.fire(); // this method shows the gun has fired
                            //magazine.roundCount();
                           // roundCount = roundCount -1;
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

    public static void secondMenuOption() {

        int secondMenuOption =0;
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
                    break;

                case 2:
                    b_shooterReady = false;
//                    b_magInserted = false;  // // removed these two and added further logic to menuOptions switch case 2-5
//                    b_racked = false;
                    break;

            }


        } while (!isValidSecondMenuOption(choice));

    }

}


// Note:  Make it so when the slide is racked, one round is removed from the magazine ie. 16 rounds in mag
// is now 15.  Also, when the handgun is fired reduce magazine count by one. I'll need to use a simple int , with the sum minus the sum is incremented.







