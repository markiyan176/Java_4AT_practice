package aqa.course.task3;
import java.util.*;
public class Task3 {

    //V8.
    // Array Intersection: Write a Java program that takes two arrays of integers and finds their intersection.
    // Your program should prompt the user to enter the size and the elements of both arrays and then output the common elements between them.
    // Make HashSet of doubles from the result array and perform the following operations: a)Add an element to the end of the list;
    // b)Remove an element from the list; c)Replace an element in the list; d)Sort the list in alphabetical order; e)Print the elements of the list;
    // Make up the situation for ArithmeticException. Catch it and display the explanation for your custom case.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of first array: ");
        int length1 = scanner.nextInt();
        int[] arr1 = new int[length1];
        System.out.println("Enter numbers of first array: ");
        for (int i = 0; i < length1; i++) {
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Enter length of second array: ");
        int length2 = scanner.nextInt();
        int[] arr2 = new int[length2];
        System.out.println("Enter numbers of second array: ");
        for (int i = 0; i < length2; i++) {
            arr2[i] = scanner.nextInt();
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : arr2) {
            set2.add(num);
        }

        List<Integer> intersection = new ArrayList<>();
        for (int num : arr1) {
            if (set2.contains(num)) {
                intersection.add(num);
            }
        }

        System.out.println("Intersection: " + intersection);





        Set<Double> doubleSet = new HashSet<>();
        for (Integer num : intersection) {
            doubleSet.add(num.doubleValue());
        }

        System.out.println("HashSet<Double>: " + doubleSet);

        doubleSet.add(10.5);
        System.out.println("After adding 10.5: " + doubleSet);

        doubleSet.remove(10.5);
        System.out.println("After removing 10.5: " + doubleSet);

        List<Double> doubleList = new ArrayList<>(doubleSet);
        doubleList.set(0, 99.9);

        Collections.sort(doubleList);
        System.out.println("Sorted list: " + doubleList);

        System.out.println("Final elements:");
        for (Double d : doubleList) {
            System.out.println(d);
        }

        try {
            int a = 10;
            int b = 0;
            int c = a / b;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: You cannot divide by zero in this example!");
        }

        scanner.close();
    }
}
