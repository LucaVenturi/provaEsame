package a02b.e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class UniversityProgramAbs implements UniversityProgram {

    protected final List<Course> courses;

    public UniversityProgramAbs() {
        this.courses = new ArrayList<>();
    }

    @Override
    public void addCourse(String name, Sector sector, int credits) {
        this.courses.add(new Course(name, sector, credits));
    }

    @Override
    public boolean isValid(Set<String> courseNames) {
        return checkValid(courseNames);
    }

    abstract boolean checkValid(Set<String> courseNames);
}
