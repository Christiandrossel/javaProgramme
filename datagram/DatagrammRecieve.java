//import wie oben!
public class DatagrammRecieve
{
	public static void main(String args[]) throws Exception
	{
		DatagramSocket s=new DatagramSocket(Integer.parseInt (args[0]) );
		while (true) {
			DatagramPacket pr=new DatagramPacket(new byte[1024],1024);
			s.receive(pr);
			String messr=new String(pr.getData(),0,pr.getLength());
			System.out.println(messr);
			// irgendwas damit machen
			messr.toUpperCase();
			messr="gesendet: "+messr;
			// -> geht nicht
			byte buf[]=messr.getBytes();
			pr.setData(buf);
			pr.setLength(buf.length);
			s.send(pr);
		}
	}
}