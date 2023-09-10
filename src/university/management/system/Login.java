package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField password;

    JButton login, back;

    Login() {

        JLabel label1 = new JLabel("Username");
        label1.setBounds(40, 20, 100, 20);
        add(label1);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 20);
        add(textField);

        JLabel passwordField = new JLabel("Password");
        passwordField.setBounds(40, 70, 100, 20);
        add(passwordField);

        password = new JPasswordField();
        password.setBounds(150, 70, 150, 20);
        add(password);

        login = new JButton("Login");
        login.setBounds(40, 140, 120, 30);
        login.setBackground(Color.BLACK);
        login.setBackground(Color.white);
        login.addActionListener(this);
        add(login);

        back = new JButton("Back");
        back.setBounds(180, 140, 120, 30);
        back.setBackground(Color.BLACK);
        back.setBackground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/Sirt.logo.gif"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(350, 20, 200, 200);
        add(img);


        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/bootstrap.jpg"));
        Image ii2 = ii1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel image = new JLabel(ii3);
        image.setBounds(0, 0, 600, 300);
        add(image);


        setLayout(null);
        setSize(600, 300);
        setLocation(500, 250);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            String username = textField.getText();
            String pass = password.getText();
            String query = "SELECT * FROM login WHERE username='"+username+"' AND password = '"+ pass +"'";
            try{
                conn c = new conn();
                ResultSet resultSet = c.statement.executeQuery(query);

                // check the data came on resultset or not
                if (resultSet.next()){
                    setVisible(false);
                    new main_class();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid username or password");
                }
            }catch (Exception E){
                E.printStackTrace();
            }



        } else if (e.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }


}
