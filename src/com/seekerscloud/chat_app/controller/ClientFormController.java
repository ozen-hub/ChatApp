package com.seekerscloud.chat_app.controller;

import com.seekerscloud.chat_app.utill.Client;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.Socket;

public class ClientFormController {
    public VBox vbox_msg;
    String clientName;

    public static VBox senderVBox;
    public Client client;

    public void initialize(){
        System.out.println("initialize");
    }

    public void setClientName(String name){
        new Thread(()->{
            try {
                senderVBox = vbox_msg;
                // cleint name set
                client = new Client(new Socket("localhost", 5000),
                        name, vbox_msg);
                System.out.println("Connected to the server");
                //=================
            }catch (IOException e){
                e.printStackTrace();
            }
            }).start();



        clientName=name;
        System.out.println(clientName);
    }
    public void exitClientOnAction(MouseEvent mouseEvent) {
    }
}
