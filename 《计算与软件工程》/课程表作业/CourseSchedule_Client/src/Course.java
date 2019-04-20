
public class Course {
	private String day;
	private String time;
	private String name;
	private String location;

	public String getDay() {
		return day;
	}

	public String getTime() {
		return time;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public Course(String c){
		//get day and time
		String[] split = c.split(";");
		
		day = split[0];
		time = split[1];
		name = split[2];
		location = split[3];
	}
	
	public String toString(){
		return day+"£»"+time+"£»"+name+"£»"+location;
	}


}
