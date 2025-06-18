/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class StudentManagement {
    private List<Student> studentList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void createStudent() {
        while (true) {
            String id = Validator.getString(sc,"Enter ID: ");
            String name = Validator.getString(sc,"Enter name: ");
            String semester = Validator.getString(sc,"Enter semester: ");
            String course = Validator.getCourse(sc,"Enter course (Java, .Net, C/C++): ");

            studentList.add(new Student(id, name, semester, course));

            System.out.print("Do you want to continue (Y/N)? ");
            if (!sc.nextLine().equalsIgnoreCase("Y")) {
                break;
            }
        }
    }

    public void findAndSortStudent() {
        String searchName = Validator.getString(sc, "Enter student name or part: ");
        List<Student> found = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getStudentName().toLowerCase().contains(searchName.toLowerCase())) {
                found.add(s);
            }
        }

        found.sort(Comparator.comparing(Student::getStudentName));

        if (found.isEmpty()) {
            System.out.println("No student found.");
        } else {
            for (Student s : found) {
                System.out.println(s.getStudentName() + " | " + s.getSemester() + " | " + s.getCourseName());
            }
        }
    }

    public void updateOrDeleteStudent() {
        String id = Validator.getString(sc, "Enter ID to find: ");
        List<Student> matched = new ArrayList<>();
        for (Student s : studentList) {
            if (s.getId().equalsIgnoreCase(id)) {
                matched.add(s);
            }
        }

        if (matched.isEmpty()) {
            System.out.println("No student found.");
            return;
        }

        for (int i = 0; i < matched.size(); i++) {
            System.out.println((i+1) + ". " + matched.get(i));
        }
        System.out.println("Choose index to update/delete:");
        int choice = Validator.getChoice(sc, 1, matched.size());
        Student selected = matched.get(choice - 1);

        String action = Validator.getString(sc, "Do you want to update (U) or delete (D)? ");
        if (action.equalsIgnoreCase("U")) {
            selected.setStudentName(Validator.getString(sc, "Enter new name: "));
            selected.setSemester(Validator.getString(sc, "Enter new semester: "));
            selected.setCourseName(Validator.getCourse(sc, "Enter new course: "));
            System.out.println("Student updated.");
        } else if (action.equalsIgnoreCase("D")) {
            studentList.remove(selected);
            System.out.println("Student deleted.");
        } else {
            System.out.println("Invalid action.");
        }
    }

    public void reportStudentCourse() {
        Map<String, Map<String, Integer>> reportMap = new LinkedHashMap<>();

        for (Student s : studentList) {
            String key = s.getStudentName() + " | " + s.getCourseName();
            reportMap.putIfAbsent(key, new HashMap<>());
            reportMap.get(key).put("count", reportMap.get(key).getOrDefault("count", 0) + 1);
        }

        for (String key : reportMap.keySet()) {
            System.out.println(key + " | " + reportMap.get(key).get("count"));
        }
    }
}