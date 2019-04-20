package chooseClassSystem;

public class Course {
	private String number;
	private String name;
	private String location;
	private String startTime;
	private String endTime;
	private String credit;
	private String ifNecessary;
	private String teacherName;
	private String teacherAssistant;

	public Course() {

	}

	public Course(String courseinfo) {
		String course[] = courseinfo.split(" ");
		try {
			this.number = course[0];
			this.name = course[1];
			this.location = course[2];
			this.startTime = course[3];
			this.endTime = course[4];
			this.credit = course[5];
			this.ifNecessary = course[6];
			this.teacherName = course[7];
			this.teacherAssistant = course[8];
		} catch (Exception e) {
		}
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public void setTeacherAssistant(String teacherAssistant) {
		this.teacherAssistant = teacherAssistant;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public void setIfNecessary(String ifNecessary) {
		this.ifNecessary = ifNecessary;
	}

	public String toString() {
		return number + " " + name + " " + location + " " + startTime + " "
				+ endTime + " " + credit + " " + ifNecessary + " "
				+ teacherName + " " + teacherAssistant;
	}
}
