package LAB211week5;

import java.util.*;

public class CourseManager {
    private List<Course> courses = new ArrayList<>();
    private Scanner sc;

    public CourseManager(Scanner sc) {
        this.sc = sc;
    }

    public void addCourse() {
        System.out.println("*** Add new course ***");
        Course course = null;
        while (true) {
            System.out.print("Online (O) or Offline (F): ");
            String type = sc.nextLine().trim();
            if (type.equalsIgnoreCase("O")) {
                System.out.println("Create new online course");
                course = new OnlineCourse();
                break;
            } else if (type.equalsIgnoreCase("F")) {
                System.out.println("Create new offline course");
                course = new OfflineCourse();
                break;
            } else {
                System.out.println("Data input is invalid");
            }
        }
        while (true) {
            course.inputAll(sc);
            if (course.getCourseID().isEmpty() || course.getCourseName().isEmpty()) {
                System.out.println("Data input is invalid");
                continue;
            }
            if (isCourseIDExists(course.getCourseID())) {
                System.out.println("Data input is invalid, ID must be unique");
                continue;
            }
            if (isCourseNameExists(course.getCourseName())) {
                System.out.println("Data input is invalid, name must be unique");
                continue;
            }
            break;
        }
        courses.add(course);
    }

    public void updateCourse() {
        System.out.println("*** Update course ***");
        Course course = findCourseByIDPrompt();
        if (course == null) return;
        printCourseDetail(course);
        System.out.println("*** Updating ***");
        System.out.println("Note: Enter empty if you don't want to change it.");
        System.out.print("Course ID: ");
        String id = sc.nextLine().trim();
        if (!id.isEmpty() && !isCourseIDExists(id)) course.setCourseID(id);
        System.out.print("Course name: ");
        String name = sc.nextLine().trim();
        if (!name.isEmpty() && !isCourseNameExists(name)) course.setCourseName(name);
        System.out.print("Credits: ");
        String creditsStr = sc.nextLine().trim();
        if (!creditsStr.isEmpty()) {
            try {
                int credits = Integer.parseInt(creditsStr);
                if (credits > 0) course.setCredits(credits);
            } catch (Exception e) {}
        }
        if (course instanceof OnlineCourse) {
            OnlineCourse oc = (OnlineCourse) course;
            System.out.print("Platform: ");
            String platform = sc.nextLine().trim();
            if (!platform.isEmpty()) oc.setPlatform(platform);
            System.out.print("Instructors: ");
            String instructors = sc.nextLine().trim();
            if (!instructors.isEmpty()) oc.setInstructors(instructors);
            System.out.print("Note: ");
            String note = sc.nextLine().trim();
            if (!note.isEmpty()) oc.setNote(note);
        } else if (course instanceof OfflineCourse) {
            OfflineCourse ofc = (OfflineCourse) course;
            System.out.print("Begin: ");
            String begin = sc.nextLine().trim();
            if (!begin.isEmpty()) {
                try {
                    java.time.LocalDate b = java.time.LocalDate.parse(begin, java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy"));
                    if (b.isAfter(java.time.LocalDate.now())) ofc.setBegin(b);
                } catch (Exception e) {}
            }
            System.out.print("End: ");
            String end = sc.nextLine().trim();
            if (!end.isEmpty()) {
                try {
                    java.time.LocalDate e = java.time.LocalDate.parse(end, java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy"));
                    if (ofc.getBegin() != null && e.isAfter(ofc.getBegin())) ofc.setEnd(e);
                } catch (Exception e) {}
            }
            System.out.print("Campus: ");
            String campus = sc.nextLine().trim();
            if (!campus.isEmpty()) ofc.setCampus(campus);
        }
        System.out.println("Updated successfully");
    }

    public void deleteCourse() {
        System.out.println("*** Delete course ***");
        Course course = findCourseByIDPrompt();
        if (course == null) return;
        courses.remove(course);
        System.out.println("Deleted successfully");
    }

    public void printCourses() {
        System.out.println("*** Print course ***");
        System.out.print("Do you want to print all (A), online course (O) or offline course (F): ");
        String type = sc.nextLine().trim();
        if (type.equalsIgnoreCase("A")) {
            System.out.println("Course ID-Course name-Credits");
            for (Course c : courses) {
                System.out.printf("%s-%s-%d\n", c.getCourseID(), c.getCourseName(), c.getCredits());
            }
        } else if (type.equalsIgnoreCase("O")) {
            System.out.println("Course ID-Course name-Credits-Platform-Instructors-Note");
            for (Course c : courses) {
                if (c instanceof OnlineCourse) {
                    OnlineCourse oc = (OnlineCourse) c;
                    System.out.printf("%s-%s-%d-%s-%s-%s\n", oc.getCourseID(), oc.getCourseName(), oc.getCredits(), oc.getPlatform(), oc.getInstructors(), oc.getNote());
                }
            }
        } else if (type.equalsIgnoreCase("F")) {
            System.out.println("Course ID-Course name-Credits-Begin-End-Campus");
            for (Course c : courses) {
                if (c instanceof OfflineCourse) {
                    OfflineCourse ofc = (OfflineCourse) c;
                    String begin = ofc.getBegin() != null ? ofc.getBegin().format(java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy")) : "";
                    String end = ofc.getEnd() != null ? ofc.getEnd().format(java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy")) : "";
                    System.out.printf("%s-%s-%d-%s-%s-%s\n", ofc.getCourseID(), ofc.getCourseName(), ofc.getCredits(), begin, end, ofc.getCampus());
                }
            }
        }
    }

    public void searchCourseByName() {
        System.out.println("*** Searching ***");
        while (true) {
            System.out.print("Course ID: ");
            String id = sc.nextLine().trim();
            Optional<Course> found = courses.stream().filter(c -> c.getCourseID().equalsIgnoreCase(id)).findFirst();
            if (found.isPresent()) {
                System.out.println("*** Search results ***");
                printCourseDetail(found.get());
                return;
            } else {
                System.out.println("No data found, do you want to find again? (Y/N): ");
                String again = sc.nextLine().trim();
                if (!again.equalsIgnoreCase("Y")) return;
            }
        }
    }

    private boolean isCourseIDExists(String id) {
        return courses.stream().anyMatch(c -> c.getCourseID().equalsIgnoreCase(id));
    }
    private boolean isCourseNameExists(String name) {
        return courses.stream().anyMatch(c -> c.getCourseName().equalsIgnoreCase(name));
    }
    private Course findCourseByIDPrompt() {
        while (true) {
            System.out.print("Course ID: ");
            String id = sc.nextLine().trim();
            Optional<Course> found = courses.stream().filter(c -> c.getCourseID().equalsIgnoreCase(id)).findFirst();
            if (found.isPresent()) return found.get();
            System.out.println("No data found, do you want to find again? (Y/N): ");
            String again = sc.nextLine().trim();
            if (!again.equalsIgnoreCase("Y")) return null;
        }
    }
    private void printCourseDetail(Course c) {
        System.out.println("Course ID: " + c.getCourseID());
        System.out.println("Course name: " + c.getCourseName());
        System.out.println("Credits: " + c.getCredits());
        if (c instanceof OnlineCourse) {
            OnlineCourse oc = (OnlineCourse) c;
            System.out.println("Platform: " + oc.getPlatform());
            System.out.println("Instructors: " + oc.getInstructors());
            System.out.println("Note: " + oc.getNote());
        } else if (c instanceof OfflineCourse) {
            OfflineCourse ofc = (OfflineCourse) c;
            String begin = ofc.getBegin() != null ? ofc.getBegin().format(java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy")) : "";
            String end = ofc.getEnd() != null ? ofc.getEnd().format(java.time.format.DateTimeFormatter.ofPattern("d/M/yyyy")) : "";
            System.out.println("Begin: " + begin);
            System.out.println("End: " + end);
            System.out.println("Campus: " + ofc.getCampus());
        }
    }
} 