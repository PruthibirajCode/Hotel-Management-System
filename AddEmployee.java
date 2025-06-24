import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField jname,jage,jsalary,jphone,jemail,jaadhar;
    JRadioButton male,female;
    JButton submit;
    JComboBox jjob;
    AddEmployee(){
        setLayout(null);
        setBounds(350,200,850,540);
        getContentPane().setBackground(Color.WHITE);

        JLabel name=new JLabel("NAME");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(name);

        jname=new JTextField();
        jname.setBounds(200,30,150,30);
        jname.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(jname);

        JLabel age=new JLabel("AGE");
        age.setBounds(60,80,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(age);

        jage=new JTextField();
        jage.setBounds(200,80,150,30);
        jage.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(jage);

        JLabel gender=new JLabel("GENDER");
        gender.setBounds(60,130,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);

        male=new JRadioButton("MALE");
        male.setBounds(200,130 ,70,30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Raleway",Font.PLAIN,14));
        add(male);

        female=new JRadioButton("FEMALE");
        female.setBounds(280,130 ,100,30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Raleway",Font.PLAIN,14));
        add(female);

        ButtonGroup bg=new ButtonGroup();
        bg.add(male);
        bg.add(female);

        JLabel job=new JLabel("JOB");
        job.setBounds(60,180,120,30);
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(job);

        String str[]={"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waitress", "Manager", "Accountant"};
        jjob=new JComboBox(str);
        jjob.setBounds(200,180,150,30);
        jjob.setBackground(Color.WHITE);
        add(jjob);

        JLabel salary=new JLabel("SALARY");
        salary.setBounds(60,230 ,120,30);
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(salary);

        jsalary=new JTextField();
        jsalary.setBounds(200,230,150,30);
        jsalary.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(jsalary);

        JLabel phone=new JLabel("PHONE");
        phone.setBounds(60,280 ,120,30);
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(phone);

        jphone=new JTextField();
        jphone.setBounds(200,280,150,30);
        jphone.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(jphone);

        JLabel email=new JLabel("EMAIL");
        email.setBounds(60,330 ,120,30);
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(email);

        jemail=new JTextField();
        jemail.setBounds(200,330,150,30);
        jemail.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(jemail);

        JLabel aadhar=new JLabel("AADHAR");
        aadhar.setBounds(60,380 ,120,30);
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(aadhar);

        jaadhar=new JTextField();
        jaadhar.setBounds(200,380,150,30);
        jaadhar.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(jaadhar);

        submit=new JButton("SUBMIT");
        submit.setBounds(200,430,150,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);



        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\tenth.jpg");
        Image i1=imageIcon.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(380,60,450,370);
        add(image);
        setVisible(true);
    }

        public void actionPerformed(ActionEvent e){
            String name=jname.getText();
            String age=jage.getText();
            String salary=jsalary.getText();
            String phone=jphone.getText();
            String email=jemail.getText();
            String aadhar=jaadhar.getText();

            String gender=null;
            if(male.isSelected()){
                gender="MALE";
            }else if(female.isSelected()){
                gender="FEMALE";
            }
            String job=(String) jjob.getSelectedItem();

            try{
                Con c=new Con();
                String query="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee added successfully");

                setVisible(false);

            }catch(Exception ae){
                System.out.print(ae);
            }
        }
    public static void main(String[] args) {
        new AddEmployee();
    }
}
