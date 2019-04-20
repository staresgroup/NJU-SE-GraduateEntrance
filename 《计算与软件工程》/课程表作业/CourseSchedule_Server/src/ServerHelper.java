import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;


public class ServerHelper {
	int port = 8888;
	private ServerSocket ss = null;
	private CourseSchedule csd = null;
	
	public ServerHelper(CourseSchedule csd){
		this.csd = csd;
		try {
			ss = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void startServer(){
		
		Socket s = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		while(true){
			try{
				s = ss.accept();
				
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				pw = new PrintWriter(s.getOutputStream());
				
				String read_str = br.readLine();
				System.out.println("the request from client is :" + read_str);
				
				String replay = csd.processNet(read_str);
				System.out.println("The replay is " +  replay);
				
				pw.write(replay);
				pw.flush();
				
			}catch(IOException ioe){
				ioe.printStackTrace();
			}finally{
				try{
					br.close();
					pw.close();
					s.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public String convert_list_to_str(List<Course> courseList){
		StringBuilder sb = new StringBuilder();
		for(Course cs:courseList){
			sb.append(cs.toString());
			sb.append("\t");
		}
		return sb.toString();
	}
	
	public void stopServer(){
		try {
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
