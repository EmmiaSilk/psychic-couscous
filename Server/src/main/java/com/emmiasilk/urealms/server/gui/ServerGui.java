package com.emmiasilk.urealms.server.gui;

import com.emmiasilk.urealms.api.util.I18n;
import com.emmiasilk.urealms.api.logging.Logging;
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
            Parent root = FXMLLoader.load(getClass().getResource("/resources/server_gui/server_gui.fxml"));
            root.getStylesheets().add("/resources/server_gui/server_gui.css");
            primaryStage.setScene(new Scene(root));

            primaryStage.getIcons().add(new Image("/resources/server_gui/img/ur_logo.png"));
            primaryStage.setTitle(I18n.getInstance().getLocalizedString("server.gui.window_title"));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch (Exception exception) {
            Logging.logError(I18n.getInstance().getLocalizedString("server.gui.error.could_not_build"), exception);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        consoleTab.setText(I18n.getInstance().getLocalizedString("server.gui.console_tab"));
        playerTab.setText(I18n.getInstance().getLocalizedString("server.gui.player_tab"));
        statsTab.setText(I18n.getInstance().getLocalizedString("server.gui.stats_tab"));

        initConsoleTab();
        //initPlayersTab();
        //initStatsTab();
    }

    private void initConsoleTab() {
        saveButton.setText(I18n.getInstance().getLocalizedString("server.gui.save_button"));
        exitButton.setText(I18n.getInstance().getLocalizedString("server.gui.exit_button"));

        saveButton.setOnAction(event -> UrealmsServer.getInstance().save());
        exitButton.setOnAction(event -> UrealmsServer.getInstance().close());

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
