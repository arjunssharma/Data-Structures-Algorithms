package Blackrock;

public class LoanPayment {
	public static void main(String args[]) {
		String input = "30000~10~6~5000";
		String input1 = "6000~5~6~0";
		String values[] = input.split("~");
		double loanAmount = Double.parseDouble(values[0]) - Double.parseDouble(values[3]);
		int years = Integer.parseInt(values[1]);
		double rateOfInterest = Double.parseDouble(values[2]);
		double monthlyROI = rateOfInterest / 1200;
		System.out.println("loan amount: "+loanAmount+"  years: "+years+"  rate of interest: "+rateOfInterest);
		double monthlyPayment = (monthlyROI * loanAmount) / (1 - Math.pow((1 + monthlyROI), -1 *years * 12));
		double totalPaid = monthlyPayment * years * 12;
		System.out.println(Math.round(monthlyPayment));
		System.out.println(Math.round(totalPaid-loanAmount));
	}
}
