package chooseClassSystem;

import java.util.ArrayList;

/*
 * Class name              Administrator
 * Method                  setPassword;setAccount;chooseCommand;changePassword;delete;show;startWork;
 * Instance variable       administratorLogin;account;password;
 */

public class Administrator {
	private final String account = "admin";
	private String password;
	public static boolean administratorLogin = false;

	public void setPassword(String password) {
		this.password = password;
	}

	public Administrator(String password) {
		this.setPassword(password);
	}

	/*
	 * 对命令进行识别
	 */
	public String chooseCommand(String command) {
		String[] commandSplit = command.split(" ");// 对指令进行分割存放
		int length = commandSplit.length; // 指令的长度
		String toReturn = null;
		if ((length == 2) && (commandSplit[0].equals("Show"))) {// show命令
			toReturn = this.show(commandSplit[1]);
		} else if ((length == 3)
				&& (commandSplit[0].equals("ChangePassword") && commandSplit[1]
						.equals("admin"))) {// ChangPassword命令
			password = commandSplit[2];
			toReturn = this.changePassword(password);
		} else if ((length == 3) && (commandSplit[0].equals("Delete"))) {// Delete命令
			toReturn = this.delete(commandSplit[1], commandSplit[2]);
		} else {// 输入错误
			toReturn = "fail";
		}
		return toReturn;
	}

	/*
	 * 修改密码
	 */
	private String changePassword(String NewPassword) {
		ArrayList<String> accountPassword = null;// 用于存放读取出的帐号密码
		/*
		 * 读取帐号密码
		 */
		accountPassword = IOHelper.readFile("Administrator.txt");
		/*
		 * 检索帐号，并修改对应密码
		 */
		int Size = accountPassword.size();
		for (int i = 0; i < Size; i++) {
			String accountPasswordToString = accountPassword.get(i);
			String[] accountPasswordString = accountPasswordToString.split(" ");
			String accountToCheck = accountPasswordString[0];
			if (accountToCheck.equals(account)) { // 修改密码并写回
				String afterChange = account + " " + NewPassword;
				accountPassword.set(i, afterChange);
				break;
			}
		}
		IOHelper.writeFile("Administrator.txt", accountPassword);
		return "true";
	}

	/*
	 * 查看数据列表
	 */
	private String show(String listName) {
		String location = null;// 设定一个字符串用于存放数据文本位置
		if (listName.equals("老师列表")) {
			location = "TeacherList.txt";
		} else if (listName.equals("学生列表")) {
			location = "StudentList.txt";
		} else if (listName.equals("课程列表")) {
			location = "CourseList.txt";
		} else if (listName.equals("选课列表")) {
			location = "ChooseCourseList.txt";
		}
		ArrayList<String> toPrint = IOHelper.readFile(location);
		String toReturn = "";
		for (String s : toPrint) {
			toReturn = toReturn + s + "\t";
		}
		return toReturn;
	}

	/*
	 * 删除数据列表中的某个元素
	 */
	private String delete(String listName, String number) { // 删除数据列表
		boolean error = true;// 设定一个用于检测命令是否错误的布尔代数
		String location = null;// 设定一个字符串用于存放数据文本位置
		if (listName.equals("老师列表")) {
			location = "TeacherList.txt";
		} else if (listName.equals("学生列表")) {
			location = "StudentList.txt";
		} else if (listName.equals("课程列表")) {
			location = "CourseList.txt";
		} else if (listName.equals("选课列表")) {
			location = "ChooseCourseList.txt";
		} else {
			error = false;
		}
		if (error == true) {
			ArrayList<String> accountPassword = null;
			/*
			 * 从文件中读出数据
			 */
			accountPassword = IOHelper.readFile(location);
			int numberInt = Integer.parseInt(number) - 1;
			accountPassword.remove(numberInt); // 删除指定项
			/*
			 * 覆盖写回
			 */
			IOHelper.writeFile(location, accountPassword);
			return "true";
		} else {
			return "false";
		}

	}

}
