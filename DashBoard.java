import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoard extends JFrame implements ActionListener {
    DashBoard(){
        setLayout(null);
        setBounds(0,0,1550,1000);
        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\third.jpg");
        Image i1=imageIcon.getImage().getScaledInstance(1550,1000,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(0,0,1550,1000);
        add(image);

        JLabel text=new JLabel("THE TAJ GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,60);
        text.setFont(new Font("Tahoma",Font.PLAIN,50));
        text.setForeground(Color.WHITE);
        image.add(text);

        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1550,30);
        image.add(mb);

        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.red);
        mb.add(hotel);

        JMenuItem reception=new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);



        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.blue);
        mb.add(admin);

        JMenuItem addemployee=new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);

        JMenuItem addrooms=new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);

        JMenuItem adddriver=new JMenuItem("ADD DRIVER");
        adddriver.addActionListener(this);
        admin.add(adddriver);

        setVisible(true);
    }
       public void actionPerformed(ActionEvent e){
           if(e.getActionCommand().equals("ADD EMPLOYEE"))
           {
               new AddEmployee();
           }else if(e.getActionCommand().equals("ADD ROOMS")){
               new AddRooms();
           }else if(e.getActionCommand().equals("ADD DRIVER")){
               new AddDrivars();
           }else if(e.getActionCommand().equals("RECEPTION")){
               new Reception();
           }
       }
    public static void main(String[] args) {
        new DashBoard();
    }
}
