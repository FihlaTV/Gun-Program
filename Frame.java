package com.pesante;

/**
 * Created by joepesante on 6/26/17.
 */
public class Frame {

    private int trigger;
    private String magRelease; // right/left or ambidextrous
    private boolean safety; // yes or no

    public int getTrigger() {
        return trigger;
    }

    public String getMagRelease() {
        return magRelease;
    }

    public boolean isSafetyOn() {
        return safety;
    }

    public Frame(int trigger, String magRelease, boolean safety) {
        this.trigger = trigger;
        this.magRelease = magRelease;
        this.safety = safety;


    }

    public void triggerPulled(){

        System.out.println("frame.triggerPulled() called. " + "Trigger pulled");
    }
}
