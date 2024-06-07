package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.PolyBayDatabase;
import models.Product;

public class ProductsDAO {
    public ProductsDAO(){

    }

    public ArrayList<Product> findAll(){
        ArrayList<Product> products = new ArrayList<Product>();
        try{
            PolyBayDatabase database = new PolyBayDatabase();
            String request = "SELECT * FROM product;";
            
            PreparedStatement statement = database.prepareStatement(request);
            ResultSet result = statement.executeQuery();

            while(result.next()){
                products.add(new Product(result.getInt("id"), result.getString("name"), result.getString("owner"), result.getFloat("bid")));
            }

        }catch(Exception e){
            System.out.println("Error : " + e);
        }
        return products;
    }

    public void bid(int id){
        try{
            PolyBayDatabase database = new PolyBayDatabase();
            String request = "UPDATE product SET bid = bid + 50 WHERE id = ?;";
            PreparedStatement statement = database.prepareStatement(request);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Bid +50");
        }catch(Exception e){
            System.out.println("Error : " + e);
        }
    }

}
