package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class UpdateTeacher extends JFrame implements ActionListener {

    JTextField textAdress, textPhone, textEmail, textuid, textcourse, textbranch;
    JLabel empText;
    JButton submit, cancel;
    Choice cEMPID;


    UpdateTeacher() {
        getContentPane().setBackground(new Color(230, 210, 252));
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50, 10, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 35));
        add(heading);

        //EmpId
        JLabel empID = new JLabel("Select Employee ID ");
        empID.setBounds(50, 100, 200, 20);
        empID.setFont(new Font("serif", Font.BOLD, 20));
        add(empID);

        cEMPID = new Choice();
        cEMPID.setBounds(250, 100, 200, 20);
        add(cEMPID);


        try {
            conn c = new conn();
            ResultSet rs = c.statement.executeQuery("SELECT * FROM teacher");
            while (rs.next()) {
                cEMPID.add(rs.getString("empId"));
            }

        } catch (Exception E) {
            E.printStackTrace();
        }
        //Name
        JLabel name = new JLabel("Name");
        name.setBounds(50, 150, 100, 30);
        name.setFont(new Font("serif", Font.BOLD, 20));
        add(name);

        JLabel textName = new JLabel();
        textName.setBounds(200, 150, 150, 30);
        add(textName);
//FName
        JLabel fname = new JLabel("Father Name");
        fname.setBounds(400, 150, 200, 30);
        fname.setFont(new Font("serif", Font.BOLD, 20));
        add(fname);

        JLabel textFather = new JLabel();
        textFather.setBounds(600, 150, 150, 30);
        add(textFather);
//EMP_Id
        JLabel EMPID = new JLabel(" Employee ID");
        EMPID.setBounds(50, 200, 200, 30);
        EMPID.setFont(new Font("serif", Font.BOLD, 20));
        add(EMPID);

       empText = new JLabel();
        empText.setBounds(200, 200, 150, 30);
        empText.setFont(new Font("serif", Font.BOLD, 20));
        add(empText);

        JLabel dob = new JLabel("Date of Birth");
        dob.setBounds(400, 200, 200, 30);
        dob.setFont(new Font("serif", Font.BOLD, 20));
        add(dob);


        JLabel dobdob = new JLabel();
        dobdob.setBounds(600, 200, 150, 30);
        add(dobdob);


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


        JLabel textM10 = new JLabel();
        textM10.setBounds(600, 300, 150, 30);
        add(textM10);
        //M12
        JLabel m12 = new JLabel("Class XII (%)");
        m12.setBounds(50, 350, 200, 30);
        m12.setFont(new Font("serif", Font.BOLD, 20));
        add(m12);


        JLabel textM12 = new JLabel();
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
        JLabel qualifications = new JLabel("Qualification");
        qualifications.setBounds(50, 400, 200, 30);
        qualifications.setFont(new Font("serif", Font.BOLD, 20));
        add(qualifications);

        textcourse = new JTextField();
        textcourse.setBounds(200, 400, 150, 30);
        add(textcourse);


        //Department


        JLabel department = new JLabel("Department");
        department.setBounds(400, 400, 200, 30);
        department.setFont(new Font("serif", Font.BOLD, 20));
        add(department);


        textbranch = new JTextField();
        textbranch.setBounds(600, 400, 150, 30);
        add(textbranch);

        // to take a data
        try {
            conn c = new conn();
            String query = "SELECT * FROM teacher WHERE empID = '" + cEMPID.getSelectedItem() + "'";
            ResultSet resultSet = c.statement.executeQuery(query);

            while (resultSet.next()) {
                textName.setText(resultSet.getString("name"));
                textFather.setText(resultSet.getString("fname"));
                dobdob.setText(resultSet.getString("dob"));
                textAdress.setText(resultSet.getString("address"));
                textPhone.setText(resultSet.getString("phone"));
                textEmail.setText(resultSet.getString("email"));
                textM10.setText(resultSet.getString("class_x"));
                textM12.setText(resultSet.getString("class_xii"));
                textuid.setText(resultSet.getString("aadhar"));
                empID.setText(resultSet.getString("empID"));
                textcourse.setText(resultSet.getString("education"));
                textbranch.setText(resultSet.getString("department"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        cEMPID.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    conn c = new conn();
                    String query = "SELECT * FROM teacher WHERE empID = '" + cEMPID.getSelectedItem() + "'";
                    ResultSet resultSet = c.statement.executeQuery(query);

                    while (resultSet.next()) {
                        textName.setText(resultSet.getString("name"));
                        textFather.setText(resultSet.getString("fname"));
                        dobdob.setText(resultSet.getString("dob"));
                        textAdress.setText(resultSet.getString("address"));
                        textPhone.setText(resultSet.getString("phone"));
                        textEmail.setText(resultSet.getString("email"));
                        textM10.setText(resultSet.getString("class_x"));
                        textM12.setText(resultSet.getString("class_xii"));
                        textuid.setText(resultSet.getString("aadhar"));
                        empID.setText(resultSet.getString("empID"));
                        textcourse.setText(resultSet.getString("education"));
                        textbranch.setText(resultSet.getString("department"));
                    }

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });


        submit = new JButton("Update");
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
            String empid = empText.getText();
            String address = textAdress.getText();
            String phone = textPhone.getText();
            String email = textEmail.getText();
            String course = textcourse.getText();
            String branch = textbranch.getText();

            try {
                String Q = "UPDATE teacher SET address = '" + address + "', phone = '" + phone + "' , email = '" + email + "' , course = '" + course + "' , branch = '" + branch + "' WHERE rollno = '"+empid+"' ";
                conn c = new conn();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null,"Details Updated");
            } catch (Exception E) {
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }


    }

    public static void main(String[] args) {
        new UpdateTeacher();
    }
}
