package login;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class welcome extends JFrame implements ActionListener
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame2;
	JButton btn1 = new JButton("Login");
	JButton btn2 = new JButton("Register");
	JLabel l1 = new JLabel("Dayananda Sagar Collge of Engineering");
	JLabel l2 = new JLabel("Welcome to CSE");
	java.net.URL imgUrl = getClass().getResource("dsce.jpg");
	ImageIcon imageIcon = new ImageIcon(imgUrl); // load the image to a imageIcon
	Image image = imageIcon.getImage(); // transform it 
	JLabel label ;
	JTextArea txt = new JTextArea(5,5);
	JScrollPane scrollpane = new JScrollPane(txt);
	 public welcome()
	 {
	     createWindow();
	     setLocationAndSize();
	     addComponentsToFrame();
	     actionEvent();
	 }
	 public void  createWindow()
	 {
		  frame2 = new JFrame("DSCE_Login");
		  frame2.setSize(800,800);
		 l1.setForeground(Color.white);
		
		  l1.setFont(new Font("Serif", Font.BOLD, 30));
		  l2.setForeground(Color.white);
			
		  l2.setFont(new Font("Serif", Font.BOLD, 20));
		  txt.setVisible(true);		
//		  txt.setForeground(Color.white);
		  txt.setFont(new Font("Serif", Font.BOLD, 20));
		  txt.setText("The Dayananda Sagar College of Engineering was established in 1979,"
		  		+ " was founded by Late Sri R Dayananda Sagar and "
		  		+ "is run by the Mahatma Gandhi Vidya Peetha Trust (MGVP). It started with the basic courses"
		  		+ " of Civil, Mechanical, Electrical and Electronics Engineering. The college offeres undergraduate"
		  		+ ", Post-graduates and doctoral programmes under Visvesvaraya Technological University");
		    txt.setLineWrap(true);
			txt.setWrapStyleWord(true);
	        frame2.getContentPane().setBackground(Color.black);
	        frame2.getContentPane().setLayout(null);
	        frame2.setVisible(true);
	        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame2.setResizable(true);
	        Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	    	imageIcon = new ImageIcon(newimg);  // transform it back
	    	label = new JLabel(imageIcon);
		 
	 }
	    public void setLocationAndSize()
	    {
	    	l1.setBounds(100,180, 600, 40);
	    	l2.setBounds(120,220,480,40);
	        btn1.setBounds(230, 700, 100, 30);
	        btn2.setBounds(380, 700, 100, 30);
	        label.setBounds(300,30,120,120);
	        scrollpane.setBounds(120, 280, 480, 400);

	    }

	    public void addComponentsToFrame()
	    {
	        frame2.add(btn1);
	        frame2.add(btn2);
	        frame2.add(l1);
	        frame2.add(label);
	        frame2.add(scrollpane);
	        frame2.add(l2);
	    }
	    public void actionEvent()
	     {
	         btn1.addActionListener(this);
	         btn2.addActionListener(this);
	     }
	    public void actionPerformed(ActionEvent e)
	    {
	    	 frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    		frame2.getContentPane().add(btn2);
	    		frame2.getContentPane().add(btn1);
	    		
	    		btn1.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent ae) {
	    				frame2.dispose();
	    				new Login();
	    			}
	    		});
	    		btn2.addActionListener(new ActionListener() {
	    			public void actionPerformed(ActionEvent ae) {
	    				frame2.dispose();
	    				new registration();
	    			}
	    		});
//	    		frame2.setSize(400,400);
//	    		frame2.setVisible(true);
	    		
	    }

public static void main(String args[])
{
	  new welcome();
}
 }