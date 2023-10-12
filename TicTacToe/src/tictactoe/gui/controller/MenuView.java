package tictactoe.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuView {
    @FXML
    Label lblMain;
    public void clickHandlePvA(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/PvAView.fxml"));
        Stage stage = (Stage) lblMain.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void clickHandlePvP(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/TicTacView.fxml"));
        Stage stage = (Stage) lblMain.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }
}
