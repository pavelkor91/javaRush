package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class Server {

    private static Map<String, Connection> connectionMap = new java.util.concurrent.ConcurrentHashMap<>();

    private static class Handler extends Thread{
        private Socket socket;
        public Handler (Socket socket){
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException{
            Message message;
            while (true){
                connection.send(new Message(MessageType.NAME_REQUEST));
                message = connection.receive();
                if(message.getType() == MessageType.USER_NAME){
                    if(message.getData() != null && !message.getData().equals(""))
                        if(connectionMap.get(message.getData()) == null)
                            break;
                }
            }
            connectionMap.put(message.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            return message.getData();
        }

        private void notifyUsers(Connection connection, String userName) throws IOException{
            for(Map.Entry<String, Connection> entry : connectionMap.entrySet()){
                if(userName.equals(entry.getKey()))
                    continue;
                else
                    connection.send(new Message(MessageType.USER_ADDED, entry.getKey()));
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException{
            while (true){
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                }
                else
                    ConsoleHelper.writeMessage("Ошибка - не текст.");
            }
        }
    }

    public static void sendBroadcastMessage(Message message){
        for(Map.Entry<String, Connection> entry: connectionMap.entrySet()){
            try {
                entry.getValue().send(message);
            }
            catch (IOException e){
                ConsoleHelper.writeMessage(e.toString());
            }
        }
    }



    public static void main(String[] args) {

        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Сервер запущен!");
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        }
        catch (IOException e) {
            ConsoleHelper.writeMessage("Error");
        }
    }
}

