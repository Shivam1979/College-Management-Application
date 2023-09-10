package university.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class ExaminationDetails extends JFrame implements ActionListener {
    JTextField search;
    JTable table;
    JButton result, back;

    ExaminationDetails() {

        getContentPane().setBackground(new Color(241, 252, 210));
        JLabel heading = new JLabel("Check result");
        heading.setBounds(350, 15, 400, 50);
        heading.setFont(new Font("TAHOMA", Font.BOLD, 24));
        add(heading);


        search = new JTextField();
        search.setBounds(80, 90, 200, 30);
        search.setFont(new Font("tahoma", Font.PLAIN, 18));
        add(search);


        result = new JButton("Result");
        result.setBounds(300, 90, 120, 30);
        result.setBackground(Color.BLACK);
        result.setForeground(Color.WHITE);
        result.addActionListener(this);
        add(result);


        back = new JButton("Back");
        back.setBounds(300, 90, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 130, 1000, 310);
        add(scrollPane);


        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("SELECT * FROM student");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }


        //{ for mouse click to get value in search field
        table.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row,2).toString());
            }
          });
        //}


        setSize(1000, 475);
        setLocation(300, 100);
        setLayout(null);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()== result){
           setVisible(false);
       }else {
           setVisible(false);
       }
    }
    public static void main(String[] args) {
     new ExaminationDetails();
    }




}
