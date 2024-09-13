package controller;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;
import java.awt.Color;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField memberno;
	private JTextField membername;
	private JTextField username;
	private JTextField password;
	private JTextField address;

	private static MemberServiceImpl msi=new MemberServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("會員編號:");
		lblNewLabel_1.setBounds(89, 41, 66, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("會員註冊");
		lblNewLabel.setBounds(178, 10, 66, 20);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("會員姓名:");
		lblNewLabel_1_1.setBounds(89, 71, 66, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("*會員帳號:");
		lblNewLabel_1_2.setForeground(new Color(255, 0, 255));
		lblNewLabel_1_2.setBounds(89, 101, 66, 20);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_4 = new JLabel("會員地址:");
		lblNewLabel_1_4.setBounds(89, 131, 66, 20);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_3 = new JLabel("*會員密碼:");
		lblNewLabel_1_3.setForeground(new Color(255, 0, 255));
		lblNewLabel_1_3.setBounds(89, 161, 66, 20);
		contentPane.add(lblNewLabel_1_3);
				
		memberno = new JTextField();
		memberno.setBounds(167, 41, 96, 21);
		contentPane.add(memberno);
		memberno.setColumns(10);
		
		membername = new JTextField();
		membername.setColumns(10);
		membername.setBounds(167, 71, 96, 21);
		contentPane.add(membername);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(167, 101, 96, 21);
		contentPane.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(165, 161, 96, 21);
		contentPane.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(165, 131, 96, 21);
		contentPane.add(address);
		
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*1擷取 username.gettext()
				 *2 帳號是否重複-->findByusername
				 *true-->重複-->addMemberError
				 *false-->註冊-->擷取剩下getText()-->new Member-->addMember-->addmemberSuccess
				 * 
				 */
				String UserName=username.getText();
				if(msi.findByUsername(UserName)) {
					AddMemberError a=new AddMemberError();
					a.setVisible(true);
					dispose();
				}
				else
				{
					
					String Memberno=memberno.getText();
					String MemberName=membername.getText();
					String Address=address.getText();
					String Password=password.getText();
								
					Member m=new Member(Memberno,MemberName,UserName,Address,Password);
						
					msi.addMember(m);
					AddMemberSuccess a=new AddMemberSuccess();
					a.setVisible(true);
					dispose(); 
				
				}
				
				
			}
		});
		btnNewButton.setBounds(295, 190, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("回登入頁");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginUI l=new LoginUI();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(29, 191, 87, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("ggg");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(273, 101, 39, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("1234");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setBounds(273, 161, 39, 20);
		contentPane.add(lblNewLabel_2_1);
	}
}
