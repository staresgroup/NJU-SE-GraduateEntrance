import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class ClientHelper {
	private String host = "localhost";
	private int port = 8888;
	public ClientHelper(){
		
	}
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
	
	public List<Course> convert_from_str_to_list(String str){
		String[] ss = str.split("\t");
		List<Course> l = new ArrayList<Course>();
		for(int i=0;i<ss.length;i++){
			Course temp = new Course(ss[i]);
			l.add(temp);
		}
		return l;
	}
	
	public static void main(String args[]){
		ClientHelper ch = new ClientHelper();
		ch.sendToNet("ysmmm");
	}
}
