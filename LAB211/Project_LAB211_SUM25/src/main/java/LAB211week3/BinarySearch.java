/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LAB211week3;

/**
 *
 * @author ADMIN
 */
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
    public static void execute(Scanner sc) {
        int n = Validator.getPositiveInt(sc, "Enter number of array: ");
        int[] arr = new int[n];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100); // random từ 0-99
        }

        // Sắp xếp mảng trước khi tìm kiếm
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        int searchVal = Validator.getValidInt(sc, "Enter search value: ");
        int index = binarySearch(arr, searchVal);

        if (index >= 0) {
            System.out.println("Found " + searchVal + " at index: " + index);
        } else {
            System.out.println(searchVal + " not found in array.");
        }
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }
}
