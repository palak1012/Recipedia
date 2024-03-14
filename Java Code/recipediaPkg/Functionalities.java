package recipediaPkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Functionalities {
	private static final String URL = "jdbc:mysql://localhost:3306/recipedia";
    private static final String USER = "root";
    private static final String PASSWORD = "1012";
    
    public static void addRecipe(String currentUser) {
        String recipeName = JOptionPane.showInputDialog("Enter recipe name:");
        String ingredients = JOptionPane.showInputDialog("Enter ingredients:");
        String preparation = JOptionPane.showInputDialog("Enter preparation steps:");
        String comment = JOptionPane.showInputDialog("Enter comments (optional):");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO Recipes (username, recipe_name, ingredients, preparation, comment) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, currentUser);
            stmt.setString(2, recipeName);
            stmt.setString(3, ingredients);
            stmt.setString(4, preparation);
            stmt.setString(5, comment);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Recipe added successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add recipe!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void viewRecipes(JTextArea recipeTextArea) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM Recipes";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            StringBuilder recipes = new StringBuilder();
            while (rs.next()) {
                recipes.append("Recipe Name: ").append(rs.getString("recipe_name")).append("\n")
                        .append("Ingredients: ").append(rs.getString("ingredients")).append("\n")
                        .append("Preparation: ").append(rs.getString("preparation")).append("\n")
                        .append("Comment: ").append(rs.getString("comment")).append("\n\n");
            }
            if (recipes.length() == 0) {
            	recipeTextArea.setText("");
                JOptionPane.showMessageDialog(null, "No recipes found!");
          
            } else {
                recipeTextArea.setText(recipes.toString());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public static void deleteRecipe(String currentUser) {
        String recipeName = JOptionPane.showInputDialog("Enter recipe name to delete:");
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM Recipes WHERE username = ? AND recipe_name = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, currentUser);
            stmt.setString(2, recipeName);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Recipe deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Recipe not found or you don't have permission to delete it!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void editRecipe(String currentUser) {
        String recipeName = JOptionPane.showInputDialog("Enter recipe name to edit:");
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)){
        	
	        String sql = "SELECT * FROM Recipes WHERE username = ? AND recipe_name = ?";
	        PreparedStatement stmt = conn.prepareStatement(sql);
	        stmt.setString(1, currentUser);
	        stmt.setString(2, recipeName);;
	        ResultSet rs = stmt.executeQuery();
	        StringBuilder recipes = new StringBuilder();
	        while (rs.next()) {
	            recipes.append("Recipe Name: ").append(rs.getString("recipe_name")).append("\n")
	                    .append("Ingredients: ").append(rs.getString("ingredients")).append("\n")
	                    .append("Preparation: ").append(rs.getString("preparation")).append("\n")
	                    .append("Comment: ").append(rs.getString("comment")).append("\n\n");
	        }
	        if (recipes.length() == 0) {
	            JOptionPane.showMessageDialog(null, "Recipe not found or you don't have permission to edit it!");
	        } else {

		        String newIngredients = JOptionPane.showInputDialog("Enter new ingredients:");
		        String newPreparation = JOptionPane.showInputDialog("Enter new preparation steps:");
		        String newComment = JOptionPane.showInputDialog("Enter new comments (optional):");
		
	            sql = "UPDATE Recipes SET ingredients = ?, preparation = ?, comment = ? WHERE username = ? AND recipe_name = ?";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, newIngredients);
	            stmt.setString(2, newPreparation);
	            stmt.setString(3, newComment);
	            stmt.setString(4, currentUser);
	            stmt.setString(5, recipeName);
	            stmt.executeUpdate();
	  
	             JOptionPane.showMessageDialog(null, "Recipe updated successfully!");
	        }
        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
	        }
    }

    public static void searchRecipe(JTextArea recipeTextArea) {
        String ingredientToSearch = JOptionPane.showInputDialog("Enter ingredient to search for:");

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM Recipes WHERE ingredients LIKE ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, "%" + ingredientToSearch + "%");
            ResultSet rs = stmt.executeQuery();
            StringBuilder recipes = new StringBuilder();
            while (rs.next()) {
                recipes.append("Recipe Name: ").append(rs.getString("recipe_name")).append("\n")
                        .append("Ingredients: ").append(rs.getString("ingredients")).append("\n")
                        .append("Preparation: ").append(rs.getString("preparation")).append("\n")
                        .append("Comment: ").append(rs.getString("comment")).append("\n\n");
            }
            if (recipes.length() == 0) {
                JOptionPane.showMessageDialog(null, "No recipes found!");
            } else {
                recipeTextArea.setText(recipes.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

}
