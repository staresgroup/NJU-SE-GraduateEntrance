import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;



public class CourseSchedule {
	static public String fileName = "CurriculumSchedule";
	public static void main(String[] args){
		String input = "",output = "";
		String command;
		String courseInfo;
		int cmd = -1;
		//0.Loop
		while(true)
		{
			//1.Input
			//1.1.Prompt

			
			//1.2.Input - get the string of input
			input = inputFromConsole();
//			input = "Add 星期四；三，四节；计算与软件工程；仙2 407；";
//			System.out.println("input:\t"+input);
			
			//1.3.Before
			//1.3.1 Analysis the cmd; get command and courseInfo
//			cmd = 1;//Add cmd
//			courseInfo ="星期四；三，四节；计算与软件工程；仙2 407；";
			cmd = analysisCmd(input);
			courseInfo = analysisCourseInfo(input);
			
			//System.out.println("command:\t"+command);		
//			System.out.println("courseInfo:\t"+courseInfo);
//			System.out.println("cmd:\t"+cmd);
			
			//2.Process
			process(cmd, courseInfo);
			
		}
	}
	public static String inputFromConsole(){
		String input = null;
		BufferedReader br1;
		
		System.out.println("-----------------------------------------");
		System.out.println("请输入命令：");
		try {
			br1 = new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
			input=br1.readLine();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return input;
	}
	public static void process(int cmd, String courseInfo){
		 switch(cmd){
		 case 0: add(courseInfo);break;
		 case 1: remove();break;
		 case 2: update();break;
		 case 3: find();break;
		 case 4: show();break;
	 }
	}

	public static int analysisCmd(String input){
		String command;
		int cmd = -1;
		
		String[] split = input.split(" ");	
		command = split[0];
		
		String[] cmds = {"Add","Remove","Update","Find","Show"};
		for(int i=0;i<cmds.length;i++){
			if(command.equals(cmds[i])==true){
				cmd = i; 
				break;
			}
		}
		return cmd;
	}
	public static String analysisCourseInfo(String input){
		String courseInfo;
		
		String[] split = input.split(" ");		
		courseInfo = split[1]; 
		
		return courseInfo;
	}
	public static void add(String courseInfo){
		boolean avaliable = true;
		//Add
		System.out.println("Adding...");
		//1.Judge whether it could be added
		//1.1 Load all data
		//1.2 Find the schedule whether have already been set.
		
		avaliable= isAvaliableInFile(courseInfo);
		
		//2.1 if avaliable Add to file
		if(avaliable){
			writeToFile(courseInfo+"\n");
		}
		//2.2 else invalid show Wrong Command
		else{
			System.out.println("该时间已经有课了");
		}
		System.out.println("End Adding!");
		System.out.println("-----------------------------------------");
	}
	public static boolean isAvaliableInFile(String courseInfo){
		boolean avaliable = true;
		String day;
		String time;
		String name;
		String location;
		

		
		//get day and time
		String[] split = courseInfo.split("；");
		
		day = split[0];
		time = split[1];
		name = split[2];
		location = split[3];
		
//		System.out.println("courseInfo:"+day+time+name+location);		
		try{
			
			BufferedReader br1=new BufferedReader(new FileReader(fileName));
			String line;
			while((line=br1.readLine())!=null){
				String day2;
				String time2;
				String name2;
				String location2;
				

				//get day and time
				String[] split2 = line.split("；");
				
				day2 = split2[0];
				time2 = split2[1];
				name2 = split2[2];
				location2 = split2[3];
//				System.out.println("line:"+day2+time2+name2+location2);
				if(day.equals(day2)&&time.equals(time2)) {
					avaliable = false;
					break;
				}
			}
			br1.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		return avaliable;
	}
	public static void writeToFile(String output){
		try{			
			FileWriter writer = new FileWriter(fileName,true);
			writer.write(output);
//			System.out.println(output);
			writer.close();
			System.out.println("已添加到文件中\n");
		}catch(IOException ex){
			ex.printStackTrace();
		}	
	}

	public static void remove(){
		//Remove
		System.out.println("Removing...");
	}
	public static void update(){
		//Update
		System.out.println("Update...");
	}
	public static void find(){
		//Find
		System.out.println("Finding...");
	}
	public static void show(){
		//Show
		System.out.println("Showing...");
	}

}
