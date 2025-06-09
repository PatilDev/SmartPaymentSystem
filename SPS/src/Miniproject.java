import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class Miniproject {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Smart_payment_System";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    // Date and Time
    public static String str = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    public static String time = new SimpleDateFormat("HH:mm:ss").format(new Date());

    public static void main(String[] args) {
        JFrame mainframe = new JFrame("Smart Payment System");
        mainframe.setExtendedState(Frame.MAXIMIZED_BOTH);
        mainframe.setLayout(new BorderLayout());

        ImageIcon img = new ImageIcon("resources/loginpage.jpg"); 
        JLabel loginimg = new JLabel(img);
        mainframe.add(loginimg, BorderLayout.CENTER);

        mainframe.setVisible(true);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        new LoginUI(); // Initialize Login UI
    }

    // Method to get database connection
    private static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            throw e; // Rethrow to handle it properly
        }
    }

    static class LoginUI {
        private JFrame frame;
        private JTextField uidField;
        private JPasswordField passField;

        public LoginUI() {
            frame = new JFrame("Login - Smart Payment System");
            frame.setLayout(null);
            frame.setBounds(400, 50, 600, 500);

            JPanel loginPanel = new JPanel();
            loginPanel.setLayout(null);
            loginPanel.setBackground(Color.YELLOW);
            loginPanel.setBounds(10, 10, 550, 450);
            frame.add(loginPanel);

            // User ID Field
            JLabel userLabel = new JLabel("ENTER THE USER ID:");
            userLabel.setBounds(150, 100, 200, 50);
            loginPanel.add(userLabel);
            uidField = new JTextField();
            uidField.setBounds(310, 110, 200, 35);
            loginPanel.add(uidField);

            // Password Field
            JLabel passLabel = new JLabel("ENTER THE PASSWORD:");
            passLabel.setBounds(150, 160, 200, 50);
            loginPanel.add(passLabel);
            passField = new JPasswordField();
            passField.setBounds(310, 170, 200, 35);
            loginPanel.add(passField);

            // Login Button
            JButton loginButton = new JButton("Submit");
            loginButton.setBounds(270, 240, 200, 35);
            loginPanel.add(loginButton);
            loginButton.addActionListener(this::handleLogin);

            // Create New Account Button
            JButton newuser = new JButton("Create New Account");
            newuser.setBounds(270, 350, 200, 20);
            loginPanel.add(newuser);
            newuser.addActionListener(this::newuserlogin);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }

        private void handleLogin(ActionEvent e) {
            String enteredUser = uidField.getText();
            String enteredPass = new String(passField.getPassword());

            try (Connection con = getConnection();
                 PreparedStatement stmt = con.prepareStatement("SELECT * FROM sps WHERE UPIID = ? AND PIN = ?")) {
                stmt.setString(1, enteredUser);
                stmt.setString(2, enteredPass);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    new MainUI();
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(frame, "Error during login: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }

        private void newuserlogin(ActionEvent e) {
            JFrame regFrame = new JFrame("New User Registration");
            regFrame.setLayout(null);
            regFrame.setBounds(400, 50, 600, 500);

            JPanel panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(Color.YELLOW);
            panel.setBounds(10, 10, 550, 450);
            regFrame.add(panel);

            JLabel userLabel = new JLabel("Enter User ID:");
            userLabel.setBounds(150, 100, 200, 50);
            panel.add(userLabel);

            JTextField userIdField = new JTextField();
            userIdField.setBounds(310, 110, 200, 35);
            panel.add(userIdField);

            JLabel passLabel = new JLabel("Enter Password:");
            passLabel.setBounds(150, 160, 200, 50);
            panel.add(passLabel);

            JPasswordField passField = new JPasswordField();
            passField.setBounds(310, 170, 200, 35);
            panel.add(passField);

            JButton submitButton = new JButton("Register");
            submitButton.setBounds(270, 240, 200, 35);
            panel.add(submitButton);

            submitButton.addActionListener(e1 -> {
                String userId = userIdField.getText();
                String password = new String(passField.getPassword());

                if (userId.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(regFrame, "Both fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try (Connection con = getConnection();
                     PreparedStatement stmt = con.prepareStatement("INSERT INTO sps (UPIID, PIN) VALUES (?, ?)")) {
                    stmt.setString(1, userId);
                    stmt.setString(2, password);
                    int rowsInserted = stmt.executeUpdate();

                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(regFrame, "Account created successfully!");
                        regFrame.dispose();
                    } else {
                        JOptionPane.showMessageDialog(regFrame, "Failed to create account. Try again!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(regFrame, "Error while creating account: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            regFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            regFrame.setVisible(true);
        }
    }

    // Main UI after successful login
    static class MainUI {
        private final JFrame frame;


        public MainUI() {
            frame = new JFrame("Smart Payment");
            frame.setLayout(new BorderLayout());
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            ImageIcon img = new ImageIcon("C:\\Users\\heman\\OneDrive\\Desktop\\Devendra\\PROJECT\\Smart_Payment_System\\SPS\\src\\SPS_Home_Page1.jpg");
            JLabel imageLabel = new JLabel(img);
            frame.add(imageLabel, BorderLayout.CENTER);

            // Menu Bar
            JMenuBar menuBar = new JMenuBar();
            menuBar.setBackground(Color.BLACK);
            frame.setJMenuBar(menuBar);

            JMenu sendMoneyMenu = new JMenu("     Send Money");
            sendMoneyMenu.setForeground(Color.YELLOW);
            sendMoneyMenu.setFont(new Font("Times New Roman", Font.BOLD, 20));

            JMenuItem upiMenuItem = new JMenuItem("To UPI ID");
            sendMoneyMenu.add(upiMenuItem);
            JMenuItem bankMenuItem = new JMenuItem("To Bank Account");
            sendMoneyMenu.add(bankMenuItem);

            JMenu billMenu = new JMenu("     Bill");
            billMenu.setForeground(Color.YELLOW);
            billMenu.setFont(new Font("Times New Roman", Font.BOLD, 20));

            JMenuItem billMenuItem = new JMenuItem("Pay electricity Bill");
            billMenu.add(billMenuItem);

            JMenu mobileRechargeMenu = new JMenu("     Mobile Recharge");
            mobileRechargeMenu.setForeground(Color.YELLOW);
            mobileRechargeMenu.setFont(new Font("Times New Roman", Font.BOLD, 20));
            
            JMenuItem rechargeMenuItem = new JMenuItem("Recharge Now");
            mobileRechargeMenu.add(rechargeMenuItem);

            JMenu helpMenu = new JMenu("     Help  ");
            helpMenu.setForeground(Color.YELLOW);
            helpMenu.setFont(new Font("Times New Roman", Font.BOLD, 20));
            JMenuItem helpMenuItem = new JMenuItem("About project");
            helpMenu.add(helpMenuItem);

            menuBar.add(sendMoneyMenu);
            menuBar.add(billMenu);
            menuBar.add(mobileRechargeMenu);
            menuBar.add(helpMenu);

            upiMenuItem.addActionListener(e -> new UPITransactionUI());
            bankMenuItem.addActionListener(e ->new BankTransferUI());
            billMenuItem.addActionListener(e -> new ElectricityBillPaymentUI());
            rechargeMenuItem.addActionListener(e -> new MobileRechargeUI());
            helpMenuItem.addActionListener(e -> new HelpUI());
           




            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }            
        }

    }
