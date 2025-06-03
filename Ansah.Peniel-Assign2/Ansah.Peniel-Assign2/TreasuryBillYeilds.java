import java.util.Scanner;

public class TreasuryBillYields {

    // Method to compute the total value of the investment over a given period
    public static double computeInvestmentValue(double principal, double rate, int periodsPerYear, double deposit, int totalPeriods) {
        // Initialize totalAmount with the principal amount
        double totalAmount = principal;

        // Loop through each period and calculate the total amount
        for (int i = 0; i < totalPeriods; i++) {
            // Calculate interest for the current period
            double interest = totalAmount * (rate / periodsPerYear / 100);
            // Update totalAmount by adding interest and deposit for each period
            totalAmount += interest + deposit;
        }
        // Subtract the deposit for the initial period (since there is no deposit in the first period)
        totalAmount -= deposit;

        // Return the total investment value
        return totalAmount;
    }

    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the initial amount to invest (principal)
        System.out.print("Enter initial amount to invest (principal): ");
        double principal = scanner.nextDouble();

        // Prompt user to enter the yearly interest rate
        System.out.print("Enter yearly rate: ");
        double rate = scanner.nextDouble();

        // Prompt user to enter the number of times interest is compounded each year
        System.out.print("Enter number of times interest is compounded each year: ");
        int periodsPerYear = scanner.nextInt();

        // Prompt user to enter the amount added to the investment account in each period after the initial one
        System.out.print("Enter amount added to the investment account in each period after the initial one: ");
        double deposit = scanner.nextDouble();

        // Prompt user to enter the number of periods the investment will accrue over
        System.out.print("Enter number of periods the investment will accrue over: ");
        int totalPeriods = scanner.nextInt();
        
        // Close the Scanner to prevent resource leaks
        scanner.close();

        // Calculate the total value of the investment using the computeInvestmentValue method
        double totalValue = computeInvestmentValue(principal, rate, periodsPerYear, deposit, totalPeriods);
        
        // Calculate the total investment amount without interest
        double totalInvestment = principal + (totalPeriods - 1) * deposit;
        
        // Calculate the total interest earned over the investment period
        double totalInterestEarned = totalValue - totalInvestment;

        // Print the results
        System.out.println("Total value of the investment: " +"GHc"+ Math.round(totalValue * 100.0) / 100.0);
        System.out.println("Total interest earned over the period: " +"GHc"+ Math.round(totalInterestEarned * 100.0) / 100.0);
    }
}
