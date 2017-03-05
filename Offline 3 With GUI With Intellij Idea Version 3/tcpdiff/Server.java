package tcpdiff;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

import util.NetworkUtil;

public class Server implements Runnable{

	private ServerSocket ServSock;
	public int i = 1;
	public Hashtable<String, NetworkUtil> table;
	Thread thr;
	public static ServerStarter main;

	public void setMain(ServerStarter M)
	{
		main = M;
	}

	Server(Hashtable<String, NetworkUtil> table) {
		this.table = table;
		thr =new Thread(this);
		thr.start();
	}

	public void run()
	{
		try {
			ServSock = new ServerSocket(33333);
			//new WriteThreadServer(table, "Server");
			while (true) {
				Socket clientSock = ServSock.accept();
				NetworkUtil nc=new NetworkUtil(clientSock);
				//table.put("c"+ i++, nc);
				ReadThreadServer readThreadServer = new ReadThreadServer(nc, table);
				readThreadServer.setMain(main);
			}
		}catch(Exception e) {
			System.out.println("Server starts:"+e);
		}
	}
	


	/*
	public static void main(String args[]) {
		Server objServer = new Server();
	}
	*/
}


