package Service.Test;
import java.io.IOException;  
import java.io.OutputStream;  
import java.net.ServerSocket;  
import java.net.Socket;  

/**
 * 
 * @author cece
 *
 */
public class SocketTest {  
    public static void main(String[] args) {  
        try {  
            ServerSocket server = new ServerSocket(8888);  
            while (true) {  
                System.out.println("execute 1\n");  
                Socket client = server.accept();  
                System.out.println("execute 2\n");  
                OutputStream out = client.getOutputStream();  
                System.out.println("execute 3\n");  
                String msg = "hello android";  
                out.write(msg.getBytes());  
                System.out.println("execute 4\n");  
                client.close();  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
  
    }  
} 
