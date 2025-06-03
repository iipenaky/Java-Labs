import java.util.Scanner;

class EssentialsStore {

    // Method to calculate change breakdown and print the denominations
    public static double computeChangeBreakdown(double itemCost, double amountPaid) {
        // Array of denominations in decreasing order
        double denominations[] = {200, 100, 50, 20, 10, 5, 2, 1, 0.5, 0.2, 0.1, 0.05, 0.01};
        // Array to store the count of each denomination
        int numTimes[] = new int[13];
        // Calculate the balance (change)
        double theBalance = amountPaid - itemCost;
        //Convert the balance to 2 decimal places.
        double balance = Math.round(theBalance * 100.0) / 100.0;
        // Store the initial change amount for later return
        double change = amountPaid - itemCost;

        // Loop through each denomination to calculate the count of each
        for (int i = 0; i < denominations.length; i++) {
            // Calculate how many times the current denomination can be used
            double times = balance / denominations[i];
            // Store the count in the array
            numTimes[i] = (int) times;
            // Update the balance for the next iteration
            balance = balance % denominations[i];
        }

        // Print the breakdown of denominations
        System.out.println("You receive: ");
        for (int i = 0; i < denominations.length; i++) {
            if (numTimes[i] == 0) {
                // Skip printing if the count is zero
                continue;
            } else if (numTimes[i] == 1) {
                // Singular form if the count is 1
                if (denominations[i] < 1) {
                    System.out.println(numTimes[i] +" "+ (int) (denominations[i] * 100) + "p coin.");
                } else {
                    System.out.println(numTimes[i]+" " + "\u20B5" + (int) denominations[i] + " note");
                }
            } else {
                // Plural form if the count is greater than 1
                if (denominations[i] < 1) {
                    System.out.println(numTimes[i] + " " + (int) (denominations[i] * 100) + "p coins.");
                } else {
                    System.out.println(numTimes[i] + '\u20B5' + denominations[i] + " notes");
                }
            }
        }
        //Convert final change to 2 deimal places
        double finalChange = Math.round(change * 100.0) / 100.0;

        // Return the initial change amount
        return finalChange;
    }

    public static void main(String[] args) {
        // Create a Scanner object to take user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the amount paid to the cashier
        System.out.println("Please enter the amount you paid to the cashier: ");
        double amountGiven = scanner.nextDouble();

        // Prompt user to enter the cost of the items
        System.out.println("Please enter the cost of the items: ");
        double costItems = scanner.nextDouble();

        // Call the method to calculate and print the change breakdown
        double remainder = computeChangeBreakdown(costItems, amountGiven);
        System.out.println(remainder);

        scanner.close();
    }
}
