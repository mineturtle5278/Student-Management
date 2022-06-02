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

public class GUInterface extends AbstractTableModel implements ActionListener
{
    public static String title[]={"Student ID","Name","Math","Physic","English","Average Score","Overall Score"};
    public static Object inf[][]={{"","","","","","",""},
            {"","","","","","",""},{"","","","","","",""},
            {"","","","","","",""},{"","","","","","",""},
            {"","","","","","",""},{"","","","","","",""},
            {"","","","","","",""},{"","","","","","",""},
            {"","","","","","",""},{"","","","","","",""},
            {"","","","","","",""},{"","","","","","",""},
            {"","","","","","",""},{"","","","","","",""},
            {"","","","","","",""},{"","","","","","",""},
            {"","","","","","",""},{"","","","","","",""},
            {"","","","","","",""},{"","","","","","",""},
            {"","","","","","",""},{"","","","","","",""}};
    public static final String datd="com.mysql.jdbc.Driver";
    public static final String datu="jdbc: mysql://localhost:3306/student?characterEncoding=utf-8&serverTimezone=UTC"; 
    public static final String dname="root";
    public static final String dpass="skey"; 
    public static final String sql="Student ID, Name, Math,Physic, English, Average Score, Overall Score";
    JFrame f=new JFrame("Student Managment System");
    JButton adda=new JButton("Add");
    JButton delete=new JButton("Delete"); 
    JButton sort=new JButton("Sort");
    JButton save=new JButton("Save");
    JButton quit=new JButton("Quit");
   
    JButton display=new JButton("Display");
    JButton search=new JButton("Search");
    JButton modify=new JButton("Modify");
    Connection con=null;
    Statement sta=null;
    ResultSet rs=null;
    PrintStream ps=null;
    JTable tab=null;
    DefaultTableModel tabmo=null;
    
                            
    
    
    
    
    
