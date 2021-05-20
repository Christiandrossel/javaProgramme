import java.io.*;

public class Stream1 {
	
	public static void main(String args[]) throws Exception{
		
		//File von Konsole einlesen
		File f = new File(args[0]);
		//Überprüfen ob es existiert
		if(!f.exists() || !f.canRead()) {
			System.out.println("Cant't File read" +f);
		}
		
		if(f.isDirectory()) {
			System.out.println("I will have a File not a Directory!!!");
		}
		else
			try {
				//Erzeuge FileInputStream
				FileInputStream fis = new FileInputStream(f);
				//Erzeuge eine byte array Variable mit der größe der Textlänge
				byte[] data = new byte[(int)f.length()];
				int pos=0;
				
				while(pos<f.length()) {
					
					pos+=fis.read(data,pos,(int)f.length()-pos);
					String s = new String(data);
					System.out.println(s);
				}
				fis.close();
			}
		catch(FileNotFoundException e){
			System.out.println("File Disappeared");
		}
		
		//File durch FileInputStream instanzieren und
		//via available die Anzahl bereitstehender Bytes ermitteln
		//In dieser Größe ein ByteArray erzeugen
		//Daten einlesen und auf der Konsole ausgeben
		
	}
}
