import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Pickup extends JFrame implements ActionListener {
    JTable table;
    JButton jButton,jButton1;
    JComboBox jbedtype;
    Choice typeofcar;
    JCheckBox jCheckBox;
    Pickup(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel bedtype=new JLabel("Type of Car");
        bedtype.setFont(new Font("Raleway",Font.PLAIN,18));
        bedtype.setBounds(50,100,100,20);
        add(bedtype);

        typeofcar=new Choice();
        typeofcar.setBounds(150,100,200,25);
        add(typeofcar);

        try{
            Con c=new Con();
            ResultSet rs=c.s.executeQuery("select * from driver");
            while(rs.next()){
                typeofcar.add(rs.getString("car_model"));
            }
        }catch(Exception e){
            e.printStackTrace();;
        }


        JLabel l1=new JLabel("Name");
        l1.setBounds(10,170,100,20);
        add(l1);

        JLabel l2=new JLabel("Age");
        l2.setBounds(150,170,100,20);
        add(l2);

        JLabel l3=new JLabel("Gender");
        l3.setBounds(300,170,100,20);
        add(l3);

        JLabel l4=new JLabel("Company");
        l4.setBounds(450,170,100,20);
        add(l4);

        JLabel l5=new JLabel("Car_Model");
        l5.setBounds(600,170,100,20);
        add(l5);

        JLabel l6=new JLabel("Available");
        l6.setBounds(750,170,100,20);
        add(l6);

        JLabel l7=new JLabel("Location");
        l7.setBounds(900,170,100,20);
        add(l7);

        table=new JTable();
        table.setBounds(0,200,1000,300);
        add(table);

        try{
            Con c=new Con();
            ResultSet rs =c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            System.out.print(e);
        }

        jButton=new JButton("Submit");
        jButton.setBounds(300,520,100,30);
        jButton.setForeground(Color.WHITE);
        jButton.setBackground(Color.BLACK);
        jButton.addActionListener(this);
        add(jButton);

        jButton1=new JButton("Back");
        jButton1.setBounds(500,520,100,30);
        jButton1.setForeground(Color.WHITE);
        jButton1.setBackground(Color.BLACK);
        jButton1.addActionListener(this);
        add(jButton1);




        setBounds(300,100,1000,600);
        setVisible(true);
    }

    public  void  actionPerformed(ActionEvent ae){
        if(ae.getSource()==jButton){
            try{
                String query1="select * from driver where car_model='"+typeofcar.getSelectedItem()+"'";
                Con c=new Con();
                ResultSet rs;
                rs=c.s.executeQuery(query1);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {

        new Pickup();
    }
}



