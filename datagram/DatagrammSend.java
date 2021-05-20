import java.net.*;
import java.io.*;
public class DatagrammSend
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket s=new DatagramSocket();
		String text="ein grosser Spass mit UDP";
		byte buf[]=text.getBytes();
		
		DatagramPacket p=new DatagramPacket(
		buf, buf.length,
		InetAddress.getByName(args[0]),
		Integer.parseInt(args[1]) );
		s.send(p);
		
		DatagramPacket pr=new DatagramPacket(new byte[1024],1024);
		s.receive(pr);
		String messr=new String(pr.getData(),0,pr.getLength());
		System.out.println(messr);
		s.close();
	}
}