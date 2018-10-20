import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ipdemo {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress inet = InetAddress.getLocalHost();
		System.out.println(inet.getHostAddress());
		System.out.println(inet.getHostName());
		System.out.println("Enter the Host ");
		String hostName = new Scanner(System.in).next();
		InetAddress net[] = InetAddress.getAllByName(hostName);
		for(InetAddress i : net) {
			System.out.println(i.getHostAddress());
		}
		

	}

}
