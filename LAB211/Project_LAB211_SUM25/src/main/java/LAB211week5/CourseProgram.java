package LAB211week5;

import java.util.Scanner;

public class CourseProgram {
    public static void start(Scanner sc) {
        CourseManager manager = new CourseManager(sc);
        int choice;
        do {
            System.out.println("*** Course Management ***");
            System.out.println("1. Add online course/ offline course");
            System.out.println("2. Update course");
            System.out.println("3. Delete course");
            System.out.println("4. Print all / online course / offline course");
            System.out.println("5. Search information base on course name");
            System.out.println("6. Exit");
            System.out.print("You choose: ");
            choice = Validator.getChoice(sc, 1, 6);
            switch (choice) {
                case 1:
                    manager.addCourse();
                    break;
                case 2:
                    manager.updateCourse();
                    break;
                case 3:
                    manager.deleteCourse();
                    break;
                case 4:
                    manager.printCourses();
                    break;
                case 5:
                    manager.searchCourseByName();
                    break;
                case 6:
                    System.out.println("BYE AND SEE YOU NEXT TIME");
                    break;
            }
        } while (choice != 6);
    }
} 