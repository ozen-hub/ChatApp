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
            closeAll(this.socket, this.bufferedReader,this.bufferedWriter);
        }
    }

    public void listenForMessage(VBox vBox, String userName){
        new Thread(()->{
            String msgFromChat=null;
            String imgFromChat=null;
            while (socket.isConnected() && !userName.equals("SERVER")){
                try{
                    msgFromChat= bufferedReader.readLine();
                    if (msgFromChat.contains(".jpg") || msgFromChat.contains(".png")){
                        imgFromChat=msgFromChat;
                        // img=====>
                    }
                }catch (Exception e){

                }
            }
        }).start();
    }

    public void closeAll(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try{
            if (bufferedReader!=null) bufferedReader.close();
            if (bufferedWriter!=null) bufferedWriter.close();
            if (socket!=null) socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
