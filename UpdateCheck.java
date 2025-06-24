import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField jroom,jname,jcheckin,jpaid,jpending;
    JButton check,update,back;
    UpdateCheck(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
        text.setForeground(Color.BLUE);
        add(text);

        JLabel cid=new JLabel("Customer Id");
        cid.setBounds(30,80,100,20);
        add(cid);

        ccustomer=new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);

        try{
            Con c=new Con();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();

        }

        JLabel room=new JLabel("Room Number");
        room.setBounds(30,120,100,20);
        add(room);

        jroom=new JTextField();
        jroom.setBounds(200,120,150,20);
        add(jroom);

        JLabel name=new JLabel("Name");
        name.setBounds(30,160,100,20);
        add(name);

        jname=new JTextField();
        jname.setBounds(200,160,150,20);
        add(jname);

        JLabel checkin=new JLabel("Checkin Time");
        checkin.setBounds(30,200,100,20);
        add(checkin);

        jcheckin=new JTextField();
        jcheckin.setBounds(200,200,150,20);
        add(jcheckin);

        JLabel paid=new JLabel("Amount Paid");
        paid.setBounds(30,240,100,20);
        add(paid);

        jpaid=new JTextField();
        jpaid.setBounds(200,240,150,20);
        add(jpaid);

        JLabel pending=new JLabel("Pending Amount");
        pending.setBounds(30,280,100,20);
        add(pending);

        jpending=new JTextField();
        jpending.setBounds(200,280,150,20);
        add(jpending);

        check=new JButton("Check");
        check.setBounds(30,350,100,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setFont(new Font("Raleway",Font.PLAIN,18));
        check.addActionListener(this);
        add(check);

        update=new JButton("Update");
        update.setBounds(150,350,100,30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setFont(new Font("Raleway",Font.PLAIN,18));
        update.addActionListener(this);
        add(update);

        back=new JButton("Back");
        back.setBounds(270,350,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Raleway",Font.PLAIN,18));
        back.addActionListener(this);
        add(back);


        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\nine.jpg");
        Image i1=imageIcon.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(400,50,500,300);
        add(image);


        setBounds(300,200,980,500);
        setVisible(true);
    }

        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==check){
                String id=ccustomer.getSelectedItem();
                String query="select * from customer where number = '"+id+"'";

                try{
                    Con c=new Con();
                    ResultSet rs=c.s.executeQuery(query);

                    while(rs.next()){
                        jroom.setText(rs.getString("room_number"));
                        jname.setText(rs.getString("name"));
                        jcheckin.setText(rs.getString("time"));
                        jpaid.setText(rs.getString("deposite"));
                    }
                    ResultSet rs2=c.s.executeQuery("select * from room where roomno = '"+jroom.getText()+"'");
                    while(rs2.next()){
                        String price=rs2.getString("price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(jpaid.getText());
                        jpending.setText(""+ amountPaid);
                    }
                }catch(Exception e){
                    System.out.print(e);
                }
            }else if(ae.getSource()==update){
                String number=ccustomer.getSelectedItem();
                String room=jroom.getText();
                String name=jname.getText();
                String checkin=jcheckin.getText();
                String paid=jpaid.getText();

                try{
                    Con c=new Con();
                    c.s.executeUpdate("update customer set room_number = '"+room+"', name = '"+name+"', time = '"+checkin+"', deposite = '"+paid+"' where number='"+number+"'");
                    JOptionPane.showMessageDialog(null,"Data Updated Successfully");

                    setVisible(false);
                    new Reception();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                setVisible(false);
                new Reception();
            }
        }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}
