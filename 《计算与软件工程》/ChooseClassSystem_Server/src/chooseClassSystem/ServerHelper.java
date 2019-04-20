package chooseClassSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerHelper {
	int port = 8888;
	LogIn li=null;
	private ServerSocket ss = null;
	private int modeNum=0;
	String account=null;
	String password=null;
	
	public static void main(String args[]){
		ServerHelper sh=new ServerHelper();
		try {
			sh.ss = new ServerSocket(sh.port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sh.li=new LogIn();
		sh.startServer();
	}
	
	public void startServer(){
		Socket s = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		System.out.println("¿ªÊ¼¼àÌý.");
		while(modeNum==0){
			try{
				s = ss.accept();
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				pw = new PrintWriter(s.getOutputStream());
				String read_str = br.readLine();
				System.out.println("the request from client is :" + read_str);
				String reply=li.chooseMode(read_str);
				System.out.println("The reply is "+reply);
				pw.write(reply);
				pw.flush();
				if(reply.equals("true")){
					String[] readsplit=read_str.split(" ");
					if(readsplit.length>2){
						switch(readsplit[1]){
						case "Student": modeNum=2;account=readsplit[2];password=readsplit[3];break;
						case "Teacher": modeNum=3;account=readsplit[2];password=readsplit[3];break;
						default: modeNum=1;password=readsplit[2];
						}
					}
				}
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
		if(modeNum==1){
			Administrator admin=new Administrator(password);
			while(true){
				try{
					s = ss.accept();
					br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					pw = new PrintWriter(s.getOutputStream());
					String read_str = br.readLine();
					System.out.println("the request from client is :" + read_str);
					String reply=admin.chooseCommand(read_str);
					System.out.println("The reply is "+reply);
					pw.write(reply);
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
		}else if(modeNum==2){
			Student st=new Student(account);
			while(true){
				try{
					s = ss.accept();
					br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					pw = new PrintWriter(s.getOutputStream());
					String read_str = br.readLine();
					System.out.println("the request from client is :" + read_str);
					String reply=st.chooseCommand(read_str);
					System.out.println("The reply is "+reply);
					pw.write(reply);
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
		}else if(modeNum==3){
			Teacher tc=new Teacher(account);
			while(true){
				try{
					s = ss.accept();
					br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					pw = new PrintWriter(s.getOutputStream());
					String read_str = br.readLine();
					System.out.println("the request from client is :" + read_str);
					String reply=tc.chooseCommand(read_str);
					System.out.println("The reply is "+reply);
					pw.write(reply);
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
	}
}
