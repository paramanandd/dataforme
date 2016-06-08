package chatClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client 
{
	public static void main(String args[]) throws Exception
	{
		Socket sk=new Socket("Localhost",2000);                   //Creating Socket Class Object
		BufferedReader sin=new BufferedReader(new InputStreamReader(sk.getInputStream()));
		PrintStream sout=new PrintStream(sk.getOutputStream());
		BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
		String s;
		
		while (true)
		{
			System.out.print("Client : ");
			s=stdin.readLine();                      //Reading
			sout.println(s);                         //Displaying on Console
			s=sin.readLine();
			System.out.print("Server : "+s+"\n");
  			if ( s.equalsIgnoreCase("BYE") )
 			   break;
		}
		 sk.close();
		 sin.close();
		 sout.close();
 		 stdin.close();
	}
}
