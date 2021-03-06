package window.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import users.students.Grade;
import users.students.GradeType;
import util.MathUtil;
import window.util.WindowUtil;

import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 */
public class EditGradeController implements Initializable {
    private Grade grade;

    @FXML
    private ComboBox<String> typeComboBox;
    @FXML
    private TextField scoreField;
    @FXML
    private TextField nameField;
    @FXML
    private Button createButton;
    @FXML
    private Button cancelButton;
    @FXML
    private Label errorLabel;

    @FXML
    private void handleCreateButtonAction(ActionEvent event) {
        if (typeComboBox.getSelectionModel().isEmpty() ||
                scoreField.getText().isEmpty() ||
                nameField.getText().isEmpty()) {
            displayErrorLabel("All Fields Are Required.");
            return;
        }

        if (!MathUtil.isNumeric(scoreField.getText()) ||
                MathUtil.isNegative(scoreField.getText())) {
            displayErrorLabel("Incorrect Values Passed.");
            return;
        }

        createGrade();
        WindowUtil.closeWindow(event);
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
        this.grade = null;
        WindowUtil.closeWindow(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Arrays.asList(GradeType.values())
                .forEach(type -> typeComboBox.getItems().add(type.toString()));
    }

    /**
     * Initializes grade instance into window.
     *
     * @param grade The grade instance that will be initialized.
     */

    public void init(Grade grade) {
        createButton.setText("Save Changes");
        nameField.setText(grade.getName());
        scoreField.setText(String.valueOf(grade.getScore()));
        typeComboBox.setValue(grade.getType().toString());
    }

    /**
     * Creates Grade instance with interface values.
     */
    private void createGrade() {
        double gradeScore = MathUtil.round(Double.parseDouble(scoreField.getText()), 2);
        GradeType type = GradeType.valueOf(typeComboBox.getValue());
        grade = new Grade(gradeScore, type);
        grade.setName(nameField.getText());
    }

    /**
     * Displays error message to interface for user's viewing.
     *
     * @param message The message that will be displayed.
     */
    private void displayErrorLabel(String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }

    public Optional<Grade> getGrade() {
        return Optional.ofNullable(grade);
    }
}
