package domain;

import application.dto.MerlinEngineDTO;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

    private String id;
    private final List<MerlinEngine> engines = new ArrayList<MerlinEngine>();
    private int totalPower = 0;
    private int maxPower = 0;


    public Rocket(String id) throws Exception {
        if (id.length() != 8) {
            throw new Exception();
        }
        this.id = id;

    }

    public void maxPowerEngine(int maxPowerEngine) {
        MerlinEngine engine = new MerlinEngine(maxPowerEngine);
        engines.add(engine);
        maxPower = maxPowerEngine;

    }

    public void acceleration() {
        totalPower = 0;
        for (int i = 0; i < engines.size(); i++) {
            engines.get(i).morePower();
            totalPower += engines.get(i).getPower();
        }
    }

    public void desacceleration() {
        totalPower = 0;
        for (int i = 0; i < engines.size(); i++) {
            engines.get(i).lessPower();
            totalPower += engines.get(i).getPower();
        }
    }

    public int getTotalPower() {
        return totalPower;
    }

    public int getMaxPower() {
        int totalMaxPower = 0;
        for (int i = 0; i < engines.size(); i++) {
            totalMaxPower += engines.get(i).getMaxPower();
        }
        return totalMaxPower;
    }

    public List<MerlinEngine> getEngines() {
        return engines;
    }

    public String getId() {
        return id;
    }

}
