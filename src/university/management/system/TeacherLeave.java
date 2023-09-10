package university.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeave extends JFrame implements ActionListener {
    Choice choiceRollNo, choTime;
    JDateChooser selDate;
    JButton submit, cancel;

    TeacherLeave() {
        getContentPane().setBackground(new Color(210, 232, 252));
        JLabel heading = new JLabel("Apply Leave (Teacher)");
        heading.setBounds(40, 50, 300, 30);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 20));
        add(heading);


        JLabel RollNoSE = new JLabel("Search by Employee ID");
        RollNoSE.setBounds(60, 100, 200, 20);
        RollNoSE.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(RollNoSE);

        choiceRollNo = new Choice();
        choiceRollNo.setBounds(60, 130, 200, 20);
        add(choiceRollNo);

        try {
            conn c = new conn();
            ResultSet resultset = c.statement.executeQuery("SELECT * FROM teacher");
            while (resultset.next()) {
                choiceRollNo.add(resultset.getString("empId"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 180, 200, 20);
        lbldate.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(lbldate);

        selDate = new JDateChooser();
        selDate.setBounds(60, 210, 200, 25);
        add(selDate);


        JLabel time = new JLabel("Time Duration");
        time.setBounds(60, 260, 200, 20);
        time.setFont(new Font("TAHOMA", Font.PLAIN, 18));
        add(time);

        choTime = new Choice();
        choTime.setBounds(60, 290, 200, 20);
        choTime.add("Full Day");
        choTime.add("Half Day");
        add(choTime);

        submit = new JButton("Submit");
        submit.setBounds(60, 350, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);


        setSize(500, 550);
        setLocation(550, 100);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        TeacherLeave tl = new TeacherLeave();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            String empId = choiceRollNo.getSelectedItem();
            String date = ((JTextField) selDate.getDateEditor().getUiComponent()).getText();
            String time = choTime.getSelectedItem();

            String Q = " INSERT  INTO teacherleave VALUES('" + empId + "','" + date + "','"+time+"')";
            try {
                conn c = new conn();
                c.statement.executeUpdate(Q);
                JOptionPane.showMessageDialog(null, "Pending Confirmation");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();

            }
        } else {
            setVisible(false);
        }
    }
}
