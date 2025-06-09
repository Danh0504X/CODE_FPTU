/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */



/**
 *
 * @author ADMIN
 */
public class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.insert(new Employee(104, "Nam Nguyen", "HR", 5));
        tree.insert(new Employee(102, "Linh Phan", "IT", 1));
        tree.insert(new Employee(103, "Minh Le", "Finance", 3));
        tree.insert(new Employee(101, "Ngoc Nguyen", "IT", 6));
        tree.insert(new Employee(107, "Huong Pham", "Finance", 3));
        tree.insert(new Employee(106, "Tuan Tran", "Finance", 2));
        tree.insert(new Employee(108, "Hang Le", "IT", 4));
        tree.insert(new Employee(105, "Hung Nguyen", "IT", 5));

        System.out.println("In-order traversal:");
        tree.inOrder();

        System.out.println("\nSearch for 'Minh Le':");
        Employee e = tree.searchByName("Minh Le");
        if (e != null) System.out.println(e);
        else System.out.println("Not found");

        System.out.println("\nIs BST balanced? " + tree.isBalanced());

        System.out.println("\nDelete ID 108:");
        tree.delete(108);
        tree.inOrder();
        System.out.println("Is BST balanced after deletion? " + tree.isBalanced());

        System.out.println("\nEmployee with highest seniority:");
        System.out.println(tree.findMaxSeniority());
    }
}
    class Employee {
    int id;
    String name;
    String department;
    int seniority;

    public Employee(int id, String name, String department, int seniority) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.seniority = seniority;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Seniority: " + seniority;
        }   
    }
   
    class Node {
    Employee data;
    Node left, right;

    public Node(Employee data) {
        this.data = data;
        this.left = null;
        this.right = null;
        }
    }
    
    class BST {
    Node root;

    public void insert(Employee emp) {
        root = insertRec(root, emp);
    }

    private Node insertRec(Node root, Employee emp) {
        if (root == null) return new Node(emp);
        if (emp.id < root.data.id) root.left = insertRec(root.left, emp);
        else root.right = insertRec(root.right, emp);
        return root;
    }
    
    public void delete(int id) {
        root = deleteRec(root, id);
    }

    
    private Node deleteRec(Node root, int id) {
        if (root == null) return null;

        if (id < root.data.id) root.left = deleteRec(root.left, id);
        else if (id > root.data.id) root.right = deleteRec(root.right, id);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            root.data = findMin(root.right);
            root.right = deleteRec(root.right, root.data.id);
        }
        return root;
    }
    
        public Employee findMaxSeniority() {
        return findMaxSeniorityRec(root, null);
    }

    private Employee findMaxSeniorityRec(Node root, Employee currentMax) {
        if (root == null) return currentMax;
        if (currentMax == null || root.data.seniority > currentMax.seniority) {
            currentMax = root.data;
        }
        currentMax = findMaxSeniorityRec(root.left, currentMax);
        return findMaxSeniorityRec(root.right, currentMax);
    }

    private Employee findMin(Node root) {
        while (root.left != null) root = root.left;
        return root.data;
    }

        public boolean isBalanced() {
        return checkHeight(root) != -1;
    }

    private int checkHeight(Node root) {
        if (root == null) return 0;
        int left = checkHeight(root.left);
        int right = checkHeight(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
    
        public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.data);
            inOrderRec(root.right);
        }
    }

        public Employee searchByName(String name) {
        return searchByNameRec(root, name);
    }

    private Employee searchByNameRec(Node root, String name) {
        if (root == null) return null;
        if (root.data.name.equals(name)) return root.data;

        Employee leftResult = searchByNameRec(root.left, name);
        if (leftResult != null) return leftResult;

        return searchByNameRec(root.right, name);
    }
}

