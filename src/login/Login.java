package login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
public class Login extends JFrame implements ActionListener
{	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JFrame frame2,frame1;
JLabel label = new JLabel();
	JLabel l1 = new JLabel("Login Form");
	JLabel l2 = new JLabel("Username");
	 JLabel l3 = new JLabel("Password");
	 JTextField tf1 = new JTextField();
	  JPasswordField p1 = new JPasswordField();
	  JButton btn1 = new JButton("Login");
public Login()
 {
     createWindow();
     setLocationAndSize();
     addComponentsToFrame();
     actionEvent();
 }
public  void createWindow()
 {
	 frame2=new JFrame();
	 frame1=new JFrame();
     frame2.setTitle("Login Form");
     frame1.setTitle("Welcome");
     frame2.getContentPane().setBackground(Color.black);
     frame1.getContentPane().setBackground(Color.black);
     l1.setFont(new Font("Serif", Font.BOLD, 30));
     l2.setFont(new Font("Serif", Font.BOLD, 15));
     l3.setFont(new Font("Serif", Font.BOLD, 15));
     l1.setForeground(Color.white);
     label.setFont(new Font("Serif", Font.BOLD, 50));
     label.setForeground(Color.white);
     l2.setForeground(Color.white);
     l3.setForeground(Color.white);
     frame2.getContentPane().setLayout(null);
     frame2.setVisible(true);
     frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame2.setResizable(true);
	 
 }
public void setLocationAndSize()
{
	l1.setBounds(80,20,200,30);
	 l2.setBounds(80, 70, 200, 30);
	  l3.setBounds(80, 110, 200, 30);
	  tf1.setBounds(300, 70, 200, 30);
	  p1.setBounds(300, 110, 200, 30);
	  btn1.setBounds(150, 160, 100, 30);
}
public void addComponentsToFrame()
{
	 frame2.add(l1);
	  frame2.add(l2);
	  frame2.add(tf1);
	  frame2.add(l3);
	  frame2.add(p1);
	  frame2.add(btn1);
	  frame1.add(label);
	  frame2.setSize(600, 600);
	  frame2.setLayout(null);
	  frame2.setVisible(true);
}
public void actionEvent()
{
   btn1.addActionListener(this);
    btn1.addActionListener(this);
}


@SuppressWarnings("deprecation")
@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource()==btn1)
    {
        try {
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdatabase","root","hNy_97movie");
            PreparedStatement Pstatement=connection.prepareStatement("SELECT * FROM logintable where uname = ?;");

            Pstatement.setString(1,tf1.getText());
//          Pstatement.setString(2,p1.getPassword().toString());
            ResultSet flag =Pstatement.executeQuery();
            if(flag.next())
            {
            	if(flag.getString(3).equals(new String(p1.getPassword())))
            	{
//            		JOptionPane.showMessageDialog(null,"Welcome  "+flag.getString(2));  
            		frame2.setVisible(false);
            		frame1.setVisible(true);
            		frame1.setSize(600,600);
            		label.setBounds(100,10,300,40);
            		label.setText("Welcome "+flag.getString(2));
            	}else
            		JOptionPane.showMessageDialog(null,"Password Mismatch");  
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Email Not Found");
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

}
    public static void main(String[] args)
    {
        new Login();
    }

}