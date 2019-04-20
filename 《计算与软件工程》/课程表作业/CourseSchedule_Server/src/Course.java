
public class Course {
	String day;
	String time;
	String name;
	String location;

	public Course(String c){
		//get day and time
		String[] split = c.split(";");
		
		day = split[0];
		time = split[1];
		name = split[2];
		location = split[3];
	}
	
	public String toString(){
		return day+";"+time+";"+name+";"+location;
	}

}
