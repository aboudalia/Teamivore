package edu.umich.teamivore;

/**
 * Created by amine on 11/18/2014.
 */
public class Team {

    private int id;
    private String name;
    private String description;

    // ratings...
    // private int success
    // private int innovation
    // etc...

    public Team(int id, String name, String description) {

        this.id = id;
        this.name = name;
        this.description = description;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
