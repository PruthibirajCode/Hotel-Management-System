import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivars extends JFrame implements ActionListener {
    JTextField jname,jage,jcompany,jmodel,jlocation;
    JRadioButton male,female;
    JComboBox availableCombo;
    JButton driver,cancel;
    AddDrivars(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading=new JLabel("Add Driver");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,10,200,20);
        add(heading);

        JLabel name=new JLabel("Name");
        name.setFont(new Font("Tahoma",Font.PLAIN,16));
        name.setBounds(60,70,120,30);
        add(name);

        jname=new JTextField();
        jname.setBounds(200,70,150,30);
        jname.setFont(new Font("Raleway",Font.PLAIN,14));
        add(jname);

        JLabel age=new JLabel("Age");
        age.setFont(new Font("Tahoma",Font.PLAIN,16));
        age.setBounds(60,110,120,30);
        add(age);

        jage=new JTextField();
        jage.setBounds(200,110,150,30);
        jage.setFont(new Font("Raleway",Font.PLAIN,14));
        add(jage);

        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Tahoma",Font.PLAIN,16));
        gender.setBounds(60,150,120,30);
        add(gender);

        male=new JRadioButton("MALE");
        male.setBounds(200,150,70,30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Raleway",Font.PLAIN,14));
        add(male);

        female=new JRadioButton("FEMALE");
        female.setBounds(270,150,100,30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Raleway",Font.PLAIN,14));
        add(female);

        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel company=new JLabel("Car Company");
        company.setFont(new Font("Tahoma",Font.PLAIN,16));
        company.setBounds(60,190,120,30);
        add(company);

        jcompany=new JTextField();
        jcompany.setBounds(200,190,150,30);
        jcompany.setFont(new Font("Raleway",Font.PLAIN,14));
        add(jcompany);

        JLabel model=new JLabel("Car Model");
        model.setFont(new Font("Tahoma",Font.PLAIN,16));
        model.setBounds(60,230,120,30);
        add(model);

        jmodel=new JTextField();
        jmodel.setBounds(200,230,150,30);
        jmodel.setFont(new Font("Raleway",Font.PLAIN,14));
        add(jmodel);

        JLabel available=new JLabel("Available");
        available.setFont(new Font("Tahoma",Font.PLAIN,16));
        available.setBounds(60,270,120,30);
        add(available);

        String availableOption[]={"Available", "Busy"};
        availableCombo=new JComboBox(availableOption);
        availableCombo.setFont(new Font("Raleway",Font.PLAIN,14));
        availableCombo.setBackground(Color.WHITE);
        availableCombo.setBounds(200,270,150,30);
        add(availableCombo);

        JLabel location=new JLabel("Location");
        location.setFont(new Font("Tahoma",Font.PLAIN,16));
        location.setBounds(60,310,310,30);
        add(location);

        jlocation=new JTextField();
        jlocation.setBounds(200,310,150,30);
        jlocation.setFont(new Font("Raleway",Font.PLAIN,14));
        add(jlocation);

        driver=new JButton("Add Driver");
        driver.setBounds(60,350,130,30);
        driver.setForeground(Color.WHITE);
        driver.setBackground(Color.BLACK);
        driver.addActionListener(this);
        add(driver);

        cancel=new JButton("Cancel");
        cancel.setBounds(220,350,130,30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\eleven.jpg");
        Image i1=imageIcon.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(400,30,500,300);
        add(image);



        setBounds(300,200,980,470);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==driver) {
            String name = jname.getText();
            String age = jage.getText();
            String gender=null;
            if(male.isSelected()){
                gender="MALE";
            }else if(female.isSelected()){
                gender="FEMALE";
            }
            String company = jcompany.getText();
            String model=jmodel.getText();
            String available = (String) availableCombo.getSelectedItem();
            String location=jlocation.getText();

            try {
                Con c = new Con();
                String query = "insert into driver values('" + name + "','" + age + "','" + gender + "','" + company + "','" + model + "','" + available + "','" + location + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Driver added Successfully");
            } catch (Exception e) {
                System.out.print(e);
            }
        }else{
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddDrivars();
    }
}
