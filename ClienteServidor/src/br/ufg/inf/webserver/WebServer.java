
package br.ufg.inf.webserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 *
 * @author fer
 */
public final class WebServer {
    
    
    public static void main(String arvg[]) throws Exception {

        Socket socket = new Socket();
        InetAddress endereco = InetAddress.getByName("java.sun.com");
        int porta = 80;
        SocketAddress sockEndereco = new InetSocketAddress(endereco, porta);
        socket.connect(sockEndereco);
        while (true) {
            HttpRequest request = new HttpRequest(socket);
            Thread thread = new Thread(request);
            thread.start();
        }
    }
    
    
}
