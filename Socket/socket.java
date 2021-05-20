import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;
public class socket{
	public static void main (String argv[]) throws IOException{
	ServerSocket ss = new ServerSocket(Integer.parseInt(argv[0]));
	while (true) new TinyServConn(ss.accept());
}
}
class TinyServConn extends Thread{
	Socket sock;
	TinyServConn(Socket s)
	{
		sock=s;
		start();
}
	public void run() {
	try
	{
		String Command=null;
		String req,buf;
		System.out.println("Socket.localPort:"+sock.getLocalPort()
		+"Socket.port:"+sock.getPort());
		BufferedReader BR = new BufferedReader
		(new InputStreamReader(sock.getInputStream()));
		while((buf=BR.readLine())!=null)
		System.out.println(buf);
		sock.close();
	}
	catch(IOException e){System.out.println("I/O Error "+e);}}}