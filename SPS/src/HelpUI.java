import java.awt.*;
import javax.swing.*;

class HelpUI {

    public HelpUI() {
        // Main Frame
        JFrame helpFrame = new JFrame("Help");
        helpFrame.setBounds(150, 100, 600, 400);
        helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        helpFrame.setVisible(true);

        // Help Panel
        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(null);
        helpPanel.setBackground(Color.yellow); // Set background color to green
        helpFrame.add(helpPanel);

        // Features Label
        JLabel featuresLabel = new JLabel("FEATURES:");
        featuresLabel.setFont(new Font("Serif", Font.BOLD, 24));
        featuresLabel.setBounds(50, 20, 500, 30);
        helpPanel.add(featuresLabel);

        // Feature Descriptions
        JLabel feature1 = new JLabel("1. Send Money through UPI");
        feature1.setFont(new Font("Serif", Font.PLAIN, 18));
        feature1.setBounds(50, 70, 400, 30);
        helpPanel.add(feature1);

        JLabel feature2 = new JLabel("2. Bank Transfer");
        feature2.setFont(new Font("Serif", Font.PLAIN, 18));
        feature2.setBounds(50, 110, 400, 30);
        helpPanel.add(feature2);

        JLabel feature3 = new JLabel("3. Mobile Recharge");
        feature3.setFont(new Font("Serif", Font.PLAIN, 18));
        feature3.setBounds(50, 150, 400, 30);
        helpPanel.add(feature3);

        JLabel feature4 = new JLabel("4. Electricity Bill Payment");
        feature4.setFont(new Font("Serif", Font.PLAIN, 18));
        feature4.setBounds(50, 190, 400, 30);
        helpPanel.add(feature4);

        // Developed By Label
        JLabel creditsLabel = new JLabel("Developed By:");
        creditsLabel.setFont(new Font("Serif", Font.BOLD, 24));
        creditsLabel.setBounds(50, 250, 400, 30);
        helpPanel.add(creditsLabel);

        JLabel developers = new JLabel("DEVENDRA PATIL AND SAURABH GOND");
        developers.setFont(new Font("Serif", Font.ITALIC, 20));
        developers.setBounds(50, 290, 500, 30);
        developers.setForeground(Color.BLUE);
        helpPanel.add(developers);
    }

}
