import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Checkout extends JFrame implements ActionListener {
    Choice ccustomer;
    JLabel room,ctime,couttime;
    JButton checkout,back;
    Checkout(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading=new JLabel("Check Out");
        heading.setBounds(100,20,100,30);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma",Font.ITALIC,20));
        add(heading);

        JLabel id=new JLabel("Id");
        id.setBounds(30,80,100,30);
        add(id);

        ccustomer=new Choice();
        ccustomer.setBounds(150,80,120,30);
        add(ccustomer);


        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\tick.png");
        Image i1=imageIcon.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(310,80,20,20);
        add(image);

        JLabel roomNumber=new JLabel("Room Number");
        roomNumber.setBounds(30,130,100,30);
        add(roomNumber);

        room=new JLabel();
        room.setBounds(150,130,100,30);
        add(room);

        JLabel checkintime=new JLabel("Check in Time");
        checkintime.setBounds(30,180,100,30);
        add(checkintime);

        ctime=new JLabel();
        ctime.setBounds(150,180,100,30);
        add(ctime);

        JLabel checkouttime=new JLabel("Check out Time");
        checkouttime.setBounds(30,230,100,30);
        add(checkouttime);

        Date date=new Date();
        couttime=new JLabel(""+date);
        couttime.setBounds(150,230,150,30);
        add(couttime);

        checkout=new JButton("Checkout");
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);

        back=new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back);

        try{
            Con c=new Con();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
                room.setText(rs.getString("room_number"));
                ctime.setText(rs.getString("time"));
            }
        }catch(Exception e){
            e.printStackTrace();

        }

        ImageIcon imageIcon2=new ImageIcon("C:\\Users\\Dell\\Downloads\\sixth.jpg");
        Image i2=imageIcon2.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon3=new ImageIcon(i2);
        JLabel image1=new JLabel(imageIcon3);
        image1.setBounds(350,50,400,250);
        add(image1);

        setBounds(300,200,800,400);
        setVisible(true);
    }

        public  void  actionPerformed(ActionEvent ae){
            if(ae.getSource()==checkout){
                String query1="delete from customer where number = '"+ccustomer.getSelectedItem()+"'";
                String query2="update room set available = 'Available' where roomno = '"+room.getText()+"'";

                try{
                    Con c=new Con();
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Checkout done");
                    setVisible(false);
                    new Reception();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                setVisible(false);
                new Reception();
            }
        }

    public static void main(String[] args) {
        new Checkout();
    }
}
