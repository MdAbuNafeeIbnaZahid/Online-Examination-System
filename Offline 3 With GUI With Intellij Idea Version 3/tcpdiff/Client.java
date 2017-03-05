package tcpdiff;

import util.NetworkUtil;

import java.util.Scanner;

public class Client 
{
	//public static void main(String args[])
	Client(String clientName){
		try {

			//Scanner scanner = new Scanner(System.in);


			//String cName = scanner.nextLine();
            String serverAddress="127.0.0.1";
            int serverPort=33333;
			NetworkUtil nc = new NetworkUtil(serverAddress,serverPort);
			new ReadThreadClient(nc);
			//new WriteThreadClient(nc, cName);
			nc.write(clientName);
		} catch(Exception e) {
			System.out.println (e);
		}
	}
}

