package aqa.course.task2;

public class Main {
    //V 8: StringBuilder
    // Objective: To understand and use the StringBuilder class in Java.
    // Instructions: //Use the StringBuilder class to build a string by appending characters.
    // Print the result to the console.


    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        for (char i = 'a'; i <= 'z'; i++) {
            stringBuilder.append(i);
        }

        System.out.println(stringBuilder.toString());
    }
}
