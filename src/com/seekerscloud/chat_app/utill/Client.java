package com.seekerscloud.chat_app.utill;

import javafx.scene.image.Image;
import javafx.scene.layout.VBox;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

public class Client {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String userName;
    private VBox vBox;
    private BufferedImage bufferedImage;
    private Image fxImage;
    private VBox sendersVBox;

    public Client(Socket socket, String userName, VBox vbox) {
        try {
            this.socket = socket;
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.userName=userName;
            this.vBox=vbox;
        }catch (IOException e){
            // close all
        }
    }
}