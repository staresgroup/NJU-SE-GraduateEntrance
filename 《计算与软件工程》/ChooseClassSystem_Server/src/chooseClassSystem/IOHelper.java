package chooseClassSystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class IOHelper {
	public static void writeFile(String location, ArrayList<String> toWrite) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
					location)));
			for (String m : toWrite) {
				writer.write(m);
				writer.write("\r\n");
			}
			writer.close();
		} catch (IOException e) {
		} finally {
		}
	}

	public static ArrayList<String> readFile(String location) {
		ArrayList<String> toReturn = new ArrayList<String>();// 用于存放读取出的数据
		String nextLine = null;
		try {
			FileReader reader = new FileReader(location);
			BufferedReader br = new BufferedReader(reader);
			while ((nextLine = br.readLine()) != null) {
				toReturn.add(nextLine);
			}
			br.close();
			reader.close();
		} catch (IOException e) {
		} finally {
		}
		return toReturn;
	}

	/*
	 * 用来检验帐号是否已经被注册
	 */
	public static boolean checkAccount(String account, String location) {
		boolean toReturn = false;// 用来储存代表是否已经存在帐号的返回值
		ArrayList<String> accountPassword = null;// 存放读取出的帐号
		accountPassword = IOHelper.readFile(location);
		/*
		 * 校对用户名密码
		 */
		int Size = accountPassword.size();
		for (int i = 0; i < Size; i++) {
			String accountPasswordToString = accountPassword.get(i);
			String[] accountPasswordString = accountPasswordToString.split(" ");
			String accountToCheck = accountPasswordString[0];
			if (accountToCheck.equals(account)) {
				toReturn = true;
				break;
			}
		}
		return toReturn;
	}

	/*
	 * 检验用户名和密码是否正确
	 */
	public static boolean checkAccountPassword(String account, String password,
			String location) {
		boolean toReturn = false;// 用来代表帐号是否正确
		ArrayList<String> accountPassword = null;// 用于存放读取出的帐号密码数据
		accountPassword = IOHelper.readFile(location);
		/*
		 * 校对帐号密码
		 */
		int Size = accountPassword.size();
		for (int i = 0; i < Size; i++) {
			String accountPasswordToString = accountPassword.get(i);
			String[] accountPasswordString = accountPasswordToString.split(" ");
			int length = accountPasswordString.length;
			if (length > 1) {
				String accountToCheck = accountPasswordString[0];
				String passwordToCheck = accountPasswordString[1];
				if ((accountToCheck.equals(account))
						&& (passwordToCheck.equals(password))) {
					toReturn = true;
					break;
				}
			}
		}
		return toReturn;// 返回检验结果
	}
}
