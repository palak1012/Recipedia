package recipediaPkg;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class HomeGUI {
    public static void createAndShowGUI(String CurrentUser) {
    	Functionalities fxn = new Functionalities();
        JFrame frame = new JFrame("Recipe App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        buttonPanel.setBackground(new Color(245, 222, 179)); // Light brown color
        buttonPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JButton addButton = new JButton("Add");
        JButton viewButton = new JButton("View");
        JButton deleteButton = new JButton("Delete");
        JButton editButton = new JButton("Edit");
        JButton searchButton = new JButton("Search");

        addButton.setBackground(new Color(139, 69, 19)); // Saddle brown color
        viewButton.setBackground(new Color(139, 69, 19)); // Saddle brown color
        deleteButton.setBackground(new Color(139, 69, 19)); // Saddle brown color
        editButton.setBackground(new Color(139, 69, 19)); // Saddle brown color
        searchButton.setBackground(new Color(139, 69, 19)); // Saddle brown color

        addButton.setForeground(Color.WHITE); // White text color
        viewButton.setForeground(Color.WHITE); // White text color
        deleteButton.setForeground(Color.WHITE); // White text color
        editButton.setForeground(Color.WHITE); // White text color
        searchButton.setForeground(Color.WHITE); // White text color

        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.add(searchButton);

        JTextArea recipeTextArea = new JTextArea(20, 40);
        recipeTextArea.setBackground(new Color(255, 248, 220)); // Ivory color
        recipeTextArea.setForeground(Color.BLACK); // Black text color
        recipeTextArea.setBorder(new LineBorder(Color.BLACK)); // Black border

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, buttonPanel, new JScrollPane(recipeTextArea));
        splitPane.setResizeWeight(0.2);
        frame.add(splitPane);

        frame.setVisible(true);

        // Add action listeners for buttons
        addButton.addActionListener(e -> fxn.addRecipe(CurrentUser));
        viewButton.addActionListener(e -> fxn.viewRecipes(recipeTextArea));
        deleteButton.addActionListener(e -> fxn.deleteRecipe(CurrentUser));
        editButton.addActionListener(e -> fxn.editRecipe(CurrentUser));
        searchButton.addActionListener(e -> fxn.searchRecipe(recipeTextArea));
    }

}
