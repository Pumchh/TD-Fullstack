package controllers;

import java.util.ArrayList;

import dao.ProductsDAO;
import models.Product;
import webserver.WebServerContext;
import webserver.WebServerResponse;

public class ProductsController {
    public static ArrayList<Product> findAll(WebServerContext context){
        
        ArrayList<Product> products = new ArrayList<Product>();

        try{
            WebServerResponse response = context.getResponse();            
            ProductsDAO productsDAO = new ProductsDAO();

            products = productsDAO.findAll();

            response.json(products);
            response.ok("Tous les produits");

        }catch(Exception e){
            System.out.println("Error : " + e);
        }

        return products;
    }

    public static void bid(WebServerContext context){
        try{
            ProductsDAO productsDAO = new ProductsDAO();
            String idTemp = context.getRequest().getParam("productID");
            int id = Integer.valueOf(idTemp);
            productsDAO.bid(id);

            context.getResponse().ok("200");

        }catch(Exception e){
            System.out.println("Error : " + e);
            context.getResponse().serverError("500");
        }
    }
}
