import java.util.Scanner;

public class IncomeTaxCalculator {

    public static double IncomeTax(double grossSalary){

        double[] cumulativeIncome = {402, 512, 642, 3642, 20037, 50000};
        double[] reversedCumulativeIncome = {50000, 20037, 3642, 642, 512, 402};
        double[] cumulativeTax = {0, 5.5, 18.5, 543.5, 4642.25, 13631.15};
        double[] taxRates = {0, 0.05, 0.1, 0.175, 0.25, 0.3, 0.35};

        double netSalary = 0;  

        if (grossSalary < 402) {
            System.out.println("No tax was deducted, hence your net salary is " + grossSalary);
        } else {
            
            double highestCumulativeIncome = 0;

            for (double income : reversedCumulativeIncome) {
                if (income <= grossSalary) {
                    highestCumulativeIncome = income;
                    break;
                }
            }

            for (int index = 0; index >= 0; index++) {
                if (cumulativeIncome[index] == highestCumulativeIncome) {
                    double taxIncome = cumulativeTax[index];
                    double remainingSalary = grossSalary - highestCumulativeIncome;
                    double taxRemainingSalary = taxRates[index + 1] * remainingSalary;
                    double tax = taxIncome + taxRemainingSalary;
                    netSalary = grossSalary - tax;  
                    System.out.println("The tax on your gross salary " + grossSalary + " is " + tax + ".");
                    System.out.println("Your net salary is " + netSalary + ".");
                    break;
                }
            }
        }
        return netSalary;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your gross salary: ");
        double grossSalary = scanner.nextDouble();

        double result = IncomeTax(grossSalary); 
    }
}
