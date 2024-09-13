package controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;
import util.Cal;
import java.awt.Color;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private static MemberServiceImpl msi=new MemberServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號:");
		lblNewLabel.setBounds(136, 75, 46, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼:");
		lblNewLabel_1.setBounds(136, 105, 46, 15);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setBounds(199, 72, 114, 21);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(199, 102, 114, 21);
		contentPane.add(password);
		
		 JLabel timeDisplay =new JLabel("現在時間:");
	        timeDisplay.setBounds(136, 25, 114, 25);
	        contentPane.add(timeDisplay);
	        
	        JLabel timeDisplayHere =new JLabel("");
	        timeDisplayHere.setBounds(199, 22, 114, 25);
	        updateTime(timeDisplayHere);
	        contentPane.add(timeDisplayHere);

		
		
		JButton btnNewButton = new JButton("登入");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username=username.getText();
				String Password=password.getText();
				Member m=msi.Login(Username, Password);
				
				if(m!=null)
				{
					Cal.SaveObject(m,"Member1.txt");
					LoginSuccess l=new LoginSuccess();
					l.setVisible(true);
					dispose();
				}
				else
				{
					LoginError l=new LoginError();
					l.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(136, 150, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddMemberUI a=new AddMemberUI();
				a.setVisible(true);
				dispose();
			
				
			}
		});
		btnNewButton_1.setBounds(233, 150, 87, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("aaa/333");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setBounds(333, 54, 101, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("admin/admin");
		lblNewLabel_2_1.setForeground(Color.RED);
		lblNewLabel_2_1.setBounds(333, 80, 101, 25);
		contentPane.add(lblNewLabel_2_1);
		
	}
	private void updateTime(JLabel timeDisplayHere) {
		// TODO Auto-generated method stub
		   //update time
            Timer timer = new Timer(1000, e -> {
                LocalTime now = LocalTime.now();
                timeDisplayHere.setText(now.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            });
            timer.start();
        }

}
