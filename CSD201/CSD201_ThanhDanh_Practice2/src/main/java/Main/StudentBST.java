/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package Main;

import java.util.*;
/**
 *
 * @author ADMIN
 */
public class StudentBST {

    // Student record
    static class Student {
        int rollNumber;
        double score;

        Student(int rollNumber, double score) {
            this.rollNumber = rollNumber;
            this.score = score;
        }
    }

    static class Node {
        Student student;
        Node left, right;

        Node(Student student) {
            this.student = student;
        }
    }

    static Node insert(Node root, Student student) {
        Node newNode = new Node(student);
        if (root == null) return newNode;

        Node current = root, parent = null;
        while (current != null) {
            parent = current;
            if (student.rollNumber < current.student.rollNumber)
                current = current.left;
            else
                current = current.right;
        }

        if (student.rollNumber < parent.student.rollNumber)
            parent.left = newNode;
        else
            parent.right = newNode;

        return root;
    }

    static double averageScore(Node root) {
        int[] count = {0};
        double[] sum = {0.0};
        computeSum(root, count, sum);
        return count[0] == 0 ? 0 : sum[0] / count[0];
    }

    static void computeSum(Node node, int[] count, double[] sum) {
        if (node == null) return;
        sum[0] += node.student.score;
        count[0]++;
        computeSum(node.left, count, sum);
        computeSum(node.right, count, sum);
    }

    static List<Student> inOrder(Node root) {
        List<Student> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            result.add(current.student);
            current = current.right;
        }
        return result;
    }


    static Node sortedArrayToBST(List<Student> sortedStudents) {
        if (sortedStudents == null || sortedStudents.isEmpty()) return null;

        class StackNode {
            int left, right;
            Node parent;
            boolean isLeftChild;

            StackNode(int l, int r, Node p, boolean isLeft) {
                left = l;
                right = r;
                parent = p;
                isLeftChild = isLeft;
            }
        }

        Stack<StackNode> stack = new Stack<>();
        Node root = null;
        stack.push(new StackNode(0, sortedStudents.size() - 1, null, false));

        Map<Integer, Node> nodeMap = new HashMap<>();

        while (!stack.isEmpty()) {
            StackNode sn = stack.pop();
            if (sn.left > sn.right) continue;

            int mid = (sn.left + sn.right) / 2;
            Node newNode = new Node(sortedStudents.get(mid));
            nodeMap.put(mid, newNode);

            if (sn.parent == null) {
                root = newNode;
            } else {
                if (sn.isLeftChild)
                    sn.parent.left = newNode;
                else
                    sn.parent.right = newNode;
            }

            stack.push(new StackNode(mid + 1, sn.right, newNode, false));
            stack.push(new StackNode(sn.left, mid - 1, newNode, true));
        }

        return root;
    }

    static int treeHeight(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            height++;
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return height;
    }

    public static void main(String[] args) {
        Student[] A = {
            new Student(5, 5.5), new Student(3, 3.3), new Student(2, 2.2),
            new Student(4, 4.4), new Student(7, 7.7), new Student(6, 6.6),
            new Student(8, 8.8), new Student(1, 1.1), new Student(9, 9.9),
            new Student(10, 10.0)
        };

        Node T = null;
        for (Student s : A) {
            T = insert(T, s);
        }

        double avg = averageScore(T);
        System.out.printf("Average score: %.2f\n", avg);

        List<Student> B = inOrder(T);
        System.out.println("Sorted student records by roll number:");
        for (Student s : B) {
            System.out.printf("Roll: %d, Score: %.1f\n", s.rollNumber, s.score);
        }

        Node T2 = sortedArrayToBST(B);

        int height = treeHeight(T2);
        System.out.println("Height of balanced BST T2: " + height);
    }
}
