/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package application.dto;

import domain.MerlinEngine;

/**
 * @author David Baqués <dbaques@gmail.com>
 */
public class MerlinEngineDTO {
    private int maxPower;
    private int power = 0;

    MerlinEngineDTO(MerlinEngine engine) throws Exception {
        if (engine == null) {
            throw new Exception();
        }
        this.maxPower = engine.getMaxPower();
        this.power = engine.getPower();
    }


    public int getPower() {
        return this.power;
    }


    public int getMaxPower() {
        return this.maxPower;
    }
}
