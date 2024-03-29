package toolbag;

import javax.swing.*;  

import java.awt.event.*;  
import java.net.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

public class IPFinderPage extends JFrame implements ActionListener{  
    private JLabel lblUrl;  
    private JTextField 	textField;  
    private JButton btn;
    private JLabel lblWallpaper;
    private JButton btnHomePage;
    
    IPFinderPage(){  
    	super("IP Finder");
    	setUndecorated(true);
		setResizable(false);
    	lblUrl=new JLabel("Enter URL:");  
    	lblUrl.setForeground(Color.WHITE);
    	lblUrl.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
    	lblUrl.setBounds(190,199,150,46);;  
    	textField=new JTextField();  
    	textField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
    	textField.setBackground(Color.WHITE);
    	textField.setForeground(Color.WHITE);
    	textField.setBounds(190,253,200,20);  
      
    	btn=new JButton();
    	btn.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
    	btn.setForeground(Color.WHITE);
    	btn.setIcon(new ImageIcon(IPFinderPage.class.getResource("/button.png")));
    	btn.setText("Find IP");
    	btn.setHorizontalTextPosition(JButton.CENTER);
    	btn.setVerticalTextPosition(JButton.CENTER);
    	btn.setBounds(190,303,150,50);  
    	btn.addActionListener(this);  
    	
    	btnHomePage = new JButton();
    	
    	btnHomePage.setIcon(new ImageIcon(IPFinderPage.class.getResource("/button.png")));
    	btnHomePage.setText("Home Page");
    	btnHomePage.setHorizontalTextPosition(SwingConstants.CENTER);
    	btnHomePage.setVerticalTextPosition(SwingConstants.CENTER);
    	btnHomePage.setForeground(Color.WHITE);
    	btnHomePage.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
    	btnHomePage.setBounds(426, 537, 150, 50);
    	
    	getContentPane().add(lblUrl);  
    	getContentPane().add(textField);
    	getContentPane().add(btnHomePage);
    	getContentPane().add(btn);  
    	
    	setSize(600,600);  
    	getContentPane().setLayout(null);  
    	
    	lblWallpaper = new JLabel("");
    	lblWallpaper.setIcon(new ImageIcon(IPFinderPage.class.getResource("/wallpaper.jpg")));
    	lblWallpaper.setBounds(0, 0, 600, 600);
    	
    	getContentPane().add(lblWallpaper);
    	setVisible(true);
    	
    	btnHomePage.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseClicked(MouseEvent arg0) {
    			HomePage homePage = new HomePage();
    			homePage.setVisible(true);
    			homePage.setLocationRelativeTo(null);
				dispose();
    		}
    	});
}  
    public void actionPerformed(ActionEvent e){  
    	String url=textField.getText();  
    	try {  
    		InetAddress iNetAddress=InetAddress.getByName(url);  
    		String ip=iNetAddress.getHostAddress();  
    		JOptionPane.showMessageDialog(this,ip);  
    	} catch (UnknownHostException e1) {  
    		JOptionPane.showMessageDialog(this,e1.toString());  
    	}  
    }
    
}  