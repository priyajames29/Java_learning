// Lesson 1: Basics — types, variables, strings, conditionals, loops, arrays, methods
// Run with:  java Lesson1_Basics.java

public class Lesson1_Basics {

    // A "static" method belongs to the class itself (like a plain function in JS).
    // Every parameter and the return value must declare a type.
    static int add(int a, int b) {
        return a + b;
    }

    static String greet(String a){
        return "Hello " + a + "!";
    }

     // Every Java program starts at main(). This is the entry point.
    public static void main(String[] args) {

         // ---- 1. Variables and primitive types ----
        int age = 26;               // whole numbers (32-bit)
        long population = 1_400_000_000L; // big whole numbers (note the L)
        double price = 99.5;        // decimal numbers
        boolean isActive = true;    // true / false
        char grade = 'B';           // a single character, single quotes
        String name = "Priya";      // text, double quotes (String is an object, capital S)

        final int MAX_TASKS = 10;    // "final" ≈ const in JS — cannot be reassigned
        var city = "Bengaluru";     // "var" lets Java infer the type (still statically typed!)

        System.out.println("=== Variables ===");
        System.out.println(name + " is " + age + " years old and lives in " + city);
        System.out.println("Population: " + population + ", price: " + price);
        System.out.println("Active? " + isActive + ", grade: " + grade + ", max: " + MAX_TASKS);


         // ---- 2. Strings ----
        System.out.println("\n=== Strings ===");
        String language = "Java";
        System.out.println("Length: " + language.length());
        System.out.println("Upper: " + language.toUpperCase());
        // String.format is like a template literal
        System.out.println(String.format("%s has %d letters", language, language.length()));
        // IMPORTANT: compare strings with .equals(), NOT ==
        System.out.println("Equals 'Java'? " + language.equals("Java"));



        // ---- 3. Conditionals ----
        System.out.println("\n=== Conditionals ===");
        if (age >= 18) {
            System.out.println("Adult");
        } else {
            System.out.println("Minor");
        }
 
        // Modern switch expression (Java 14+) — returns a value
        String message = switch (grade) {
            case 'A' -> "Excellent";
            case 'B' -> "Good";
            default -> "Keep trying";
        };
        System.out.println("Grade message: " + message);


        // ---- 4. Loops ----
        System.out.println("\n=== Loops ===");
        for (int i = 1; i <= 3; i++) {
            System.out.println("for loop, i = " + i);
        }
 
        int count = 3;
        while (count > 0) {
            System.out.println("while loop, count = " + count);
            count--;
        }

         // ---- 5. Arrays (fixed size!) ----
        System.out.println("\n=== Arrays ===");
        int[] scores = {90, 75, 88};
        int total = 0;
        for (int score : scores) {   // "for-each" ≈ for (const score of scores)
            total += score;
        }
        System.out.println("Number of scores: " + scores.length);
        System.out.println("Total: " + total + ", average: " + (total / (double) scores.length));

         // ---- 6. Methods ----
        System.out.println("\n=== Methods ===");
        System.out.println("add(5, 7) = " + add(5, 7));
        System.out.println(greet(name));

    }
}

// Static vs. instance methods

// Java has two kinds of methods:

// Instance method (no static) belongs to each object. It runs on one specific object and can read that object’s fields through this.
// Static method belongs to the class itself. It runs without any object, so there is no this.