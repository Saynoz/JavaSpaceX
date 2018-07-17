/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.dto;

import domain.MerlinEngine;
import domain.Rocket;

import java.util.ArrayList;
import java.util.List;

public class RocketDTO {

    private List<MerlinEngineDTO> engines = new ArrayList<MerlinEngineDTO>();
    private Rocket rocket;

    public RocketDTO(Rocket rocket) throws Exception  {
        if(rocket == null){
            throw new Exception();
        }
        this.rocket = rocket;
    }

    public String getId() {
        return rocket.getId();
    }

    public int getTotalPower()  {
        return rocket.getTotalPower();
    }

    public int getMaxPower() {
        return rocket.getMaxPower();
    }

    public List<MerlinEngineDTO> getEngines() throws Exception {
        for (MerlinEngine engine : rocket.getEngines()) {
            engines.add(new MerlinEngineDTO(engine));
        }
        return engines;
    }


}
