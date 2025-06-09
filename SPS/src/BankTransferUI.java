import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class BankTransferUI {
        
    public BankTransferUI() {
        JFrame bank = new JFrame("BANK TRANSFER");
        bank.setBounds(50,50,900,700);
        bank.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        bank.setVisible(true);
        JPanel jp3=new JPanel();
        jp3.setLayout(null);
        JPanel jp4=new JPanel();
        jp4.setLayout(null);
        JPanel jp5=new JPanel();
        jp5.setLayout(null);
        
        bank.add(jp3);
        
        jp3.setVisible(true);
        jp3.setLayout(null);
          JLabel bn=new JLabel("ENTER THE BANK NAME :-  ",JLabel.CENTER);
          bn.setBounds(100,100,300,50);
          jp3.add(bn);
         JTextField name=new JTextField(30);
        name.setBounds(360,110,200,35);
     jp3.add(name);
    JLabel ac=new JLabel("ENTER THE ACCOUNT NUMBER : -",JLabel.CENTER);
     ac.setBounds(100,160,300,50);
                 jp3.add(ac);
                 JTextField acno=new JTextField(20);
                 acno.setBounds(360,160,200,35);
                 jp3.add(acno);
                 JLabel IF=new JLabel("ENTER THE IFSC CODE : -      ",JLabel.CENTER);
                 IF.setBounds(140,220,300,50);
                 jp3.add(IF);
                 JTextField ifsc=new JTextField(20);
                 ifsc.setBounds(360,220,200,35);
                 jp3.add(ifsc);
                 
                 JLabel am=new JLabel("ENTER THE AMOUNT : -      ",JLabel.CENTER);
                 am.setBounds(140,280,300,50);
                 jp3.add(am);
                 JTextField amo=new JTextField(20);
                 amo.setBounds(360,280,200,35);
                 jp3.add(amo);
                 JButton submitB=new JButton("SUBMIT");
                 submitB.setBounds(370, 340, 150, 40);
                 jp3.add(submitB);
                 
                 
                 submitB.addActionListener(( e1) -> {
 
                     String bankName = name.getText().trim();
             String accountNumber = acno.getText().trim();
             String ifscCode = ifsc.getText().trim();
             String amount = amo.getText().trim();
 
             if (bankName.isEmpty() || accountNumber.isEmpty() || ifscCode.isEmpty() || amount.isEmpty()) {
                 JOptionPane.showMessageDialog(bank, "All fields must be filled out!", "Error", JOptionPane.ERROR_MESSAGE);
                 return; // Exit from the method if validation fails
             }
 
             try {
                 Double.parseDouble(amount); // Validate if the amount is a number
             } catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(bank, "Please enter a valid amount!", "Error", JOptionPane.ERROR_MESSAGE);
                 return;
             }
 
 
             try {
                 Double.parseDouble(amount); // Validate if the amount is a number
             } catch (NumberFormatException ex) {
                 JOptionPane.showMessageDialog(bank, "Please enter a valid amount!", "Error", JOptionPane.ERROR_MESSAGE);
                 return;
             }
 
                     jp3.setVisible(false);
                     bank.add(jp4);
                     JLabel pin=new JLabel("Enter PIN :-  ");
                     pin.setBounds(250,160,300,50);
                     pin.setFont(new Font("SAFARI",Font.BOLD,18));
                     jp4.add(pin);
                     JPasswordField t2 =new JPasswordField(10);
                     t2.setBounds(360,165,200,40);
                     jp4.add(t2);
                     JButton jb2 =new JButton("DONE");
                     jb2.setBounds(350,240,200,50);
                     jb2.setFont(new Font("Serif",Font.BOLD,20));
                     jp4.add(jb2);
                     jb2.addActionListener((ActionEvent e2) -> {
                         String bpin = new String(t2.getPassword()).trim();
     
                     if (bpin.isEmpty()) {
                         JOptionPane.showMessageDialog(bank, "PIN is required!", "Error", JOptionPane.ERROR_MESSAGE);
                         return;
                     }
                         jp4.setVisible(false);//close the panel
                         jp5.setLayout(null);//to add Layout manager used for add color on panel
                         jp5.setBackground(Color.green);
                         bank.add(jp5);
                         jp5.setVisible(true);
                         
                         JLabel b2=new JLabel(" TRANSECTION SUCCESSFULL ",JLabel.CENTER);
                         b2.setFont(new Font("Serif",Font.BOLD,30));
                         b2.setBounds(70,50, 500, 50);
                         b2.setOpaque(true);
                         b2.setBackground(Color.WHITE);
                         b2.setForeground(Color.BLUE);
                         jp5.add(b2);
                         String getbn=name.getText();
                         String getac=acno.getText();
                         String getvalue=amo.getText();
                         JLabel u=new JLabel("AMOUNT TRNSFER TO BANK NAME :- "+getbn,JLabel.CENTER);
                         u.setFont(new Font("Serif",Font.PLAIN,20));
                         u.setSize(50,50);
                         u.setOpaque(true);
                         u.setBackground(Color.white);
                         u.setForeground(Color.RED);
                         u.setBounds(70,150 , 500, 50);
                         
                         JLabel z=new JLabel("TO ACCOUNT NO :-  " +getac,JLabel.CENTER);
                         z.setFont(new Font("Serif",Font.BOLD,20));
                         z.setOpaque(true);
                         z.setBackground(Color.WHITE);
                         z.setForeground(Color.BLACK);
                         z.setBounds(70,250, 500, 50);
                         JLabel z1=new JLabel("RUPPES   ("+getvalue+")   SUCCESSFULLY TRANSFERED ",JLabel.CENTER);
                         z.setFont(new Font("Serif",Font.BOLD,20));
                         z1.setOpaque(true);
                         z1.setBackground(Color.WHITE);
                         z1.setForeground(Color.BLACK);
                         z1.setBounds(70,350, 500, 50);
                         jp5.add(u);
                         jp5.add(z);
                         jp5.add(z1);
                         JLabel date=new JLabel("DATE :- "+Miniproject.str+"  Time:- "+Miniproject.time,JLabel.CENTER);
                         date.setBounds(200,400, 200, 70);
                         jp5.add(date);

                         JLabel transactionDetails = new JLabel("Transaction ID: " + generateTransactionId(), JLabel.CENTER);
                transactionDetails.setFont(new Font("Serif", Font.PLAIN, 20));
                transactionDetails.setBounds(70, 450, 500, 50);
                jp5.add(transactionDetails);
                     });
                 });
         }
         // Method to generate a random transaction ID
    private String generateTransactionId() {
        return "TXN" + (int) (Math.random() * 1000000);
    }
     }