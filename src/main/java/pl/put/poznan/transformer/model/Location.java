package pl.put.poznan.transformer.model;

public abstract class Location {

    private final long id;
    private final String name;

    protected Location(long id, String name) {
        this.id = id;
        this.name = name;
    }

    //#3
    public abstract float calculateArea();
    //#4
    public abstract float calculateVolume();
    //#5
    public abstract float calculateLight();
    //#6
    public abstract float calculateHeating();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}