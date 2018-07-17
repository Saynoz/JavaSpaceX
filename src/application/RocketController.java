/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import application.dto.RocketDTO;
import domain.Rocket;
import java.util.ArrayList;
import java.util.List;
import repository.RocketRepository;

public class RocketController {

    RocketRepository repository = new RocketRepository();

    public void createRocket(String id) throws Exception {
        Rocket rocket = new Rocket(id);
        repository.addRocket(rocket);
    }
    public void createRocket(String id, int[] maxPowerEngine) throws Exception {
        Rocket rocket = new Rocket(id);
        repository.addRocket(rocket);
        for(int i=0; i<maxPowerEngine.length; i++){
            addEngine(id, maxPowerEngine[i]);
        }

    }

    public void addEngines(String id, int[] maxPowerEngine) {
        for(int i=0; i<maxPowerEngine.length; i++) {
            repository.getRocketbyID(id).maxPowerEngine(maxPowerEngine[i]);
        }
    }
    public void addEngine(String id, int maxPower) {
        repository.getRocketbyID(id).maxPowerEngine(maxPower);
    }

    public void increasePower(String id)  {
        repository.getRocketbyID(id).acceleration();
    }

    public void decreasePower(String id)  {
        repository.getRocketbyID(id).desacceleration();
    }

    public int totalPower(String id)  {
        return repository.getRocketbyID(id).getTotalPower();
    }

    public int maxPower(String id)  {
        return repository.getRocketbyID(id).getMaxPower();
    }

    public List<RocketDTO> getRockets() throws Exception {
        List<RocketDTO> list = new ArrayList<>();
        for (Rocket i : RocketRepository.getRocket()) {
            list.add(new RocketDTO(i));
        }
        return list;
    }

}
