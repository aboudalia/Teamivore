package edu.umich.teamivore;

/**
 * Created by amine on 11/18/2014.
 */
public class Team {

    private String name;
    private String description;

    // ratings...
    // private int success
    // private int innovation
    // etc...

    public Team(String name, String description) {

        this.name = name;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
