import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Reception extends JFrame implements ActionListener {
    JButton form,rooms,department,employees,customerInfo,managerInfo,checkout,status,roomStatus,pickupService,searchRoom,logout;
    Reception(){
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        form=new JButton("New Customer Form");
        form.setBounds(20,30,200,30);
        form.setBackground(Color.black);
        form.setForeground(Color.white);
        form.addActionListener(this);
        form.setFont(new Font("Raleway",Font.PLAIN,16));
        add(form);


        rooms=new JButton("Rooms");
        rooms.setBounds(20,70,200,30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        rooms.setFont(new Font("Raleway",Font.PLAIN,16));
        add(rooms);

        department=new JButton("Department");
        department.setBounds(20,110,200,30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.addActionListener(this);
        department.setFont(new Font("Raleway",Font.PLAIN,16));
        add(department);

        employees=new JButton("All Employees");
        employees.setBounds(20,150,200,30);
        employees.setBackground(Color.black);
        employees.setForeground(Color.white);
        employees.addActionListener(this);
        employees.setFont(new Font("Raleway",Font.PLAIN,16));
        add(employees);

        customerInfo=new JButton("Customer Info");
        customerInfo.setBounds(20,190,200,30);
        customerInfo.setBackground(Color.black);
        customerInfo.setForeground(Color.white);
        customerInfo.addActionListener(this);
        customerInfo.setFont(new Font("Raleway",Font.PLAIN,16));
        add(customerInfo);

        managerInfo=new JButton("Manager Info");
        managerInfo.setBounds(20,230,200,30);
        managerInfo.setBackground(Color.black);
        managerInfo.setForeground(Color.white);
        managerInfo.addActionListener(this);
        managerInfo.setFont(new Font("Raleway",Font.PLAIN,16));
        add(managerInfo);

        checkout=new JButton("Checkout");
        checkout.setBounds(20,270,200,30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        checkout.setFont(new Font("Raleway",Font.PLAIN,16));
        add(checkout);

        status=new JButton("Update Status");
        status.setBounds(20,310,200,30);
        status.setBackground(Color.black);
        status.setForeground(Color.white);
        status.addActionListener(this);
        status.setFont(new Font("Raleway",Font.PLAIN,16));
        add(status);

        roomStatus=new JButton("Update Room Status");
        roomStatus.setBounds(20,350,200,30);
        roomStatus.setBackground(Color.black);
        roomStatus.setForeground(Color.white);
        roomStatus.addActionListener(this);
        roomStatus.setFont(new Font("Raleway",Font.PLAIN,16));
        add(roomStatus);

        pickupService=new JButton("Pickup Service");
        pickupService.setBounds(20,390,200,30);
        pickupService.setBackground(Color.black);
        pickupService.setForeground(Color.white);
        pickupService.addActionListener(this);
        pickupService.setFont(new Font("Raleway",Font.PLAIN,16));
        add(pickupService);

        searchRoom=new JButton("Search Room");
        searchRoom.setBounds(20,430,200,30);
        searchRoom.setBackground(Color.black);
        searchRoom.setForeground(Color.white);
        searchRoom.addActionListener(this);
        searchRoom.setFont(new Font("Raleway",Font.PLAIN,16));
        add(searchRoom);

        logout=new JButton("Logout");
        logout.setBounds(20,470,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        logout.setFont(new Font("Raleway",Font.PLAIN,16));
        add(logout);

        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Dell\\Downloads\\fourth.jpg");
        Image i1=imageIcon.getImage().getScaledInstance(550,470,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel image=new JLabel(imageIcon1);
        image.setBounds(250,30,550,470);
        add(image);

        setBounds(350,100,800,600);
        setVisible(true);
    }

        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==form){
                setVisible(false);
                new AddCustomer();
            }else if(ae.getSource()==rooms){
                setVisible(false);
                new Room();
            }else if(ae.getSource()==department){
                setVisible(false);
                new Department();
            }else if(ae.getSource()==employees){
                setVisible(false);
                new EmployeeInfo();
            }else if(ae.getSource()==managerInfo){
                setVisible(false);
                new ManagerInfo();
            }else if(ae.getSource()==customerInfo){
                setVisible(false);
                new CustomerInfo();
            }else if(ae.getSource()==searchRoom){
                setVisible(false);
                new SearchRoom();
            }else if(ae.getSource()==status){
                setVisible(false);
                new UpdateCheck();
            }else if(ae.getSource()==roomStatus){
                setVisible(false);
                new UpdateRoom();
            }else if(ae.getSource()==pickupService){
                setVisible(false);
                new Pickup();
            }else if(ae.getSource()==checkout){
                setVisible(false);
                new Checkout();
            }else if(ae.getSource()==logout){
                setVisible(false);
                System.exit(0);
            }
        }
    public static void main(String[] args) {
        new Reception();
    }
}
