package recipediaPkg;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RecipeApp {
	

    public static void main(String[] args) {
    	LoginSignupGUI loginGUI = new LoginSignupGUI();
        SwingUtilities.invokeLater(() -> loginGUI.createAndShowLoginGUI());
    }
}


