import java.io.*;
import java.net.*;
import java.util.*;

public class FileClient {

    public static void main(String[] args) {
    
        if (args.length != 4) {
            System.err.println("Usage: java FileClient <host> <port> <serverfile> <clientfile>");
        }
        else {
            try {
                Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
                
                PrintStream output = new PrintStream(socket.getOutputStream());
                
                output.println("GET " + args[2]);
                output.println("\r");
                
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                
                File file = new File(args[3]);
                FileOutputStream out = new FileOutputStream(file);
                
                String answer;
                while((answer = input.readLine()) != null) {
                    out.write((answer + "\n").getBytes());
                }
                
                socket.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
