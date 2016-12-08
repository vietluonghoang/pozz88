/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import interfaces.Team;

/**
 *
 * @author Rypon
 */
public class SoccerTeam implements Team {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null) {
            name = "";
        }
        if (name.isEmpty()) {
            this.name = "---";
        } else {
            this.name = name;
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
