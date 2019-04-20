package d;

public class Student {

	private int stu_no;
	private String name;
	private int age;
	
	public int getStu_no() {
		return stu_no;
	}

	public void setStu_no(int stu_no) {
		this.stu_no = stu_no;
	}

	public Student(int sn, String n, int a) {
		this.stu_no = sn;
		this.name = n;
		this.age = a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
