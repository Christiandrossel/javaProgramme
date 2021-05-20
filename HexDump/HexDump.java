import java.lang.*;
import java.io.*;

public class HexDump
{
  
  byte data[];

  HexDump(String s)
  {
     data=s.getBytes();
  }

  HexDump(InputStream fis)	//Klasse InputStream
  {
     try
     {
		 //erzeugt ein ByteArrayOutputStream mit lassen sich primitive datentypen in byte-Feldern Kopieren
		 //Die dann bitweise weiter verwendet werden können
	ByteArrayOutputStream bos=new ByteArrayOutputStream(1024);
		//Für ByteArrayOutputStream brauchen wir natürlich ein byte Datentyp
	byte buf[]=new byte[1024];
	int lenr;		//und die länge 
			//Hier wird der übergebene Stream fis gelesen und so lange auf bos geschrieben ------------------------??????????
	while ((lenr=fis.read(buf))>-1) bos.write(buf,0,lenr);

	data=bos.toByteArray();	//Anschliesend wird die bos auf die data übergeben
     }catch(Exception e){System.out.println(e);}
  }

  /* produces a char Array of length len displaying
     the hexadecimal Value of the value z */
  private char[] hexByte(int z, int len)
  {
    char[] x=new char[len];
    int i,hx;
    for(i=len-1;i>=0;i--)
    {
       hx=z;
       z>>>=4;									//---------------------------?????? was passiert hier??????????????
       hx&=0xf;
       x[i]=(char)(hx<=9?hx+'0':hx+'A'-10);
    } 
    return x;
  }

  /* produces a String in the Form of a hexdump
     of an array of bytes */
  public String getHexString()
  {
   String s= "";
	
	
	for (int i=0; i < data.length; i+=16)
	{
		//Hier gebe ich die Zeile aus deswegen im hexByte i 
		s= s+ new String(hexByte(i,4))+": ";
	
		
		for(int j = 0; j < 16 && i+j < data.length ;j++)
		{
			//und hier gebe ich den string aus, der auf data liegt mit der größe i+j 
			s = s+ new String(hexByte(data[i+j],2))+ " ";
			
			
			if ((j+1) %4 == 0) 
			{
				s = s+ " | ";
			}
			
		}
		for(int j = 0; j < 16 && i+j < data.length ;j++)
		{
			if(data[i+j] >= ' ' ) s= s+ (char)data[i+j];	//Um am Ende den orginal textinhalt darzustellen
			
			else 				  s= s+ '.'; 
				
			
		//	s = s+ data[i+j]>= ' '?(char)data[i+j] :'.';    
		}
	s = s+ "\n";	
	}
   // geben Sie zuerst den Text in data als String zurueck, erzeugen Sie dazu ein 
   // neues Objekt der Klasse String und initialisieren es mit data.
   // Als zweites erzeugen Sie ein Stringobjekt aus dem Returnwert der 
   // Fuhnktion getHexByte, der Sie das erste Byte von Data und die 
   // Laenge 2 uebergeben.
   // Als drittes bauen Sie eine Schleife, in der die Bytes aus Data 
   // mit getHexByte umgewndelt werden und nacheinander, durch Leerzeichen 
   // getrennt zu dem String zusammen gebaut werden.

    return s;
  }
  public static void main(String args[])
  {
//     System.out.println(new HexDump(args[0]).getHexString());
     try	//try und catch ist für die Fehlerbehandlung da, um diese abzufangen
     {
		//Eine neue HexDump wird erzeugt, mit der die Fkt getHexString aufgerufen wird. 
		//Außerdem wird der Stream aus der std eingabe eingelesen.
     System.out.println(new HexDump(new FileInputStream(args[0])).getHexString());
     }catch(Exception e){System.out.println(e);}
  }
}