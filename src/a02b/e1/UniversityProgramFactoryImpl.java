package a02b.e1;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class UniversityProgramFactoryImpl implements UniversityProgramFactory {

    @Override
    public UniversityProgram flexible() {
        return new UniversityProgramAbs() {

            @Override
            boolean checkValid(Set<String> courseNames) {
                int sum = courses.stream()
                    .filter(c -> courseNames.contains(c.getName()))
                    .mapToInt(Course::getCredits)
                    .sum();
                return sum == 60 ? true : false;
            }
            
        };

    }

    @Override
    public UniversityProgram scientific() {
        return new UniversityProgramAbs() {

            @Override
            boolean checkValid(Set<String> courseNames) {
                List<Course> validCourses = courses.stream().filter(c -> courseNames.contains(c.getName())).toList();

                boolean valid = true;
                valid = validCourses.stream().mapToInt(Course::getCredits).sum() == 60 ? true : false;
                
                boolean checkMaths = getCourseCredits(validCourses, Sector.MATHEMATICS) >= 12;

                boolean checkComputerScience = getCourseCredits(validCourses, Sector.COMPUTER_SCIENCE) >= 12;

                boolean checkPhysics = getCourseCredits(validCourses, Sector.PHYSICS) >= 12;

                return valid && checkMaths & checkComputerScience && checkPhysics;
            }
            
        };
    }

    @Override
    public UniversityProgram shortComputerScience() {
        return new UniversityProgramAbs() {

            @Override
            boolean checkValid(Set<String> courseNames) {
                List<Course> validCourses = courses.stream().filter(c -> courseNames.contains(c.getName())).toList();

                boolean valid = true;
                valid = validCourses.stream().mapToInt(Course::getCredits).sum() >= 48 ? true : false;

                int checkEngineering = getCourseCredits(validCourses, Sector.COMPUTER_ENGINEERING);

                int checkComputerScience = getCourseCredits(validCourses, Sector.COMPUTER_SCIENCE);

                return valid && checkComputerScience + checkEngineering >= 30;
            }
            
        };
    }

    @Override
    public UniversityProgram realistic() {
        return new UniversityProgramAbs() {

            @Override
            boolean checkValid(Set<String> courseNames) {
                List<Course> validCourses = courses.stream().filter(c -> courseNames.contains(c.getName())).toList();

                boolean valid = true;
                valid = validCourses.stream().mapToInt(Course::getCredits).sum() == 120 ? true : false;

                int checkCompEng = getCourseCredits(validCourses, Sector.COMPUTER_ENGINEERING);

                int checkCompScience = getCourseCredits(validCourses, Sector.COMPUTER_SCIENCE);

                int checkPhysics = getCourseCredits(validCourses, Sector.PHYSICS);

                int checkMaths = getCourseCredits(validCourses, Sector.MATHEMATICS);

                return valid && (checkCompScience + checkCompEng >= 60) && (checkMaths + checkPhysics <= 18);
            }
            
        };
    }

    private int getCourseCredits(Collection<Course> courses, UniversityProgram.Sector sector) {
        return courses.stream()
            .filter(c -> c.getSector().equals(sector))
            .mapToInt(Course::getCredits)
            .sum();
    }

}
