import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Room(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\eight.jpg");
        Image i1=imageIcon.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(500,0,600,600);
        add(image);

        JLabel l1=new JLabel("Room Number");
        l1.setBounds(10,10,100,20);
        add(l1);

        JLabel l2=new JLabel("Price");
        l2.setBounds(120,10,100,20);
        add(l2);

        JLabel l3=new JLabel("Availibility");
        l3.setBounds(200,10,100,20);
        add(l3);

        JLabel l4=new JLabel("Cleaning_Status");
        l4.setBounds(300,10,100,20);
        add(l4);

        JLabel l5=new JLabel("bedtype");
        l5.setBounds(420,10,100,20);
        add(l5);

        table=new JTable();
        table.setBounds(0,40,500,400);
        add(table);

        try{
            Con c=new Con();
            ResultSet rs =c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.print(e);
        }

        back=new JButton("BACK");
        back.setBounds(200,500,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.addActionListener(this);
        add(back);


        setBounds(300,100,1050,600);
        setVisible(true);
    }

        public  void  actionPerformed(ActionEvent ae){
            setVisible(false);
            new Reception();
        }
    public static void main(String[] args) {
        new Room();
    }
}
