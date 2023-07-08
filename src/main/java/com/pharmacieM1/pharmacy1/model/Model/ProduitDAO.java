package com.pharmacieM1.pharmacy1.model.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.pharmacieM1.pharmacy1.model.Model.Produit;


public class ProduitDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pharmacie";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    public List<Produit> getAllProduits() {
        List<Produit> produits = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM product")) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                double prix = resultSet.getDouble("prix");

                Produit produit = new Produit();
                produit.setId(id);
                produit.setNom(nom);
                produit.setPrix(prix);

                produits.add(produit);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produits;
    }
}
