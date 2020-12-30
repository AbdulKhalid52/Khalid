package student;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class Student extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField student_id;
	private JTextField student_name;
	private JTextField course;
	private JTextField fee;
	private JTextField father_name;
	private JTextField address;
	private JTextField contact_number;
	private JLabel student_idLabel;
	private JLabel student_nameLabel;
	private JLabel courseLabel;
	private JLabel feeLabel;
	private JLabel father_nameLabel;
	private JLabel addressLabel;
	private JLabel contact_numberLabel;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 60, 511, 522);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 139)));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		student_id = new JTextField();
		student_id.setBounds(163, 100, 175, 27);
		contentPane.add(student_id);
		student_id.setColumns(10);
		
		student_name = new JTextField();
		student_name.setBounds(163, 138, 175, 27);
		contentPane.add(student_name);
		student_name.setColumns(10);
		
		course = new JTextField();
		course.setBounds(163, 178, 175, 27);
		contentPane.add(course);
		course.setColumns(10);
		
		fee = new JTextField();
		fee.setBounds(163, 228, 175, 27);
		contentPane.add(fee);
		fee.setColumns(10);
		
		father_name =new JTextField();
		father_name.setBounds(163, 278, 175, 27);
		contentPane.add(father_name);
		father_name.setColumns(10);
		
		address = new JTextField();
		address.setBounds(163, 329, 175, 27);
		contentPane.add(address);
		address.setColumns(10);
		
		contact_number = new JTextField();
		contact_number.setBounds(163, 378, 175, 27);
		contentPane.add(contact_number);
		contact_number.setColumns(10);
		
		student_idLabel = new JLabel("Student ID");
		student_idLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		student_idLabel.setBounds(58, 105, 105, 14);
		contentPane.add(student_idLabel);
		
		student_nameLabel = new JLabel("Student Name");
		student_nameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		student_nameLabel.setBounds(58, 143, 105, 14);
		contentPane.add(student_nameLabel);
		
		courseLabel = new JLabel("Course");
		courseLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		courseLabel.setBounds(58, 184, 46, 14);
		contentPane.add(courseLabel);
		
		feeLabel = new JLabel("Fee");
		feeLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		feeLabel.setBounds(58, 234, 46, 14);
		contentPane.add(feeLabel);
		
		father_nameLabel = new JLabel("Father Name");
		father_nameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		father_nameLabel.setBounds(58, 281, 95, 21);
		contentPane.add(father_nameLabel);
		
		addressLabel = new JLabel("Address");
		addressLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		addressLabel.setBounds(58, 334, 89, 14);
		contentPane.add(addressLabel);
		
		contact_numberLabel = new JLabel("Contact Number");
		contact_numberLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		contact_numberLabel.setBounds(48, 383, 105, 14);
		contentPane.add(contact_numberLabel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/stu", "root", "root1");
					PreparedStatement ps= con.prepareStatement("insert into stu_info(student_name,course,fee,father_name,address,contact_number)values(?,?,?,?,?,?)");
					ps.setString(1, student_name.getText());
					ps.setString(2, course.getText());
					ps.setString(3, fee.getText());
					ps.setString(4, father_name.getText());
					ps.setString(5, address.getText());
					ps.setString(6, contact_number.getText());
					int x = ps.executeUpdate();
					if(x > 0) {
						
						System.out.println("Information submit...");
						}

				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnSubmit.setBounds(58, 437, 89, 23);
		contentPane.add(btnSubmit);
		
		
		JButton Show = new JButton("Show");
		Show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Info i = new Info();
				i.NewScreen();
			}
			});
	
		Show.setBounds(176, 437, 89, 23);
		contentPane.add(Show);
		
		
		JLabel lblNewLabel = new JLabel("STUDENTS INFORMATION");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 22));
		lblNewLabel.setBounds(125, 35, 273, 39);
		contentPane.add(lblNewLabel);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/stu", "root", "root1");
						if (student_name.getText().length()!=0)
						{
						PreparedStatement ps= con.prepareStatement("update stu_info SET student_name=? where student_id=? ");
						ps.setString(1, student_name.getText());
						ps.setInt(2,Integer.parseInt( student_id.getText()));
						int x = ps.executeUpdate();
						
						if(x > 0) {
							System.out.println("Information updated...");
							}
						}
						
						if (course.getText().length()!=0)
						{
						PreparedStatement ps= con.prepareStatement("update stu_info SET course=? where student_id=? ");
						ps.setString(1, course.getText());
						ps.setInt(2,Integer.parseInt( student_id.getText()));
						int x = ps.executeUpdate();
						
						if(x > 0) {
							System.out.println("Information updated...");
							}
						}
						
						if (fee.getText().length()!=0)
						{
						PreparedStatement ps= con.prepareStatement("update stu_info SET fee=? where student_id=? ");
						ps.setString(1, fee.getText());
						ps.setInt(2,Integer.parseInt( student_id.getText()));
						int x = ps.executeUpdate();
						
						if(x > 0) {
							System.out.println("Information updated...");
							}
						}
						
						if (father_name.getText().length()!=0)
						{
						PreparedStatement ps= con.prepareStatement("update stu_info SET father_name=? where student_id=? ");
						ps.setString(1, father_name.getText());
						ps.setInt(2,Integer.parseInt( student_id.getText()));
						int x = ps.executeUpdate();
						
						if(x > 0) {
							System.out.println("Information updated...");
							}
						}
						
						if (address.getText().length()!=0)
						{
						PreparedStatement ps= con.prepareStatement("update stu_info SET address=? where student_id=? ");
						ps.setString(1, address.getText());
						ps.setInt(2,Integer.parseInt( student_id.getText()));
						int x = ps.executeUpdate();
						
						if(x > 0) {
							System.out.println("Information updated...");
							}
						}
						
						if (contact_number.getText().length()!=0)
						{
						PreparedStatement ps= con.prepareStatement("update stu_info SET contact_number=? where student_id=? ");
						ps.setString(1, contact_number.getText());
						ps.setInt(2,Integer.parseInt( student_id.getText()));
						int x = ps.executeUpdate();
						
						if(x > 0) {
							System.out.println("Information updated...");
							}
						}

					
					} catch (Exception e2) {
						System.out.println(e2);
					}
					
				}
			});
		btnUpdate.setBounds(284, 437, 89, 23);
		contentPane.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/stu", "root", "root1");
						PreparedStatement ps= con.prepareStatement("delete from stu_info where student_id=?");
						ps.setInt(1,Integer.parseInt( student_id.getText()));
						int x = ps.executeUpdate();
						
						if(x > 0) {
							System.out.println("Information deleted...");
							}
						} catch (Exception e2) {
						System.out.println(e2);
					}
					
				}
			});
		btnDelete.setBounds(385, 437, 89, 23);
		contentPane.add(btnDelete);
			}
}
		

