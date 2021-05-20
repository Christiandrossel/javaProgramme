import java.io.*;
import java.net.*;
import java.security.*;
import java.util.*;

public class FileServer {

    public static void main(String[] args) throws IOException {
        /*Properties properties = System.getProperties();
        final String libPath = properties.getProperty("sun.boot.library.path");
        System.setSecurityManager(new SecurityManager(){
            @Override
            public void checkAccept(String host, int port) {
                super.checkAccept(host, port);
            }

            @Override
            public void checkPermission(Permission perm) {
                super.checkPermission(perm);
            }

            @Override
            public void checkRead(String file) {
                // für den Zugriff auf Klassenbibliothek
                if (file.startsWith(libPath)) return;
                if (file.contains("FileServer")) return;
                if (file.startsWith("/") | file.contains(".."))
                    throw (new SecurityException("Forbidden Access: " + file));
            }
        });*/

        ServerSocket serverSocket = new ServerSocket(Integer.parseInt(args[0]));
        while (true) new TinyServerConnection(serverSocket.accept());
    }

    private static class TinyServerConnection extends Thread {
        Socket socket;

        TinyServerConnection(Socket s) {
            socket = s;
            start(); //Methode von Thread --> Aufruf der Funktion run()
        }

        @Override
        public void run() {
            OutputStream outputStream = null;
            try {
                String command = null;
                String request, buffer;
            
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while ((buffer = bufferedReader.readLine()) != null && buffer.length() > 0) {
                    if (buffer.startsWith("GET")) break;
                }

                StringTokenizer stringTokenizer = new StringTokenizer(buffer);
                
                // Dateiname extrahieren
                request = stringTokenizer.nextToken();
                request = stringTokenizer.nextToken();
                if (request.substring(0,1).equals("/")) {
                    request = request.substring(1);
                }

                outputStream = socket.getOutputStream();
                FileInputStream fileInputStream = new FileInputStream(request);

                int lenr = 0;
                byte byteBuffer[] = new byte[1024];

                while ((lenr = fileInputStream.read(byteBuffer)) != -1) {
                    outputStream.write(byteBuffer, 0, lenr);
                }

                socket.shutdownOutput();
                socket.close();
            } catch (IOException ioe) {
                System.out.println("I/O error " + ioe);
                try {
                    PrintStream printStream = new PrintStream(outputStream);
                    printStream.println("I/O Error" + ioe);
                    socket.shutdownOutput();
                    socket.close();
                } catch (IOException ioe2) {
                }
            }
        }
    }
}
