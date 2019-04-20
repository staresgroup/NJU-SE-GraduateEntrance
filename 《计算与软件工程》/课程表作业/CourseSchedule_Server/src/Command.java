
public class Command {
	
	private int cmd=-1;	
	private Course course;
	
	public Command(String input){
		String command;
		
		String[] split = input.split(" ");	
		command = split[0];
		
		String[] cmds = {"Add","Remove","Update","Find","Show"};
		for(int i=0;i<cmds.length;i++){
			if(command.equals(cmds[i])==true){
				cmd = i; 
				break;
			}
		}
		if (cmd != 4)
			course = new Course(split[1]);
		
	}
	
	public int getCmd(){
		return cmd;
	}
	public Course getCourse(){
		return course;
	}

}
