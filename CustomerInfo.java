import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    CustomerInfo(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        JLabel l1=new JLabel("ID");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2=new JLabel("Number");
        l2.setBounds(150,10,100,20);
        add(l2);

        JLabel l3=new JLabel("Name");
        l3.setBounds(250,10,100,20);
        add(l3);

        JLabel l4=new JLabel("Gender");
        l4.setBounds(400,10,100,20);
        add(l4);

        JLabel l5=new JLabel("Country");
        l5.setBounds(500,10,100,20);
        add(l5);

        JLabel l6=new JLabel("Room no");
        l6.setBounds(630,10,100,20);
        add(l6);

        JLabel l7=new JLabel("Time");
        l7.setBounds(760,10,100,20);
        add(l7);

        JLabel l8=new JLabel("Deposit");
        l8.setBounds(900,10,100,20);
        add(l8);

        table=new JTable();
        table.setBounds(0,40,1000,400);
        add(table);

        try{
            Con c=new Con();
            ResultSet rs =c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.print(e);
        }

        back=new JButton("BACK");
        back.setBounds(420,500,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);


        setBounds(300,100,1000,600);
        setVisible(true);
    }

    public  void  actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args) {
        new CustomerInfo();
    }
}



