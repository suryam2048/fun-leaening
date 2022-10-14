import java.net.*;
import java.io.*;
public class EchoServer
{
 public static void main(String args[])
 {
 int port = 8000;
 ServerSocket serverSocket = null;
 DataInputStream dataInputStream = null;
 DataOutputStream dataOutputStream = null;
 try
 {
 // open a server socket
 serverSocket = new ServerSocket(port);
 System.out.println("Server created on port "+port);
 System.out.println("Awaiting client connection...");
 // await for a client connection
 Socket clientSocket = serverSocket.accept();
 System.out.println("Client connected from"+clientSocket.getInetAddress());
 dataInputStream = new DataInputStream
 (clientSocket.getInputStream());
 dataOutputStream = new DataOutputStream
 (clientSocket.getOutputStream());
 }
 catch(IOException e)
 {
 System.out.println("Problems initializing server: "+e);
 System.exit(1);
 }
 // communicate with the client
 try
 {
 dataOutputStream.writeUTF("Welcome to the TCP EchoServer!");
 String input;
 while(true)
 {
 // read data in from client
 input = dataInputStream.readUTF();
 System.out.println("You typed: "+input);
 // write data back to client
 dataOutputStream.writeUTF(input);
 }
 }
 catch(IOException e)
 {
 System.out.println("Client disconnected from server");
 }
 try
 {
 serverSocket.close();
 }
 catch(Exception e) { }
 } }