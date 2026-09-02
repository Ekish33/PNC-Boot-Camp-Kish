import java.util.Scanner;

public class BillSummary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Product name: ");
        // TODO: read name
        String name = scanner.nextLine();

        System.out.print("Quantity: ");
        // TODO: read qty (nextLine + Integer.parseInt)
        int qty = Integer.parseInt(scanner.nextLine());

        System.out.print("Unit price: ");
        // TODO: read price (nextLine + Double.parseDouble)
        double price = Double.parseDouble(scanner.nextLine());

        // TODO: compute total, 10% discount, and final amount
        double total = qty*price;           // qty * price
        double discount = total * .10;        // 10% of total
        double finalAmount = total - discount;     // total - discount

        System.out.println("--- Bill Summary ---");
        // TODO: print Product, Quantity, Unit price, Total, Discount (10%), Final amount
        // hints: %.2f for money; use 10%% in the format string to print a literal %
        System.out.printf("Product%s | Qauntity%d | Unit price%.2f | Total%.2f | Discount 10%% | Final amount%.2f", name, qty, price, total,finalAmount);
        scanner.close();
    }
}