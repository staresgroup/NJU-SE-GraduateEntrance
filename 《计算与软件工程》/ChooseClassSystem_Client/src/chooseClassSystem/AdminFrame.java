package chooseClassSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AdminFrame {
	private ClientHelper ch;
	private JFrame frame;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private String user;
	private String password;
	private JPasswordField passwordField_2;
	private JTable table;
	private JTextField textField;

	public void Startwork(String user, String password) {
		this.user = user;
		this.password = password;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		ch = new ClientHelper();
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Admin");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] listline = { "Change Password", "Show List", "Delete" };
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JList list = new JList(listline);
		list.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Functions",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		list.setBounds(30, 138, 138, 324);
		list.setSelectedValue("Change Password", true);
		frame.getContentPane().add(list);

		final JPanel changePassword = new JPanel();
		changePassword.setBounds(194, 48, 614, 484);
		changePassword.setLayout(null);

		final JPanel showList = new JPanel();
		showList.setBounds(194, 48, 614, 484);
		showList.setLayout(null);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 138, 542, 308);
		showList.add(scrollPane);

		final JPanel delete = new JPanel();
		delete.setBounds(194, 48, 614, 484);
		delete.setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome   " + user);
		lblWelcome.setBounds(43, 63, 216, 54);
		frame.getContentPane().add(lblWelcome);

		frame.getContentPane().add(changePassword);

		/*
		 * 如果点击了JList中的选项，根据选中的选项进行操作
		 */
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				frame.remove(changePassword);
				frame.remove(delete);
				frame.remove(showList);
				if (list.getSelectedValue().toString() != null) {
					switch (list.getSelectedValue().toString()) {
					case "Change Password":
						frame.getContentPane().add(changePassword);
						break;
					case "Show List":
						frame.getContentPane().add(showList);
						break;
					default:
						frame.getContentPane().add(delete);
					}
				}
				frame.repaint();
				// TODO Auto-generated method stub
			}
		});

		/*
		 * changepassword中的组件 在changepassword中点击修改密码时作出的操作
		 */
		JLabel lblYourPassword = new JLabel("Your password:");
		lblYourPassword.setBounds(57, 36, 208, 48);
		changePassword.add(lblYourPassword);

		JLabel lblNewPassword = new JLabel("New password:");
		lblNewPassword.setBounds(57, 119, 208, 48);
		changePassword.add(lblNewPassword);

		JLabel lblConfirmPassword = new JLabel("Confirm password");
		lblConfirmPassword.setBounds(57, 220, 208, 48);
		changePassword.add(lblConfirmPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(296, 120, 260, 48);
		changePassword.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(296, 221, 260, 48);
		changePassword.add(passwordField_1);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(296, 37, 260, 48);
		changePassword.add(passwordField_2);

		JButton btnNewButton = new JButton("Change");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if ((passwordField.getText().equals(passwordField_1.getText()))
						&& (passwordField_2.getText().equals(password))) {
					String back = ch.sendToNet("ChangePassword admin "
							+ passwordField.getText());
					password = passwordField.getText();
					if (back.equals("true")) {
						JOptionPane.showMessageDialog(null, "Success!",
								"Warning", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Fail!", "Warning",
								JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Your password is not consistent", "Warning",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(210, 350, 186, 46);
		changePassword.add(btnNewButton);

		/*
		 * 
		 * 
		 * ShowList中的几个按钮以及对应操作如下
		 */
		table = new JTable();
		table.setBounds(33, 138, 542, 308);

		JButton btnTeacher = new JButton("Teacher");// 教师列表
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] toArray = ch.sendToNet("Show 老师列表").split("\t");
				String[] columnTitle = { "teacher account", "password" };
				int length = toArray.length;
				String toTable[][] = new String[length][2];
				for (int i = 0; i < length; i++) {
					for (int j = 0; j < 2; j++) {
						try {
							if (toArray[i].split(" ").length > j) {
								toTable[i][j] = toArray[i].split(" ")[j];
							}
						} catch (Exception e) {
						}
					}
				}
				showList.remove(scrollPane);
				table = new JTable(toTable, columnTitle);
				table.setBounds(33, 138, 542, 308);
				scrollPane.setViewportView(table);
				table.add(table.getTableHeader());
				showList.add(scrollPane);
				frame.repaint();
			}
		});
		btnTeacher.setBounds(21, 21, 150, 46);
		showList.add(btnTeacher);

		JButton btnStudent = new JButton("Student");// 学生列表
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] toArray2 = ch.sendToNet("Show 学生列表").split("\t");
				String[] columnTitle2 = { "Student account", "password" };
				int length2 = toArray2.length;
				String toTable2[][] = new String[length2][2];
				for (int i = 0; i < length2; i++) {
					for (int j = 0; j < 2; j++) {
						try {
							if (toArray2[i].split(" ").length > j) {
								toTable2[i][j] = toArray2[i].split(" ")[j];
							}
						} catch (Exception e) {
						}
					}
				}
				showList.remove(scrollPane);
				table = new JTable(toTable2, columnTitle2);
				table.setBounds(33, 138, 542, 308);
				scrollPane.setViewportView(table);
				table.add(table.getTableHeader());
				showList.add(scrollPane);
				frame.repaint();
			}
		});
		btnStudent.setBounds(209, 21, 150, 46);
		showList.add(btnStudent);

		JButton btnClass = new JButton("Course");// 课程列表
		btnClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] toArray2 = ch.sendToNet("Show 课程列表").split("\t");
				String[] columnTitle2 = { "Course Num", "Course Name",
						"Location", "Start Time", "End Time", "Credit",
						"If Necessary", "Teachers", "Assistants", "Students" };
				int length2 = toArray2.length;
				String toTable2[][] = new String[length2][10];
				for (int i = 0; i < length2; i++) {
					for (int j = 0; j < 10; j++) {
						try {
							if (toArray2[i].split(" ").length > j) {
								toTable2[i][j] = toArray2[i].split(" ")[j];
							}
						} catch (Exception e) {
						}
					}
				}
				showList.remove(scrollPane);
				table = new JTable(toTable2, columnTitle2);
				table.setBounds(33, 138, 542, 308);
				scrollPane.setViewportView(table);
				table.add(table.getTableHeader());
				showList.add(scrollPane);
				frame.repaint();
			}
		});
		btnClass.setBounds(429, 21, 150, 46);
		showList.add(btnClass);

		JButton btnChooseclass = new JButton("ChooseClass");// 选课列表
		btnChooseclass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] toArray2 = ch.sendToNet("Show 选课列表").split("\t");
				String[] columnTitle2 = { "Student account", "Course;Score", };
				int length2 = toArray2.length;
				String toTable2[][] = new String[length2][2];
				for (int i = 0; i < length2; i++) {
					for (int j = 0; j < 2; j++) {
						try {
							if (toArray2[i].split(" ").length > j) {
								toTable2[i][j] = toArray2[i].split(" ")[j];
							}
						} catch (Exception e) {
						}
					}
				}
				showList.remove(scrollPane);
				table = new JTable(toTable2, columnTitle2);
				table.setBounds(33, 138, 542, 308);
				scrollPane.setViewportView(table);
				table.add(table.getTableHeader());
				showList.add(scrollPane);
				frame.repaint();
			}
		});
		btnChooseclass.setBounds(134, 77, 320, 46);
		showList.add(btnChooseclass);

		/*
		 * 
		 * 
		 * 在delelte中组件以及作出操作如下
		 */
		final JRadioButton rdbtnTeacherlist = new JRadioButton("TeacherList",
				true);
		rdbtnTeacherlist.setBounds(229, 66, 121, 23);

		final JRadioButton rdbtnStudentlist = new JRadioButton("StudentList");
		rdbtnStudentlist.setBounds(229, 117, 121, 23);

		final JRadioButton rdbtnCourselist = new JRadioButton("CourseList");
		rdbtnCourselist.setBounds(229, 168, 121, 23);

		final JRadioButton rdbtnChoosecourselist = new JRadioButton(
				"ChooseCourseList");
		rdbtnChoosecourselist.setBounds(229, 222, 121, 23);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnChoosecourselist);
		bg.add(rdbtnCourselist);
		bg.add(rdbtnStudentlist);
		bg.add(rdbtnTeacherlist);
		delete.add(rdbtnChoosecourselist);
		delete.add(rdbtnCourselist);
		delete.add(rdbtnStudentlist);
		delete.add(rdbtnTeacherlist);

		JLabel lblDeleteIn = new JLabel("Delete in:");
		lblDeleteIn.setBounds(68, 64, 107, 27);
		delete.add(lblDeleteIn);

		textField = new JTextField();
		textField.setBounds(303, 293, 66, 21);
		delete.add(textField);
		textField.setColumns(10);

		JLabel lblNo = new JLabel("No.");
		lblNo.setBounds(267, 293, 39, 21);
		delete.add(lblNo);

		JLabel lblNote = new JLabel("note");
		lblNote.setBounds(379, 294, 66, 18);
		delete.add(lblNote);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String bonus = null;
				if (rdbtnChoosecourselist.isSelected()) {
					bonus = "选课列表";
				} else if (rdbtnCourselist.isSelected()) {
					bonus = "课程列表";
				} else if (rdbtnTeacherlist.isSelected()) {
					bonus = "老师列表";
				} else {
					bonus = "学生列表";
				}
				String tosend = "Delete " + bonus + " " + textField.getText();
				String back = ch.sendToNet(tosend);
				if (back.equals("true")) {
					JOptionPane.showMessageDialog(null, "Delete successfully!",
							"Warning", JOptionPane.PLAIN_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Fail.Try it again!",
							"Warning", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnDelete.setBounds(412, 362, 93, 23);
		delete.add(btnDelete);
	}

}
