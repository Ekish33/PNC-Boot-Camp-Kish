
public class Test {
    public static void main(String[] args) {
        int score = 75;

        if (score >= 90) {
            System.out.println("The score is 90 or higher, so the grade is A.");
        } else if (score >= 80) {
            System.out.println("The score is between 80 and 89, so the grade is B.");
        } else if (score >= 70) {
            System.out.println("The score is between 70 and 79, so the grade is C.");
        } else if (score >= 60) {
            System.out.println("The score is between 60 and 69, so the grade is D.");
        } else {
            System.out.println("The score is below 60, so the student failed.");
        }
    }




}

