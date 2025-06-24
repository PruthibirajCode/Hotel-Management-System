import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JTable table;
    JButton jButton,jButton1;
    JComboBox jbedtype;
    JCheckBox jCheckBox;
    SearchRoom(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("Search For Room");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel bedtype=new JLabel("Bed Type");
        bedtype.setFont(new Font("Raleway",Font.PLAIN,18));
        bedtype.setBounds(50,100,100,20);
        add(bedtype);

        String str[]={"Single Bed","Double Bed"};
        jbedtype=new JComboBox(str);
        jbedtype.setBackground(Color.WHITE);
        jbedtype.setBounds(150,100,100,20);
        add(jbedtype);

        jCheckBox=new JCheckBox("Only Display Available");
        jCheckBox.setBounds(650,100,150,30);
        jCheckBox.setBackground(Color.WHITE);
        add(jCheckBox);

        JLabel l1=new JLabel("Room Number");
        l1.setBounds(10,170,100,20);
        add(l1);

        JLabel l2=new JLabel("Price");
        l2.setBounds(220,170,100,20);
        add(l2);

        JLabel l3=new JLabel("Availibility");
        l3.setBounds(400,170,100,20);
        add(l3);

        JLabel l4=new JLabel("Cleaning_Status");
        l4.setBounds(600,170,100,20);
        add(l4);

        JLabel l5=new JLabel("Bed type");
        l5.setBounds(800,170,100,20);
        add(l5);

        table=new JTable();
        table.setBounds(0,200,1000,300);
        add(table);

        try{
            Con c=new Con();
            ResultSet rs =c.s.executeQuery("select * from room");
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
                String query1="select * from room where bedtype='"+jbedtype.getSelectedItem()+"'";
                String query2="select * from room where available ='Available' AND bedtype='"+jbedtype.getSelectedItem()+"'";
                Con c=new Con();
                ResultSet rs;
                if(jCheckBox.isSelected()){
                    rs=c.s.executeQuery(query2);
                }else{
                    rs=c.s.executeQuery(query1);
                }
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
        new SearchRoom();
    }
}


