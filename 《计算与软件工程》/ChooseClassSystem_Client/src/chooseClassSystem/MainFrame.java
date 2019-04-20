package chooseClassSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class MainFrame {
	private ClientHelper ch;
	private String command;
	private String result;
	private String user;
	private String password;
	private JFrame frame;
	private JTextField textField;
	private String bonus;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 270);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		frame.getContentPane().add(rdbtnNewRadioButton, BorderLayout.SOUTH);
		
		textField = new JTextField();
		textField.setBounds(129, 48, 144, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(36, 51, 83, 15);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(36, 89, 83, 15);
		frame.getContentPane().add(lblPassword);
		
		JButton btnLogin = new JButton("LogIn");
		btnLogin.setBounds(144, 146, 93, 23);
		frame.getContentPane().add(btnLogin);
		
		final JRadioButton rdbtnAdmin = new JRadioButton("Admin",true);
		rdbtnAdmin.setBounds(49, 185, 72, 23);
		
		final JRadioButton rdbtnStudent = new JRadioButton("Student");
		rdbtnStudent.setBounds(153, 185, 84, 23);
		
		final JRadioButton rdbtnTeacher = new JRadioButton("Teacher");
		rdbtnTeacher.setBounds(267, 185, 77, 23);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnTeacher);
		bg.add(rdbtnStudent);
		bg.add(rdbtnAdmin);
		frame.getContentPane().add(rdbtnAdmin);
		frame.getContentPane().add(rdbtnStudent);
		frame.getContentPane().add(rdbtnTeacher);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(129, 86, 144, 21);
		frame.getContentPane().add(passwordField);
		
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnAdmin.isSelected()){
					bonus="";
				}else if(rdbtnStudent.isSelected()){
					bonus="Student ";
				}else{
					bonus="Teacher ";
				}
				ch=new ClientHelper();
				user=textField.getText();
				password=passwordField.getText();
				command="Login"+" "+bonus+textField.getText()+" "+passwordField.getText();
				System.out.print(command);
				result=ch.sendToNet(command);
				if(result.equals("true")){
					switch(bonus){
						case"Student ":frame.dispose();StuFrame sf=new StuFrame();sf.Startwork(user);break;
						case"Teacher ":frame.dispose();TeaFrame tf=new TeaFrame();tf.Startwork(user);break;
						default:frame.dispose();AdminFrame af=new AdminFrame();af.Startwork(user,password);
					}
				}else{
					JOptionPane.showMessageDialog(null, "your account or password is wrong.","Warning",JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}
}
