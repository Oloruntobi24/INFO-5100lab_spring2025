/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import model.User;

/**
 * FXML Controller class
 *
 * @author Owner
 */
public class PrimaryFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    TextField nameTextField;
    @FXML
    TextField ageTextField;
    @FXML
    TextField emailTextField;
    
    public void submit() {
        
        try {
            User user = new User();
            user.setName(nameTextField.getText());
            user.setEmail(emailTextField.getText());
            user.setAge(parseInt(ageTextField.getText()));

            
            if (nameTextField.getText() == null || nameTextField.getText().isBlank()) {
                showAlert("Oops!", "Please enter your name", AlertType.ERROR);
                return;
            }
            if (emailTextField.getText() == null || emailTextField.getText().isBlank()) {
                showAlert("Oops!", "Please enter a valid email", AlertType.ERROR);
                return;
            }

            String email = emailTextField.getText();
            if (!email.contains("@") || !email.contains(".")) {
                showAlert("Oops!", "Please enter a valid email format", AlertType.ERROR);
                return;
            }

            try {
                int age = Integer.parseInt(ageTextField.getText());
                if (age < 21) {
                    showAlert("Invalid input", "Age must be 21 or older", AlertType.ERROR);
                    return;
                }
                user.setAge(age);
            } catch (NumberFormatException e) {
                showAlert("Invalid input", "Please enter a valid number for age", AlertType.ERROR);
                return;
            }

            Alert userAlert = new Alert(AlertType.INFORMATION);
            userAlert.setTitle("Success");
            userAlert.setHeaderText("Thanks for submitting");
            userAlert.setContentText(user.toString());
            userAlert.showAndWait();

        } catch (NullPointerException e) {
            showAlert("Error", "Something went wrong. Please try again.", AlertType.ERROR);
            e.printStackTrace(); 
        }
    }

    private void showAlert(String title, String message, AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
       
    } 
       
}
