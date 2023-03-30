import java.net.*;

// datagram socket is connection less so we have to make two different class one for receiver and one for sender
public class DatagramSocket_Receiver {
      public static void main(String[]args) throws Exception {
    	  
    	  DatagramSocket ds = new DatagramSocket(3000);
    	  byte [] buf = new byte[1024];
    	  DatagramPacket dp = new DatagramPacket(buf,1024);
    	  
    	  ds.receive(dp);
    	  String str  = new String (dp.getData(),dp.getLength());
    	  
    	  System.out.print(str);
          ds.close();
      }
}
