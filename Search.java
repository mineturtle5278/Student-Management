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

class Search extends GUInterface
{
private JFrame jf=new JFrame("Search Student Information");
private JButton jb=new JButton("Search");
private JLabel j1=new JLabel("Please Enter Student ID or Name ");
private JTextField jt=new JTextField();
private String s=null;
private String sq=null;

public Search()throws Exception
{
    super();
    Font fo=new Font("Serief",Font.BOLD,12);
    j1.setFont(fo);
    jt.setBounds(15,15,150,30);
    jb.setBounds(175,15,60,30);
    j1.setBounds(10,80,180,30);
    jf.add(jt);
    jf.add(jb);
    jf.add(j1);
    jf.setSize(300,170);
    jf.setLocation(300,250);
    jf.setVisible(true);
    jb.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e){
        if(e.getSource()==jb){
        if(jt.getText().trim().equals(""))
        {
        JOptionPane.showMessageDialog(null,"Input cannot be Empty,please enter again","Error Notification!",JOptionPane.INFORMATION_MESSAGE);
        f.dispose();
        jf.dispose();
        
        try{
        new Search();
        }catch(Exception ex){}
    }else
        {
            s=jt.getText().trim();
            try{
            int t=Integer.parseInt(jt.getText().trim());
            if(t<=0)
            {
                JOptionPane.showMessageDialog(null,"Input cannot be 0 or negative, please enter again!","Error Notification!",JOptionPane.INFORMATION_MESSAGE);
                f.dispose();
                jf.dispose();
            try{
                new Search();
                }catch(Exception ex){}
            }
            else
            {
                sq="select id,name,math,physic,english,average,overall from studnet where id like '%"+t+"%'";
                jf.dispose();
                try{
                    show(sq,0,"");

                }catch(Exception ex){}
            }
            
}catch(Exception ex){
sq="select id,name,math,physic,english,average,overall from studnet where id like '%"+s+"%'";
jf.dispose();
try{
        show(sq,0,"");
        }catch(Exception ex1){}
}
}
}
}
});
}
}
