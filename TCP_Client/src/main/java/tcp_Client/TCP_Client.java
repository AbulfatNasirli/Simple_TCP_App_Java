/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_Client;

import fileUtility.FileUtility;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;


/**
 *
 * @author DELL
 */
public class TCP_Client {
     public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 6668);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        byte[] readByte = FileUtility.readBytes("C:/Users/Dell/Downloads/GREENCRD.PNG");
        dataOutputStream.writeInt(readByte.length);
        outputStream.write(readByte);
        socket.close();
    }
}
