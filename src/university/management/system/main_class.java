package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {
    main_class() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/mainsirt.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        add(img);

        JMenuBar mb = new JMenuBar();

        // new information
        JMenu newInfo = new JMenu("New Information");
        newInfo.setForeground(Color.black);
        mb.add(newInfo);
        // now we need to items inside the menu bar  -- 1st option
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.white);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);


        // 2nd option
        JMenuItem studentInfo = new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.white);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);


        //DETAILS

        JMenu details = new JMenu("View Details");
        details.setForeground(Color.black);
        details.addActionListener(this);
        mb.add(details);
        // now we need to items inside the menu bar  -- 1st option
        JMenuItem facultyDetails = new JMenuItem("View  Faculty Details");
        facultyDetails.setBackground(Color.white);
        facultyDetails.addActionListener(this);
        details.add(facultyDetails);
        // 2nd option
        JMenuItem studentetails = new JMenuItem("View Student Details");
        studentetails.setBackground(Color.white);
        studentetails.addActionListener(this);
        details.add(studentetails);


        //Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.black);
        leave.addActionListener(this);
        mb.add(leave);


        // now we need to items inside the menu bar  -- 1st option
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.white);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);


        // 2nd option
        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.white);
        studentleave.addActionListener(this);
        leave.add(studentleave);


        //Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.black);
        leaveDetails.addActionListener(this);
        mb.add(leaveDetails);



        // now we need to items inside the menu bar  -- 1st option
        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.white);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);




        // 2nd option
        JMenuItem studentLeaveDetails = new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.white);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        // Exam
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.black);
        exam.addActionListener(this);
        mb.add(exam);


        // now we need to items inside the menu bar  -- 1st option
        JMenuItem examinationDetails = new JMenuItem("Examination Results");
        examinationDetails.setBackground(Color.white);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);


        // 2nd option
        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setBackground(Color.white);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);




        //Update info
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.black);
        updateInfo.addActionListener(this);
        mb.add(updateInfo);



        // now we need to items inside the menu bar  -- 1st option
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.white);
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);



        // 2nd option
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.white);
        updatestudentinfo.addActionListener(this);
        updateInfo.add(updatestudentinfo);

        //fee
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.black);
        fee.addActionListener(this);
        mb.add(fee);



        // now we need to items inside the menu bar  -- 1st option
        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.white);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);


        // 2nd option
        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.white);
        feeForm.addActionListener(this);
        fee.add(feeForm);

        //Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.black);
        mb.add(utility);
        // now we need to items inside the menu bar  -- 1st option
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setBackground(Color.white);
        calculator.addActionListener(this);
        utility.add(calculator);
        // 2nd option
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);


        //-------------About------------
        JMenu about = new JMenu("About");
        about.setForeground(Color.black);
        mb.add(about);


        // now we need to items inside the menu bar  -- 1st option
        JMenuItem About = new JMenuItem("About");
        About.setBackground(Color.white);
        About.addActionListener(this);
        about.add(About);


        //----------Exit--------------
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.black);
        mb.add(exit);
        // now we need to items inside the menu bar  -- 1st option
        JMenuItem Exit = new JMenuItem("Exit");
        Exit.setBackground(Color.white);
        Exit.addActionListener(this);
        exit.add(Exit);

        // now we need to add in menu bar
        setJMenuBar(mb);


        setSize(1540, 850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm = e.getActionCommand();
        if (sm.equals("Exit")) {
            System.exit(15);
        } else if (sm.equals("Calculator")) {

            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (sm.equals("Notepad")) {

            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (sm.equals("New Faculty Information")) {
            new AddFaculty();
        } else if (sm.equals("New Student Information")) {
            new AddStudent();
        } else if (sm.equals("View  Faculty Details")) {
            new TeacherDetails();
        } else if (sm.equals("View Student Details")) {
            new StudentDetails();
        } else if (sm.equals("Faculty Leave")) {
            new TeacherLeave();
        } else if (sm.equals("Student Leave")) {
            new StudentLeave();
        } else if (sm.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
        } else if (sm.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        } else if (sm.equals("Update Faculty Details")) {
            new UpdateTeacher();
        } else if (sm.equals("Update Student Details")) {
            new UpdateStudent();
        } else if (sm.equals("Enter Marks")) {
            new EnterMarks();
        } else if (sm.equals("Examination Results")) {
            new ExaminationDetails();
        } else if (sm.equals("Fee Structure")) {
            new FeeStructure();
        }else if (sm.equals("Student Fee Form")) {
            new StudentFeeForm();
        }else if (sm.equals("About")) {
            new About();
        }
    }


    public static void main(String[] args) {
        new main_class();

    }


}
