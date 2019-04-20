package chooseClassSystem;

import java.util.ArrayList;

/*
 * Class name:			Student
 * Method:				setPassword;setAccount;startWork;register;showCourseList;
 * 						selectCourse;quitCourse;showScore;chooseCommand;
 * Instance variable	account;password;studentLogin;
 */
public class Student {
	public static boolean studentLogin = false;// 表示是否处于登录状态
	private String account;// 储存帐号

	public void setAccount(String account) {
		this.account = account;
	}

	public Student(String account) {
		this.setAccount(account);
	}

	/*
	 * 对命令进行识别
	 */
	public String chooseCommand(String command) {
		String[] commandSplit = command.split(" ");// 分割命令
		int length = commandSplit.length;// 保存命令段的个数
		String toReturn = null;
		if ((length == 2) && commandSplit[0].equals("Show")
				&& commandSplit[1].equals("mycourseList")) {// Show
															// mycourseList指令
			toReturn = this.showCourseList();
		} else if ((length == 3) && commandSplit[0].equals("Select")
				&& commandSplit[1].equals("course")) {// Select指令
			toReturn = this.selectCourse(commandSplit[2]);
		} else if ((length == 3) && commandSplit[0].equals("Quit")
				&& commandSplit[1].equals("course")) {// Quit指令
			toReturn = this.quitCourse(commandSplit[2]);
		} else if ((length == 2) && commandSplit[0].equals("Show")
				&& commandSplit[1].equals("score")) {// Show score指令
			toReturn = this.showScore();
		} else if ((length == 2) && commandSplit[0].equals("Show")
				&& commandSplit[1].equals("CouseList")) {
			toReturn = this.showCourses();
		}
		return toReturn;
	}

	private String showCourses() {
		ArrayList<String> courseList = IOHelper.readFile("CourseList.txt");
		String toReturn = "";
		for (String m : courseList) {
			toReturn = toReturn + m + "\t";
		}
		return toReturn;
	}

	/*
	 * 展示已选的课程列表
	 */
	private String showCourseList() {
		ArrayList<String> studentInfo = IOHelper
				.readFile("ChooseCourseList.txt");
		ArrayList<String> courseInfo = IOHelper.readFile("CourseList.txt");
		String toReturn = "";
		for (String m : studentInfo) {
			String[] infoLine = m.split(" ");
			int length = infoLine.length;
			if (infoLine[0].equals(account)) {
				if (length > 1) {
					for (int i = 1; i < length; i++) {
						String courseNum = infoLine[i].split(";")[0];
						for (int j = 0; j < courseInfo.size(); j++) {
							if (courseInfo.get(j).split(" ")[0]
									.equals(courseNum)) {
								toReturn = toReturn + courseInfo.get(j) + "\t";
							}
						}
					}
				} else {
					toReturn = "未选择任何课程.";
				}
			}
		}
		return toReturn;
	}

	private String selectCourse(String courseNum) {
		if (IOHelper.checkAccount(courseNum, "CourseList.txt")) {
			ArrayList<String> chooseInfo = IOHelper
					.readFile("ChooseCourseList.txt");
			int size = chooseInfo.size();
			boolean ifChoose = false;
			for (int j = 0; j < size; j++) {
				String[] chooseInfoLine = chooseInfo.get(j).split(" ");
				int length = chooseInfoLine.length;
				String afterSelect = chooseInfo.get(j);
				for (int i = 0; i < length; i++) {
					if ((chooseInfoLine[0].equals(this.account))
							&& (chooseInfoLine[i].split(";")[0]
									.equals(courseNum))) {
						ifChoose = true;
					}
				}
				if ((chooseInfoLine[0].equals(this.account))
						&& (ifChoose == false)) {
					afterSelect = afterSelect + " " + courseNum;
				}
				chooseInfo.set(j, afterSelect);
			}
			IOHelper.writeFile("ChooseCourseList.txt", chooseInfo);
			if (ifChoose == false) {
				return "选课成功.";
			} else {
				return "您已经选择过该课程!";
			}
		} else {
			return "不存在该课程号的课程!";
		}
	}

	private String quitCourse(String courseNum) {
		if (IOHelper.checkAccount(courseNum, "CourseList.txt")) {
			ArrayList<String> chooseInfo = IOHelper
					.readFile("ChooseCourseList.txt");
			boolean ifChoose = false;
			int size = chooseInfo.size();
			for (int j = 0; j < size; j++) {
				String afterQuit = "";
				String[] chooseInfoLine = chooseInfo.get(j).split(" ");
				int length = chooseInfoLine.length;
				for (int i = 0; i < length; i++) {
					if ((chooseInfoLine[0].equals(this.account))
							&& (chooseInfoLine[i].split(";")[0]
									.equals(courseNum))) {
						ifChoose = true;
					} else {
						afterQuit = afterQuit + chooseInfoLine[i] + " ";
					}
				}
				chooseInfo.set(j, afterQuit);
			}
			IOHelper.writeFile("ChooseCourseList.txt", chooseInfo);
			if (ifChoose == true) {
				return "退选成功!";
			} else {
				return "错误！您尚未选择该课程!";
			}
		} else {
			return "不存在该课程号的课程!";
		}
	}

	private String showScore() {
		String toReturn = "";
		ArrayList<String> chooseInfo=IOHelper.readFile("ChooseCourseList.txt");
		for(String m:chooseInfo){
			if(m.split(" ")[0].equals(account)&&m.split(" ").length>1){
				String msplit[]=m.split(" ");
				for(int i=1;i<msplit.length;i++){
					toReturn=toReturn+msplit[i]+" ";
				}
			}
		}
		return toReturn;
	}

}
