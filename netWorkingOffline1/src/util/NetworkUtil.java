package util;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class NetworkUtil
{
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    // By Nafee
    public boolean isConnected()
    {
        return socket.isConnected();
    }

    //By Nafee
    public InetAddress getInetAddress()
    {
        return socket.getInetAddress();
    }

    // By Nafee
    public void fileSend(String filePath) throws FileNotFoundException, IOException
    {
        FileInputStream fin;
        int size;
        fin = new FileInputStream(filePath);
        size=fin.available();
        this.write(size);
        int totalBlock=(size/1024)+1;
        byte [] b;
        for(int i=1;i<=totalBlock;i++)
        {
            if(i==totalBlock)
            {
                b=new byte[size%1024];
                //fin.read(b);
            }
            else
            {
                b=new byte[1024];
                //fin.read(b);
            }
            fin.read(b);
            //outToServer.write(b);
            this.write(b);
        }
        fin.close();
    }

    // By Nafee
    public void fileReceive(String filePath) throws IOException
    {
        int size;
        size=(Integer)this.read();
        int totalBlock=(size/1024)+1;
        filePath=filePath + "/answerFile.doc";

        FileOutputStream fout=new FileOutputStream(filePath);

        byte [] buffer;

        for(int i=1;i<=totalBlock;i++)
        {
            if(i==totalBlock)
            {

                buffer=new byte[size%1024];
            }
            else
            {

                buffer=new byte[1024];
            }
            buffer=(byte[])this.read();
            fout.write(buffer);
        }
        fout.close();
    }

    public NetworkUtil(String s, int port) {
        try {
            this.socket=new Socket(s,port);
            oos=new ObjectOutputStream(socket.getOutputStream());
            ois=new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println("In NetworkUtil : " + e.toString());
        }
    }

    public NetworkUtil(Socket s) {
        try {
            this.socket = s;
            oos=new ObjectOutputStream(socket.getOutputStream());
            ois=new ObjectInputStream(socket.getInputStream());
        } catch (Exception e) {
            System.out.println("In NetworkUtil : " + e.toString());
        }
    }

    public Object read() {
        Object o = null;
        try {
            o=ois.readObject();
        } catch (Exception e) {
            //System.out.println("Reading Error in network : " + e.toString());
        }
        return o;
    }

    public void write(Object o) {
        try {
            oos.writeObject(o);
        } catch (IOException e) {
            System.out.println("Writing  Error in network : " + e.toString());
        }
    }

    public void closeConnection() {
        try {
            ois.close();
            oos.close();
        } catch (Exception e) {
            System.out.println("Closing Error in network : "  + e.toString());
        }
    }
}

