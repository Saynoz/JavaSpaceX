/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import domain.Rocket;

import java.util.ArrayList;
import java.util.List;

public class RocketRepository {

    public static List<Rocket> rockets = new ArrayList<>();

    public void addRocket(Rocket rocket) throws Exception {
        if (rockets == null) {
            throw new Exception();
        }
        RocketRepository.rockets.add(rocket);
    }

    public Rocket getRocketbyID(String id) {
        Rocket result = null;
        for (int i = 0; i < rockets.size(); i++) {
            if (rockets.get(i).getId().contentEquals(id)) {
                result = rockets.get(i);
            }
        }
        return result;
    }

    public static List<Rocket> getRocket() {
        return rockets;
    }

}
