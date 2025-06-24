import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Department(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1=new JLabel("Department");
        l1.setBounds(100,10,100,20);
        add(l1);

        JLabel l2=new JLabel("Budget");
        l2.setBounds(400,10,100,20);
        add(l2);


        table=new JTable();
        table.setBounds(0,50,700,350);
        add(table);

        try{
            Con c=new Con();
            ResultSet rs =c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.print(e);
        }

        back=new JButton("BACK");
        back.setBounds(280,400,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);


        setBounds(400,200,700,480);
        setVisible(true);
    }

    public  void  actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new Department();
    }
}

