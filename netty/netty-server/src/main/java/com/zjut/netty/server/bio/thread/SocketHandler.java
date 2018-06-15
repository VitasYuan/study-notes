package com.zjut.netty.server.bio.thread;

import com.zjut.netty.common.constants.ServerConstants;
import com.zjut.netty.common.util.DateUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @author yuanweipeng
 * @date 2017-12-13
 **/
public class SocketHandler extends Thread implements Runnable{

    private Socket socket;

    public SocketHandler(Socket socket, String threadName){
        this.socket = socket;
        setName(threadName);
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            writer = new PrintWriter(this.socket.getOutputStream(), true);
            String body = "";
            String response = "";
            while (true) {
                long startTime = System.currentTimeMillis();
                System.out.println("ReadLine start:"+ startTime);
                body = reader.readLine();
                System.out.println("ReadLine finished:"+ System.currentTimeMillis() + ",Cost:" + (System.currentTimeMillis() - startTime) / 1000 + "s");

                if (body == null) {
                    break;
                }
                response = ServerConstants.INTERFACE_URL.equals(body) ? "Current time is: " + DateUtil.format(new Date()):
                "Error order.";
                writer.println(response);
            }

        } catch (IOException e) {
            if (reader != null) {
                try {
                    reader.close();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
