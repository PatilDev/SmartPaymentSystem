import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

class MobileRechargeUI {

    public MobileRechargeUI() {
        // Main Frame
        JFrame rechargeFrame = new JFrame("Mobile Recharge");
        rechargeFrame.setBounds(150, 100, 600, 500);
        rechargeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        rechargeFrame.setVisible(true);

        // Initial Panel (Plan Selection)
        JPanel planPanel = new JPanel();
        planPanel.setLayout(null);
        rechargeFrame.add(planPanel);

        JLabel mobileLabel = new JLabel("ENTER MOBILE NUMBER:");
        mobileLabel.setBounds(50, 50, 200, 30);
        planPanel.add(mobileLabel);

        JTextField mobileField = new JTextField(10);
        mobileField.setBounds(250, 50, 200, 30);
        planPanel.add(mobileField);

        JLabel planLabel = new JLabel("SELECT RECHARGE PLAN:");
        planLabel.setBounds(50, 100, 200, 30);
        planPanel.add(planLabel);

        String[] plans = {"₹199 - 1GB/day - 28 Days", "₹399 - 2GB/day - 56 Days", "₹599 - 3GB/day - 84 Days"};
        JComboBox<String> planComboBox = new JComboBox<>(plans);
        planComboBox.setBounds(250, 100, 200, 30);
        planPanel.add(planComboBox);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setBounds(250, 200, 100, 30);
        planPanel.add(submitButton);

        // Action Listener for Submit Button
        submitButton.addActionListener((ActionEvent e) -> {
            String mobileNumber = mobileField.getText().trim();
            String selectedPlan = (String) planComboBox.getSelectedItem();

            // Validation
            if (mobileNumber.isEmpty()) {
                JOptionPane.showMessageDialog(rechargeFrame, "Mobile number is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!mobileNumber.matches("\\d{10}")) {
                JOptionPane.showMessageDialog(rechargeFrame, "Invalid mobile number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Move to PIN Entry Panel
            planPanel.setVisible(false);
            JPanel pinPanel = new JPanel();
            pinPanel.setLayout(null);
            rechargeFrame.add(pinPanel);

            JLabel pinLabel = new JLabel("ENTER PIN", JLabel.CENTER);
            pinLabel.setBounds(200, 50, 200, 30);
            pinPanel.add(pinLabel);

            JPasswordField pinField = new JPasswordField(10);
            pinField.setBounds(200, 100, 200, 30);
            pinPanel.add(pinField);

            JButton doneButton = new JButton("DONE");
            doneButton.setBounds(250, 200, 100, 30);
            pinPanel.add(doneButton);

            // Action Listener for DONE Button
            doneButton.addActionListener(e1 -> {
                String pin = new String(pinField.getPassword()).trim();

                if (pin.isEmpty()) {
                    JOptionPane.showMessageDialog(rechargeFrame, "PIN is required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Move to Transaction Success Panel
                pinPanel.setVisible(false);
                JPanel successPanel = new JPanel();
                successPanel.setLayout(null);
                successPanel.setBackground(Color.YELLOW);
                rechargeFrame.add(successPanel);

                JLabel successLabel = new JLabel("TRANSACTION SUCCESSFUL", JLabel.CENTER);
                successLabel.setFont(new Font("Serif", Font.BOLD, 30));
                successLabel.setBounds(70, 50, 500, 50);
                successLabel.setOpaque(true);
                successLabel.setBackground(Color.WHITE);
                successLabel.setForeground(Color.BLUE);
                successPanel.add(successLabel);

                JLabel mobileInfo = new JLabel("Recharge Done for Mobile Number: " + mobileNumber, JLabel.CENTER);
                mobileInfo.setFont(new Font("Serif", Font.PLAIN, 20));
                mobileInfo.setBounds(70, 150, 500, 50);
                mobileInfo.setOpaque(true);
                mobileInfo.setBackground(Color.WHITE);
                mobileInfo.setForeground(Color.RED);
                successPanel.add(mobileInfo);

                JLabel planInfo = new JLabel("Selected Plan: " + selectedPlan, JLabel.CENTER);
                planInfo.setFont(new Font("Serif", Font.BOLD, 20));
                planInfo.setBounds(70, 250, 500, 50);
                planInfo.setOpaque(true);
                planInfo.setBackground(Color.WHITE);
                planInfo.setForeground(Color.DARK_GRAY);
                successPanel.add(planInfo);

                JLabel date = new JLabel("DATE :- " + Miniproject.str + " Time :- " + Miniproject.time, JLabel.CENTER);
                date.setBounds(70, 300, 500, 50);
                successPanel.add(date);

                JLabel transactionDetails = new JLabel("Transaction ID: " + generateTransactionId(), JLabel.CENTER);
                transactionDetails.setFont(new Font("Serif", Font.PLAIN, 20));
                transactionDetails.setBounds(70, 350, 500, 50);
                successPanel.add(transactionDetails);
            });
        });
    }

    // Method to generate a random transaction ID
    private String generateTransactionId() {
        return "TXN" + (int) (Math.random() * 1000000);
    }
}
