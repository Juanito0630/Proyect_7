package co.edu.sena.project_2687365.servlets;

import co.edu.sena.project_2687365.model.Product;
import co.edu.sena.project_2687365.model.User;
import co.edu.sena.project_2687365.model.repository.ProductRepositoryImpI;
import co.edu.sena.project_2687365.model.repository.Repository;
import co.edu.sena.project_2687365.model.repository.UseRepositoryImpI;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class ProductRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String name_Product=request.getParameter("name_Product");
        Float value_Product= Float.valueOf(request.getParameter("value_Product"));

        Product product=new Product(name_Product, value_Product);
        //call Repository layer and save the user object to DB
        Repository<Product> repository= new ProductRepositoryImpI();
        int rows=0;
        try {
            rows=repository.saveObj(product);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // prepare an information message for User about success or failure of the operation
        String infoMessage= null;
        if(rows==0){
            System.out.println("Ocurrio Un Error");
        }else {
            System.out.println("Regitro Exitoso");
        }
    }
}