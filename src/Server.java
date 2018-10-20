import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final int PORT = 9100;
		ServerSocket server = new ServerSocket(PORT);
		System.out.println("Server Start and waiting for client....");
		Socket socket = server.accept();
		System.out.println("Here comes the client....");
		InputStream is = socket.getInputStream();
		DataInputStream di = new DataInputStream(is);
		String msg = di.readUTF();
		//byte arr[] = is.readAllBytes();
		//String msg = new String(arr);
		System.out.println("Client Said "+msg);
		is.close();
		socket.close();
		
		

	}

}


