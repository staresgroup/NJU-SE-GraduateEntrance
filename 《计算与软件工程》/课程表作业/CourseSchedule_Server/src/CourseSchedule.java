
import java.util.ArrayList;

public class CourseSchedule {
	
	ArrayList<Course> courseList = new ArrayList<Course>();
	MyFile file;
	ServerHelper sh;

	
	public CourseSchedule(String fileName){

		file = new MyFile(fileName);
		System.out.println("File : "+file);
		ArrayList<String> list = file.readFromFile();
		
		for(String s:list)
			courseList.add(new Course(s));
		
		sh = new ServerHelper(this);
		
	}
	
	public void start(){
		sh.startServer();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CourseSchedule cs = new CourseSchedule("CurriculumSchedule.txt");
		cs.start();
	}
	
	public String processNet(String input){
		
		Command command = new Command(input);
		
		int cmd = command.getCmd();
		System.out.println("cmd is " + cmd);
		
		Course course = command.getCourse();
		
		String reply = process(cmd, course);
		
		return reply;
	}
	
	public void run(){
		MyConsole console = new MyConsole();
		
		while(true){
			
			String input = console.inputFromConsole();
			
			Command command = new Command(input);
			
			int cmd = command.getCmd();
			
			Course course = command.getCourse();
			
			process(cmd, course);
		}
	}
	public String process(int cmd, Course course){
		 String ret = null;
		 switch(cmd){
		 case 0: ret = add(course);break;
		 case 1: ret = remove();break;
		 case 2: ret = update();break;
		 case 3: ret = find();break;
		 case 4: ret = show();break;
	 }
		 return ret;
	}
	
	public String add(Course c){
		boolean isOK = false;
		
		isOK = isOKtoAdd(c);
		if(isOK){
			courseList.add(c);
		}
		
		file.AppendToFile(c.toString()+"\n");
		return "add";
	}
	public boolean isOKtoAdd(Course c){
		boolean isOK = true;
		
		for(Course course:courseList){
			if(course.day.equals(c.day)&&course.time.equals(c.time)){
				isOK = false;
				break;
			}
		}
		
		return isOK;
	}
	public String remove(){
		//Remove
		
		System.out.println("Removing...");
		return "remove";
	}
	public String update(){
		//Update
		System.out.println("Update...");
		return "update";
	}
	public String find(){
		//Find
		System.out.println("Finding...");
		return "find";
	}
	public String show(){
		//Show
		String ret = sh.convert_list_to_str(courseList);
		return ret;
	}

}
