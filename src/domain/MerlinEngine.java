/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 * @author David Baqués <dbaques@gmail.com>
 */
public class MerlinEngine {

    private final int maxPower;
    private int power = 0;

    MerlinEngine(int maxPower) {
        this.maxPower = maxPower;
    }


    public void morePower() {
        this.power += 10;
        if (this.power > this.maxPower) {
            this.power = this.maxPower;
        }
    }

    public void lessPower() {
        this.power -= 10;
        if (0 >= this.power) {
            this.power = 0;
        }
    }

    public int getPower() {
        return this.power;
    }

    public int getMaxPower() {
        return this.maxPower;
    }

}
