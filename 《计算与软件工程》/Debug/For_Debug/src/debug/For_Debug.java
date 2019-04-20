package debug;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class For_Debug {
	public For_Debug(StringBuffer sb1, StringBuffer sb2, StringBuffer sb3) {
		ArrayList<String> pass = new ArrayList<String>();
		FileReader fr = null;
		FileWriter fw = null;
		FileWriter fw2 = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(sb1.toString());
			br = new BufferedReader(fr);
			fw = new FileWriter(sb2.toString());
			fw2 = new FileWriter(sb3.toString());
			String s;
			while ((s = br.readLine()) != null) {
				String temp[] = s.split("-");
				Double goal = Double.valueOf(temp[1]);
				if (goal >= 60)
					System.out.println("pass: " + temp[0]);
				pass.add("pass: " + temp[0]);
				fw2.write(s);
				s = br.readLine();
			}
			for (int i = 0; i < pass.size(); i++) {
				fw.write(pass.get(i));
				fw.write("\r\n");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fr.close();
				br.close();
				fw.close();
				fw2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String args[]) {
		StringBuffer input_path = new StringBuffer("input.txt");
		StringBuffer output_path = new StringBuffer("output.txt");
		StringBuffer file_path_bak = input_path;
		file_path_bak.append(".bak");
		For_Debug fd = new For_Debug(input_path, output_path,file_path_bak);
	}
}
