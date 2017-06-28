package com.emmiasilk.urealms.server.gui;

import com.emmiasilk.urealms.core.logging.Logging;
import com.emmiasilk.urealms.core.logging.QueueAppender;
import com.emmiasilk.urealms.server.UrealmsServer;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ServerGui extends Application implements Initializable {

    @FXML private TextArea consoleTextArea;
    @FXML private Tab consoleTab;
    @FXML private Tab playerTab;
    @FXML private Tab statsTab;
    @FXML private Button saveButton;
    @FXML private Button exitButton;

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/server_gui.fxml"));
            root.getStylesheets().add("/gui/server_gui.css");
            primaryStage.setScene(new Scene(root));

            primaryStage.getIcons().add(new Image("/gui/img/ur_logo.png"));
            primaryStage.setTitle("URealms Server");
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch (Exception exception) {
            Logging.logError("Couldn't build server GUI", exception);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        consoleTab.setText("Console");
        playerTab.setText("Player");
        statsTab.setText("Statistic");

        initConsoleTab();
        //initPlayersTab();
        //initStatsTab();
    }

    private void initConsoleTab() {
        saveButton.setText("Save");
        exitButton.setText("Exit");

        saveButton.setOnAction(event -> UrealmsServer.getServer().save());
        exitButton.setOnAction(event -> UrealmsServer.getServer().close());

        consoleTextArea.setEditable(false);

        Thread thread = new Thread(() -> {
            String line;

            while ((line = QueueAppender.getNext("ServerConsoleGui")) != null) {
                consoleTextArea.appendText(line);
            }
        });

        thread.setDaemon(true);
        thread.start();
    }
}
