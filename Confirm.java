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

public class Confirm 
{
    private String name ;
    private String password;
    public Confirm(String name, String password)
    {
        this.name = name;
         this.password = password;
    }
         public boolean validate()
         {
             if("root".equals(name) &&"java".equals(password))
             {
                 return true;
             }
             else
             {
                 return false;
             }
         }
    
}
