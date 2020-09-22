package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer = new Employer();
    private Location location = new Location();
    private PositionType positionType = new PositionType();
    private CoreCompetency coreCompetency = new CoreCompetency();

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {
        String noData = "Data not available";
        String employeeData = "";
        String locationData = "";
        String positionData = "";
        String coreData = "";

        if (name == null && employer.getValue() == null && location.getValue() == null && positionType.getValue() == null && coreCompetency.getValue() == null){
            return "OOPS! This job does not seem to exist.";
        } else {

            if (name == null) {
                name = noData;
            }

            if (employer == null || employer.getValue() == null) {
                employeeData += noData;
            } else {
                employeeData += employer.getValue();
            }

            if (location == null || location.getValue() == null) {
                locationData += noData;
            } else {
                locationData += location.getValue();
            }

            if (positionType == null || positionType.getValue() == null) {
                positionData += noData;
            } else {
                positionData += positionType.getValue();
            }

            if (coreCompetency == null || coreCompetency.getValue() == null) {
                coreData += noData;
            } else {
                coreData += coreCompetency.getValue();
            }

            return "\n" +
                    "ID: " + id + "\n" +
                    "Name: " + name + "\n" +
                    "Employer: " + employeeData + "\n" +
                    "Location: " + locationData + "\n" +
                    "PositionType: " + positionData + "\n" +
                    "Core Competency: " + coreData + "\n";
        }
    }
}

