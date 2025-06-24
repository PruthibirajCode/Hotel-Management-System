import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame implements ActionListener {
    Choice ccustomer;
    JTextField jroom,javailable,jstatus,jpaid,jpending;
    JButton check,update,back;
    UpdateRoom(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text=new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setBounds(90,20,250,30);
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
        room.setBounds(30,130,100,20);
        add(room);

        jroom=new JTextField();
        jroom.setBounds(200,130,150,20);
        add(jroom);

        JLabel name=new JLabel("Availability");
        name.setBounds(30,180,100,20);
        add(name);

        javailable=new JTextField();
        javailable.setBounds(200,180,150,20);
        add(javailable);

        JLabel checkin=new JLabel("Cleaning Status");
        checkin.setBounds(30,230,100,20);
        add(checkin);

        jstatus=new JTextField();
        jstatus.setBounds(200,230,150,20);
        add(jstatus);


        check=new JButton("Check");
        check.setBounds(30,300,100,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.setFont(new Font("Raleway",Font.PLAIN,18));
        check.addActionListener(this);
        add(check);

        update=new JButton("Update");
        update.setBounds(150,300,100,30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.setFont(new Font("Raleway",Font.PLAIN,18));
        update.addActionListener(this);
        add(update);

        back=new JButton("Back");
        back.setBounds(270,300,100,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Raleway",Font.PLAIN,18));
        back.addActionListener(this);
        add(back);


        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\seventh.jpg");
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

                }
                ResultSet rs2=c.s.executeQuery("select * from room where roomno = '"+jroom.getText()+"'");
                while(rs2.next()){
                   javailable.setText(rs2.getString("available"));
                   jstatus.setText(rs2.getString("cleaning_Status"));
                }
            }catch(Exception e){
                System.out.print(e);
            }
        }else if(ae.getSource()==update){
            String number=ccustomer.getSelectedItem();
            String room=jroom.getText();
            String name=javailable.getText();
            String checkin=jstatus.getText();


            try{
                Con c=new Con();
                c.s.executeUpdate("update room set available = '"+name+"', cleaning_Status = '"+checkin+"' where roomno = '"+room+"'");
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
        new UpdateRoom();
    }
}

