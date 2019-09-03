import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class ATMController {

    @FXML
    private TextArea output;

    private ATMModel atm;
    
    public ATMController() {
    	atm = new ATMModel();
    }
    
    private void print(String msg) {
    	output.appendText(msg+"\n\n");
    }
    
    @FXML
    void aboutSelected(ActionEvent event) {
    	JOptionPane.showMessageDialog(null, "It's a simple ATM simulation. Duh.");
    }

    @FXML
    void clearSelected(ActionEvent event) {
    	output.setText("");
    }

    @FXML
    void closedSelected(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void balancePressed(ActionEvent event) {
    	double balance = atm.getBalance();
    	print("Current balance: $"+String.format("%.2f", balance));
    }

    @FXML
    void depostPressed(ActionEvent event) {
    	try {
    		String input = JOptionPane.showInputDialog("Deposit how much?");
    		double amount = Double.parseDouble(input);
    		if(atm.deposit(amount)) {
    			print("Hey, thanks for the cash!");
    		} else {
    			print("ERROR: Depost failed.");
    		}
    	} catch (NumberFormatException e) {
    		print("ERROR: Invalid input received.");
    	}
    }

    @FXML
    void withdraw100Pressed(ActionEvent event) {
    	withdraw(100);
    }

    @FXML
    void withdraw200Pressed(ActionEvent event) {
    	withdraw(200);
    }

    @FXML
    void withdrawPressed(ActionEvent event) {
    	try {
    		String input = JOptionPane.showInputDialog("Withdraw how much?");
    		double amount = Double.parseDouble(input);
    		withdraw(amount);
    	} catch (NumberFormatException e) {
    		print("ERROR: Invalid input received.");
    	}
    }

    private void withdraw(double amount) {
    	if (atm.withdraw(amount)) {
    		print("Here's your $"+String.format("%.2f", amount));
    	} else {
    		print("ERROR: Withdraw failed.");
    	}
    }
    
}
