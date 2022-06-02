/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_SQL;

/**
 *
 * @author clone
 */
import java.awt.*; 
import java.awt.event.*;
import javax.swing. *;
import javax.swing. JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JButton; 
import javax.swing.JTextField; 
import javax.swing.JTable. *; 
import javax.swing.JOptionPane; 
import javax.swing.table.DefaultTableModel; 
import javax.swing. table.AbstractTableModel; 
import java.sql.*; 
import java.io.File; 
import java.io.FileWriter; 
import java.io.Writer; 
import java.io.*; 
import java.math.BigDecimal;

public class Base 
{
    private JLabel name = new JLabel("Username:");
    private JLabel password = new JLabel("Password:"); 
    private JButton login = new JButton("Login");
    private JFrame frame = new JFrame("Student Management System");
    private JButton reset = new JButton("Reset");
   
    
   
    
    
    private JLabel info = new JLabel("Username Login(root, java)");
    private JTextField nameText = new JTextField(10);
    private JPasswordField passText = new JPasswordField();
    
    public Base() throws Exception
    {
        Font fnt = new Font("Serief", Font. ITALIC + Font.BOLD, 12);
        info.setFont(fnt);
        
        login.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==login)
                {
                    String tname = nameText.getText();
                    String tpass = new String(passText.getPassword());
                    Confirm log = new Confirm(tname, tpass);
                    
                     if(log.validate())
                     {
                         try{
                             JOptionPane.showMessageDialog(null,"Password Correct,login to the system!", "Login Notification!", JOptionPane.INFORMATION_MESSAGE);
                             Thread.sleep(3000);
                             frame.dispose();
                             new GUInterface();
                         }catch(Exception ex)
                         {
                             ex.printStackTrace();
                         }
                     }
                     else
                     {
                         try{
                              JOptionPane.showMessageDialog(null,"Password Incorrect,Please enter agin!", "Login Notification!", JOptionPane.INFORMATION_MESSAGE);
                              frame.dispose();
                              new Base();
                         }catch(Exception ex){}
                     }
            }
        }
    });
    
        
        reset.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                if(e.getSource()==reset)
                {
                    nameText.setText("");
                    passText.setText("");
                    info.setText("User Login(root, java)");
                }
            }
        
         });
            
        
        frame.addWindowListener(new WindowAdapter()
        {
            public void windowclosing(WindowEvent e)
            {
                System.exit(1);
            }
        });
        frame.setBackground(Color.WHITE); 
        frame.setLocation(420,230);
        frame.setVisible(true);
        
        frame.setLayout(null);
        name.setBounds(5,5,60,20) ; 
  
        passText.setBounds (65,30,100,20); 
        login.setBounds (170,5,60,20) ; 
        reset.setBounds (170,30,60,20) ;
        password.setBounds(5,30,60,20) ; 
        info.setBounds(5,65,220,30); 
        nameText.setBounds(65,5,100,20) ;
       
        frame.add(info); 
        frame.add(nameText); 
        frame.add(passText);
        frame.add(login);
        frame.add(name);
        frame.add(password);
        frame.add(reset);
        frame.setSize(280,130);
        
        }
                
              
}
