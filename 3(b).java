import java.util.Scanner;

class PiCalculator {
    private double pi;

    public PiCalculator(int terms) {
        double approx = 0.0;
        for (int i = 0; i < terms; i++) {
            approx += (i % 2 == 0 ? 1.0 : -1.0) * (4.0 / (2 * i + 1));
        }
        this.pi = approx;
    }

    public void displayPi() {
        System.out.println("Approximated Value of Pi: " + pi);
    }

    protected void displayInfo(int terms) {
        System.out.println("Calculated using Leibniz series with " + terms + " terms.");
    }

    void showData() {
        System.out.println("Internal Pi state successfully processed.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Pi Calculator using Access Specifiers ===");
        System.out.print("Enter the number of terms for Pi approximation: ");
        int terms = sc.nextInt();

        PiCalculator obj = new PiCalculator(terms);

        System.out.println("\nPublic Method - Displaying Result:");
        obj.displayPi();

        System.out.println("\nProtected Method - Displaying Precision Info:");
        obj.displayInfo(terms);

        System.out.println("\nPrivate Data - Accessed only within class:");
        obj.showData();

        sc.close();
    }
}