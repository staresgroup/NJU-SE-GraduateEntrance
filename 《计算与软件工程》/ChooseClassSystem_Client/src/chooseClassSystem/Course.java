package chooseClassSystem;

public class Course {
	private String number;
	private String name;
	private String location;
	private String startTime;
	private String endTime;
	private String teacherName;
	private String teacherAssistant;
	private String credit;
	private boolean ifNecessary;

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
		if (ifNecessary.equals("ÊÇ")) {
			this.ifNecessary = true;
		} else {
			this.ifNecessary = false;
		}
	}

	public String toString() {
		if (ifNecessary == true) {
			return number + " " + name + " " + location + " " + startTime + " "
					+ endTime + " " + credit + " " + "±ØÐÞ" + " " + teacherName
					+ " " + teacherAssistant;
		} else {
			return number + " " + name + " " + location + " " + startTime + " "
					+ endTime + " " + credit + " " + "Ñ¡ÐÞ" + " " + teacherName
					+ " " + teacherAssistant;
		}
	}
}
