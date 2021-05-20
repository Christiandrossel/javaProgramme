import java.io.*;

public class Stream2{
	
	
	
	public static void main(String args[])throws Exception{
		File f = new File(args[0]);
		try{
			FileInputStream fis = new FileInputStream(f);
			int len=(int)f.length();
			byte[] data = new byte[len];
			int bytesRead = 0;
			
			
			while(bytesRead<len) {
					
					bytesRead+=fis.read(data,bytesRead,(int)f.length()-bytesRead);
		
				}
				String s = new String(data);
					System.out.println(s);
				System.out.println("Die länge: " +len);
				System.out.println("Die länge der Bytes: " +bytesRead);
				fis.close();
			
		}
		catch(FileNotFoundException e){
			System.err.println("File not Found");
		}
	}
	
}

