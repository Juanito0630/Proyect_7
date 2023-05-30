package co.edu.sena.project_2687365.model;

public class Category {
    private Integer id_Category;
    private String name_Category;

    public Category(String name_Category) {
    }

    public Category(int id_Category, String name_Category) {
        this.id_Category = id_Category;
        this.name_Category = name_Category;
    }

    public int getId_Category() {
        return id_Category;
    }
    public void setId_Category(int id_Category) {
        this.id_Category = id_Category;
    }
    public String getName_Category() {
        return name_Category;
    }
    public void setName_Category(String name_Category) {
        this.name_Category = name_Category;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id_Category=" + id_Category +
                ", name_Category='" + name_Category + '\'' +
                '}';
    }
}