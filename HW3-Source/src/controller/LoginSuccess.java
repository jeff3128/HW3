package controller;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import util.Cal;

public class LoginSuccess extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccess frame = new LoginSuccess();
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
	public LoginSuccess() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("登入成功!");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(165, 67, 105, 40);
		contentPane.add(lblNewLabel);
		
		JLabel show = new JLabel("");
		show.setFont(new Font("新細明體", Font.PLAIN, 16));
		show.setBounds(149, 105, 144, 29);
		contentPane.add(show);
		
		Member m=(Member) Cal.ReadObject("Member1.txt");
		show.setText(m.getMembername()+"歡迎您!!");
		
		
		JButton btnNewButton = new JButton("進入系統");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member m=(Member) Cal.ReadObject("Member1.txt");
				if (m.getUsername().equals("admin")) {
					MemberManagementUI l=new MemberManagementUI();
					//OrderReportSystemUI l=new OrderReportSystemUI();
					l.setVisible(true);
					dispose();
				} else {
				LoginAndOrderSystem L=new LoginAndOrderSystem();
				L.setVisible(true);
				dispose();}
				
			
			}
		});
		btnNewButton.setBounds(153, 144, 117, 23);
		contentPane.add(btnNewButton);
		
		
	}

}
