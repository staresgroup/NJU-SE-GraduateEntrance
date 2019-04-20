package d;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Student s1 = new Student(1,"Lucy", 17);
		Student s2 = new Student(2,"Alice", 19);
		Student s3 = new Student(3,"Bill", 20);
		Student s4 = new Student(4,"David", 18);
		Student s5 = new Student(5,"Tom", 18);
		Student s6 = new Student(6,"Peter", 21);
		Student s7 = new Student(7,"张三", 16);
		Student s8 = new Student(8,"李四", 17);
		Student s9 = new Student(9,"王五", 11);
		Student s10 = new Student(10,"赵六", 22);
		Student s11 = new Student(11,"孙七", 18);
		
		ArrayList<Student> list1 = new ArrayList<Student>();
		list1.add(s1);
		list1.add(s2);
		list1.add(s3);
		list1.add(s4);
		list1.add(s5);
		list1.add(s8);
		
		ArrayList<Student> list2 = new ArrayList<Student>();
		list2.add(s5);
		list2.add(s6);
		list2.add(s7);
		list2.add(s8);
		list2.add(s9);
		list2.add(s10);
		list2.add(s11);
		
	}
}
