/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week4;

import java.util.*;

public class Main2 {
    private static List<Teacher> teacherList = new ArrayList<>();
    private static List<Student2> studentList = new ArrayList<>();

    public static void studentMenu(Scanner sc) {
        while (true) {
            System.out.println("*** Student Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            int c = Validator.getChoice(sc, 1, 3);
            switch (c) {
                case 1:
                    Student2 s = new Student2();
                    s.inputAll(sc);
                    studentList.add(s);
                    break;
                case 2:
                    studentList.stream()
                        .sorted(Comparator.comparing(Student2::getYearOfAdmission))
                        .forEach(Student2::display);
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void teacherMenu(Scanner sc) {
        while (true) {
            System.out.println("*** Teacher Management ***");
            System.out.println("1. Input");
            System.out.println("2. Print");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            int c = Validator.getChoice(sc, 1, 3);
            switch (c) {
                case 1:
                    Teacher t = new Teacher();
                    t.inputAll(sc);
                    teacherList.add(t);
                    break;
                case 2:
                    teacherList.stream()
                        .sorted(Comparator.comparing(Teacher::getYearInProfession).reversed())
                        .forEach(Teacher::display);
                    break;
                case 3:
                    return;
            }
        }
    }

    public static void personMenu(Scanner sc) {
        while (true) {
            System.out.println("*** Person Management ***");
            System.out.println("1. Search");
            System.out.println("2. Print all");
            System.out.println("3. Exit");
            System.out.print("You choose: ");
            int c = Validator.getChoice(sc, 1, 3);
            switch (c) {
                case 1:
                    String name = Validator.getString(sc, "Name: ");
                    List<Person> found = new ArrayList<>();
                    for (Teacher t : teacherList)
                        if (t.getFullName().toLowerCase().contains(name.toLowerCase()))
                            found.add(t);
                    for (Student2 s : studentList)
                        if (s.getFullName().toLowerCase().contains(name.toLowerCase()))
                            found.add(s);
                    if (found.isEmpty()) {
                        System.out.println("Result: not found");
                    } else {
                        found.stream()
                            .sorted(Comparator.comparing(Person::getYearOfBirth).reversed())
                            .forEach(Person::displayCommon);
                    }
                    break;
                case 2:
                    List<Person> all = new ArrayList<>();
                    all.addAll(teacherList);
                    all.addAll(studentList);
                    all.stream()
                        .sorted(Comparator.comparing(Person::getYearOfBirth).reversed())
                        .forEach(Person::displayCommon);
                    break;
                case 3:
                    return;
            }
        }
    }
    
    public static void assignment105Menu(Scanner sc) {
    int choice;
    do {
        System.out.println("*** Information Management ***");
        System.out.println("1. Teacher");
        System.out.println("2. Student");
        System.out.println("3. Person");
        System.out.println("4. Exit");
        System.out.print("You choose: ");
        choice = Validator.getChoice(sc, 1, 4);
        switch (choice) {
            case 1:
                teacherMenu(sc);
                break;
            case 2:
                studentMenu(sc);
                break;
            case 3:
                personMenu(sc);
                break;
        }
    } while (choice != 4);
}

}
