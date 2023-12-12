package a02b.e1;

import a02b.e1.UniversityProgram.Sector;

public class Course {

    private final String name;
    private final UniversityProgram.Sector sector;
    private final int credits;
    
    public Course(String name, Sector sector, int credits) {
        this.name = name;
        this.sector = sector;
        this.credits = credits;
    }

    public String getName() {
        return this.name;
    }

    public UniversityProgram.Sector getSector() {
        return this.sector;
    }

    public int getCredits() {
        return this.credits;
    }
}
