package toolbag;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ImageComp extends JFrame {

	private JPanel contentPane;
	private JLabel lblWallpaper;
	private JButton btnHomePage;
	private JLabel img1,img2;
	private String url1, url2;
	private JLabel lblPercentage;

	public ImageComp(String url1, String url2) {
		this.url1 = url1;
		this.url2 = url2;
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 1280, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		drawImages(url1,url2);
		
		btnHomePage = new JButton();
		
		btnHomePage.setIcon(new ImageIcon(IPFinderPage.class.getResource("/button.png")));
		btnHomePage.setText("Home Page");
		btnHomePage.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHomePage.setVerticalTextPosition(SwingConstants.CENTER);
		btnHomePage.setForeground(Color.WHITE);
		btnHomePage.setFont(new Font("Berlin Sans FB", Font.PLAIN, 18));
		btnHomePage.setBounds(1118, 737, 150, 50);
		contentPane.add(btnHomePage);
		
		
		
		lblWallpaper = new JLabel("");
    	lblWallpaper.setIcon(new ImageIcon(ImageComp.class.getResource("/wallpaper.jpg")));
    	lblWallpaper.setBounds(0, 0, 1280, 800);
    	
    	contentPane.add(lblWallpaper);
    	
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

	private void drawImages(String url12, String url22) {
		img1 = new JLabel();
		img2 = new JLabel();
		URL url;
		BufferedImage image1,image2;
		ImageIcon icon;
		try {
			url = new URL(url1);
			image1 = ImageIO.read(url);
			icon = new ImageIcon(new ImageIcon(image1).getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
			
			img1.setIcon(icon);
			img1.setBounds(20, 100, 600, 600);
			contentPane.add(img1);
			url = new URL(url2);
			image2 = ImageIO.read(url);
			icon = new ImageIcon(new ImageIcon(image2).getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT));
			img2.setIcon(icon);
			img2.setBounds(640, 100, 600, 600);
			contentPane.add(img2);
			
			compTwoImages(image1,image2);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void compTwoImages(BufferedImage image1, BufferedImage image2) {
		
		int width1 = image1.getWidth(); 
        int width2 = image2.getWidth(); 
        int height1 = image1.getHeight(); 
        int height2 = image2.getHeight(); 
        
        if ((width1 != width2) || (height1 != height2)) 
            System.out.println("diff size"); 
        else
        { 
            long difference = 0; 
            for (int y = 0; y < height1; y++) 
            { 
                for (int x = 0; x < width1; x++) 
                { 
                    int rgbA = image1.getRGB(x, y); 
                    int rgbB = image2.getRGB(x, y); 
                    int redA = (rgbA >> 16) & 0xff; 
                    int greenA = (rgbA >> 8) & 0xff; 
                    int blueA = (rgbA) & 0xff; 
                    int redB = (rgbB >> 16) & 0xff; 
                    int greenB = (rgbB >> 8) & 0xff; 
                    int blueB = (rgbB) & 0xff; 
                    difference += Math.abs(redA - redB); 
                    difference += Math.abs(greenA - greenB); 
                    difference += Math.abs(blueA - blueB); 
                } 
            } 
        double total_pixels = width1 * height1 * 3;
        double avg_different_pixels = difference / total_pixels;
        double percentage = (avg_different_pixels / 255) * 100;
        
		lblPercentage = new JLabel("Percentage: " + percentage);
		lblPercentage.setForeground(Color.WHITE);
		lblPercentage.setFont(new Font("Berlin Sans FB", Font.PLAIN, 22));
		lblPercentage.setBounds(542, 13, 163, 32);
		contentPane.add(lblPercentage);
		
	}
}
}
