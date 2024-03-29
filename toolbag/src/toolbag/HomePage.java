package toolbag;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


public class HomePage extends JFrame {

	private JPanel contentPane;
	private JLabel lblWallpaper;
	
	private JLabel lblSearch;
	private JLabel btnSearch;
	
	private JLabel lblIPFinder;
	private JLabel btnIPFinder;
	
	private JLabel lblWCCount;
	private JLabel btnWCCount;
	
	private JLabel lblSourceCodeGen;
	private JLabel btnSourceCodeGen;
	
	private JLabel lblImageComp; 
	private JLabel btnImageComp;
	
	private JLabel lblExit;
	private JLabel btnExit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage homePage = new HomePage();
					homePage.setLocationRelativeTo(null);
					homePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomePage() {
		setUndecorated(true);
		setResizable(false);
		setTitle("Tool Bag");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnExit = new JLabel("Exit");
		btnExit.setHorizontalAlignment(SwingConstants.CENTER);
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnExit.setBounds(550, 443, 160, 60);
		contentPane.add(btnExit);
		
		lblExit = new JLabel("");
		lblExit.setIcon(new ImageIcon(HomePage.class.getResource("/button.png")));
		lblExit.setBounds(550, 443, 160, 60);
		contentPane.add(lblExit);
		
		btnImageComp = new JLabel("Image Comparison");
		btnImageComp.setHorizontalTextPosition(SwingConstants.CENTER);
		btnImageComp.setHorizontalAlignment(SwingConstants.CENTER);
		btnImageComp.setForeground(Color.WHITE);
		btnImageComp.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnImageComp.setBounds(90, 443, 160, 60);
		contentPane.add(btnImageComp);
		
		lblImageComp = new JLabel("");
		lblImageComp.setIcon(new ImageIcon(HomePage.class.getResource("/button.png")));
		lblImageComp.setBounds(90, 443, 160, 60);
		contentPane.add(lblImageComp);
		
		btnSourceCodeGen = new JLabel("<html>Source Code<br/>Generator</html>");
		btnSourceCodeGen.setHorizontalAlignment(SwingConstants.CENTER);
		btnSourceCodeGen.setForeground(Color.WHITE);
		btnSourceCodeGen.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnSourceCodeGen.setBounds(550, 243, 160, 60);
		contentPane.add(btnSourceCodeGen);
		
		lblSourceCodeGen = new JLabel("");
		lblSourceCodeGen.setIcon(new ImageIcon(HomePage.class.getResource("/button.png")));
		lblSourceCodeGen.setBounds(550, 243, 160, 60);
		contentPane.add(lblSourceCodeGen);
		
		btnWCCount = new JLabel("<html>Word Character<br/>Count</html>");
		btnWCCount.setHorizontalTextPosition(SwingConstants.CENTER);
		btnWCCount.setHorizontalAlignment(SwingConstants.CENTER);
		btnWCCount.setForeground(Color.WHITE);
		btnWCCount.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnWCCount.setBounds(90, 243, 160, 60);
		contentPane.add(btnWCCount);
		
		lblWCCount = new JLabel("");
		lblWCCount.setIcon(new ImageIcon(HomePage.class.getResource("/button.png")));
		lblWCCount.setBounds(90, 243, 160, 60);
		contentPane.add(lblWCCount);
		
		btnIPFinder = new JLabel("IP Finder");
		btnIPFinder.setHorizontalAlignment(SwingConstants.CENTER);
		btnIPFinder.setForeground(Color.WHITE);
		btnIPFinder.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnIPFinder.setBounds(550, 43, 160, 60);
		contentPane.add(btnIPFinder);
		
		lblIPFinder = new JLabel("");
		lblIPFinder.setIcon(new ImageIcon(HomePage.class.getResource("/button.png")));
		lblIPFinder.setBounds(550, 43, 160, 60);
		contentPane.add(lblIPFinder);
		
		btnSearch = new JLabel("Search on Google");
		btnSearch.setHorizontalAlignment(SwingConstants.CENTER);
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnSearch.setBounds(90, 43, 160, 60);
		contentPane.add(btnSearch);
		
		lblSearch = new JLabel("");
		lblSearch.setIcon(new ImageIcon(HomePage.class.getResource("/button.png")));
		lblSearch.setBounds(90, 43, 160, 60);
		contentPane.add(lblSearch);
		
		lblWallpaper = new JLabel("");
		lblWallpaper.setIcon(new ImageIcon(HomePage.class.getResource("/wallpaper.jpg")));
		lblWallpaper.setBounds(0, 0, 800, 600);
		contentPane.add(lblWallpaper);
		
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String search = JOptionPane.showInputDialog("Enter what you want to search");
			    System.out.println(search);
			    search = calculateWordForChrome(search);
			    String searchKey = "http://www.google.com/search?q=" + search;
			    System.out.println(searchKey);
			    if(search != null){
			    	try {
						Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome " + searchKey });
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
			}

		
		});
		btnIPFinder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				IPFinderPage finderPage = new IPFinderPage();
				finderPage.setVisible(true);
				finderPage.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnWCCount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				WCC wcc = new WCC();
				wcc.setVisible(true);
				wcc.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnSourceCodeGen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SourceCodeGenerator sourceCodeGenerator = new SourceCodeGenerator();
				sourceCodeGenerator.setVisible(true);
				sourceCodeGenerator.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnImageComp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				String url1 = JOptionPane.showInputDialog("Enter image1 Url");
				String url2 = JOptionPane.showInputDialog("Enter image2 Url");
				ImageComp imageComp = new ImageComp(url1,url2);
				imageComp.setVisible(true);
				imageComp.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 System.exit(0);
			}
		});
		
		
	}
	private String calculateWordForChrome(String search) {
		String[] splittedWord = search.split(" ");
		String searchKey = "";
		for(int i=0; i< splittedWord.length; i++){
			 searchKey += splittedWord[i]+ '+'; 
		}
		return searchKey;
	}
}
