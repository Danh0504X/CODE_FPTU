/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week1;

/**
 *
 * @author ADMIN
 */
import java.util.*;

public class S10_LinearSearchApp  {

    private int[] array;
    private int size;
    private int searchValue;

    // Constructor
    public S10_LinearSearchApp(int size, int searchValue) {
        this.size = size;
        this.searchValue = searchValue;
        this.array = new int[size];
    }

    // Sinh mảng số nguyên ngẫu nhiên từ 0–9
    public void generateArray() {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10); // từ 0 đến 9
        }
    }

    // Hiển thị mảng
    public void displayArray() {
        System.out.print("The array: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // Tìm tuyến tính – trả về chỉ số đầu tiên tìm được, hoặc -1
    public int search() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                return i;
            }
        }
        return -1;
    }

    // Chạy chương trình
    public void run() {
        generateArray();
        displayArray();
        int index = search();
        if (index != -1) {
            System.out.println("Found " + searchValue + " at index: " + index);
        } else {
            System.out.println(searchValue + " not found in array.");
        }
    }

    // Hàm nhập và kiểm tra đầu vào
    public static int getPositiveInt(Scanner sc, String prompt) {
        int number;
        do {
            System.out.print(prompt);
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive number.");
                sc.next(); // bỏ giá trị sai
                System.out.print(prompt);
            }
            number = sc.nextInt();
            if (number <= 0) {
                System.out.println("Number must be positive. Try again.");
            }
        } while (number <= 0);
        return number;
    }
}