    public GUInterface() throws Exception
    {
        Class. forName(datd); 
        con=DriverManager.getConnection(datu, dname, dpass);
        sta=con.createStatement(); 
        tabmo=new DefaultTableModel(inf, title);
        tab=new JTable(tabmo); 
        JScrollPane js=new JScrollPane(tab); 
        JPanel jp=new JPanel();
       
        jp.add(sort);
        jp.add(save);
        jp.add(quit);
        jp.add(display);
        jp.add(search);
        jp.add(modify); 
        jp.add(adda);
        jp.add(delete);
        f.setSize(700,500);
        f.setLocation (250,70); 
        f.setVisible(true);
        f.add(jp, BorderLayout. NORTH);
        f.add(js,BorderLayout.CENTER); 
        
       
        delete.addActionListener(this);
        sort.addActionListener(this);
        save. addActionListener(this); 
        quit.addActionListener(this);
         display.addActionListener(this);
        search.addActionListener(this); 
        modify.addActionListener(this); 
        adda.addActionListener(this);
    }
    
public int getColumnCount()
{
return title.length;
}
public int getRowCount()
{
return inf.length;
}
public Object getValueAt(int row, int col)
{
return inf[row][col];
}
public String getColumnName(int col)
{
return title[col];
}
public Class<?>getColumnClass(int col) 
{
return this.getValueAt(0,col).getClass();
}
public boolean isCellEditable(int row, int col) 
{
return false;
}
public void setValueAt(Object newv, int row, int col) 
{
this.inf[row][col]=newv;
    
}
    
public void actionPerformed(ActionEvent e)
{
     if(e.getSource()==display)
     {
         try{
             this.show(sql,0,"");
         }catch(Exception ex){}
     }
     if(e.getSource()==search)
     {
         try{
             f.dispose(); 
             new Search();
             if(tabmo.getValueAt(0,0).equals(""))
             {
                 JOptionPane.showMessageDialog(null,"Coundnt find Information from you searched, Please Enter Again!","Notification!", JOptionPane.INFORMATION_MESSAGE);
                 f.dispose();
                 new Search();
             }
                 
         }catch(Exception ex){}
     }
     
     
    if(e.getSource()==modify)
    {
        try{
            f.dispose();
            new Modify();
        }catch(Exception ex){}
    }
    
if(e.getSource()==adda)
    {
        try{
            f.dispose();
            new Adda();
        }catch(Exception ex){}
    }
    
    if(e.getSource()==delete)
    {
        try{
            f.dispose();
            new Delete();
        }catch(Exception ex){}
    }
    
    if(e.getSource()==sort)
    {
        try{
          JOptionPane.showMessageDialog(null,"Sort methhod can only sort the sequence of the database, it coundnt twick the information!","Notification!", JOptionPane.INFORMATION_MESSAGE);
          this.Sort();
        }catch(Exception ex){}
    }
    
    if(e.getSource()==save)
    {
        try{
          this.Save();
          JOptionPane.showMessageDialog(null,"Save Succeful!","Notification!", JOptionPane.INFORMATION_MESSAGE);
          
        }catch(Exception ex){}
    }
    
    if(e.getSource()==quit)
    {
        try{
            sta.close();
            con.close();
            System.exit(1);
        }catch(Exception ex){}
    }
}
    
public void show(String s, int p, String t)throws Exception
{
    if(p==0)
    {
        rs=sta.executeQuery(s);
    }
    else
    {
        sta.executeUpdate(t); 
        rs=sta.executeQuery(s);
    }
    int id0;
    String name0=null;
     float math0; 
     float physic0; 
     float english0; 
     float average0; 
     float overall0;
     int i=0;
     
     while(rs.next())
     {
         id0=rs.getInt("id");
         name0=rs.getString("name");
         math0=rs.getFloat("math");
         physic0=rs.getFloat("physic"); 
         english0=rs.getFloat("english");
         average0=toTwo(rs.getFloat("average"));
         overall0=rs.getFloat("overall"); 
         tabmo.setValueAt(id0,i,0);
         tabmo.setValueAt(name0,i,1);
         tabmo.setValueAt (math0, i,2);
         tabmo.setValueAt (physic0,i,3);
         tabmo.setValueAt(english0,i,4);
         tabmo.setValueAt(average0,i,5);
         tabmo.setValueAt(overall0,i,6);
         i+=1;
         if(i>=tabmo.getRowCount())
         {
             tabmo.addRow(new Object[]{});
         }
         
     }
     
}

public void Sort() throws Exception
{
    int id[ ]=new int[1000]; 
    String name[]=new String[1000]; 
    float math[]=new float[1000];
    float physic[]=new float[1000];
    float english[]=new float[1000];
    float average[ ]=new float[1000];
    float overall[ ]=new float[1000]; 
    int id_Sort; 
    String nametemp=null;
    float math_Sort;
    float physic_Sort;
    float english_Sort;
    float average_Sort;
    float overall_Sort;
    int num=0;
    rs=sta.executeQuery(sql);
    
    while(rs.next())
    {
        id[num]=rs.getInt("id");
        name[num]=rs.getString("name"); 
        math[num]=rs.getFloat("math");
        physic[num]=rs.getFloat("physic"); 
        english[num]=rs.getFloat("english");
        average[num]=toTwo(rs.getFloat("everage"));
        overall[num]=rs.getFloat("sum"); num+=1;
        
        for(int j=1;j<num;j++)
            for(int k=0;k<num-j;k++)
            if(overall[k]<overall[k+1])
            {
                id_Sort=id[k];
                id[k]=id[k+1];
                id[k+1]=id_Sort;
                
                nametemp=name[k];
                name[k]=name[k+1];
                name[k+1]=nametemp;
                
                math_Sort=math[k];
                math[k]=math[k+1];
                math[k+1]=math_Sort;
                
                physic_Sort=physic[k];
                physic[k]=physic[k+1];
                physic[k+1]=  physic_Sort;
                
                english_Sort=english[k];
                english[k]=english[k+1];
                english[k+1]=english_Sort;
                
                average_Sort=average[k];
                average[k]=average[k+1];
                average[k+1]=average_Sort;
                
                overall_Sort=overall[k];
                overall[k]=overall[k+1];
                overall[k+1]=overall_Sort;
    }
        
        
     for(int n=0; n<num;n++) 
     {
         tabmo.setValueAt(id[n], n, 0);
         tabmo.setValueAt(name[n], n, 0);
         tabmo.setValueAt(math[n], n, 2);
         tabmo.setValueAt(physic[n], n, 3);
         tabmo.setValueAt(english[n], n, 4);
         tabmo.setValueAt(average[n], n, 5);
         tabmo.setValueAt(overall[n], n, 6);
         if(n>=tabmo.getRowCount())
         {
             tabmo.addRow(new Object[]{});
         }
     }
}

public void Save()throws Exception
{
    String id1[ ]=new String[1000]; 
    String name1[]=new String[1000]; 
    String math1[]=new String[1000];
    String physic1[]=new String[1000];
    String english1[]=new String[1000];
    String average1[ ]=new String[1000];
    String overall1[ ]=new String[1000]; 
    int i=0;
    
    Writer out= new FileWriter(new File("d: "+File.separator+"Student.txt"));
    rs=sta.executeQuery(sql);
    while(rs.next())
    {
        id1[i]=rs.getString("id");
        name1[i]=rs.getString("name");
        math1[i]=rs.getString("math");
        physic1[i]=rs.getString("physic1");
        english1[i]=rs.getString("english");
        average1[i]=String.valueOf(toTwo(rs.getFloat("average")));
        overall1[i]=rs.getString("overall");
        i+=1;
        
    }
    for(int j=0;j<i;j++)
    {
    out.write(id1[j]+"\t\t");
    out.write(name1[j]+"\t\t");
    out.write(math1[j]+"\t\t");
    out.write(physic1[j]+"\t\t");
    out.write(english1[j]+"\t\t");
    out.write(average1[j]+"\t\t");
    out.write(overall1[j]);
    out.write("\r");
  
    }
     out.close();
}
    
    
public float toTwo(float f)
{
    BigDecimal b=new BigDecimal(f);
    float f1=b.setScale(2,BigDecimal.ROUND_HALF_UP).floatValue();
    return f1;
}

}
