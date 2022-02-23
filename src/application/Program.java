package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		sc.nextLine();
		for (int i=1 ; i<=n ; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or Company (i/c)?" );
			char response = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();
			
			if(response == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();
				list.add(new Individual(name, anualIncome, healthExpenditures));
			}else {
				System.out.print("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				list.add(new Company(name, anualIncome, numberOfEmployees));
			}
		}
			System.out.println();
			System.out.println("TAXES PAID: ");
			for(TaxPayer c : list) {
				System.out.println(c.getName() + ": $ " + String.format("%.2f", c.tax()));
			}
			System.out.println();
			System.out.print("TOTAL TAXES: $ ");
			int sum = 0;
			for(TaxPayer c : list) {
				sum += c.getAnualIncome();
			}
			System.out.println(sum);
		
				
				
		sc.close();
	}

}
