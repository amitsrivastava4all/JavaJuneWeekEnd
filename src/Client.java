import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
public static void main(String[] args) throws UnknownHostException, IOException {
	String serverIP = "192.168.1.78";
	Socket socket = new Socket(serverIP,9100);
	System.out.println("Enter the Message Send to the Server...");
	String msg = new Scanner(System.in).nextLine();
	OutputStream os = socket.getOutputStream();
	DataOutputStream ds = new DataOutputStream(os);
	ds.writeUTF(msg);
	ds.close();
	os.close();
	//os.write(msg.getBytes());
	//os.close();
	socket.close();
	System.out.println("Data Send to the Server....");
}
}
