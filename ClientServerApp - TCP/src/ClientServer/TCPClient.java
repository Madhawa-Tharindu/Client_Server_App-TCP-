package ClientServer;
import java.io.*;
import java.net.*;

public class TCPClient {

	public static void main(String[] args) throws Exception {
		
		String sentence;    //sending sentence
		String modifiedSentence;  // retrieving sentence from the TCP server
		
		//fetch user input
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		// InputStreamReader read data byte by byte
		
		// create a client socket to get..
		Socket clientSocket = new Socket("localhost", 9806);
		
		System.out.println("Enter a string: ");
		
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
		sentence = inFromUser.readLine();
		
		outToServer.writeBytes(sentence + '\n');
		
		modifiedSentence = inFromServer.readLine();
		
		System.out.println("FROM SERVER : " + modifiedSentence);
		
		clientSocket.close();
	}

}
