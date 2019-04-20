package chooseClassSystem;

import java.util.ArrayList;

/*
 * Class name:			Teacher
 * Method:				setPassword;setAccount;startWork;register;publishCourse;
 * 						showCourse;updateCourse;showStudent;recordScore;chooseCommand;
 * Instance variable:	teacherLogin;account;password;
 */
public class Teacher {
	public static boolean teacherLogin = false;// 表示是否处于登录状态
	private String account;// 储存帐号
	
	public void setAccount(String account) {
		this.account = account;
	}

	public Teacher(String account) {
		this.setAccount(account);
	}

	/*
	 * 对命令进行识别
	 */
	public String chooseCommand(String command) {
		String[] commandSplit = command.split(" ");// 分割命令
		int length = commandSplit.length;// 保存命令段的个数
		if ((length > 3) && commandSplit[0].equals("Publish")) {// Publish命令
			return this.publishCourse(command);
		} else if ((length == 3) && commandSplit[0].equals("Show")
				&& commandSplit[1].equals("course")) {// Show course命令
			return this.showCourse(commandSplit[2]);
		} else if ((length == 3) && commandSplit[0].equals("Show")
				&& commandSplit[1].equals("student")) {// Show student命令
			return this.showStudent(commandSplit[2]);
		} else if ((length > 3) && commandSplit[0].equals("Record")
				&& commandSplit[1].equals("score")) {// Record score命令
			return this.recordScore(command);
		} else if ((length > 3) && commandSplit[0].equals("Update")
				&& commandSplit[1].equals("course")) {
			return this.updateCourse(command);
		} else {
			return "";
		}
	}

	/*
	 * 发布课程
	 */
	private String publishCourse(String command) {
		String info = "";// 用于存放课程信息
		String split[] = command.split(" ");
		for (int i = 1; i < split.length; i++) {
			info = info + split[i] + " ";
		}
		if (info.length() != 0) {
			if (!IOHelper.checkAccount(info.split(" ")[0], "CourseList.txt")) {
				ArrayList<String> toWrite = IOHelper.readFile("CourseList.txt");
				toWrite.add(info);
				IOHelper.writeFile("CourseList.txt", toWrite);
				return "写入成功.";
			} else {
				return "课程号已被使用。";
			}
		} else {
			return "您输入的课程号为空，";
		}
	}

	/*
	 * 查看教师本人发布的课程
	 */
	private String showCourse(String courseNum) {
		if (courseNum.length() == 0) {// 输入为空时
			return "输入为空.";
		} else if (courseNum.equals("*")) {// 输入为"*"时
			ArrayList<String> courseList = IOHelper.readFile("CourseList.txt");
			String toReturn = "";
			for (String m : courseList) {
				for (String n : m.split(" ")[7].split(";")) {
					if (n.equals(this.account)) {
						toReturn = toReturn + m + "\t";
					}
				}
			}
			return toReturn;
		} else if (IOHelper.checkAccount(courseNum, "CourseList.txt")) {// 输入为课程号且该课程存在时
			ArrayList<String> courseToShow = IOHelper
					.readFile("CourseList.txt");
			for (String m : courseToShow) {
				if (m.split(" ")[0].equals(courseNum)) {
					return m;
				}
			}
			return "输出完毕.";
		} else {// 输入的课程不存在时
			return "不存在该课程号的课程.";
		}
	}

	/*
	 * 更新已发布的课程
	 */
	private String updateCourse(String command) {
		String courseinfo = "";
		String[] split = command.split(" ");
		String courseToUpdate = split[2];
		for (int i = 3; i < split.length; i++) {
			courseinfo = courseinfo + split[i] + " ";
		}
		ArrayList<String> courseArray = IOHelper.readFile("CourseList.txt");
		int size = courseArray.size();
		int toUpdate = -1;
		for (int i = 0; i < size; i++) {
			String num = courseArray.get(i).split(" ")[0];
			if (num.equals(courseToUpdate)) {
				toUpdate = i;
			}
		}
		if (courseinfo.length() != 0) {
			if (!IOHelper.checkAccount(courseinfo, "CourseList.txt")) {
				courseArray.set(toUpdate, courseinfo);
				IOHelper.writeFile("CourseList.txt", courseArray);
				return "更新完毕.";
			} else {
				return "课程号已被使用.";
			}
		} else {
			return "您输入的课程号为空.";
		}

	}

	private String showStudent(String courseNum) {
		String toReturn = "";
		if (courseNum.length() != 0) {
			if (IOHelper.checkAccount(courseNum, "CourseList.txt")) {
				ArrayList<String> chooseCourseList = IOHelper
						.readFile("ChooseCourseList.txt");
				for (String m : chooseCourseList) {
					for (String n : m.split(" ")) {
						if (n.split(";")[0].equals(courseNum)) {
							toReturn = toReturn + m.split(" ")[0];
							if (n.split(";").length > 1) {
								toReturn = toReturn + ";" + n.split(";")[1];
							}
							toReturn = toReturn + " ";
						}
					}
				}
				return toReturn;
			} else {
				return "不存在该课程号的课程.";
			}
		} else {
			return "您输入的课程号为空.";
		}
	}

	private String recordScore(String command) {
		String[] split = command.split(" ");
		String courseNum = split[2];
		String studentNum = split[3];
		String score = split[4];
		String toReturn = null;
		boolean studentFindIf = false;
		boolean courseFindIf = false;
		boolean haveRightIf = false;
		ArrayList<String> courseList = IOHelper.readFile("CourseList.txt");
		for (String line : courseList) {// 老师是否有该课程权限
			if (line.split(" ")[0].equals(courseNum)) {
				String info[] = line.split(" ")[7].split(";");
				for (String teacher : info) {
					if (teacher.equals(account)) {
						haveRightIf = true;
					}
				}
			}
		}
		if (IOHelper.checkAccount(courseNum, "CourseList.txt")) {// 该课程是否存在
			if (haveRightIf == true) {// 是否拥有权限
				ArrayList<String> chooseCourseList = IOHelper
						.readFile("ChooseCourseList.txt");
				int size = chooseCourseList.size();
				for (int j = 0; j < size; j++) {
					String[] mSplit = chooseCourseList.get(j).split(" ");
					int length = mSplit.length;
					String afterRecord = "";
					if (mSplit[0].equals(studentNum)) {// 该课程中是否有该学生
						studentFindIf = true;
						for (int i = 0; i < length; i++) {
							if (mSplit[i].split(";")[0].equals(courseNum)) {
								courseFindIf = true;
								if (mSplit[i].split(";").length == 1) {// 是否已经为该学生登记了成绩
									afterRecord = afterRecord + mSplit[i] + ";"
											+ score + " ";
									toReturn = "成功.";
								} else {
									afterRecord = afterRecord + mSplit[i] + " ";
									toReturn = "该学生已经登记了成绩.";
								}
							} else {
								afterRecord = afterRecord + mSplit[i] + " ";
							}
						}
						chooseCourseList.set(j, afterRecord);
					}
				}
				if (studentFindIf == false) {
					toReturn = "未找到该学生号.";
				}
				if (studentFindIf == true && courseFindIf == false) {
					toReturn = "该学生未选择该课程.";
				}
				IOHelper.writeFile("ChooseCourseList.txt", chooseCourseList);
			} else {
				toReturn = "你未拥有该课程权限.";
			}
		} else {
			toReturn = "不存在该课程号的课程.";
		}

		return toReturn;
	}

}
