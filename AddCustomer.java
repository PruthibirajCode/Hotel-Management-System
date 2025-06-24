import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener {
    JTextField jnumber,jname,jcountry,jdeposite;
    JComboBox jid;
    JRadioButton male,female;
    Choice croom;
    JLabel checkin;
    JButton customer,back;
    AddCustomer(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setFont(new Font("Tahoma",Font.BOLD,24));
        text.setBounds(60,20,300,30);
        text.setForeground(Color.blue);
        add(text);

        JLabel id=new JLabel("ID");
        id.setFont(new Font("Raleway",Font.PLAIN,16));
        id.setBounds(20,70,100,30);
        add(id);

        String str[]={"Passport", "Aadhar Card", "Voter ID","Rasan Card","Driving Liesence","Other"};
        jid=new JComboBox(str);
        jid.setBounds(200,70,150,30);
        jid.setBackground(Color.WHITE);
        jid.setFont(new Font("Raleway",Font.PLAIN,14));
        add(jid);

        JLabel number=new JLabel("Number");
        number.setFont(new Font("Raleway",Font.PLAIN,16));
        number.setBounds(20,120,100,30);
        add(number);

        jnumber=new JTextField();
        jnumber.setFont(new Font("Raleway",Font.PLAIN,14));
        jnumber.setBounds(200,120,150,30);
        add(jnumber);

        JLabel name=new JLabel("Name");
        name.setFont(new Font("Raleway",Font.PLAIN,16));
        name.setBounds(20,170,100,30);
        add(name);

        jname=new JTextField();
        jname.setFont(new Font("Raleway",Font.PLAIN,14));
        jname.setBounds(200,170,150,30);
        add(jname);

        JLabel gender=new JLabel("GENDER");
        gender.setBounds(20,220,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);

        male=new JRadioButton("MALE");
        male.setBounds(200,220 ,70,30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Raleway",Font.PLAIN,14));
        add(male);

        female=new JRadioButton("FEMALE");
        female.setBounds(280,220 ,100,30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Raleway",Font.PLAIN,14));
        add(female);

        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel country=new JLabel("Country");
        country.setFont(new Font("Raleway",Font.PLAIN,16));
        country.setBounds(20,270,100,30);
        add(country);

        jcountry=new JTextField();
        jcountry.setFont(new Font("Raleway",Font.PLAIN,14));
        jcountry.setBounds(200,270,150,30);
        add(jcountry);

        JLabel roomNumber=new JLabel("Allocated Room Number");
        roomNumber.setFont(new Font("Raleway",Font.PLAIN,16));
        roomNumber.setBounds(20,320,180,30);
        add(roomNumber);

        croom=new Choice();

        try{
            Con c=new Con();
            String query="select * from  room where available = 'Available'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomno"));
            }
        }catch(Exception e){
            System.out.print(e);
        }
        croom.setBounds(200,325,150,40);
        add(croom);

        JLabel time=new JLabel("Check-in time");
        time.setFont(new Font("Raleway",Font.PLAIN,16));
        time.setBounds(20,370,180,30);
        add(time);

        Date date=new Date();

        checkin=new JLabel(""+date);
        checkin.setFont(new Font("Raleway",Font.PLAIN,14));
        checkin.setBounds(200,370,200,30);
        add(checkin);

        JLabel deposit=new JLabel("Deposit");
        deposit.setFont(new Font("Raleway",Font.PLAIN,16));
        deposit.setBounds(20,420,100,30);
        add(deposit);

        jdeposite=new JTextField();
        jdeposite.setFont(new Font("Raleway",Font.PLAIN,14));
        jdeposite.setBounds(200,420,150,30);
        add(jdeposite);

        customer=new JButton("Add Customer");
        customer.setBounds(40,500,150,30);
        customer.setFont(new Font("Raleway",Font.PLAIN,16));
        customer.setBackground(Color.BLACK);
        customer.setForeground(Color.WHITE);
        customer.addActionListener(this);
        add(customer);

        back=new JButton("Back");
        back.setBounds(200,500,150,30);
        back.setFont(new Font("Raleway",Font.PLAIN,16));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\fifth.png");
        Image i1=imageIcon.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(400,50,300,400);
        add(image);


        setBounds(350,100,800,600);
        setVisible(true);
    }

        public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==customer) {
            String id = (String) jid.getSelectedItem();
            String number = jnumber.getText();
            String name = jname.getText();
            String gender = null;
            if (male.isSelected()) {
                gender = "MALE";
            } else if (female.isSelected()) {
                gender = "FEMALE";
            }
            String country = jcountry.getText();
            String roomNumber = croom.getSelectedItem();
            String time = checkin.getText();
            String deposite=jdeposite.getText();

            try{
                Con c=new Con();
                String query1="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+roomNumber+"','"+time+"','"+deposite+"')";
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"Customer added successfully");
            }catch(Exception e){
                System.out.print(e);
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }



        }
    public static void main(String[] args) {
        new AddCustomer();
    }
}
