package pkgCore;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
import javafx.fxml.FXML;

public class Retirement {

	private int iYearsToWork;
	
	@FXML
	private double dAnnualReturnWorking;
	@FXML
	private int iYearsRetired;
	@FXML
	private double dAnnualReturnRetired;
	@FXML
	private double dRequiredIncome;
	@FXML
	private double dMonthlySSI;
	@FXML
	private double TotalAmountSaved;
	@FXML
	private double dMonthlySavings;
	
	//@param iYearsToWork
	//@param dAnnualReturnWorking
	//@param iYearsRetired
	//@param dAnnualReturnRetired
	//@param dRequiredIncome
	//@param dMonthlySSI
	//@param totalAmountSaved
	//@param dMonthlySavings
	
	
	
	// Build the constructor, getters and setters for the attributes above.
	public Retirement(int iYearsToWork, double dAnnualReturnWorking,int iYearsRetired, double dAnnualReturnRetired, double dRequiredIncome, double dMonthlySSI, double totalAmountSaved, double dMonthlySavings) {
		
		this.iYearsToWork = iYearsToWork;
		
		this.iYearsRetired = iYearsRetired;
		
		this.dAnnualReturnWorking = dAnnualReturnWorking;
		
		this.dAnnualReturnRetired = dAnnualReturnRetired;
		
		this.dRequiredIncome = dRequiredIncome;
		
		this.dMonthlySSI = dMonthlySSI;
		
		TotalAmountSaved = totalAmountSaved;
		
		this.dMonthlySavings = dMonthlySavings;
	}
		
	

		/** return the iYearsToWork**/
		
		public int getiYearsToWork() {
			return iYearsToWork;
			
		}
		/** return the dAnnualReturnWorking**/
		public double getdAnnualReturnWorking() {
			return dAnnualReturnWorking;
			
		}
		/** return the iYears retired**/
		public int getiYearsRetired() {
			return iYearsRetired;
			
		}
		/** return the dAnnualReturnRetired **/
		public double getdAnnualReturnRetired() {
			return dAnnualReturnRetired;
			
		}
		/** return the dRequiredIncome**/
		public double getdRequiredIncome() {
			return dRequiredIncome;
			
		}
		/** return the dMonthlySSI**/
		public double getdMonthlySSI() {
			return dMonthlySSI;
			
		}
		/** return the totalAmountSaved**/
		public double getTotalAmountSaved() {
			return TotalAmountSaved;
			
		}
		/** return the monthly savings **/
		public double getdMonthlySavings() {
			return dMonthlySavings;
			
		}
		/** @param iYearsToWork the iYearsToWork to set**/
		public void setiYearsToWork(int iYearsToWork) {
			this.iYearsToWork = iYearsToWork;
			
		}
		/** @param dAnnualReturnWorking the dAnnualReturnWorking to set**/
		public void setdAnnualReturnWorking(double dAnnualReturnWorking) {
			this.dAnnualReturnWorking = dAnnualReturnWorking;
			
		}
		/** @param iYearsRetired the iYearsRetired to set**/
		public void setiYearsRetired(int iYearsRetired) {
			this.iYearsRetired = iYearsRetired;
			
		}
		/** @param dAnnualReturnRetired the dAnnualReturnRetired to set**/
		public void setdAnnualReturnRetired(double dAnnualReturnRetired) {
			this.dAnnualReturnRetired = dAnnualReturnRetired;
			
		}
		/** @param dRequiredIncome the dRequiredIncome to set**/
		public void setdRequiredIncome(double dRequiredIncome) {
			this.dRequiredIncome = dRequiredIncome;
			
		}
		/** @param dMonthlySSI the dMonthlySSI to set**/
		public void setdMonthlySSI(double dMonthlySSI) {
			this.dMonthlySSI = dMonthlySSI;
			
		}
		/** @param totalAmountSaved the totalAmountSaved to get**/
		public void setTotalAmountSaved(double totalAmountSaved) {
			TotalAmountSaved = totalAmountSaved;
			
		}
		/** @param dMonthlySavings the dMonthlySavings to set**/
		public void setdMonthlySavings(double dMonthlySavings) {
			this.dMonthlySavings = dMonthlySavings;
			
		}
		



	public double AmountToSave()
	{
		// Determine the amount to save each month based on TotalAmountSaved, YearsToWork
		//		and Annual return while working
		dAnnualReturnRetired = (dAnnualReturnWorking/100)/12;
		dMonthlySavings = TotalAmountSaved*((dAnnualReturnWorking)/(Math.pow((1+dAnnualReturnWorking), (iYearsToWork*12))-1));
		return dMonthlySavings;
	}
	
	public double TotalAmountSaved()
	{
		//	 Determine amount to be saved based on Monthly SSI, Required Income, Annual return during retirement
		//		and number of years retired.
		//
		 TotalAmountSaved = (dRequiredIncome-dMonthlySSI)*((1-(1/(Math.pow(1+(dAnnualReturnWorking/100)/12,iYearsRetired*12)))))/((dAnnualReturnRetired/100)/12);
		return TotalAmountSaved;
	}
}
