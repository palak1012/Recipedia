package recipediaPkg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class LoginSignupGUI {
	private static String currentUser;
	
	
	public static void createAndShowLoginGUI() {
		RecipeAppLogin logincode = new RecipeAppLogin();
		HomeGUI homeGUI = new HomeGUI();
		
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(245, 222, 179)); // Light brown color

        // Load and scale logo image
        ImageIcon logoIcon = new ImageIcon("Image/logo1.png"); 
        Image scaledLogo = logoIcon.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH); // Adjust width and height as needed
        ImageIcon scaledIcon = new ImageIcon(scaledLogo);
        JLabel logoLabel = new JLabel(scaledIcon);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(logoLabel, BorderLayout.NORTH); // Display logo in the top

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        formPanel.setBackground(new Color(245, 222, 179)); // Light brown color

        JLabel idLabel = new JLabel("Username:");
        idLabel.setForeground(Color.BLACK); // Black text color
        JTextField idField = new JTextField();
        idField.setBackground(new Color(255, 248, 220)); // Ivory color
        idField.setForeground(Color.BLACK); // Black text color
        idField.setBorder(new LineBorder(Color.BLACK)); // Black border

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.BLACK); // Black text color
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBackground(new Color(255, 248, 220)); // Ivory color
        passwordField.setForeground(Color.BLACK); // Black text color
        passwordField.setBorder(new LineBorder(Color.BLACK)); // Black border

        formPanel.add(idLabel);
        formPanel.add(idField);
        formPanel.add(passwordLabel);
        formPanel.add(passwordField);

        mainPanel.add(formPanel, BorderLayout.CENTER); // Display text fields in the center

        JButton loginButton = new JButton("Login");
        JButton signupButton = new JButton("Signup");
        loginButton.setBackground(new Color(139, 69, 19)); // Saddle brown color
        signupButton.setBackground(new Color(139, 69, 19)); // Saddle brown color
        loginButton.setForeground(Color.WHITE); // White text color
        signupButton.setForeground(Color.WHITE); // White text color

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.setBackground(new Color(245, 222, 179)); // Light brown color
        buttonPanel.setBorder(new EmptyBorder(20, 0, 0, 0));
        buttonPanel.add(loginButton);
        buttonPanel.add(signupButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Display buttons at the bottom

        frame.add(mainPanel);
        frame.setVisible(true);

        loginButton.addActionListener(e -> {
            String username = idField.getText();
            String password = String.valueOf(passwordField.getPassword());
            if (logincode.authenticateUser(username, password)) {
                currentUser = username;
                frame.dispose();
                homeGUI.createAndShowGUI(currentUser);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password!");
            }
        });

        signupButton.addActionListener(e -> {
            String username = idField.getText();
            String password = String.valueOf(passwordField.getPassword());
            if (logincode.signupUser(username, password)) {
                JOptionPane.showMessageDialog(null, "User created successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Error creating user!");
            }
        });
    }


}
