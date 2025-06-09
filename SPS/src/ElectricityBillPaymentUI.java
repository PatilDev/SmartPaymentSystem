import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

class ElectricityBillPaymentUI {

    public ElectricityBillPaymentUI() {
        // Main Frame
        JFrame billFrame = new JFrame("Electricity Bill Payment");
        billFrame.setBounds(150, 100, 600, 500);
        billFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        billFrame.setVisible(true);

        // Initial Panel (Bill Details)
        JPanel billPanel = new JPanel();
        billPanel.setLayout(null);
        billFrame.add(billPanel);

        JLabel consumerLabel = new JLabel("ENTER CONSUMER NUMBER:");
        consumerLabel.setBounds(50, 50, 200, 30);
        billPanel.add(consumerLabel);

        JTextField consumerField = new JTextField(10);
        consumerField.setBounds(250, 50, 200, 30);
        billPanel.add(consumerField);

        JLabel amountLabel = new JLabel("ENTER BILL AMOUNT:");
        amountLabel.setBounds(50, 100, 200, 30);
        billPanel.add(amountLabel);

        JTextField amountField = new JTextField(10);
        amountField.setBounds(250, 100, 200, 30);
        billPanel.add(amountField);

        JButton submitButton = new JButton("SUBMIT");
        submitButton.setBounds(250, 200, 100, 30);
        billPanel.add(submitButton);

        // Action Listener for Submit Button
        submitButton.addActionListener((ActionEvent e) -> {
            String consumerNumber = consumerField.getText().trim();
            String billAmount = amountField.getText().trim();

            // Validation
            if (consumerNumber.isEmpty()) {
                JOptionPane.showMessageDialog(billFrame, "Consumer number is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!consumerNumber.matches("\\d+")) {
                JOptionPane.showMessageDialog(billFrame, "Invalid consumer number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (billAmount.isEmpty()) {
                JOptionPane.showMessageDialog(billFrame, "Bill amount is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double parsedAmount = Double.parseDouble(billAmount);
                if (parsedAmount <= 0) {
                    JOptionPane.showMessageDialog(billFrame, "Bill amount must be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(billFrame, "Invalid bill amount!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Move to PIN Entry Panel
            billPanel.setVisible(false);
            JPanel pinPanel = new JPanel();
            pinPanel.setLayout(null);
            billFrame.add(pinPanel);

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
                    JOptionPane.showMessageDialog(billFrame, "PIN is required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Move to Payment Success Panel
                pinPanel.setVisible(false);
                JPanel successPanel = new JPanel();
                successPanel.setLayout(null);
                successPanel.setBackground(Color.YELLOW);
                billFrame.add(successPanel);

                JLabel successLabel = new JLabel("PAYMENT SUCCESSFUL", JLabel.CENTER);
                successLabel.setFont(new Font("Serif", Font.BOLD, 30));
                successLabel.setBounds(70, 50, 500, 50);
                successLabel.setOpaque(true);
                successLabel.setBackground(Color.WHITE); 
                successLabel.setForeground(Color.GRAY);
                successPanel.add(successLabel);

                JLabel consumerInfo = new JLabel("Consumer Number: " + consumerNumber, JLabel.CENTER);
                consumerInfo.setFont(new Font("Serif", Font.PLAIN, 20));
                consumerInfo.setBounds(70, 150, 500, 50);
                consumerInfo.setOpaque(true);
                consumerInfo.setBackground(Color.WHITE);
                consumerInfo.setForeground(Color.BLUE);
                successPanel.add(consumerInfo);

                JLabel amountInfo = new JLabel("Bill Amount Paid: ₹" + billAmount, JLabel.CENTER);
                amountInfo.setFont(new Font("Serif", Font.BOLD, 20));
                amountInfo.setBounds(70, 250, 500, 50);
                amountInfo.setOpaque(true);
                amountInfo.setBackground(Color.WHITE);
                amountInfo.setForeground(Color.DARK_GRAY);
                successPanel.add(amountInfo);

                JLabel date = new JLabel("DATE: " + Miniproject.str + " TIME: " + Miniproject.time, JLabel.CENTER);
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
