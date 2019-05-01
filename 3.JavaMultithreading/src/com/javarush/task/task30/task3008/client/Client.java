package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

public class Client {

    protected Connection connection;
    private volatile boolean clientConnected = false;
    public class SocketThread extends Thread{

        protected void processIncomingMessage(String message){
            ConsoleHelper.writeMessage(message);
        }
        protected void informAboutAddingNewUser(String userName){
            ConsoleHelper.writeMessage(String.format("Пользователь с именем %s присоединился к чату", userName));
        }
        protected void informAboutDeletingNewUser(String userName){
            ConsoleHelper.writeMessage(String.format("Пользователь с именем %s покинул чат", userName));
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected){
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this){
                Client.this.notify();
            }
        }

        protected void clientHandshake() throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if(message.getType() == MessageType.NAME_REQUEST){
                    String name = getUserName();
                    connection.send(new Message(MessageType.USER_NAME, name));
                }
                else if(message.getType() == MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    return;
                }
                else
                {
                    throw  new  IOException("Unexpected MessageType");
                }
            }
        }

        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    processIncomingMessage(message.getData());
                }
                else if(message.getType() == MessageType.USER_ADDED){
                    informAboutAddingNewUser(message.getData());
                }
                else if(message.getType() == MessageType.USER_REMOVED){
                    informAboutDeletingNewUser(message.getData());
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        @Override
        public void run() {
            String ip = getServerAddress();
            int port = getServerPort();
            try {
                Socket socket = new Socket(ip, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            }
            catch (IOException | ClassNotFoundException e){
                ConsoleHelper.writeMessage(e.getMessage());
                notifyConnectionStatusChanged(false);
            }

        }
    }

    protected String getServerAddress(){
        ConsoleHelper.writeMessage("Введите IP адрес");
        String ip = ConsoleHelper.readString();
        return ip;
    }

    protected int getServerPort(){
        ConsoleHelper.writeMessage("Введите порт");
        int port = ConsoleHelper.readInt();
        return port;
    }

    protected String getUserName(){
        ConsoleHelper.writeMessage("Введите имя пользователя");
        String name = ConsoleHelper.readString();
        return name;
    }

    public void run(){
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
            try {
                synchronized (this) {
                    this.wait();
                }
            }
            catch (InterruptedException e){
                ConsoleHelper.writeMessage(e.getMessage());
                return;
            }
            if(clientConnected){
                ConsoleHelper.writeMessage("Connected");
            }
            else ConsoleHelper.writeMessage("error");

            String message = null;
            while (clientConnected){
                message = ConsoleHelper.readString();
                if(message.equals("exit")){
                    break;
                }
                else if(shouldSendTextFromConsole()){
                        sendTextMessage(message);
                }
            }
        }

    protected boolean shouldSendTextFromConsole(){
        return true;
    }

    protected SocketThread getSocketThread(){
        return new SocketThread();
    }

    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        }
        catch (IOException e){
            ConsoleHelper.writeMessage(e.getMessage());
            clientConnected = false;
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
