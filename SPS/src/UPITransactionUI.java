// UPI Transaction UI
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
class UPITransactionUI {

    public UPITransactionUI() {
        // Main Frame
        JFrame upi = new JFrame("UPI");
        upi.setBounds(150, 100, 600, 500);
        upi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        upi.setVisible(true);

        // Initial Panel
        JPanel jp = new JPanel();
        jp.setLayout(null);
        upi.add(jp);

        JLabel u = new JLabel("ENTER THE UPI ID (eg...@BANK):");
        u.setBounds(50, 50, 200, 30);
        jp.add(u);

        JTextField upiField = new JTextField(20);
        upiField.setBounds(250, 50, 200, 30);
        jp.add(upiField);

        JLabel a = new JLabel("ENTER THE AMOUNT:");
        a.setBounds(50, 100, 200, 30);
        jp.add(a);

        JTextField amountField = new JTextField(20);
        amountField.setBounds(250, 100, 200, 30);
        jp.add(amountField);

        JButton b = new JButton("SUBMIT");
        b.setBounds(250, 200, 100, 30);
        jp.add(b);

        // Action Listener for Submit Button
        b.addActionListener((ActionEvent e1) -> {
            String upiId = upiField.getText().trim();
            String amount = amountField.getText().trim();

            // Validation
            if (upiId.isEmpty()) {
                JOptionPane.showMessageDialog(upi, "UPI ID is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (amount.isEmpty()) {
                JOptionPane.showMessageDialog(upi, "Amount is required!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double parsedAmount = Double.parseDouble(amount);
                if (parsedAmount <= 0) {
                    JOptionPane.showMessageDialog(upi, "Amount must be greater than 0!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(upi, "Invalid amount entered!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Move to PIN Entry Panel
            jp.setVisible(false);
            JPanel jp1 = new JPanel();
            jp1.setLayout(null);
            upi.add(jp1);

            JLabel b1 = new JLabel("ENTER PIN", JLabel.CENTER);
            b1.setBounds(200, 50, 200, 30);
            jp1.add(b1);

            JPasswordField t2 = new JPasswordField(10);
            t2.setBounds(200, 100, 200, 30);
            jp1.add(t2);

            JButton jb2 = new JButton("DONE");
            jb2.setBounds(250, 200, 100, 30);
            jp1.add(jb2);

            // Action Listener for DONE Button
            jb2.addActionListener(e2 -> {
                String pin = new String(t2.getPassword()).trim();

                if (pin.isEmpty()) {
                    JOptionPane.showMessageDialog(upi, "PIN is required!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Move to Transaction Success Panel
                jp1.setVisible(false);
                JPanel jp2 = new JPanel();
                jp2.setLayout(null);
                jp2.setBackground(Color.YELLOW);
                upi.add(jp2);

                JLabel b2 = new JLabel("TRANSACTION SUCCESSFUL", JLabel.CENTER);
                b2.setFont(new Font("Serif", Font.BOLD, 30));
                b2.setBounds(70, 50, 500, 50);
                b2.setOpaque(true);
                b2.setBackground(Color.WHITE);
                b2.setForeground(Color.BLUE);
                jp2.add(b2);

                JLabel u1 = new JLabel("AMOUNT TRANSFERRED TO UPI ID: " + upiId, JLabel.CENTER);
                u1.setFont(new Font("Serif", Font.PLAIN, 20));
                u1.setBounds(70, 150, 500, 50);
                u1.setOpaque(true);
                u1.setBackground(Color.WHITE);
                u1.setForeground(Color.RED);
                jp2.add(u1);

                JLabel z = new JLabel("RUPEES (" + amount + ") SUCCESSFULLY TRANSFERRED", JLabel.CENTER);
                z.setFont(new Font("Serif", Font.BOLD, 20));
                z.setBounds(70, 250, 500, 50);
                z.setOpaque(true);
                z.setBackground(Color.WHITE);
                z.setForeground(Color.DARK_GRAY);
                jp2.add(z);

                JLabel date = new JLabel("DATE :- " + Miniproject.str + " Time :- " + Miniproject.time, JLabel.CENTER);
                date.setBounds(70, 300, 500, 50);
                jp2.add(date);

                JLabel transactionDetails = new JLabel("Transaction ID: " + generateTransactionId(), JLabel.CENTER);
                transactionDetails.setFont(new Font("Serif", Font.PLAIN, 20));
                transactionDetails.setBounds(70, 350, 500, 50);
                jp2.add(transactionDetails);
            });
        });
    }
    // Method to generate a random transaction ID
    private String generateTransactionId() {
        return "TXN" + (int) (Math.random() * 1000000);
    }
}