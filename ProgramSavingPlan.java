package com.dhiyauddin.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgramSavingPlan {

	static Scanner input;
	static int yearForecastGlobal;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double numbers = 0.0;

		System.out.println("Please select your types of income : (Key in number e.g. 1 or 2 or 3)");
		System.out.println("1)Daily Income");
		System.out.println("2)Weekly Income");
		System.out.println("3)Monthly Income");

		input = new Scanner(System.in);
		String incomeTypeStr = input.nextLine();
		int incomeTypeInt = Integer.valueOf(incomeTypeStr);

		switch (incomeTypeInt) {
		case 1: {
			System.out.println("Daily Income Selected.");
			numbers = dailySaving();
			if (numbers > 0) {
				numbers = forecastDailyIncome(numbers);
				currencyConverter(numbers);
				break;
			}
		}
		case 2: {
			System.out.println("Weekly Income Selected.");
			numbers = weeklySaving();
			if (numbers > 0) {
				numbers = forecastWeeklyIncome(numbers);
				currencyConverter(numbers);
				break;
			}
		}
		case 3: {
			System.out.println("Monthly Income Selected.");
			numbers = monthlySaving();
			if (numbers > 0) {
				numbers = forecastMonthlyIncome(numbers);
				numbers = currencyConverter(numbers);
				break;
			}
		}
		}

		if (3 == incomeTypeInt) {
			System.out.println("To calculate Tax(SG-IRAS), please key in 'Y' to continue or 'N' to exit.");
			input = new Scanner(System.in);
			String nextProcess = "";
			nextProcess = input.nextLine().toUpperCase();
			if ("Y".equals(nextProcess)) {
				System.out.println("AmtBeforeTaxCalculation : " + numbers);
				numbers = taxCalculation(numbers);
				System.out.println("AmtAfterTaxCalculation : " + numbers);
				if (numbers > 0) {
					numbers = numbers * 0.15;
					System.out.println("Tax you need to pay is SGD " + numbers);
				} else {
					System.out.println("You no need to pay tax for this year.");
				}
			} else {
				System.out.println("Thank You for your time.");
			}
		}

	}

	static double currencyConverter(double numbers) {
		System.out.println("Please select your currency. (Key in number e.g. 1 or 2 or 3..");
		System.out.println("1)Malaysian Ringgit");
		System.out.println("2)Singapore Dollar");
		System.out.println("3)United State Dollar");
		System.out.println("4)Saudi Riyal");
		System.out.println("5)Bangladeshi Taka");
		System.out.println("6)Brunei Dollar");
		System.out.println("7)Chinese Yuan");
		System.out.println("8)Indian Rupee");
		System.out.println("9)Indonesian Rupiah");
		System.out.println("10)Philipine Peso");
		input = new Scanner(System.in);
		String currencySelected = input.nextLine();
		int currencySelectedInt = Integer.valueOf(currencySelected);
		Map<Integer, String> currencyMap = new HashMap<Integer, String>();
		currencyMap.put(1, "MYR");
		currencyMap.put(2, "SGD");
		currencyMap.put(3, "USD");
		currencyMap.put(4, "SAR");
		currencyMap.put(5, "BDT");
		currencyMap.put(6, "BND");
		currencyMap.put(7, "CNY");
		currencyMap.put(8, "INR");
		currencyMap.put(9, "IDR");
		currencyMap.put(10, "PHP");
		Map<String, Double> currencyValueMap = new HashMap<String, Double>();
		currencyValueMap.put("MYR", 1.0);
		currencyValueMap.put("SGD", 0.31);
		currencyValueMap.put("USD", 0.23);
		currencyValueMap.put("SAR", 0.86);
		currencyValueMap.put("BDT", 23.60);
		currencyValueMap.put("BND", 0.31);
		currencyValueMap.put("CNY", 1.59);
		currencyValueMap.put("INR", 18.72);
		currencyValueMap.put("IDR", 3556.18);
		currencyValueMap.put("PHP", 12.72);
		String currencyTypeStr = "";
		currencyTypeStr = currencyMap.get(currencySelectedInt);
		System.out.println(
				"Your saving in currency " + currencyTypeStr + ", please key in 'Y' to continue or 'N' to exit.");
		input = new Scanner(System.in);
		String nextProcess = "";
		nextProcess = input.nextLine().toUpperCase();
		double currencyValue = 0.0;
		double currencyResult = 0.0;
		if ("Y".equals(nextProcess)) {
			switch (currencyTypeStr) {
			case "MYR": {
				currencyValue = currencyValueMap.get(currencyTypeStr);
				currencyResult = numbers * currencyValue;
				break;
			}
			case "SGD": {
				currencyValue = currencyValueMap.get(currencyTypeStr);
				currencyResult = numbers * currencyValue;
				break;
			}
			case "USD": {
				currencyValue = currencyValueMap.get(currencyTypeStr);
				currencyResult = numbers * currencyValue;
				break;
			}
			case "SAR": {
				currencyValue = currencyValueMap.get(currencyTypeStr);
				currencyResult = numbers * currencyValue;
				break;
			}
			case "BDT": {
				currencyValue = currencyValueMap.get(currencyTypeStr);
				currencyResult = numbers * currencyValue;
				break;
			}
			case "BND": {
				currencyValue = currencyValueMap.get(currencyTypeStr);
				currencyResult = numbers * currencyValue;
				break;
			}
			case "CNY": {
				currencyValue = currencyValueMap.get(currencyTypeStr);
				currencyResult = numbers * currencyValue;
				break;
			}
			case "INR": {
				currencyValue = currencyValueMap.get(currencyTypeStr);
				currencyResult = numbers * currencyValue;
				break;
			}
			case "IDR": {
				currencyValue = currencyValueMap.get(currencyTypeStr);
				currencyResult = numbers * currencyValue;
				break;
			}
			case "PHP": {
				currencyValue = currencyValueMap.get(currencyTypeStr);
				currencyResult = numbers * currencyValue;
				break;
			}
			}
		} else {
			System.out.println("Thank You for your time");
		}
		System.out.println(
				"Result your saving in currency " + currencyTypeStr + " is " + currencyTypeStr + " " + currencyResult);
		return currencyResult;
	}

	static double forecastDailyIncome(double numbers) {
		System.out.println("How many years your request for forecast ?");
		input = new Scanner(System.in);
		String yearForecast = "";
		yearForecast = input.nextLine();
		int yearForecastInt = Integer.valueOf(yearForecast);
		yearForecastGlobal = yearForecastInt;
		System.out.println("Forecast for your saving in " + yearForecastInt
				+ " years, please key in 'Y' to continue or 'N' to exit.");
		input = new Scanner(System.in);
		String nextForecast = "";
		nextForecast = input.nextLine().toUpperCase();
		double forecastResult = 0.0;
		if ("Y".equals(nextForecast)) {
			forecastResult = numbers * 365 * yearForecastInt;
		} else {
			System.out.println("Thank Your for your time");
		}
		System.out.println("Result forcast for your saving : RM " + forecastResult);
		return forecastResult;
	}

	static double forecastWeeklyIncome(double numbers) {
		System.out.println("How many years your request for forecast ?");
		input = new Scanner(System.in);
		String yearForecast = "";
		yearForecast = input.nextLine();
		int yearForecastInt = Integer.valueOf(yearForecast);
		System.out.println("Forecast for your saving in " + yearForecastInt
				+ " years, please key in 'Y' to continue or 'N' to exit.");
		input = new Scanner(System.in);
		String nextForecast = "";
		nextForecast = input.nextLine().toUpperCase();
		double forecastResult = 0.0;
		if ("Y".equals(nextForecast)) {
			forecastResult = numbers * 52 * yearForecastInt;
		} else {
			System.out.println("Thank Your for your time");
		}
		System.out.println("Result forcast for your saving : RM " + forecastResult);
		return forecastResult;
	}

	static double forecastMonthlyIncome(double numbers) {
		System.out.println("How many years your request for forecast ?");
		input = new Scanner(System.in);
		String yearForecast = "";
		yearForecast = input.nextLine();
		int yearForecastInt = Integer.valueOf(yearForecast);
		System.out.println("Forecast for your saving in " + yearForecastInt
				+ " years, please key in 'Y' to continue or 'N' to exit.");
		input = new Scanner(System.in);
		String nextForecast = "";
		nextForecast = input.nextLine().toUpperCase();
		double forecastResult = 0.0;
		if ("Y".equals(nextForecast)) {
			forecastResult = numbers * 12 * yearForecastInt;
		} else {
			System.out.println("Thank Your for your time");
		}
		System.out.println("Result forcast for your saving : RM " + forecastResult);
		return forecastResult;
	}

	static double dailySaving() {
		System.out.println("Please entry your income in MYR today.");
		input = new Scanner(System.in);
		double income = Double.valueOf(input.nextLine());
		System.out.println("Please entry your expanse in MYR today.");
		input = new Scanner(System.in);
		double expanse = Double.valueOf(input.nextLine());
		Date today = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String todayStr = formatter.format(today);
		double savingToday = 0.0;
		savingToday = income - expanse;
		System.out.println("Saving for " + todayStr + " is RM " + savingToday);
		return savingToday;
	}

	static double weeklySaving() {
		double expense = 0.0;
		double savingToday = 0.0;
		double totalSaving = 0.0;

		System.out.println("Please entry your income in MYR for this week or Key in 'N' to exit.");
		input = new Scanner(System.in);
		String incomeStr = input.nextLine().toUpperCase();

		for (int i = 0; i < 7; i++) {
			switch (i) {
			case 0: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					double incomeWeekly = Double.valueOf(incomeStr);
					System.out.println("Please entry your expense in MYR on Sunday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					savingToday = incomeWeekly - expense;
					totalSaving = totalSaving + savingToday;
				} else {
					break;
				}
			}
			case 1: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					System.out.println("Please entry your expense in MYR on Monday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					totalSaving = totalSaving - expense;
				} else {
					break;
				}
			}
			case 2: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					System.out.println("Please entry your expense in MYR on Tuesday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					totalSaving = totalSaving - expense;
				} else {
					break;
				}
			}
			case 3: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					System.out.println("Please entry your expense in MYR on Wednesday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					totalSaving = totalSaving - expense;
				} else {
					break;
				}
			}
			case 4: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					System.out.println("Please entry your expense in MYR on Thursday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					totalSaving = totalSaving - expense;
				} else {
					break;
				}
			}
			case 5: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					System.out.println("Please entry your expense in MYR on Friday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					totalSaving = totalSaving - expense;
				} else {
					break;
				}
			}
			case 6: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					System.out.println("Please entry your expense in MYR on Saturday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					totalSaving = totalSaving - expense;
				} else {
					break;
				}
			}
			}
			System.out.println("Your Saving for this Weeks is RM " + totalSaving);
			break;
		}

		return totalSaving;
	}

	static double weeklySaving(double numbers) {
		double expense = 0.0;
		double savingToday = 0.0;
		double totalSaving = 0.0;

		double incomeWeekly = numbers;
		String incomeStr = String.valueOf(numbers);

		for (int i = 0; i < 7; i++) {
			switch (i) {
			case 0: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					System.out.println("Please entry your expense in MYR on Sunday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					savingToday = incomeWeekly - expense;
					totalSaving = totalSaving + savingToday;
				} else {
					break;
				}
			}
			case 1: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					System.out.println("Please entry your expense in MYR on Monday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					totalSaving = totalSaving - expense;
				} else {
					break;
				}
			}
			case 2: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					System.out.println("Please entry your expense in MYR on Tuesday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					totalSaving = totalSaving - expense;
				} else {
					break;
				}
			}
			case 3: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					System.out.println("Please entry your expense in MYR on Wednesday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					totalSaving = totalSaving - expense;
				} else {
					break;
				}
			}
			case 4: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					System.out.println("Please entry your expense in MYR on Thursday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					totalSaving = totalSaving - expense;
				} else {
					break;
				}
			}
			case 5: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					System.out.println("Please entry your expense in MYR on Friday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					totalSaving = totalSaving - expense;
				} else {
					break;
				}
			}
			case 6: {
				if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
					System.out.println("Please entry your expense in MYR on Saturday.");
					input = new Scanner(System.in);
					expense = Double.valueOf(input.nextLine());
					totalSaving = totalSaving - expense;
				} else {
					break;
				}
			}
			}
			System.out.println("Your Saving for this Weeks is RM " + totalSaving);
			break;
		}

		return totalSaving;
	}

	static double monthlySaving() {
		double totalMonth = 0.0;
		System.out.println("Please entry your income in MYR for this month or Key in 'N' to exit.");
		input = new Scanner(System.in);
		String incomeStr = input.nextLine().toUpperCase();
		if (!"N".equals(incomeStr) && !"".equals(incomeStr)) {
			double amtIncomeMonthly = Double.valueOf(incomeStr);
			for (int i = 0; i < 4; i++) {
				// week1
				if (0 == i) {
					System.out.println("Week 1:");
					totalMonth = weeklySaving(amtIncomeMonthly);
				}
				// week2
				if (1 == i) {
					System.out.println("Week 2:");
					totalMonth = weeklySaving(totalMonth);
				}
				// week3
				if (2 == i) {
					System.out.println("Week 3:");
					totalMonth = weeklySaving(totalMonth);
				}
				// week4
				if (3 == i) {
					System.out.println("Week 4:");
					totalMonth = weeklySaving(totalMonth);
				}
			}
			System.out.println("Your saving for this Month is RM " + totalMonth);

		} else {
			System.out.println("Thank You for your time.");
		}

		return totalMonth;
	}

	static double taxCalculation(double numbers) {
		// By default income must be annually income;

		// SG IRAS value
		// wife 2000
		numbers = numbers - 2000;
		int amtDeductKids = 0;
		// kids 500 per person
		System.out.println("How many kids ? (Key in number e.g. 0 or 1 or 2...)");
		input = new Scanner(System.in);
		int kids = Integer.valueOf(input.nextLine());
		if (kids > 0) {
			amtDeductKids = kids * 500;
			numbers = numbers - amtDeductKids;
		} else {
			numbers = numbers - amtDeductKids;
		}
		// mother 5500
		System.out.println("Do you still have your mother ? 'Y' for yes and 'N' for No");
		input = new Scanner(System.in);
		String motherFlag = input.nextLine().toUpperCase();
		if ("Y".equals(motherFlag)) {
			numbers = numbers - 5500;
		} else {
			numbers = numbers - 0;
		}
		// life insurance max 3000
		System.out.println("Do you take life insurance ? 'Y' for yes and 'N' for No");
		input = new Scanner(System.in);
		String lifeInsuranceFlag = input.nextLine().toUpperCase();
		if ("Y".equals(lifeInsuranceFlag)) {
			System.out.println("How much your paid monthly ? ");
			input = new Scanner(System.in);
			double amtLifeInsurance = Double.valueOf(input.nextLine());
			if (amtLifeInsurance > 0) {
				amtLifeInsurance = amtLifeInsurance * 12;
				numbers = numbers - amtLifeInsurance;
			}
		} else {
			numbers = numbers - 0;
		}
		System.out.println("Final Amount after calculate Tax : " + numbers);
		return numbers;
	}

}
