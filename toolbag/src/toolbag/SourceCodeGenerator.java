package toolbag;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;   
import java.io.InputStream;  
import java.net.*;  

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SourceCodeGenerator extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;  
    private JTextArea textArea;  
    private JButton btnGetSourceCode;  
    private JLabel lblEnterUrl;
    private JLabel lblWallpaper;
    private JButton btnHomePage;
    private JLabel lblSourceCode;
    private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public SourceCodeGenerator() {
		super("Source Code Generator");
        setUndecorated(true);
    	setResizable(false);
		
    	
        lblEnterUrl=new JLabel("Enter URL:");  
        lblEnterUrl.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        lblEnterUrl.setForeground(Color.WHITE);
        lblEnterUrl.setBounds(50,50,111,30);  
          
        textField=new JTextField();  
        textField.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        textField.setBounds(173,50,355,30);  
          
        btnGetSourceCode=new JButton("Get Source Code");  
        btnGetSourceCode.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        btnGetSourceCode.setBounds(261, 93,179,30);  
        btnGetSourceCode.addActionListener(this);  
        
        btnHomePage = new JButton();	
    	btnHomePage.setIcon(new ImageIcon(SourceCodeGenerator.class.getResource("/button.png")));
    	btnHomePage.setText("Home Page");
    	btnHomePage.setHorizontalTextPosition(SwingConstants.CENTER);
    	btnHomePage.setVerticalTextPosition(SwingConstants.CENTER);
    	btnHomePage.setForeground(Color.WHITE);
    	btnHomePage.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
    	btnHomePage.setBounds(426, 537, 150, 50);
    	
		setBounds(100, 100, 600, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
    	contentPane.setLayout(null);
    	getContentPane().add(btnHomePage);
        getContentPane().add(lblEnterUrl);
        getContentPane().add(textField);
        getContentPane().add(btnGetSourceCode);
        
		lblSourceCode = new JLabel("Source Code:");
        lblSourceCode.setForeground(Color.WHITE);
        lblSourceCode.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
        lblSourceCode.setBounds(50, 126, 111, 20);
        contentPane.add(lblSourceCode);
        
        lblWallpaper = new JLabel("");
        lblWallpaper.setIcon(new ImageIcon(WCC.class.getResource("/wallpaper.jpg")));
        lblWallpaper.setBounds(5, 5, 590, 590);
        
        getContentPane().add(lblWallpaper);
		
		JPanel panel = new JPanel();
		panel.setBounds(50, 159, 506, 307);
		contentPane.add(panel);
		panel.setPreferredSize(new Dimension(1000,1000));
		panel.setLayout(null);
		
        textArea=new JTextArea();  
        textArea.setBounds(0, 0, 478, 307);
        textArea.setFont(new Font("Berlin Sans FB", Font.PLAIN, 16));
        
        scrollPane = new JScrollPane(textArea);
        
		scrollPane.setBounds(0, 0, 506, 307);
		panel.add(scrollPane);
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String string=textField.getText();  
        if(string==null){}  
        else{  
            try{  
            URL url=new URL(string);  
            URLConnection urlConnection=url.openConnection();  
          
            InputStream inputStream=urlConnection.getInputStream();  
            int i;  
            StringBuilder stringBuilder=new StringBuilder();  
            while((i=inputStream.read())!=-1){  
            	stringBuilder.append((char)i);  
            }  
            String source=stringBuilder.toString();  
            textArea.setText(source);  
            }catch(Exception ex){System.out.println(ex);}  
        }
	}
}
