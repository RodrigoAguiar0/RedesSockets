/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.webserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author fer
 */
public final class HttpRequest implements Runnable {
        final static String CRLF = "\r\n";
        Socket socket;
    
      
        public HttpRequest(Socket socket){
            this.socket = socket;
        }
        
        @Override
        public void run() {
            try {
                processRequest();
            } catch(Exception e) {
                System.out.println(e);
            }
            
        }
        
        private void processRequest() throws IOException{
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            BufferedReader bufferedReader = null;
            String requestedLine = null;
            System.out.println();
            System.out.println(requestedLine);
            
            String headerLine = null;
            while ((headerLine = bufferedReader.readLine()).length() != 0){
                System.out.println(headerLine);
            }
        }
    
    }
