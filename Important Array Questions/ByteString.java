//Converting byte array to String
import java.util.*;

class ByteString{
	public static void main(String args[]){
		byte[] bytearr = new byte[] {75, 69, 82, 88, 93, 100, 115};
		String str = new String(bytearr);
//		String str1 = new String(bytearr, "UTF-8");
		System.out.println("Byte -> String: " + str);
	}
}