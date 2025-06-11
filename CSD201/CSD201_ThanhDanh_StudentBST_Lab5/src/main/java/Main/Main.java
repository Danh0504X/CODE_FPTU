/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Main;

/**
 *
 * @author ADMIN
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentBST bst = new StudentBST();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n========== STUDENT MANAGEMENT ==========");
            System.out.println("1. Insert a student");
            System.out.println("2. Traverse (In-order)");
            System.out.println("3. Search student by ID");
            System.out.println("4. Delete student by ID");
            System.out.println("5. Find student with highest score");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student score: ");
                    double score = scanner.nextDouble();
                    scanner.nextLine();
                    bst.insert(new Student(id, name, score));
                    System.out.println("Student inserted successfully.");
                    break;

                case 2:
                    System.out.println("Student list (In-order):");
                    bst.traverseInOrder();
                    break;

                case 3:
                    System.out.print("Enter student ID to search: ");
                    String searchId = scanner.nextLine();
                    Student found = bst.search(searchId);
                    if (found != null) {
                        System.out.println("Student found: " + found);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = scanner.nextLine();
                    bst.delete(deleteId);
                    System.out.println("If student existed, it has been deleted.");
                    break;

                case 5:
                    Student topStudent = bst.findMaxScore();
                    if (topStudent != null)
                        System.out.println("Student with the highest score: " + topStudent);
                    else
                        System.out.println("No students in the tree.");
                    break;

                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

class StudentBST {
    private Node root;

    public void insert(Student s) {
        root = insertRec(root, s);
    }

    private Node insertRec(Node node, Student s) {
        if (node == null) return new Node(s);
        if (s.studentId.compareTo(node.data.studentId) < 0)
            node.left = insertRec(node.left, s);
        else if (s.studentId.compareTo(node.data.studentId) > 0)
            node.right = insertRec(node.right, s);
        return node;
    }

    public void traverseInOrder() {
        traverseInOrderRec(root);
        System.out.println();
    }

    private void traverseInOrderRec(Node node) {
        if (node != null) {
            traverseInOrderRec(node.left);
            System.out.println(node.data);
            traverseInOrderRec(node.right);
        }
    }

    public Student search(String id) {
        return searchRec(root, id);
    }

    private Student searchRec(Node node, String id) {
        if (node == null) return null;
        if (id.equals(node.data.studentId)) return node.data;
        if (id.compareTo(node.data.studentId) < 0)
            return searchRec(node.left, id);
        else
            return searchRec(node.right, id);
    }

    public void delete(String id) {
        root = deleteRec(root, id);
    }

    private Node deleteRec(Node node, String id) {
        if (node == null) return null;

        if (id.compareTo(node.data.studentId) < 0)
            node.left = deleteRec(node.left, id);
        else if (id.compareTo(node.data.studentId) > 0)
            node.right = deleteRec(node.right, id);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node minNode = minValueNode(node.right);
            node.data = minNode.data;
            node.right = deleteRec(node.right, minNode.data.studentId);
        }

        return node;
    }

    private Node minValueNode(Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    public Student findMaxScore() {
        return findMaxScoreRec(root, root != null ? root.data : null);
    }

    private Student findMaxScoreRec(Node node, Student currentMax) {
        if (node == null) return currentMax;
        if (node.data.score > currentMax.score) currentMax = node.data;
        currentMax = findMaxScoreRec(node.left, currentMax);
        return findMaxScoreRec(node.right, currentMax);
    }
}

class Node {
    Student data;
    Node left, right;

    public Node(Student data) {
        this.data = data;
    }
}

class Student {
    String studentId;
    String name;
    double score;

    public Student(String studentId, String name, double score) {
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return "[" + studentId + " - " + name + " - " + score + "]";
    }
}
