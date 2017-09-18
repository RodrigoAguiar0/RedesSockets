
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
        
//        Socket novoSocket = new Socket();
//        HttpRequest request = new HttpRequest(novoSocket);
        
        while (true) {
            //Thread thread = new Thread(request);
            //Aqui deve ser feito a escuta e o incio da thread de cada
            //requisição.
            //Mas pelo codigo do professor, não é possivel, pois é um
            // contexto estático.
        }
    }
    
    final class HttpRequest implements Runnable {
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
