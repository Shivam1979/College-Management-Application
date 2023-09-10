package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EnterMarks extends JFrame implements ActionListener {
    Choice choicerollno;
    JComboBox comboBox;
    JButton submit, cancel;

    JTextField sub1, sub2, sub3, sub4, sub5, mrk1, mrk2, mrk3, mrk4, mrk5;


    EnterMarks() {
        getContentPane().setBackground(new Color(252, 245, 210));
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/exam.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(500, 40, 400, 300);
        add(img);

        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(20, 0, 500, 50);
        heading.setFont(new Font("tahoma", Font.BOLD, 20));
        add(heading);


        JLabel rollno = new JLabel("Select Roll Number");
        rollno.setBounds(50, 70, 150, 20);
        add(rollno);


        choicerollno = new Choice();
        choicerollno.setBounds(200, 70, 150, 20);
        add(choicerollno);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM student");
            while (resultSet.next()) {
                choicerollno.add(resultSet.getString("rollno")); // add value in to choice
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel sem = new JLabel("Select Roll Number");
        sem.setBounds(50, 110, 150, 20);
        add(sem);

        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester"};
        comboBox = new JComboBox(semester);
        comboBox.setBounds(200, 110, 150, 20);
        comboBox.setBackground(Color.white);
        add(comboBox);

        JLabel entersub = new JLabel("Enter Subject");
        entersub.setBounds(100, 150, 200, 40);
        add(entersub);

        JLabel entermarks = new JLabel("Enter Marks");
        entermarks.setBounds(320, 150, 200, 40);
        add(entermarks);


        sub1 = new JTextField();
        sub1.setBounds(50, 200, 190, 20);
        add(sub1);

        sub2 = new JTextField();
        sub2.setBounds(50, 230, 190, 20);
        add(sub2);

        sub3 = new JTextField();
        sub3.setBounds(50, 260, 190, 20);
        add(sub3);

        sub4 = new JTextField();
        sub4.setBounds(50, 290, 190, 20);
        add(sub4);

        sub5 = new JTextField();
        sub5.setBounds(50, 320, 190, 20);
        add(sub5);


        //////////////////////////////// for marks ////////////////////////////////

        mrk1 = new JTextField();
        mrk1.setBounds(250, 200, 190, 20);
        add(mrk1);

        mrk2 = new JTextField();
        mrk2.setBounds(250, 230, 190, 20);
        add(mrk2);

        mrk3 = new JTextField();
        mrk3.setBounds(250, 260, 190, 20);
        add(mrk3);
        mrk4 = new JTextField();
        mrk4.setBounds(250, 290, 190, 20);
        add(mrk4);

        mrk5 = new JTextField();
        mrk5.setBounds(250, 320, 190, 20);
        add(mrk5);

        // button
        submit = new JButton("Submit");
        submit.setBounds(70, 360, 150, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);


        cancel = new JButton("Cancel");
        cancel.setBounds(270, 360, 150, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);



        setSize(1000, 500);
        setLayout(null);
        setLocation(300, 150);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
          try{
             conn c = new conn();
              String Q1 = "INSERT INTO subject VALUE('"+choicerollno.getSelectedItem()+"','"+comboBox.getSelectedItem()+"','"+sub1.getText()+"','"+sub2.getText()+"','"+sub3.getText()+"','"+sub4.getText()+"','"+sub5.getText()+"')";
              String Q2 = "INSERT INTO marks VALUE('"+choicerollno.getSelectedItem()+"','"+comboBox.getSelectedItem()+"','"+mrk1.getText()+"','"+mrk2.getText()+"','"+mrk3.getText()+"','"+mrk4.getText()+"','"+mrk5.getText()+"')";
              c.statement.executeUpdate(Q1);
              c.statement.executeUpdate(Q2);
              JOptionPane.showMessageDialog(null,"Marks Inserted Sucessfully");

          }catch (Exception E){
              E.printStackTrace();

          }


    }


    public static void main(String[] args) {
        new EnterMarks();
    }


}
