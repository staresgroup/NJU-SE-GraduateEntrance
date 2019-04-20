package chooseClassSystem;

/*                        
 * Version information     Version 2
 * author                  Peiwen Sun 121250134
 * Date                    2013.5.16
 */

/*
 * Class name              LogIn
 * Method                  main;readCommand;chooseMode;checkAccountPassword;
 * Instance variable       no instance variable
 */
public class LogIn {
	/*
	 * 对命令进行区分,分作数步进行。
	 */
	public String chooseMode(String Receive) {
		boolean error = true; // 新建一个布尔代数来检验是否已经出错

		/*
		 * 对命令的长度进行检验
		 */
		String[] afterSplit = Receive.split(" ");
		int length = afterSplit.length;
		if ((length != 3) && (length != 4)) {
			error = false;
		}

		/*
		 * 对于管理员登录的指令
		 */
		if ((length == 3) && (error == true)) {
			String command = afterSplit[0]; // 命令部分
			String account = afterSplit[1]; // 帐号部分
			String password = afterSplit[2]; // 密码部分
			if ((command.equals("Login")) && (account.equals("admin"))) {
				Administrator.administratorLogin = IOHelper
						.checkAccountPassword(account, password,
								"Administrator.txt");
				if (Administrator.administratorLogin == false) {
					error = false;
				}
			} else {
				error = false;
			}
		}

		/*
		 * 对于教师或学生的指令
		 */
		if ((length == 4) && (error == true)) {
			String command = afterSplit[0]; // 命令部分
			String mode = afterSplit[1]; // 模式部分
			String account = afterSplit[2]; // 帐号部分
			String password = afterSplit[3];// 密码部分
			/*
			 * 检测命令前两项是否正确，并由前两项分别进入登录、注册或者学生、老师界面
			 */
			if ((!(command.equals("Login") || command.equals("Register")))
					|| (!(mode.equals("Teacher") || mode.equals("Student")))) {// 若命令错误
				error = false;
			} else if ((command.equals("Login")) && (error == true)) {
				if (mode.equals("Teacher")
						&& (IOHelper.checkAccountPassword(account, password,
								"TeacherList.txt"))) {// 若为教师登录且帐号密码正确
					Teacher.teacherLogin = true;
				} else if (mode.equals("Student")
						&& (IOHelper.checkAccountPassword(account, password,
								"StudentList.txt"))) {// 若为学生登录且帐号密码正确
					Student.studentLogin = true;
				} else {// 若密码错误
					error = false;
				}
			}
		}
		if(error==false){
			return "false";
		}else{
			return "true";
		}
	}

}
