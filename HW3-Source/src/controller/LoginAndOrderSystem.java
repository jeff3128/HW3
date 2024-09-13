package controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class LoginAndOrderSystem extends JFrame {

	private static final long serialVersionUID = 1L;
	// 模擬會員數據
  /*  private static final String[][] USERS = {
            {"user1", "user123", "金"},
            {"user2", "user123", "銀"},
            {"user3", "user123", "銅"}
    }; */

    // 商品價格
    private static final int ITEM1_PRICE = 50;
    private static final int ITEM2_PRICE = 60;
    private static final int ITEM3_PRICE = 40;
    private static final int ITEM4_PRICE = 50;

    // 會員等級折扣
    private static final double GOLD_DISCOUNT = 0.7;
    private static final double SILVER_DISCOUNT = 0.8;
    private static final double BRONZE_DISCOUNT = 0.9;

    private JComboBox<String> membershipLevelComboBox;
    private JTextField item1Quantity;
    private JTextField item2Quantity;
    private JTextField item3Quantity;
    private JTextField item4Quantity;
    private JTextArea outputArea;
    private JTextArea outputArea1;
    private JTextField paymentField;

    public static void main(String[] args) {
        new LoginAndOrderSystem();
    }

    public LoginAndOrderSystem() {
        setTitle("神清氣爽飲料店");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new CardLayout());

     //   JPanel loginPanel = createLoginPanel();
        JPanel orderPanel = createOrderPanel();

      //  add(loginPanel, "login");
        getContentPane().add(orderPanel, "order");

        setVisible(true);
    }

    // 創建點餐頁面
    private JPanel createOrderPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel membershipLabel = new JLabel("會員等級:");
        membershipLabel.setBounds(50, 20, 100, 25);
        panel.add(membershipLabel);

        membershipLevelComboBox = new JComboBox<>(new String[]{"金", "銀", "銅"});
        membershipLevelComboBox.setBounds(150, 20, 100, 25);
        panel.add(membershipLevelComboBox);

        // 商品1
        JLabel item1Label = new JLabel("氣泡飲 - 50元 數量:");
        item1Label.setBounds(50, 60, 150, 25);
        panel.add(item1Label);

        item1Quantity = new JTextField("0");
        item1Quantity.setBounds(200, 60, 50, 25);
        panel.add(item1Quantity);

        // 商品2
        JLabel item2Label = new JLabel("蔬果汁 - 60元 數量:");
        item2Label.setBounds(50, 100, 150, 25);
        panel.add(item2Label);

        item2Quantity = new JTextField("0");
        item2Quantity.setBounds(200, 100, 50, 25);
        panel.add(item2Quantity);

        // 商品3
        JLabel item3Label = new JLabel("青草茶 - 40元 數量:");
        item3Label.setBounds(50, 140, 150, 25);
        panel.add(item3Label);

        item3Quantity = new JTextField("0");
        item3Quantity.setBounds(200, 140, 50, 25);
        panel.add(item3Quantity);

        // 商品4
        JLabel item4Label = new JLabel("咖  啡 - 50元 數量:");
        item4Label.setBounds(50, 180, 150, 25);
        panel.add(item4Label);

        item4Quantity = new JTextField("0");
        item4Quantity.setBounds(200, 180, 50, 25);
        panel.add(item4Quantity);

        // 總金額的 TextArea
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(50, 220, 340, 150);
        panel.add(scrollPane);
        
        // 找零的 TextArea1
        outputArea1 = new JTextArea();
        outputArea1.setEditable(false);
        JScrollPane scrollPane1 = new JScrollPane(outputArea1);
        scrollPane1.setBounds(390, 220, 340, 150);
        panel.add(scrollPane1); 

        // 確認按鈕
        JButton confirmButton = new JButton("確認");
        confirmButton.setBounds(50, 380, 100, 25);
        panel.add(confirmButton);

        // 列印按鈕
        JButton printButton = new JButton("列印");
        printButton.setBounds(160, 380, 100, 25);
        panel.add(printButton);

        // 找零按鈕
        JButton changeButton = new JButton("找零");
        changeButton.setBounds(480, 380, 100, 25);
        panel.add(changeButton);

        JLabel paymentLabel = new JLabel("付款金額:");
        paymentLabel.setBounds(270, 380, 100, 25);
        panel.add(paymentLabel);

        paymentField = new JTextField();
        paymentField.setBounds(330, 380, 100, 25);
        panel.add(paymentField);

        JLabel changeLabel = new JLabel("找零:");
        changeLabel.setBounds(590, 380, 50, 25);
        panel.add(changeLabel);

        JLabel changeAmountLabel = new JLabel("");
        changeAmountLabel.setBounds(640, 380, 100, 25);
        panel.add(changeAmountLabel);
        
        JButton closeButton = new JButton("結束");
        closeButton.setBounds(640, 448, 100, 25);
        panel.add(closeButton);
        
        JLabel timeDisplay =new JLabel("現在時間:");
        timeDisplay.setBounds(400, 100, 100, 25);
        panel.add(timeDisplay);
        
        JLabel timeDisplayHere =new JLabel("");
        timeDisplayHere.setBounds(500, 100, 200, 25);
        updateTime(timeDisplayHere);
        panel.add(timeDisplayHere);
        
        JButton btnNewButton = new JButton("回登入頁");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		LoginUI l=new LoginUI();
				l.setVisible(true);
				dispose();
        		
        		
        	}
        });
        btnNewButton.setBounds(538, 449, 87, 23);
        panel.add(btnNewButton);

        // 確認按鈕事件處理
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int total = 0;
                int undiscount=0;
                int item1Count = Integer.parseInt(item1Quantity.getText());
                int item2Count = Integer.parseInt(item2Quantity.getText());
                int item3Count = Integer.parseInt(item3Quantity.getText());
                int item4Count = Integer.parseInt(item4Quantity.getText());

                total += item1Count * ITEM1_PRICE;
                total += item2Count * ITEM2_PRICE;
                total += item3Count * ITEM3_PRICE;
                total += item4Count * ITEM4_PRICE;
                undiscount=total;
                String membershipLevel = (String) membershipLevelComboBox.getSelectedItem();
                if ("金".equals(membershipLevel)) {
                    total *= GOLD_DISCOUNT;
                } else if ("銀".equals(membershipLevel)) {
                    total *= SILVER_DISCOUNT;
                } else if ("銅".equals(membershipLevel)) {
                    total *= BRONZE_DISCOUNT;
                }

                // 顯示計算結果於 JTextArea
                outputArea.setText("氣泡飲 數量: " + item1Count + " 小計: " + (item1Count * ITEM1_PRICE) + " 元\n" +
                        "蔬果汁 數量: " + item2Count + " 小計: " + (item2Count * ITEM2_PRICE) + " 元\n" +
                        "青草茶 數量: " + item3Count + " 小計: " + (item3Count * ITEM3_PRICE) + " 元\n" +
                        "咖  啡 數量: " + item4Count + " 小計: " + (item4Count * ITEM4_PRICE) + " 元\n" +
                        "金額:"+undiscount+"元\n\n" +
                        "會員等級: " + membershipLevel + "\n" +
                        "折扣後總金額: " + total + " 元\n");
            }
        });

        // 列印按鈕事件處理
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // System.out.println("列印中...\n" + outputArea.getText());
             
                try {
                	outputArea.print();
                } catch (PrinterException e1) {
                	e1.printStackTrace();
                }
            }
        });
        
        //結束按鈕事件處理
        
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                	System.exit(0);
              
            }
        });

        // 找零按鈕事件處理
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                //double payment = Double.parseDouble(paymentField.getText());
            	int payment = (int) Double.parseDouble(paymentField.getText());
                String totalText = outputArea.getText().split("折扣後總金額: ")[1].split(" 元")[0];
                
                //double total = Double.parseDouble(totalText);
                int total = (int) Double.parseDouble(totalText);
                int change = payment - total;

                if (change < 0) {
                    changeAmountLabel.setText("金額不足");
                } else 
                	if  (change > 1000) {
                	outputArea1.setText("需要找您："+change+"元\n"+
                           // "--------------------------\n"+
                			"一千元:"+change/1000+" 張\n"+
                			"五百元:"+change%1000/500+" 張\n"+
                			"一百元:"+change%500/100+" 張\n"+
                			"五十元:"+change%100/50+" 枚\n"+
                			"十元："+change%50/10+" 枚\n"+
                			"五元："+change%10/5+" 枚\n"+
                			"一元："+change%5/1+" 枚\n");
                } else if (change >500 && change < 1000) {
                	outputArea1.setText("需要找您："+change+"元\n"+
                            "--------------------------\n"+
                			"五百元:"+change%1000/500+" 張\n"+
                			"一百元:"+change%500/100+" 張\n"+
                			"五十元:"+change%100/50+" 枚\n"+
                			"十元："+change%50/10+" 枚\n"+
                			"五元："+change%10/5+" 枚\n"+
                			"一元："+change%5/1+" 枚\n");
                } else  
                	outputArea1.setText("需要找您："+change+"元\n"+
                            "--------------------------\n"+
                			"一百元:"+change%500/100+" 張\n"+
                			"五十元:"+change%100/50+" 枚\n"+
                			"十元："+change%50/10+" 枚\n"+
                			"五元："+change%10/5+" 枚\n"+
                			"一元："+change%5/1+" 枚\n");  	
                //    changeAmountLabel.setText(String.format("%0.2f", change) + " 元");
                	  changeAmountLabel.setText(change+"元"); 
            }
        });

        return panel;
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

