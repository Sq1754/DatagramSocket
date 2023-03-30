import java.net.*;
import java.io.*;
import java.util.Scanner;

// Dilouge connection on the same device
// client side
public class DilougeConnection_receiver {
	public static void main(String[]args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
	// Create Socket object for carrying data
		DatagramSocket ds = new DatagramSocket();
		InetAddress ip = InetAddress.getLocalHost();
		byte[] buf = null;
		
		// loop while user not entered "bye"
		while(true) {
			String inp = sc.nextLine();
			
			buf = inp.getBytes(); // string to byte array
			
	// Creating DatagrmPacket for sending data
			DatagramPacket DpSend = new DatagramPacket(buf,buf.length,ip,1234);
			
	// invoke the send call to actually send the data
			ds.send(DpSend);
			
			if(inp.equals("bye"))
				break;
		}
	}
}
