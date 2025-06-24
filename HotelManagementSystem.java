import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {
    JButton next;
    HotelManagementSystem(){
        setLayout(null);
        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\first.jpg");
        Image i1=imageIcon.getImage().getScaledInstance(1366,565,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(0,0,1366,565);
        add(image);

        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Serif",Font.PLAIN,50));
        image.add(text);

        next=new JButton("NEXT");
        next.setBounds(1150,450,150,50);
        next.setFont(new Font("Raleway",Font.BOLD,18));
        next.setForeground(Color.MAGENTA);
        next.setBackground(Color.WHITE);
        next.addActionListener(this);
        image.add(next);

        setSize(1366,565);
        setLocation(100,100);
        setVisible(true);

        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Login().setVisible(true);
    }
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}
