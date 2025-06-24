import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JTextField juser,jpass;
    JButton login,cancel;
    Login(){
        setLayout(null);
        setSize(600,300);
        getContentPane().setBackground(Color.WHITE);

        JLabel user =new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);

        juser=new JTextField();
        juser.setBounds(120,20,150,30);
        add(juser);

        JLabel pass =new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);

        jpass=new JTextField();
        jpass.setBounds(120,70,150,30);
        add(jpass);

        login=new JButton("LOGIN");
        login.setBounds(40,150,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel=new JButton("CANCEL");
        cancel.setBounds(150,150,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\second.jpg");
        Image i1=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(350,10,200,200);
        add(image);


        setLocation(400,250);
        setVisible(true);
    }

       public void actionPerformed(ActionEvent e){
            if(e.getSource()==login){


                try{
                    Con c=new Con();
                    String user=juser.getText();
                    String pass=jpass.getText();

                    String query="select * from login where username = '"+ user + "'and password = '" + pass +"'";
                    ResultSet rs=c.s.executeQuery(query);

                    if(rs.next()){
                        setVisible(false);
                        new DashBoard();
                    }else{
                        JOptionPane.showMessageDialog(null,"Invalid username or password");
                        setVisible(false);
                    }
                }catch(Exception ae){
                    System.out.print(ae);
                }
            }else if(e.getSource()==cancel){
                setVisible(false);
            }
       }
    public static void main(String[] args) {
        new Login();
    }
}
