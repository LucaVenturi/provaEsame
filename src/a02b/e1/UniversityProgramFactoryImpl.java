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
                boolean valid = true;
                List<Course> validCourses = courses.stream().filter(c -> courseNames.contains(c.getName())).toList();
                valid = validCourses.stream().mapToInt(Course::getCredits).sum() == 60 ? true : false;
                
                boolean checkMaths = getCourseCredits(, Sector.MATHEMATICS) >= 12;

                boolean checkComputerScience = courses.stream()
                    .filter(c -> courseNames.contains(c.getName()))
                    .filter(c -> c.getSector().equals(Sector.COMPUTER_SCIENCE))
                    .mapToInt(Course::getCredits)
                    .sum() >= 12;

                boolean checkPhysics = courses.stream()
                    .filter(c -> courseNames.contains(c.getName()))
                    .filter(c -> c.getSector().equals(Sector.PHYSICS))
                    .mapToInt(Course::getCredits)
                    .sum() >= 12;
                return valid && checkMaths & checkComputerScience && checkPhysics;
            }
            
        };
    }

    @Override
    public UniversityProgram shortComputerScience() {
        return new UniversityProgramAbs() {

            @Override
            boolean checkValid(Set<String> courseNames) {
                boolean valid = true;
                valid = courses.stream().filter(c -> courseNames.contains(c.getName())).mapToInt(Course::getCredits).sum() >= 48 ? true : false;
                int checkEngineering = courses.stream()
                    .filter(c -> courseNames.contains(c.getName()))
                    .filter(c -> c.getSector().equals(Sector.COMPUTER_ENGINEERING))
                    .mapToInt(Course::getCredits)
                    .sum();

                int checkComputerScience = courses.stream()
                    .filter(c -> courseNames.contains(c.getName()))
                    .filter(c -> c.getSector().equals(Sector.COMPUTER_SCIENCE))
                    .mapToInt(Course::getCredits)
                    .sum();
                return valid && checkComputerScience + checkEngineering >= 30;
            }
            
        };
    }

    @Override
    public UniversityProgram realistic() {
        return new UniversityProgramAbs() {

            @Override
            boolean checkValid(Set<String> courseNames) {
                boolean valid = true;
                valid = courses.stream().filter(c -> courseNames.contains(c.getName())).mapToInt(Course::getCredits).sum() == 120 ? true : false;

                int checkCompEng = courses.stream()
                    .filter(c -> courseNames.contains(c.getName()))
                    .filter(c -> c.getSector().equals(Sector.COMPUTER_ENGINEERING))
                    .mapToInt(Course::getCredits)
                    .sum();

                int checkCompScience = courses.stream()
                    .filter(c -> courseNames.contains(c.getName()))
                    .filter(c -> c.getSector().equals(Sector.COMPUTER_SCIENCE))
                    .mapToInt(Course::getCredits)
                    .sum();

                int checkPhysics = courses.stream()
                    .filter(c -> courseNames.contains(c.getName()))
                    .filter(c -> c.getSector().equals(Sector.PHYSICS))
                    .mapToInt(Course::getCredits)
                    .sum();

                int checkMaths = courses.stream()
                    .filter(c -> courseNames.contains(c.getName()))
                    .filter(c -> c.getSector().equals(Sector.MATHEMATICS))
                    .mapToInt(Course::getCredits)
                    .sum();

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
