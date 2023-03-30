import java.net.*;

// sender 
public class DatagramSocket_Sender {
	public static void main(String[]args) throws Exception {
		DatagramSocket ds = new DatagramSocket();
		String str = "Hey It's me Sq ";
		InetAddress ip = InetAddress.getLocalHost();
		
		DatagramPacket dp = new DatagramPacket(str.getBytes(),str.length(),ip,3000); // port number:3000 should be same in both receiver and sender
	    ds.send(dp);
	    ds.close();
	}
}

