package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.jar.JarFile;

public class AddStudent extends JFrame implements ActionListener {
    JTextField textName, textFather, textAdress, textPhone, textEmail, textM10, textM12, textuid;
    JLabel empText;
    JDateChooser cdob;
    JComboBox courseBox, departmentBox;
    JButton submit, cancel;

    Random ran = new Random();
    long f4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    AddStudent(){

        getContentPane().setBackground(new Color(128,176,255));
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
//Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        textName = new JTextField();
        textName.setBounds(200, 150, 150, 30);
        add(textName);
//FName
        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        textFather = new JTextField();
        textFather.setBounds(600, 150, 150, 30);
        add(textFather);
//EMP_Id
        JLabel empId = new JLabel("Roll No.");
        empId.setBounds(50, 200, 200, 30);
        empId.setFont(new Font("serif", Font.BOLD, 20));
        add(empId);

        empText = new JLabel("0133XY" + f4);
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("serif", Font.BOLD, 20));
        add(empText);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);

        cdob = new JDateChooser();
        cdob.setBounds(600, 200, 150, 30);
        add(cdob);


        JLabel adress = new JLabel("Address");
        adress.setBounds(50, 250, 200, 30);
        adress.setFont(new Font("serif", Font.BOLD, 20));
        add(adress);


        textAdress = new JTextField();
        textAdress.setBounds(200, 250, 150, 30);
        add(textAdress);

//Phone number
        JLabel phone = new JLabel("Phone");
        phone.setBounds(400, 250, 200, 30);
        phone.setFont(new Font("serif", Font.BOLD, 20));
        add(phone);

        textPhone = new JTextField();
        textPhone.setBounds(600, 250, 150, 30);
        add(textPhone);


        //Email
        JLabel email = new JLabel("Email");
        email.setBounds(50, 300, 200, 30);
        email.setFont(new Font("serif", Font.BOLD, 20));
        add(email);
        textEmail = new JTextField();
        textEmail.setBounds(200, 300, 150, 30);
        add(textEmail);
        //M10
        JLabel m10 = new JLabel("Class X (%)");
        m10.setBounds(400, 300, 200, 30);
        m10.setFont(new Font("serif", Font.BOLD, 20));
        add(m10);
        textM10 = new JTextField();
        textM10.setBounds(600, 300, 150, 30);
        add(textM10);
        //M12
        JLabel m12 = new JLabel("Class XII (%)");
        m12.setBounds(50, 350, 200, 30);
        m12.setFont(new Font("serif", Font.BOLD, 20));
        add(m12);
        textM12 = new JTextField();
        textM12.setBounds(200, 350, 150, 30);
        add(textM12);

        //UID
        JLabel AadharNo = new JLabel("Aadhar Number");
        AadharNo.setBounds(400, 350, 200, 30);
        AadharNo.setFont(new Font("serif", Font.BOLD, 20));
        add(AadharNo);
        textuid = new JTextField();
        textuid.setBounds(600, 350, 150, 30);
        add(textuid);

        //Qualifications
        JLabel qualifications = new JLabel("Course");
        qualifications.setBounds(50, 400, 200, 30);
        qualifications.setFont(new Font("serif", Font.BOLD, 20));
        add(qualifications);

        String course[] = {"B.Tech", "BBA", "BCA", "MSC", "BSC", "MCA", "MA", "BA"};
        courseBox = new JComboBox(course);
        courseBox.setBounds(200, 400, 150, 30);
        courseBox.setBackground(Color.white);
        add(courseBox);

        //Department


        JLabel department = new JLabel("Branch");
        department.setBounds(400, 400, 200, 30);
        department.setFont(new Font("serif", Font.BOLD, 20));
        add(department);

        String Department[] = {"Electronics & Commun. ", "Information Technology", "Computer Science", "Mechnical ", "Civil", "Electrical  & Electronics"};
        departmentBox = new JComboBox(Department);
        departmentBox.setBounds(600, 400, 150, 30);
        departmentBox.setBackground(Color.white);
        add(departmentBox);

        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900, 700);
        setLocation(350, 50);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String name = textName.getText(); // store thr textName in name by the help of getText();
            String fname = textFather.getText();
            String empID = empText.getText();
            String dob = ((JTextField) cdob.getDateEditor().getUiComponent()).getText();
            String address = textAdress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String x = textM10.getText();
            String xii = textM12.getText();
            String uid = textuid.getText();
            String course = (String) courseBox.getSelectedItem();
            String department = (String) departmentBox.getSelectedItem();

            try {

                String q = "INSERT INTO student VALUES ('" + name + "','" + fname + "','" + empID + "','" + dob + "','" + address + "','" + phone + "','" + email + "','" + x + "','" + xii + "','" + uid + "','" + course + "','" + department + "')";
                conn c = new conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Submitted Succesfully ");
                System.out.println("Student table me submit ho gya "); // console output
            } catch (Exception E) {
                E.printStackTrace();

            }
        } else { // cancel
            setVisible(false);

        }
    }
    public static void main(String[] args) {
        new AddStudent();
    }


}
