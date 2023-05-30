package co.edu.sena.project_2687365.model.repository;


import co.edu.sena.project_2687365.model.Product;
import co.edu.sena.project_2687365.util.connection_test.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpI implements Repository<Product>{

    private String sql = null;

    @Override
    public List<Product> listAllObj() throws SQLException {
        sql = "select p.id_Product, p.name_Producto, p.value_Product, p.id_Category " +
                "from Product p order by p.name_Producto, p.value_Product";
        List<Product> products = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Product p = createObj(rs);
                products.add(p);
            }
        }
        return products;
    }

    @Override
    public Product byIdObj(Integer id) throws SQLException {
        sql = "select p.id_Product, p.name_Producto, p.value_Product, p.id_Category " +
                "from Product p where p.id_Product = ?";
        Product product = null;

        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    product =createObj(rs);
                }
            }
        }
        return product;
    }

    @Override
    public Integer saveObj(Product product) throws SQLException {
        Integer rowsAffected = 0;

        if (product.getId_Product() != null && product.getId_Product() > 0) {
            sql = "update Product set name_Producto = ?, value_Product = ?, id_Category = ? " +
                    " where id_Product = ? ";
        } else {
            sql = "insert into Product (name_Producto, value_Product, id_Category) " +
                    "values(upper(?), upper(?), lower(?), ";
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product.getName_Product());
            ps.setString(2, product.getValue_Product());
            ps.setString(3, product.getId_Category());
            if (product.getId_Product() != null && product.getId_Product() > 0) {
                ps.setInt(4, product.getId_Product());
            }
            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }

    @Override
    public void deleteObj(Integer id) throws SQLException {
        sql = "delete from Product where id_Product = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Product createObj(ResultSet rs) throws SQLException {
        Product product = new Product(name_Product, value_Product);
        product.setId_Product(rs.getInt("id_Product"));
        product.setName_Product(rs.getString("name_Producto"));
        product.setValue_Product(rs.getFloat("value_Product"));
        product.setId_Category(rs.getInt("id_Category"));

        return product;
    }
}