import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JTextField jroomno,jprice;
    JComboBox availablecombo,cleaningCombo,bedCombo;
    JButton room,cancel;
    AddRooms(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel roomno=new JLabel("Room Number");
        roomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        roomno.setBounds(60,80,120,30);
        add(roomno);

        jroomno=new JTextField();
        jroomno.setBounds(200,80,150,30);
        jroomno.setFont(new Font("Raleway",Font.PLAIN,14));
        add(jroomno);

        JLabel available=new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,16));
        available.setBounds(60,130,120,30);
        add(available);

        String availableOptions[]={"Available", "Occupied"};
        availablecombo=new JComboBox(availableOptions);
        availablecombo.setFont(new Font("Raleway",Font.PLAIN,14));
        availablecombo.setBackground(Color.WHITE);
        availablecombo.setBounds(200,130,150,30);
        add(availablecombo);

        JLabel cleaningStatus=new JLabel("Cleaning Status");
        cleaningStatus.setFont(new Font("Tahoma",Font.PLAIN,16));
        cleaningStatus.setBounds(60,180,120,30);
        add(cleaningStatus);

        String cleaningOptions[]={"Cleaned", "Dirty"};
        cleaningCombo=new JComboBox(cleaningOptions);
        cleaningCombo.setFont(new Font("Raleway",Font.PLAIN,14));
        cleaningCombo.setBackground(Color.WHITE);
        cleaningCombo.setBounds(200,180,150,30);
        add(cleaningCombo);

        JLabel bedtype=new JLabel("Bed Type");
        bedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
        bedtype.setBounds(60,230,120,30);
        add(bedtype);

        String bedOption[]={"Single Bed", "Double Bed"};
        bedCombo=new JComboBox(bedOption);
        bedCombo.setFont(new Font("Raleway",Font.PLAIN,14));
        bedCombo.setBackground(Color.WHITE);
        bedCombo.setBounds(200,230,150,30);
        add(bedCombo);

        JLabel price=new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        price.setBounds(60,280,120,30);
        add(price);

        jprice=new JTextField();
        jprice.setBounds(200,280,150,30);
        jprice.setFont(new Font("Raleway",Font.PLAIN,14));
        add(jprice);

        room=new JButton("Add Room");
        room.setBounds(60,350,130,30);
        room.setForeground(Color.WHITE);
        room.setBackground(Color.BLACK);
        room.addActionListener(this);
        add(room);

        cancel=new JButton("Cancel");
        cancel.setBounds(220,350,130,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\seventh.jpg");
        Image i1=imageIcon.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(400,30,500,300);
        add(image);



        setBounds(330,200,940,470);
        setVisible(true);
    }

        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==room) {
                String roomno = jroomno.getText();
                String price = jprice.getText();
                String available = (String) availablecombo.getSelectedItem();
                String cleaningStatus = (String) cleaningCombo.getSelectedItem();
                String bedtype = (String) bedCombo.getSelectedItem();

                try {
                    Con c = new Con();
                    String query = "insert into room values('" + roomno + "','" + price + "','" + available + "','" + cleaningStatus + "','" + bedtype + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Room added Successfully");
                } catch (Exception e) {
                    System.out.print(e);
                }
            }else{
                setVisible(false);
            }
        }
    public static void main(String[] args) {
        new AddRooms();
    }
}
