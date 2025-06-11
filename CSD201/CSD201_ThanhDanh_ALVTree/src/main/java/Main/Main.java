/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Main;

/**
 *
 * @author ADMIN
 */
class Product {
    String productId;
    String name;
    double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "[" + productId + ", " + name + ", $" + price + "]";
    }
}

class AVLTreeNode {
    Product data;
    AVLTreeNode left, right;
    int height;

    public AVLTreeNode(Product data) {
        this.data = data;
        this.height = 1;
    }
}

class AVLTree {
    private AVLTreeNode root;

    private int height(AVLTreeNode n) {
        return n == null ? 0 : n.height;
    }

    private int getBalance(AVLTreeNode n) {
        return n == null ? 0 : height(n.left) - height(n.right);
    }

    private AVLTreeNode rightRotate(AVLTreeNode y) {
        AVLTreeNode x = y.left;
        AVLTreeNode T2 = x.right;
        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVLTreeNode leftRotate(AVLTreeNode x) {
        AVLTreeNode y = x.right;
        AVLTreeNode T2 = y.left;
        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(Product p) {
        root = insertRec(root, p);
    }

    private AVLTreeNode insertRec(AVLTreeNode node, Product p) {
        if (node == null) return new AVLTreeNode(p);

        if (p.productId.compareTo(node.data.productId) < 0)
            node.left = insertRec(node.left, p);
        else if (p.productId.compareTo(node.data.productId) > 0)
            node.right = insertRec(node.right, p);
        else return node; 

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && p.productId.compareTo(node.left.data.productId) < 0)
            return rightRotate(node);
        if (balance < -1 && p.productId.compareTo(node.right.data.productId) > 0)
            return leftRotate(node);
        if (balance > 1 && p.productId.compareTo(node.left.data.productId) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && p.productId.compareTo(node.right.data.productId) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void delete(String id) {
        root = deleteRec(root, id);
    }

    private AVLTreeNode deleteRec(AVLTreeNode node, String id) {
        if (node == null) return null;

        if (id.compareTo(node.data.productId) < 0)
            node.left = deleteRec(node.left, id);
        else if (id.compareTo(node.data.productId) > 0)
            node.right = deleteRec(node.right, id);
        else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                AVLTreeNode minLargerNode = minValueNode(node.right);
                node.data = minLargerNode.data;
                node.right = deleteRec(node.right, minLargerNode.data.productId);
            }
        }

        if (node == null) return null;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private AVLTreeNode minValueNode(AVLTreeNode node) {
        AVLTreeNode current = node;
        while (current.left != null)
            current = current.left;
        return current;
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(AVLTreeNode node) {
        if (node != null) {
            inOrderRec(node.left);
            System.out.print(node.data + " ");
            inOrderRec(node.right);
        }
    }

    public Product findMaxPrice() {
        return findMaxPriceRec(root, root.data);
    }

    private Product findMaxPriceRec(AVLTreeNode node, Product currentMax) {
        if (node == null) return currentMax;
        if (node.data.price > currentMax.price) currentMax = node.data;
        currentMax = findMaxPriceRec(node.left, currentMax);
        return findMaxPriceRec(node.right, currentMax);
    }

    public Product findMinPrice() {
        return findMinPriceRec(root, root.data);
    }

    private Product findMinPriceRec(AVLTreeNode node, Product currentMin) {
        if (node == null) return currentMin;
        if (node.data.price < currentMin.price) currentMin = node.data;
        currentMin = findMinPriceRec(node.left, currentMin);
        return findMinPriceRec(node.right, currentMin);
    }
}

