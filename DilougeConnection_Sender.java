import java.net.*;
import java.io.*;

// Server side  
//UDP server

public class DilougeConnection_Sender {

	// method to convert the byte array
    public static StringBuilder data(byte[] a) {
    	if(a==null) {
    		return null;
    	}
    	
    	StringBuilder ret = new StringBuilder();
        
    	int i = 0;
    	while(a[i] != 0) {
    		ret.append((char)a[i]);
    		i++;
    	}
    	
    	return ret;
    }
	
	public static void main(String[]args) throws IOException {
		
	// step 1: Create Socket to Listen at port 1234
		DatagramSocket ds = new DatagramSocket(1234);
		byte [] receive = new byte[65535];
		DatagramPacket DpReceive = null;
		
		while(true) {
	// step 2: Create a DatagramPacket to receive the data
			DpReceive = new DatagramPacket(receive,receive.length);
			
	// step 3: Receive the data in byte buffer
			ds.receive(DpReceive);
			
			System.out.println("Client:- " + data(receive));
    
			// Exit the Server if client says "bye"
			if(data(receive).toString().equals("bye")) {
				System.out.print("Client sent bye ... Exitting");
				break;
			}
			
			// clear the buffer after every message
			receive = new byte[65535];
		} // loop ending
		
	}
}

