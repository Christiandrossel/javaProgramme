import java.lang.*;
import java.io.*;

public class HexDump {

	private byte data[];

	HexDump(String s) {
		data = s.getBytes();
	}

	public HexDump(InputStream fis) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
			byte buf[] = new byte[1024];
			int lenr;

			while ((lenr = fis.read(buf)) > -1) bos.write(buf, 0, lenr);

			data = bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* produces a char Array of length len displaying
	   the hexadecimal Value of the value z */
	private char[] hexByte(int z, int len) {
		char[] x = new char[len];
		int i, hx;
		for (i = len - 1; i >= 0; i--) {
			hx = z;
			z >>>= 4;
			hx &= 0xf;
			x[i] = (char) (hx <= 9 ? hx + '0' : hx + 'A' - 10);
		}
		return x;
	}

	/* produces a String in the Form of a hexdump
	   of an array of bytes */
	public String getHexString() {
		String s = "";

        String h = "";

		for (int i = 0; i < data.length; i++) {

			if (i % 16 == 0) {
                s+= new String(hexByte(i, 4)) + ": ";
            }

			s += new String(hexByte(data[i], 2)) + " ";
			if (i % 4 == 3 && i % 16 != 15) {
                s+= "| ";
			}

			h += data[i] > 32 ? (char) data[i] : ".";

			if (i % 16 == 15) {
                s+="\t"+ h + "\n";
                h="";
			}

		}
		int r = data.length % 16;
		// System.out.println(r);
        if (r != 0) {
            for (int j=0;j<((16-r)*3+(16-r)/4*2);j++) {
                s += " ";

            }
            s += "\t" + h;
        }

		return s;
	}

// 	public static void main(String args[]) {
// //     System.out.println(new HexDump(args[0]).getHexString());
// 		try {
// 			System.out.println(new HexDump(new FileInputStream(args[0])).getHexString());
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 	}
}
