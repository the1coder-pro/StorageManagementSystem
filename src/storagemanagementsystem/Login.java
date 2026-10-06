package storagemanagementsystem;
// * means all element from the library
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Login extends JFrame implements ActionListener {
    JLabel Welcome_label = new JLabel("Authentication");
   JLabel lblUsername = new JLabel("Username:");
   JLabel lblPassword = new JLabel("Password:");
   JTextField txtUsername  = new JTextField(15);
   JPasswordField txtPassword = new JPasswordField(15);
   JButton btnLogin = new JButton("Login");
   JButton btnClear = new JButton("Clear");
   private GridBagLayout layout;
   private GridBagConstraints c = new GridBagConstraints();

    public Login() {
        super("Storage Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        layout = new GridBagLayout();
        setLayout(layout);
        JPanel BTN_panel = new JPanel();
        BTN_panel.add(btnLogin);
        BTN_panel.add(btnClear);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);
        Welcome_label.setFont(new Font("Arial",Font.BOLD,20));
        addComponent(Welcome_label,0,1,2,1);
        addComponent(lblUsername,1,0,1,1);
        addComponent(txtUsername,1,1,1,1);

        addComponent(lblPassword,2,0,1,1);
        addComponent(txtPassword,2,1,1,1);

        c.fill = GridBagConstraints.NONE;
        addComponent(BTN_panel,3,0,2,1);
        btnLogin.addActionListener(this);
        btnClear.addActionListener(this);
        setVisible(true);


    }

    private void addComponent(Component component, int row, int column, int width, int height) {
        c.gridx = column;
        c.gridy = row;
        c.gridwidth = width;
        c.gridheight = height;
        layout.setConstraints(component, c);
        add(component);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {

            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (username.equals("ali") && password.equals("yousef")) {
                JOptionPane.showMessageDialog(null, "Welcome to Storage Management System "+username);
            }
            else {JOptionPane.showMessageDialog(null,"Wrong! Username or Password is not correct." + password);}
        }
        if (e.getSource() == btnClear) {
            txtUsername.setText("");
            txtPassword.setText("");
        }
    }

}
