package ClientServer;
import java.net.*;
import java.io.*;

public class TCPServer {

	public static void main(String[] args) throws Exception{
		
		String clientSentence;
		String capitalizedSentence;
		
		System.out.println("Waiting for clients");
		
		//creating welcome socket
		ServerSocket welcomeSocket = new ServerSocket(9806);
		
		while(true) {
			Socket connectionSocket = welcomeSocket.accept();
			System.out.println("Connection is stablished");
			
			System.out.println("getting client data..");
			
			//To read the strings (data) that was client sent, we should implement a input stream
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			
			//for send data to client
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
			//store client sentence
			clientSentence = inFromClient.readLine();
			// capitalized the client sentence
			capitalizedSentence = clientSentence.toUpperCase() + '\n';
			
			//send data byte to byte
			outToClient.writeBytes(capitalizedSentence);
		}

	}

}
