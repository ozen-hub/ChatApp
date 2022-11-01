package com.seekerscloud.chat_app.controller;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFormController {

    public void initialize() {
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                Socket accept = serverSocket.accept();
                System.out.println("Server Started..");
                System.out.println(accept.getPort());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public TextField txtMessageBox;

    public void shutdownServerOnClick(MouseEvent mouseEvent) {
    }
}
