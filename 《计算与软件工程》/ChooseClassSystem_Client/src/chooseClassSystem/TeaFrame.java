package chooseClassSystem;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JList;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class TeaFrame {
	private String user;
	private ClientHelper ch;
	private JFrame frame;
	private JTable table;
	private JTable table1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private boolean ifSearch = false;
	private String courseNum = "";
	private JTextField textField_24;
	private JTable table2;
	private JTextField textField_25;
	private JTextField textField_26;

	/**
	 * Launch the application.
	 */
	public void Startwork(String user) {
		this.user = user;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeaFrame window = new TeaFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TeaFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ch = new ClientHelper();
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.getContentPane().setLayout(null);

		String listLine[] = { "Publish", "Show Course", "Update Course",
				"Show Student", "Record Score" };
		@SuppressWarnings({ "rawtypes", "unchecked" })
		final JList list = new JList(listLine);

		list.setBorder(new TitledBorder(null, "Functions",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		list.setBounds(30, 138, 138, 324);
		list.setSelectedValue("Publish", true);
		frame.getContentPane().add(list);

		JLabel lblWelcome = new JLabel("Welcome   " + user);
		lblWelcome.setBounds(43, 63, 216, 54);
		frame.getContentPane().add(lblWelcome);

		frame.setTitle("Teacher");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final JPanel publish = new JPanel();
		publish.setBounds(194, 48, 614, 484);
		publish.setLayout(null);

		final JPanel showCourse = new JPanel();
		showCourse.setBounds(194, 48, 614, 484);
		showCourse.setLayout(null);

		final JPanel update = new JPanel();
		update.setBounds(194, 48, 614, 484);
		update.setLayout(null);

		final JPanel showStudent = new JPanel();
		showStudent.setBounds(194, 48, 614, 484);
		showStudent.setLayout(null);

		final JPanel record = new JPanel();
		record.setBounds(194, 48, 614, 484);
		record.setLayout(null);

		frame.getContentPane().add(publish);

		/*
		 * publish对应的部件以及操作
		 */
		JLabel lblCourseNum = new JLabel("Course Num:");
		lblCourseNum.setBounds(21, 35, 74, 30);
		publish.add(lblCourseNum);

		textField = new JTextField();
		textField.setBounds(105, 40, 81, 21);
		publish.add(textField);
		textField.setColumns(10);

		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setBounds(21, 85, 74, 30);
		publish.add(lblCourseName);

		textField_1 = new JTextField();
		textField_1.setBounds(105, 90, 81, 21);
		publish.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblClassroom = new JLabel("Classroom:");
		lblClassroom.setBounds(21, 136, 74, 30);
		publish.add(lblClassroom);

		textField_2 = new JTextField();
		textField_2.setBounds(105, 141, 81, 21);
		publish.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblStartTime = new JLabel("Start time:");
		lblStartTime.setBounds(21, 187, 74, 30);
		publish.add(lblStartTime);

		textField_3 = new JTextField();
		textField_3.setBounds(105, 192, 81, 21);
		publish.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblEndTime = new JLabel("End time:");
		lblEndTime.setBounds(21, 237, 74, 30);
		publish.add(lblEndTime);

		textField_4 = new JTextField();
		textField_4.setBounds(105, 242, 81, 21);
		publish.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblCredit = new JLabel("Credit:");
		lblCredit.setBounds(21, 284, 74, 34);
		publish.add(lblCredit);

		textField_5 = new JTextField();
		textField_5.setBounds(105, 291, 81, 21);
		publish.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblTeacherlessThan = new JLabel("Teacher(less than 3):");
		lblTeacherlessThan.setBounds(21, 377, 130, 30);
		publish.add(lblTeacherlessThan);

		textField_6 = new JTextField();
		textField_6.setBounds(184, 382, 81, 21);
		publish.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(291, 382, 81, 21);
		publish.add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setBounds(400, 382, 81, 21);
		publish.add(textField_8);
		textField_8.setColumns(10);

		JLabel lblIfnecessary = new JLabel("ifNecessary:");
		lblIfnecessary.setBounds(21, 338, 74, 22);
		publish.add(lblIfnecessary);

		final JRadioButton rdbtnYes = new JRadioButton("Yes", true);
		rdbtnYes.setBounds(105, 338, 112, 23);

		final JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(232, 338, 106, 23);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnYes);
		bg.add(rdbtnNo);
		publish.add(rdbtnYes);
		publish.add(rdbtnNo);

		JButton btnNewButton = new JButton("Publish");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Please input the course number.", "Warning",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					String teacher = textField_6.getText();
					if (!textField_7.getText().equals("")) {
						teacher = teacher + ";" + textField_7.getText();
					}
					if (!textField_8.getText().equals("")) {
						teacher = teacher + ";" + textField_8.getText();
					}
					String necessary = null;
					if (rdbtnYes.isSelected()) {
						necessary = "必修";
					} else {
						necessary = "选修";
					}
					String send = "Publish " + textField.getText() + " "
							+ textField_1.getText() + " "
							+ textField_2.getText() + " "
							+ textField_3.getText() + " "
							+ textField_4.getText() + " "
							+ textField_5.getText() + " " + necessary + " "
							+ teacher;
					String back = ch.sendToNet(send);
					if (back.equals("课程号已被使用。")) {
						JOptionPane.showMessageDialog(null,
								"The course number has been used.", "Warning",
								JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Success!",
								"Warning", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(343, 410, 93, 23);
		publish.add(btnNewButton);

		/*
		 * showcourse的部件以及操作
		 */
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 138, 542, 308);
		showCourse.add(scrollPane);

		JLabel lblCourseNum1 = new JLabel("Course Num:");
		lblCourseNum1.setBounds(33, 24, 95, 28);
		showCourse.add(lblCourseNum1);

		textField_9 = new JTextField();
		textField_9.setBounds(156, 28, 95, 21);
		showCourse.add(textField_9);
		textField_9.setColumns(10);

		JButton btnShowThisCourse = new JButton("Show this course");
		btnShowThisCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_9.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Please input the course number.", "Warning",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					String courseinfo = ch.sendToNet("Show course "
							+ textField_9.getText());
					if (courseinfo.equals("不存在该课程号的课程.")) {
						JOptionPane.showMessageDialog(null,
								"Wrong course number.", "Warning",
								JOptionPane.PLAIN_MESSAGE);
					} else {
						String[] columnTitle = { "Course Num", "Course Name",
								"Classroom", "Start time", "End time",
								"Credit", "ifNecessary", "Teacher", "Assistant" };
						String toTable[][] = new String[1][9];
						for (int j = 0; j < 9; j++) {
							try {
								if (courseinfo.split(" ").length > j) {
									toTable[0][j] = courseinfo.split(" ")[j];
								}
							} catch (Exception e1) {
							}
						}
						showCourse.remove(scrollPane);
						table = new JTable(toTable, columnTitle);
						table.setBounds(33, 138, 542, 308);
						scrollPane.setViewportView(table);
						table.add(table.getTableHeader());
						showCourse.add(scrollPane);
						frame.repaint();
					}
				}
			}
		});
		btnShowThisCourse.setBounds(343, 27, 158, 25);
		showCourse.add(btnShowThisCourse);

		JButton btnShowAllCourses = new JButton("Show your courses");
		btnShowAllCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseinfo[] = ch.sendToNet("Show course *").split("\t");
				String[] columnTitle = { "Course Num", "Course Name",
						"Classroom", "Start time", "End time", "Credit",
						"ifNecessary", "Teacher", "Assistant" };
				int length = courseinfo.length;
				String toTable[][] = new String[length][9];
				for (int i = 0; i < length; i++) {
					for (int j = 0; j < 9; j++) {
						try {
							if (courseinfo[i].split(" ").length > j) {
								toTable[i][j] = courseinfo[i].split(" ")[j];
							}
						} catch (Exception e1) {
						}
					}
				}
				showCourse.remove(scrollPane);
				table = new JTable(toTable, columnTitle);
				table.setBounds(33, 138, 542, 308);
				scrollPane.setViewportView(table);
				table.add(table.getTableHeader());
				showCourse.add(scrollPane);
				frame.repaint();
			}
		});
		btnShowAllCourses.setBounds(343, 75, 158, 28);
		showCourse.add(btnShowAllCourses);
		/*
		 * Update的部件以及操作
		 */
		JLabel lblCoursenum = new JLabel("CourseNum:");
		lblCoursenum.setBounds(27, 30, 80, 23);
		update.add(lblCoursenum);

		textField_10 = new JTextField();
		textField_10.setBounds(143, 31, 80, 22);
		update.add(textField_10);
		textField_10.setColumns(10);

		JLabel lblCoursenum_1 = new JLabel("Course Name:");
		lblCoursenum_1.setBounds(27, 75, 80, 23);
		update.add(lblCoursenum_1);

		JLabel label = new JLabel("Classroom:");
		label.setBounds(27, 126, 80, 23);
		update.add(label);

		JLabel lblNewLabel = new JLabel("Start time:");
		lblNewLabel.setBounds(27, 173, 80, 23);
		update.add(lblNewLabel);

		JLabel lblStarttime = new JLabel("End time:");
		lblStarttime.setBounds(27, 226, 80, 23);
		update.add(lblStarttime);

		JLabel lblEndtime = new JLabel("Credit:");
		lblEndtime.setBounds(27, 284, 93, 23);
		update.add(lblEndtime);

		JLabel lblCredit1 = new JLabel("If necessary");
		lblCredit1.setBounds(27, 339, 80, 23);
		update.add(lblCredit1);

		JLabel lblTeacherlessThan1 = new JLabel("Teacher(less than 3):");
		lblTeacherlessThan1.setBounds(27, 388, 158, 23);
		update.add(lblTeacherlessThan1);

		JLabel lblAssistantlessThan = new JLabel("Assistant(less than 3):");
		lblAssistantlessThan.setBounds(27, 426, 158, 23);
		update.add(lblAssistantlessThan);

		textField_11 = new JTextField();
		textField_11.setBounds(144, 75, 79, 22);
		update.add(textField_11);
		textField_11.setColumns(10);

		textField_12 = new JTextField();
		textField_12.setBounds(143, 126, 80, 22);
		update.add(textField_12);
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(143, 174, 80, 22);
		update.add(textField_13);

		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(143, 227, 80, 22);
		update.add(textField_14);

		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(143, 285, 80, 22);
		update.add(textField_15);

		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(143, 340, 80, 22);
		update.add(textField_16);

		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(192, 389, 80, 22);
		update.add(textField_17);

		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(298, 389, 80, 22);
		update.add(textField_18);

		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(396, 389, 80, 22);
		update.add(textField_19);

		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(192, 427, 80, 22);
		update.add(textField_20);

		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(298, 427, 80, 22);
		update.add(textField_21);

		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(396, 427, 80, 22);
		update.add(textField_22);

		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ifSearch == false) {
					JOptionPane
							.showMessageDialog(
									null,
									"You should choose one existed course to update first.",
									"Warning", JOptionPane.PLAIN_MESSAGE);
				} else {
					String send = "Update course " + courseNum + " "
							+ textField_10.getText() + " "
							+ textField_11.getText() + " "
							+ textField_12.getText() + " "
							+ textField_13.getText() + " "
							+ textField_14.getText() + " "
							+ textField_15.getText() + " "
							+ textField_16.getText();
					String teacher = textField_17.getText();
					if (!textField_18.getText().equals("")) {
						teacher = teacher + ";" + textField_18.getText();
					}
					if (!textField_19.getText().equals("")) {
						teacher = teacher + ";" + textField_19.getText();
					}
					String assistant = "";
					if (!textField_20.getText().equals("")) {
						assistant = assistant + textField_20.getText();
					}
					if (!textField_21.getText().equals("")) {
						assistant = assistant + ";" + textField_21.getText();
					}
					if (!textField_22.getText().equals("")) {
						assistant = assistant + ";" + textField_22.getText();
					}
					send = send + " " + teacher + " " + assistant;
					String back = ch.sendToNet(send);
					if (back.equals("课程号已被使用.")) {
						JOptionPane.showMessageDialog(null,
								"The course number has been used.", "Warning",
								JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Success!",
								"Warning", JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		});
		btnChange.setBounds(408, 96, 93, 23);
		update.add(btnChange);

		JButton btnConfirm = new JButton("Search");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (textField_10.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Wrong course number.",
							"Warning", JOptionPane.PLAIN_MESSAGE);
				} else {
					courseNum = textField_10.getText();
					String send = "Show course " + textField_10.getText();
					String back = ch.sendToNet(send);
					if (back.equals("不存在该课程号的课程.")) {
						JOptionPane.showMessageDialog(null,
								"Wrong course number.", "Warning",
								JOptionPane.PLAIN_MESSAGE);
					} else {
						ifSearch = true;
						String courseinfo[] = back.split(" ");
						textField_10.setText(courseinfo[0]);
						textField_11.setText(courseinfo[1]);
						textField_12.setText(courseinfo[2]);
						textField_13.setText(courseinfo[3]);
						textField_14.setText(courseinfo[4]);
						textField_15.setText(courseinfo[5]);
						textField_16.setText(courseinfo[6]);
						textField_17.setText(courseinfo[7].split(";")[0]);
						if (courseinfo[7].split(";").length > 1) {
							textField_18.setText(courseinfo[7].split(";")[1]);
						}
						if (courseinfo[7].split(";").length > 2) {
							textField_19.setText(courseinfo[7].split(";")[2]);
						}
						if (courseinfo.length > 8) {
							textField_20.setText(courseinfo[7].split(";")[0]);
							if (courseinfo[8].split(";").length > 1) {
								textField_21.setText(courseinfo[7].split(";")[1]);
							}
							if (courseinfo[8].split(";").length > 2) {
								textField_22.setText(courseinfo[7].split(";")[2]);
							}
						}
					}
				}
				frame.repaint();
			}
		});
		btnConfirm.setBounds(408, 30, 93, 23);
		update.add(btnConfirm);

		/*
		 * showstudent的部件以及操作
		 */
		JLabel lblCoursenum1 = new JLabel("CourseNum:");
		lblCoursenum1.setBounds(57, 56, 87, 25);
		showStudent.add(lblCoursenum1);

		textField_23 = new JTextField();
		textField_23.setBounds(208, 58, 66, 21);
		showStudent.add(textField_23);
		textField_23.setColumns(10);

		final JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(33, 138, 542, 308);
		showStudent.add(scrollPane1);

		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_23.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Please input the course number.", "Warning",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					String courseinfo = ch.sendToNet("Show student "
							+ textField_23.getText());
					if (courseinfo.equals("不存在该课程号的课程.")) {
						JOptionPane.showMessageDialog(null,
								"Wrong course number.", "Warning",
								JOptionPane.PLAIN_MESSAGE);
					} else {
						String[] columnTitle2 = { "Name", "Score" };
						String toTable1[][] = new String[courseinfo.split(" ").length][2];
						for (int i = 0; i < courseinfo.split(" ").length; i++) {
							for (int j = 0; j < 2; j++) {
								if (courseinfo.split(" ")[i].split(";").length > j) {
									toTable1[i][j] = courseinfo.split(" ")[i]
											.split(";")[j];
								}
							}
						}
						showStudent.remove(scrollPane1);
						table1 = new JTable(toTable1, columnTitle2);
						table1.setBounds(33, 138, 542, 308);
						scrollPane1.setViewportView(table1);
						table1.add(table1.getTableHeader());
						showStudent.add(scrollPane1);
						frame.repaint();
					}
				}
			}
		});
		btnShow.setBounds(385, 57, 93, 23);
		showStudent.add(btnShow);
		/*
		 * record的组件以及功能
		 */
		JLabel lblCoursenum2 = new JLabel("CourseNum:");
		lblCoursenum2.setBounds(57, 56, 87, 25);
		record.add(lblCoursenum2);

		textField_24 = new JTextField();
		textField_24.setBounds(208, 58, 66, 21);
		record.add(textField_24);
		textField_24.setColumns(10);

		final JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(33, 138, 543, 282);
		record.add(scrollPane2);

		JButton btnShow1 = new JButton("Show");
		btnShow1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textField_24.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Please input the course number.", "Warning",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					String courseinfo = ch.sendToNet("Show student "
							+ textField_24.getText());
					if (courseinfo.equals("不存在该课程号的课程.")) {
						JOptionPane.showMessageDialog(null,
								"Wrong course number.", "Warning",
								JOptionPane.PLAIN_MESSAGE);
					} else {
						String[] columnTitle2 = { "Name", "Score" };
						String toTable1[][] = new String[courseinfo.split(" ").length][2];
						for (int i = 0; i < courseinfo.split(" ").length; i++) {
							for (int j = 0; j < 2; j++) {
								if (courseinfo.split(" ")[i].split(";").length > j) {
									toTable1[i][j] = courseinfo.split(" ")[i]
											.split(";")[j];
								}
							}
						}
						record.remove(scrollPane2);
						table2 = new JTable(toTable1, columnTitle2);
						table2.setBounds(33, 138, 542, 308);
						scrollPane2.setViewportView(table2);
						table2.add(table2.getTableHeader());
						record.add(scrollPane2);
						frame.repaint();
					}
				}
			}
		});
		btnShow1.setBounds(385, 57, 93, 23);
		record.add(btnShow1);

		textField_25 = new JTextField();
		textField_25.setBounds(106, 440, 106, 21);
		record.add(textField_25);
		textField_25.setColumns(10);

		textField_26 = new JTextField();
		textField_26.setBounds(355, 440, 106, 21);
		record.add(textField_26);
		textField_26.setColumns(10);

		JLabel lblStudentNum = new JLabel("Student Num:");
		lblStudentNum.setBounds(10, 443, 86, 15);
		record.add(lblStudentNum);

		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(277, 443, 68, 15);
		record.add(lblScore);

		JButton btnRecord = new JButton("Record");
		btnRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String send = "Record score " + textField_24.getText() + " "
						+ textField_25.getText() + " " + textField_26.getText();
				String returnInfo = ch.sendToNet(send);
				String warningInfo = null;
				switch (returnInfo) {
				case "不存在该课程号的课程.":
					warningInfo = "The course is not exist.";
					break;
				case "你未拥有该课程权限.":
					warningInfo = "You don't have the right to record score.";
					break;
				case "该学生未选择该课程.":
					warningInfo = "The student hasn't choose this course.";
					break;
				case "未找到该学生号.":
					warningInfo = "The student num doesn't exist.";
					break;
				case "该学生已经登记了成绩.":
					warningInfo = "The score of this student has been recorded.";
					break;
				case "成功.":
					warningInfo = "Success.";
					break;
				default:
					warningInfo = "Unknown error.";
					break;
				}

				JOptionPane.showMessageDialog(null, warningInfo, "Warning",
						JOptionPane.PLAIN_MESSAGE);

			}
		});
		btnRecord.setBounds(483, 439, 93, 23);
		record.add(btnRecord);
		/*
		 * 如果点击了JList中的选项，根据选中的选项进行操作
		 */
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				frame.remove(publish);
				frame.remove(showCourse);
				frame.remove(showStudent);
				frame.remove(update);
				frame.remove(record);
				if (list.getSelectedValue().toString() != null) {
					switch (list.getSelectedValue().toString()) {
					case "Publish":
						frame.getContentPane().add(publish);
						break;
					case "Show Course":
						frame.getContentPane().add(showCourse);
						break;
					case "Show Student":
						frame.getContentPane().add(showStudent);
						break;
					case "Update Course":
						frame.getContentPane().add(update);
						break;
					default:
						frame.getContentPane().add(record);
					}
				}
				frame.repaint();
			}
		});
	}
}
