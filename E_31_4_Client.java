package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class E_31_4_Client extends Application {
    DataInputStream fromServer = null;

    private Label label  = new Label("");

    @Override
    public void start(Stage primaryStage) {

        StackPane pane = new StackPane();
        pane.getChildren().add(label);

        Scene scene = new Scene(pane, 300, 75);
        primaryStage.setTitle("Exercise31_04Client");
        primaryStage.setScene(scene);
        primaryStage.show();

        try {
            Socket socket = new Socket("localhost", 8000);

            fromServer = new DataInputStream(socket.getInputStream());

            label.setText(fromServer.readUTF());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
