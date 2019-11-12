package login;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class registration extends JFrame implements ActionListener
{	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JFrame frame2;
	  JLabel l1 = new JLabel("Registration Form");
	  JLabel l2 = new JLabel("Name");
	  JLabel l3 = new JLabel("Username");
	  JLabel l4 = new JLabel("Password");
	  JTextField tf2  = new JTextField();
	  JTextField tf1 = new JTextField();
	  JPasswordField p1 = new JPasswordField();
	  JButton btn1 = new JButton("Register");
	  JButton resetButton=new JButton("RESET");
	  public  registration()
	    {
	        createWindow();
	        setLocationAndSize();
	        addComponentsToFrame();
	        actionEvent();
	    } 
	  public void createWindow()
	  {
		  frame2=new JFrame();
	        frame2.setTitle("Registration Form");
	        frame2.setSize(600,600);
	        l1.setForeground(Color.white);
	        l1.setFont(new Font("Serif", Font.BOLD, 30));
	        l2.setFont(new Font("Serif", Font.BOLD, 15));
	        l3.setFont(new Font("Serif", Font.BOLD, 15));
	        l4.setFont(new Font("Serif", Font.BOLD, 15));
	        l2.setForeground(Color.white);
	        l3.setForeground(Color.white);
	        l4.setForeground(Color.white);
	        frame2.getContentPane().setBackground(Color.black);
	        frame2.getContentPane().setLayout(null);
	        frame2.setVisible(true);
	        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame2.setResizable(true);
	  }
	  public void setLocationAndSize()
	  {
		  l1.setBounds(80, 30, 400, 30);
		  l2.setBounds(80, 80, 200, 30);
		  l3.setBounds(80, 120, 200, 30);
		  l4.setBounds(80, 160, 200, 30);
		  tf1.setBounds(300, 80, 200, 30);
		  tf2.setBounds(300, 120, 200, 30);
		  p1.setBounds(300, 160, 200, 30);
		  btn1.setBounds(150, 210, 100, 30);
		  resetButton.setBounds(300,210,100,30);
	  }
     public void addComponentsToFrame()
      {
    	 
    	  frame2.add(l1);
    	  frame2.add(l2);
    	  frame2.add(l3);
    	  frame2.add(l4);
    	  frame2.add(tf1);  
    	  frame2.add(p1);
    	  frame2.add(tf2);
    	  frame2.add(btn1);
    	  frame2.add(resetButton);
    	  
      }
     public void actionEvent()
     {
         btn1.addActionListener(this);
         resetButton.addActionListener(this);
     }

 public void actionPerformed(ActionEvent e)
 {
	 if(e.getSource()==btn1)
	    {
	        try {
	        	PreparedStatement Ps;
	            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","hNy_97movie");
//	            PreparedStatement Ps=connection.prepareStatement("insert into logintable values(?,?,?)");
//	            Ps.setString(1,tf1.getText());
	            PreparedStatement Pstatement=connection.prepareStatement("SELECT * FROM logintable where uname = ?;");
	            Pstatement.setString(1,tf1.getText());
//	            ResultSet flag =Pstatement.executeQuery();
	            	Ps=connection.prepareStatement("insert into logintable values(?,?,?)");
	 	            Ps.setString(2,tf1.getText());
	 	            Ps.setString(1,tf2.getText() );
	 	            Ps.setString(3,new String(p1.getPassword()));
	 	            Ps.executeUpdate();
	               JOptionPane.showMessageDialog(null,"Registration successfull"); 
	            }
	
	        catch (SQLException e1) {
                e1.printStackTrace();
            }
	    }
	 if(e.getSource() == resetButton)
     {
  	   tf1.setText("");
         tf2.setText("");
         p1.setText("");
     }
	            
 }
 public static void main(String[] args) {
  new registration();
 }
}
