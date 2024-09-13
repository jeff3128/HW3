package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.OrderReport;
import service.impl.OrderReportServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class OrderReportSystemUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField orderno_qry;
	private JTextField employeename_qry;

	private static OrderReportServiceImpl osi=new OrderReportServiceImpl();
	private JTextField id_qry;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderReportSystemUI frame = new OrderReportSystemUI();
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
	public OrderReportSystemUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(68, 26, 647, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("銷售報表查詢系統");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 25));
		lblNewLabel.setBounds(211, 10, 249, 36);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(68, 328, 174, 0);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 10, 232, 102);
		panel_1.add(textArea);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(68, 126, 653, 163);
		contentPane.add(panel_1_1);
		
		JTextArea output_qry = new JTextArea();
		output_qry.setBounds(10, 10, 633, 139);
		panel_1_1.add(output_qry);
		
		JLabel lblNewLabel_1 = new JLabel("銷售一覽表:");
		lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(78, 92, 83, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("條件查詢");
		lblNewLabel_3.setFont(new Font("微軟正黑體", Font.BOLD, 14));
		lblNewLabel_3.setBounds(10, 316, 56, 21);
		contentPane.add(lblNewLabel_3);
		
		orderno_qry = new JTextField();
		orderno_qry.setBounds(191, 372, 96, 21);
		contentPane.add(orderno_qry);
		orderno_qry.setColumns(10);
		
		employeename_qry = new JTextField();
		employeename_qry.setColumns(10);
		employeename_qry.setBounds(314, 372, 96, 21);
		contentPane.add(employeename_qry);
		
		 JLabel timeDisplay =new JLabel("現在時間:");
	        timeDisplay.setBounds(566, 317, 64, 25);
	        contentPane.add(timeDisplay);
	        
	        JLabel timeDisplayHere =new JLabel("");
	        timeDisplayHere.setBounds(640, 317, 64, 25);
	        updateTime(timeDisplayHere);
	        contentPane.add(timeDisplayHere);
		
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				//OrderReport ort=new OrderReport();
				
				List<OrderReport> l=osi.selectAll();
				String show="";
				show=show+"id\t訂單編號\t員工姓名\t產品名稱\t會員姓名\t訂單金額\n";
				show=show+"--------\t---------\t---------\t---------\t---------\t---------\n";
				for(OrderReport o:l) {show=show+o.getId()
				+"\t"+o.getOrderno()+"\t"+o.getEmployeename()+"\t"+o.getProductname()+
				"\t"+o.getMembername()+"\t"+o.getSum()+"\n";	                        
				}
				output_qry.setText(show);
				
			}
		});
		btnNewButton.setBounds(633, 97, 87, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("依 ID查詢");
		btnNewButton_1.setFont(new Font("PMingLiU", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(240, 240, 240));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               // OrderReport ort=new OrderReport();
                int Id=Integer.parseInt(id_qry.getText());
				List<OrderReport> l=osi.selectById(Id);
				String show="";
				show=show+"id\t訂單編號\t員工姓名\t產品名稱\t會員姓名\t訂單金額\n";
				show=show+"--------\t---------\t---------\t---------\t---------\t---------\n";
				for(OrderReport o:l) {show=show+o.getId()
				+"\t"+o.getOrderno()+"\t"+o.getEmployeename()+"\t"+o.getProductname()+
				"\t"+o.getMembername()+"\t"+o.getSum()+"\n";	                        
				}
				output_qry.setText(show);
			}
		});
		btnNewButton_1.setBounds(78, 315, 93, 23);
		contentPane.add(btnNewButton_1);
		
		
		JButton btnNewButton_1_2 = new JButton("依訂單編號");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//    OrderReport ort=new OrderReport();
	                String OrderNo=orderno_qry.getText();
					List<OrderReport> l=osi.selectOrderno(OrderNo);
					String show="";
					show=show+"id\t訂單編號\t員工姓名\t產品名稱\t會員姓名\t訂單金額\n";
					show=show+"--------\t---------\t---------\t---------\t---------\t---------\n";
					for(OrderReport o:l) {show=show+o.getId()
					+"\t"+o.getOrderno()+"\t"+o.getEmployeename()+"\t"+o.getProductname()+
					"\t"+o.getMembername()+"\t"+o.getSum()+"\n";	                        
					}
					output_qry.setText(show);
				}	
		});
		btnNewButton_1_2.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1_2.setBounds(186, 315, 101, 23);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3_1 = new JButton("依員工姓名");
		btnNewButton_1_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//OrderReport ort=new OrderReport();
				String EmployeeName=employeename_qry.getText();
				List<OrderReport> l=osi.selectEmployeeName(EmployeeName);
				String show="";
				show=show+"id\t訂單編號\t員工姓名\t產品名稱\t會員姓名\t訂單金額\n";
				show=show+"--------\t---------\t---------\t---------\t---------\t---------\n";
				for(OrderReport o:l) {show=show+o.getId()
				+"\t"+o.getOrderno()+"\t"+o.getEmployeename()+"\t"+o.getProductname()+
				"\t"+o.getMembername()+"\t"+o.getSum()+"\n";	                        
				}
				output_qry.setText(show);
					
			}
		});
		btnNewButton_1_3_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1_3_1.setBounds(314, 318, 96, 23);
		contentPane.add(btnNewButton_1_3_1);
		
		id_qry = new JTextField();
		id_qry.setColumns(10);
		id_qry.setBounds(78, 372, 96, 21);
		contentPane.add(id_qry);
		
		JButton btnNewButton_2 = new JButton("離開");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(640, 403, 87, 23);
		contentPane.add(btnNewButton_2);
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
	
