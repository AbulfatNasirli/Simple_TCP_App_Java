/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author DELL
 */

import com.sun.source.tree.Scope;
import fileUtility.FileUtility;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

public class TCP_Server {
    public static void main(String[] args) throws IOException, Exception {
           readAsByte();
    }

    public static void readAsByte() throws IOException, Exception {
        ServerSocket serverSocket = new ServerSocket(6668);
        while (true) {
            Socket connection = serverSocket.accept();
            InputStream in = connection.getInputStream();
            DataInputStream inFromClient = new DataInputStream(in);
            byte [] arr = readMessage(inFromClient);
            System.out.println("message length2=" + arr.length);
            FileUtility.writeIntoByte("C:/Users/Dell/Desktop/TCPdeneme.png",arr);
        }

    }

    public static byte[] readMessage(DataInputStream dataInputStream) throws IOException {
        int msgLen = dataInputStream.readInt();
        System.out.println("message length= "+ msgLen);
        byte[] msg = new byte[msgLen];
        dataInputStream.readFully(msg);
        return msg;
    }

    public static void readAsString() throws Exception {
        ServerSocket ourFirstServerSocket = new ServerSocket(1997);
        while (true) {
            Socket connection = ourFirstServerSocket.accept();
            InputStream is = connection.getInputStream();
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String messageFromClient = bufferedReader.readLine();
            System.out.println("Message from client= " + messageFromClient);

        }
    }
}

