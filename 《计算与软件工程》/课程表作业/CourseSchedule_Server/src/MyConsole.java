import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MyConsole {
	
	public String inputFromNet(){
		return "";
	}

	public String inputFromConsole(){
		String input = null;
		BufferedReader br1;
		
		System.out.println("-----------------------------------------");
		System.out.println("Please enter the cmd£º");
		
		try {
			br1 = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
			input=br1.readLine();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		return input;
	}
	
	public void outputToConsole(String s){
		System.out.println(s);
	}

}
