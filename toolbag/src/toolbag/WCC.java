package toolbag;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;  

import javax.swing.*;  
public class WCC extends JFrame implements ActionListener{  

private JTextArea textArea;  
private JButton btnWord,btnCharacters;

private JLabel lblWallpaper;
private JLabel lblText;
private JButton btnHomePage;

WCC(){  
	super("Word - Character Count");
	setUndecorated(true);
	setResizable(false);
    textArea=new JTextArea();  
    textArea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
    textArea.setBounds(85,81,414,280);
    
    btnWord=new JButton();  
    btnWord.setIcon(new ImageIcon(WCC.class.getResource("/button.png")));
    btnWord.setText("Word");
    btnWord.setHorizontalTextPosition(SwingConstants.CENTER);
    btnWord.setVerticalTextPosition(SwingConstants.CENTER);
    btnWord.setForeground(Color.WHITE);
    btnWord.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
    btnWord.setBounds(145,383,140,40);  
      
    btnCharacters=new JButton();
    btnCharacters.setIcon(new ImageIcon(WCC.class.getResource("/button.png")));
    btnCharacters.setText("Character");
    btnCharacters.setHorizontalTextPosition(SwingConstants.CENTER);
    btnCharacters.setVerticalTextPosition(SwingConstants.CENTER);
    btnCharacters.setForeground(Color.WHITE);
    btnCharacters.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
    btnCharacters.setBounds(297,383,140,40);  
      
    btnWord.addActionListener(this);  
    btnCharacters.addActionListener(this);  
    
    lblText = new JLabel("Enter your text:");
    lblText.setForeground(Color.WHITE);
    lblText.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
    lblText.setBounds(88, 46, 140, 21);
    
    getContentPane().add(lblText);
    getContentPane().add(btnWord);
    getContentPane().add(btnCharacters);
    getContentPane().add(textArea);
    
    btnHomePage = new JButton();
	
	btnHomePage.setIcon(new ImageIcon(IPFinderPage.class.getResource("/button.png")));
	btnHomePage.setText("Home Page");
	btnHomePage.setHorizontalTextPosition(SwingConstants.CENTER);
	btnHomePage.setVerticalTextPosition(SwingConstants.CENTER);
	btnHomePage.setForeground(Color.WHITE);
	btnHomePage.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
	btnHomePage.setBounds(426, 537, 150, 50);
    
    lblWallpaper = new JLabel("");
	lblWallpaper.setIcon(new ImageIcon(WCC.class.getResource("/wallpaper.jpg")));
	lblWallpaper.setBounds(0, 0, 600, 600);
	
	getContentPane().add(btnHomePage);
	getContentPane().add(lblWallpaper);
	
    setSize(600,600);  
    getContentPane().setLayout(null);  
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
    String text=textArea.getText();  
    if(e.getSource()==btnWord){  
        String words[]=text.split("\\s");  
        JOptionPane.showMessageDialog(this,"Total words: "+words.length);  
    }  
    if(e.getSource()==btnCharacters){  
        JOptionPane.showMessageDialog(this,"Total Characters with space: "+text.length());  
    }  
}  
}