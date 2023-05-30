package co.edu.sena.project_2687365.model;

public class Product {
    private Integer id_Product;
    private String name_Product;
    private Float value_Product;
    private Integer id_Category;

    public Product(String name_Product, Float value_Product) {
    }

    public Product(Integer id_Product, String name_Product, Float value_Product, Integer id_Category) {
        this.id_Product = id_Product;
        this.name_Product = name_Product;
        this.value_Product = value_Product;
        this.id_Category = id_Category;
    }

    public Integer getId_Product() {
        return id_Product;
    }

    public void setId_Product(Integer id_Product) {
        this.id_Product = id_Product;
    }

    public String getName_Product() {
        return name_Product;
    }

    public void setName_Product(String name_Product) {
        this.name_Product = name_Product;
    }

    public Float getValue_Product() {
        return value_Product;
    }

    public void setValue_Product(Float value_Product) {
        this.value_Product = value_Product;
    }

    public Integer getId_Category() {
        return id_Category;
    }

    public void setId_Category(Integer id_Category) {
        this.id_Category = id_Category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id_Product=" + id_Product +
                ", name_Product='" + name_Product + '\'' +
                ", value_Product=" + value_Product +
                ", id_Category=" + id_Category +
                '}';
    }
}
