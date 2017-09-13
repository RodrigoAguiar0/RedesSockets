
package br.ufg.inf.webserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author fer
 */
public final class WebServer {
    public static void main(String arvg[]) throws Exception {
    
    }
    
    final class HttpRequest implements Runnable {
        final static String CRLF = "\r\n";
        Socket socket;
        int port = 6789;
        
        public HttpRequest(Socket socket){
            this.socket = socket;
        }
        
        @Override
        public void run() {
            while (true) {
                HttpRequest request = new HttpRequest(new Socket());
                Thread thread = new Thread(request);
                thread.start();
            }
        }
        
        private void processRequest() throws IOException{
            InputStream inputStream = socket.getInputStream();
            DataOutputStream outputStream = (DataOutputStream) socket.getOutputStream();
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
}
