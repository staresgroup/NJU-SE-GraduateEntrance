package chooseClassSystem;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class StuFrame {
	private ClientHelper ch;
	private String user;
	private JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public void Startwork(String user) {
		this.user = user;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StuFrame window = new StuFrame();
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
	public StuFrame() {
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
		frame.setTitle("Student");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String listLine[] = { "Show mycourseList", "Select course",
				"Quit course", "Show score" };
		@SuppressWarnings({ "unchecked", "rawtypes" })
		final JList list = new JList(listLine);

		list.setBorder(new TitledBorder(null, "Functions",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		list.setBounds(30, 138, 138, 324);
		list.setSelectedValue("Show mycourseList", true);
		frame.getContentPane().add(list);

		JLabel lblWelcome = new JLabel("Welcome   " + user);
		lblWelcome.setBounds(43, 63, 216, 54);
		frame.getContentPane().add(lblWelcome);

		final JPanel showMyCourse = new JPanel();
		showMyCourse.setBounds(194, 48, 614, 484);
		showMyCourse.setLayout(null);

		final JPanel selectCourse = new JPanel();
		selectCourse.setBounds(194, 48, 614, 484);
		selectCourse.setLayout(null);

		final JPanel quitCourse = new JPanel();
		quitCourse.setBounds(194, 48, 614, 484);
		quitCourse.setLayout(null);

		final JPanel showScore = new JPanel();
		showScore.setBounds(194, 48, 614, 484);
		showScore.setLayout(null);
		
		frame.getContentPane().add(showMyCourse);
		/*
		 * 根据Jlist调整右侧页面
		 */
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				frame.remove(showMyCourse);
				frame.remove(selectCourse);
				frame.remove(quitCourse);
				frame.remove(showScore);
				if (list.getSelectedValue().toString() != null) {
					switch (list.getSelectedValue().toString()) {
					case "Show mycourseList":
						frame.getContentPane().add(showMyCourse);
						break;
					case "Select course":
						frame.getContentPane().add(selectCourse);
						break;
					case "Quit course":
						frame.getContentPane().add(quitCourse);
						break;
					default:
						frame.getContentPane().add(showScore);
						break;
					}
				}
				frame.repaint();
			}
		});

		/*
		 * Show Mycourse的组件以及操作
		 */
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 63, 543, 359);
		showMyCourse.add(scrollPane);

		JButton btnShowMyCourse = new JButton("Show My Course");
		btnShowMyCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String courseinfo[] = ch.sendToNet("Show mycourseList").split(
						"\t");
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
				showMyCourse.remove(scrollPane);
				table = new JTable(toTable, columnTitle);
				table.setBounds(33, 138, 542, 308);
				scrollPane.setViewportView(table);
				table.add(table.getTableHeader());
				showMyCourse.add(scrollPane);
				frame.repaint();
			}
		});
		btnShowMyCourse.setBounds(194, 30, 218, 23);
		showMyCourse.add(btnShowMyCourse);

		/*
		 * selectCourse的组件以及操作
		 */

		final JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(34, 63, 543, 359);
		selectCourse.add(scrollPane1);

		JButton btnShowCourselist = new JButton("Show courselist");
		btnShowCourselist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseinfo[] = ch.sendToNet("Show CouseList")
						.split("\t");
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
				selectCourse.remove(scrollPane1);
				table = new JTable(toTable, columnTitle);
				table.setBounds(33, 138, 542, 308);
				scrollPane1.setViewportView(table);
				table.add(table.getTableHeader());
				selectCourse.add(scrollPane1);
				frame.repaint();
			}
		});
		btnShowCourselist.setBounds(219, 22, 158, 23);
		selectCourse.add(btnShowCourselist);

		JLabel lblCoursenum = new JLabel("CourseNum:");
		lblCoursenum.setBounds(54, 444, 98, 15);
		selectCourse.add(lblCoursenum);

		textField = new JTextField();
		textField.setBounds(162, 441, 107, 21);
		selectCourse.add(textField);
		textField.setColumns(10);

		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().equals("")) {
					String send = "Select course " + textField.getText();
					String returnInfo = ch.sendToNet(send);
					if (returnInfo.equals("选课成功.")) {
						JOptionPane.showMessageDialog(null, "Success!",
								"Warning", JOptionPane.PLAIN_MESSAGE);
					} else if (returnInfo.equals("不存在该课程号的课程!")) {
						JOptionPane.showMessageDialog(null,
								"Thise course doesn't exist.", "Warning",
								JOptionPane.PLAIN_MESSAGE);
					} else if (returnInfo.equals("您已经选择过该课程!")) {
						JOptionPane.showMessageDialog(null,
								"You have chosen the course.", "Warning",
								JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Please input the course number.", "Warning",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnSelect.setBounds(453, 440, 93, 23);
		selectCourse.add(btnSelect);

		/*
		 * quitCourse的组件以及操作
		 */
		final JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(34, 63, 543, 359);
		quitCourse.add(scrollPane2);

		JButton btnShowMyCourse1 = new JButton("Show My Course");
		btnShowMyCourse1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String courseinfo[] = ch.sendToNet("Show mycourseList").split(
						"\t");
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
				quitCourse.remove(scrollPane2);
				table = new JTable(toTable, columnTitle);
				table.setBounds(33, 138, 542, 308);
				scrollPane2.setViewportView(table);
				table.add(table.getTableHeader());
				quitCourse.add(scrollPane2);
				frame.repaint();
			}
		});
		btnShowMyCourse1.setBounds(194, 30, 218, 23);
		quitCourse.add(btnShowMyCourse1);

		JLabel lblCoursenum_1 = new JLabel("CourseNum:");
		lblCoursenum_1.setBounds(34, 444, 108, 15);
		quitCourse.add(lblCoursenum_1);

		textField_1 = new JTextField();
		textField_1.setBounds(221, 441, 94, 21);
		quitCourse.add(textField_1);
		textField_1.setColumns(10);

		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_1.getText().equals("")) {
					String returnInfo = ch.sendToNet("Quit course " + textField_1.getText());
					if (returnInfo.equals("退选成功!")) {
						JOptionPane.showMessageDialog(null, "Success!",
								"Warning", JOptionPane.PLAIN_MESSAGE);
					} else if (returnInfo.equals("错误！您尚未选择该课程!")) {
						JOptionPane.showMessageDialog(null,
								"You haven't chosen the course.", "Warning",
								JOptionPane.PLAIN_MESSAGE);
					} else if (returnInfo.equals("不存在该课程号的课程!")) {
						JOptionPane.showMessageDialog(null,
								"Thise course doesn't exist.", "Warning",
								JOptionPane.PLAIN_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Please input the course number.", "Warning",
							JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		btnQuit.setBounds(453, 440, 93, 23);
		quitCourse.add(btnQuit);
		
		/*
		 * showScore的组件以及操作
		 */
		
		final JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(34, 63, 543, 359);
		showScore.add(scrollPane3);
		
		JButton btnShowMyScore = new JButton("Show my score");
		btnShowMyScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String courseinfo[] = ch.sendToNet("Show score").split(
						" ");
				String[] columnTitle = { "Course Num", "Score" };
				int length = courseinfo.length;
				String toTable[][] = new String[length][2];
				for (int i = 0; i < length; i++) {
					for (int j = 0; j < 2; j++) {
						try {
							if (courseinfo[i].split(";").length > j) {
								toTable[i][j] = courseinfo[i].split(";")[j];
							}
						} catch (Exception e1) {
						}
					}
				}
				showScore.remove(scrollPane3);
				table = new JTable(toTable, columnTitle);
				table.setBounds(33, 138, 542, 308);
				scrollPane3.setViewportView(table);
				table.add(table.getTableHeader());
				showScore.add(scrollPane3);
				frame.repaint();
			}
		});
		btnShowMyScore.setBounds(187, 10, 191, 23);
		showScore.add(btnShowMyScore);
	}
}
