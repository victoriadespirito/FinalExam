package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;
import org.springframework.util.NumberUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

	@FXML
	private RetirementApp mainApp = null;
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtAnnualReturnWorking;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtAnnualReturn;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
	@FXML 
	private TextField txtTotalAmountSaved;
	@FXML 
	private TextField txtAmountToSave;
	@FXML
	private TextField txtpopulate;
	@FXML 
	private Button Clear;
	@FXML
	private Button Calc;
	
	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		// Clear all the text inputs
		txtYearsToWork.setText("");
		txtAnnualReturnWorking.setText("");
		txtYearsRetired.setText("");
		txtAnnualReturn.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");
		txtTotalAmountSaved.setText("");
		txtAmountToSave.setText("");
		
		
		
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		// Call AmountToSave and TotalAmountSaved and populate 
		if(inputValid()){
			Retirement r = new Retirement((int) Integer.valueOf(txtYearsToWork.getText()),
					(double) Double.valueOf(txtAnnualReturnWorking.getText()),
					(int) Integer.valueOf(txtYearsRetired.getText()),
					(double) Double.valueOf(txtAnnualReturn.getText()),
					(double) Double.valueOf(txtRequiredIncome.getText()),
					(double) Double.valueOf(txtMonthlySSI.getText()), 
					(double) Double.valueOf(txtTotalAmountSaved.getText()),
					(double) Double.valueOf(txtAmountToSave.getText()));
		}

	}
	
	
    private boolean inputValid() {
        String errorMessage = "";

        try {
            Integer.parseInt(txtYearsToWork.getText());
        } catch (NumberFormatException e) {
            errorMessage += "Years To Work needs to be an integer!\n"; 
        }
        
        try {
            Integer.parseInt(txtYearsRetired.getText());
        } catch (NumberFormatException e) {
            errorMessage += "Years Retired needs to be an integer!\n"; 
        }
        
        try {
            if(Double.parseDouble(txtAnnualReturnWorking.getText())<0 || Double.parseDouble(txtAnnualReturnWorking.getText())>.2) {
            	errorMessage += "Annual Return Working needs to be between 0 and 0.20!\n";
            }
            
        } catch (NumberFormatException e) {
            errorMessage += "Annual Return Working needs to be a number!\n"; 
        }
        
        try {
        	if(Double.parseDouble(txtAnnualReturn.getText())<0 || Double.parseDouble(txtAnnualReturn.getText())>.03) {
            	errorMessage += "Annual Return Working needs to be between 0 and 0.03!\n";
            }
        } catch (NumberFormatException e) {
            errorMessage += "Annual Return needs to be a number!\n"; 
        }
        
        try {
            Double.parseDouble(txtRequiredIncome.getText());
        } catch (NumberFormatException e) {
            errorMessage += "Required Income needs to be a number!\n"; 
        }

        try {
            Double.parseDouble(txtMonthlySSI.getText());
        } catch (NumberFormatException e) {
            errorMessage += "Monthly SSI needs to be a number!\n"; 
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Display when error
            Alert alert = new Alert(AlertType.ERROR);
          
            
            // alert
            alert.setTitle("Invalid please correct");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
