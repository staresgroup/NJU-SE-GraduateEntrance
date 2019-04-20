package chooseClassSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHelper {
	private String host = "localhost";
	private int port = 8888;
	public String sendToNet(String send){
		Socket s = null;
		PrintWriter pw = null;
		BufferedReader br = null;
		String reply = "";
		try{
			s= new Socket(host,port);
			
			pw = new PrintWriter(s.getOutputStream());
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			pw.write(send);
			pw.flush();
			s.shutdownOutput();
			
			reply = br.readLine();
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}finally{
			try {
				br.close();
				pw.close();
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return reply;
	}
}
