package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class TeacherLeaveDetails extends JFrame implements ActionListener {

    Choice choiceEmpId;
    JTable table;
    JButton search, cancel, print;

    TeacherLeaveDetails() {
        getContentPane().setBackground(new Color(250, 172, 206));
        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20, 20, 150, 20);
        add(heading);

        choiceEmpId = new Choice();
        choiceEmpId.setBounds(180, 20, 150, 20);
        add(choiceEmpId);

// for Employee ID

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM teacher");
            while (resultSet.next()) {
                choiceEmpId.add(resultSet.getString("empId"));
            }


        } catch (Exception E) {
            E.printStackTrace();
        }
// table
        table = new JTable();
        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT  * FROM  teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception E) {
            E.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 100, 900, 600);
        add(scrollPane);

        //search Button
        search = new JButton("Search");
        search.setBounds(20, 70, 80, 20);
        search.addActionListener(this);
        add(search);
        //print Button
        print = new JButton("Print");
        print.setBounds(120, 70, 80, 20);
        print.addActionListener(this);
        add(print);
        //cancel Button
        cancel = new JButton("Cancel");
        cancel.setBounds(220, 70, 80, 20);
        cancel.addActionListener(this);
        add(cancel);


        setSize(900, 700);
        setLayout(null);
        setLocation(300, 100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == search) {
            String q = "SELECT * FROM  teacherleave where empId = '" + choiceEmpId.getSelectedItem() + "'";

            try {
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(q);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print) {
            try {
                table.print();

            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {


        new TeacherLeaveDetails();
    }


}
