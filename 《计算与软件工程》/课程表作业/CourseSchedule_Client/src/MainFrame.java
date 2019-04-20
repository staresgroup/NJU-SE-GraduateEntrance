import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JScrollPane;


public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private ClientHelper ch = new ClientHelper();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 33, 221, 200);
		contentPane.add(scrollPane);
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{"\u738B\u660E", "\u4E2D\u56FD", "234", "345"},
			},
			new String[] {
				"test1", "test2", "test4", "test5"
			}
		));
		scrollPane.setViewportView(table);
		table.setForeground(Color.GREEN);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBackground(Color.RED);
		table.add(table.getTableHeader());
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setBounds(290, 29, 122, 23);
		contentPane.add(btnAddCourse);
		
		JButton btnDeleteCourse = new JButton("Delete Course");
		btnDeleteCourse.setBounds(290, 85, 122, 23);
		contentPane.add(btnDeleteCourse);
		
		JButton btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.setBounds(290, 148, 122, 23);
		contentPane.add(btnUpdateCourse);
		
		JButton btnShowCourses = new JButton("Show Courses");
		btnShowCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String reply_from_server = ch.sendToNet(CommandHelper.getShow_course());
				//System.out.println("reply_from_server is " + reply_from_server);
			
				MainFrame.this.fillintable(ch.convert_from_str_to_list(reply_from_server));
			}
				
			
		});
		btnShowCourses.setBounds(290, 209, 122, 23);
		contentPane.add(btnShowCourses);
		
		String[] headers = { "Name", "Day", "Time","Location" };
		Object[][] cellData = {{ "test", "test", "test","test" }};
		DefaultTableModel model = new DefaultTableModel(cellData, headers);
		
		JLabel lblWelcom = new JLabel("Welcome,ysm");
		lblWelcom.setBounds(313, 0, 111, 23);
		contentPane.add(lblWelcom);
		
		textField = new JTextField();
		textField.setBounds(10, 1, 83, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(103, 0, 83, 23);
		contentPane.add(btnSearch);
	}
	
	
	
	public void fillintable(List<Course> courses){
		 DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		 tableModel.setRowCount(0);// 清除原有行
		  
		  // 填充数据
		  for(Course cs:courses){
		    String[] arr = new String[4];
		    arr[0] = cs.getName();
		    arr[1] = cs.getDay();
		    arr[2] = cs.getTime();
		    arr[3] = cs.getLocation();
		    // 添加数据到表格
		    tableModel.addRow(arr);
		  }
		  
		  // 更新表格
			 table.invalidate();
			 table.updateUI();
		}
}
