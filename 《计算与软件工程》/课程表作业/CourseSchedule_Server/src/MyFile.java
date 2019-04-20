import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MyFile {
	String fileName;
	
	public MyFile(String fileName){
		this.fileName = fileName;
	}
	
	public ArrayList<String> readFromFile(){

		ArrayList<String> list = new ArrayList<String>();
		
		try{
			File f = new File("CurriculumSchedule.txt");
			BufferedReader br1=new BufferedReader(new FileReader(f));
			String line;
			
			while((line=br1.readLine())!=null){
				list.add(line);
			}
			br1.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		return list;
	}
	
	public void AppendToFile(String output){

		try{			
			FileWriter writer = new FileWriter(fileName,true);
			writer.write(output);
//			System.out.println(output);
			writer.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
	}

}
