
def income_tax(gross_salary: float) -> float:

    cummulative_income = [402, 512, 642, 3642, 20037, 50000]

    cummulative_tax = [0, 5.5, 18.5, 543.5, 4642.25, 13631.15]

    tax_rates = [0, 0.05, 0.1, 0.175, 0.25, 0.3, 0.35]

    if gross_salary< 402:
        print("No tax was decucted hence your net salary is", gross_salary)
        return gross_salary
    else:
        for income in reversed(cummulative_income):
            if income <= gross_salary:
                highest_cummulative_income = income
                for index, number in enumerate(cummulative_income):
                    if number == highest_cummulative_income:
                        tax_income = cummulative_tax[index]
                        remaining_salary = gross_salary - highest_cummulative_income
                        tax_remaining_salary = tax_rates[index + 1] * remaining_salary
                        tax = tax_income + tax_remaining_salary
                        net_salary = gross_salary - tax
                        print("The tax on your gross salary", gross_salary, "is", tax, ".")
                        print("Your net salary is", net_salary, ".")
                break
        return net_salary

salary = float(input("Please enter your gross salary: "))

print(income_tax(salary))

        

        

        

        

    