package com.company;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class E_31_4_Server extends Application {
    private TextArea ta = new TextArea();

    private int threadNo = 0;

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("Exercise31_04Sever");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            try {

                ServerSocket serverSocket = new ServerSocket(8000);
                ta.appendText("Exercise31_04Sever started at " + new Date() + '\n');

                while (true) {

                    Socket socket = serverSocket.accept();

                    Platform.runLater(() -> {

                        ta.appendText("Starting thread " + threadNo++ + '\n');

                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("Client IP /" +
                                inetAddress.getHostAddress() + '\n');

                    });

                    new Thread(new HandleAClient(socket)).start();
                }
            }
            catch(IOException ex) {
                System.err.println(ex);
            }
        }).start();
    }

    class HandleAClient implements Runnable {
        private Socket socket;

        public HandleAClient(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());

                outputToClient.writeUTF("You are visitor " + threadNo);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
