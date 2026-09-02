import java.util.Scanner;   // Scanner lives in java.util — must import it

public class PersonalDetails {
    public static void main(String[] args) {
        // TODO: create a Scanner reading from System.in
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        // TODO: read the whole line as a String
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        // TODO: read an int with nextInt()
        //int age = Integer.parseInt(scanner.nextLine()); inline way
        String ageLine = scanner.nextLine(); //broken up version where nextline consumes the enter newline call and gets the number as a string
        int age = Integer.parseInt(ageLine); //age is then converted into a integer by parsing the string

        // TODO: consume the leftover newline after nextInt() (critical!)
        // scanner._____;

        System.out.print("Enter your city: ");
        // TODO: read the city with nextLine()
        String city = scanner.nextLine();

        // TODO: print a greeting with printf — %s for strings, %d for age, %n for newline
        System.out.printf("Hello, %s! You are %d years old and live in %s.%n",  name, age, city);

        scanner.close();
    }
}