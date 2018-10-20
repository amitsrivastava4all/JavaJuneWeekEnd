import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {

	public static void main(String[] args) throws IOException {
		final int PORT = 9001;
		ServerSocket server = new ServerSocket(PORT);
		System.out.println("Server Start and Waiting for Client.....");
		Socket socket=  server.accept();
		System.out.println("Client Joins");
		System.out.println("Enter the Data Send to the Client");
		Scanner scanner = new Scanner(System.in);
		String data = scanner.nextLine();
		socket.getOutputStream().write(data.getBytes());
		socket.close();
		System.out.println("Data Send it ");

	}

}
