package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;
import javax.swing.JTextArea;
import java.awt.SystemColor;



public class MemberManagementUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField memberno_update;
	private JTextField membername_update;
	private JTextField username_update;
	private JTextField address_update;
	private JTextField password_update;
	private static MemberServiceImpl msi=new MemberServiceImpl();
	private JTextField password_change;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberManagementUI frame = new MemberManagementUI();
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
	public MemberManagementUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("會員資料更新系統");
		lblNewLabel.setBounds(324, 10, 166, 40);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		username_update = new JTextField();
		username_update.setBounds(109, 291, 96, 21);
		contentPane.add(username_update);
		username_update.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("會員帳號:");
		lblNewLabel_1_2.setBounds(48, 291, 59, 20);
		contentPane.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("會員編號:");
		lblNewLabel_1.setBounds(37, 398, 66, 20);
		contentPane.add(lblNewLabel_1);
		
		memberno_update = new JTextField();
		memberno_update.setBounds(109, 398, 96, 21);
		contentPane.add(memberno_update);
		memberno_update.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("會員姓名:");
		lblNewLabel_1_1.setBounds(228, 398, 66, 20);
		contentPane.add(lblNewLabel_1_1);
		
		membername_update = new JTextField();
		membername_update.setBounds(291, 398, 96, 21);
		contentPane.add(membername_update);
		membername_update.setColumns(10);
		
		JLabel lblNewLabel_1_4 = new JLabel("會員地址:");
		lblNewLabel_1_4.setBounds(37, 429, 66, 20);
		contentPane.add(lblNewLabel_1_4);
		
		address_update = new JTextField();
		address_update.setBounds(109, 429, 278, 21);
		contentPane.add(address_update);
		address_update.setColumns(10);
		
		JLabel lblNewLabel_1_3 = new JLabel("會員密碼:");
		lblNewLabel_1_3.setBounds(228, 291, 66, 20);
		contentPane.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setForeground(new Color(0, 0, 0));
		
		password_update = new JTextField();
		password_update.setBounds(290, 291, 96, 21);
		contentPane.add(password_update);
		password_update.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("會員Id:");
		lblNewLabel_2.setBounds(51, 373, 52, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel member_id = new JLabel("");
		member_id.setBounds(109, 369, 95, 19);
		contentPane.add(member_id);
		
		JLabel lblNewLabel_2_1 = new JLabel("請輸入欲修改會員帳號及密碼:");
		lblNewLabel_2_1.setBounds(37, 262, 168, 19);
		contentPane.add(lblNewLabel_2_1);
		
		JTextArea output2_update = new JTextArea();
		output2_update.setBounds(22, 322, 718, 41);
		contentPane.add(output2_update);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("會員密碼:");
		lblNewLabel_1_3_1.setBounds(228, 369, 66, 20);
		lblNewLabel_1_3_1.setForeground(Color.BLACK);
		contentPane.add(lblNewLabel_1_3_1);
		
		password_change = new JTextField();
		password_change.setBounds(291, 370, 96, 21);
		password_change.setColumns(10);
		contentPane.add(password_change);

		
		
		
		JButton btnNewButton_1 = new JButton("回登入頁");
		btnNewButton_1.setBounds(651, 497, 87, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginUI l=new LoginUI();
				l.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 44, 728, 208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea output_update = new JTextArea();
		output_update.setBounds(10, 43, 708, 156);
		panel.add(output_update);
		
		JButton btnNewButton_2 = new JButton("資料查詢");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				List<Member> l=msi.selectAll();
						
				String show="";
				show=show+"id\t會員編號\t會員姓名\t會員帳號\t會員地址\t會員密碼\n";
				show=show+"--------\t---------\t---------\t---------\t---------\t---------\n";
				for(Member m:l) {show=show+m.getId()
				+"\t"+m.getMemberno()+"\t"+m.getMembername()+"\t"+m.getUsername()+
				"\t"+m.getAddress()+"\t"+"*******\n";//m.getPassword()+"\n";	                        
				}
				output_update.setText(show);
					
			}
		});
		btnNewButton_2.setBounds(631, 10, 87, 23);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("密碼以隱碼(******)顯示:");
		lblNewLabel_3.setBounds(481, 10, 151, 23);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		
		JButton btnNewButton = new JButton("修改確認");
		btnNewButton.setBounds(417, 428, 87, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*1擷取 username.gettext()
				 *2 帳號是否重複-->findByusername
				 *true-->重複-->addMemberError
				 *false-->註冊-->擷取剩下getText()-->new Member-->addMember-->addmemberSuccess
				 * 
				 */
				    Integer Id=Integer.valueOf(member_id.getText());
				    String Memberno=memberno_update.getText();
					String UserName=username_update.getText();
				    String Membername=membername_update.getText();
					String Address=address_update.getText();
					String Password=password_change.getText();
					
				Member x=new Member(Id, Memberno,Membername,UserName,Address,Password);
                msi.update(x);
                
                List<Member> l=msi.selectAll();
				
				String show="";
				show=show+"id\t會員編號\t會員姓名\t會員帳號\t會員地址\t會員密碼\n";
				show=show+"--------\t---------\t---------\t---------\t---------\t---------\n";
				for(Member m:l) {show=show+m.getId()
				+"\t"+m.getMemberno()+"\t"+m.getMembername()+"\t"+m.getUsername()+
				"\t"+m.getAddress()+"\t"+"*******\n";//m.getPassword()+"\n";	                        
				}
				output_update.setText(show);
                
                				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("確認");
		btnNewButton_3.setBounds(417, 290, 87, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName=username_update.getText();
				String Password=password_update.getText();
				
				Member m=msi.Login(UserName, Password);
			if(m!=null)
				{	
				
						String Address=m.getAddress();	
						String Memberno=m.getMemberno();
						String Membername=m.getMembername();
						String show="";
						show=show+"id\t會員編號\t會員姓名\t會員帳號\t會員地址\t會員密碼\n";
						show=show+m.getId()
						+"\t"+m.getMemberno()+"\t"+m.getMembername()+"\t"+m.getUsername()+
						"\t"+m.getAddress()+"\t"+m.getPassword()+"\n";	                        
						output2_update.setText(show);
		
					
				    member_id.setText(m.getId().toString());	
					memberno_update.setText(Memberno);
					membername_update.setText(Membername);
					address_update.setText(Address);
					password_change.setText(Password);
				
				}
				else
				{
					String show="";
					show=show+"帳號或密碼輸入不正確，請再輸入一次!\n";                     
					output2_update.setText(show);									
			//		AddMemberError a=new AddMemberError();
			//		a.setVisible(true);
			//		dispose();
				
				}
				
				
				
			}
		});
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("(密碼錯誤不予修改)");
		lblNewLabel_3_1.setBounds(199, 258, 125, 23);
		lblNewLabel_3_1.setForeground(Color.RED);
		contentPane.add(lblNewLabel_3_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(23, 459, 604, 76);
		panel_1.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("報表功能區:");
		lblNewLabel_4.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 10, 93, 20);
		panel_1.add(lblNewLabel_4);
		
		JButton btnNewButton_4 = new JButton("銷售報表");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderReportSystemUI l=new OrderReportSystemUI();
				l.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_4.setFont(new Font("微軟正黑體", Font.BOLD, 12));
		btnNewButton_4.setBounds(100, 10, 93, 56);
		panel_1.add(btnNewButton_4);
	
		

		
		
	}
}
