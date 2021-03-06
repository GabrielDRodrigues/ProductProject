package mentoring.productProject.resource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String sku;
    private String name;
    private String description;
    private Double price;
    private String category;

    public Product(Integer id, String sku, String name, String description, Double price, String category) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product(String sku, String name, String description, Double price, String category) {
        this.sku = sku;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription(@NotEmpty @NotNull String description) {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice(Double price) {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", sku=" + sku +
                ", nome='" + name + '\'' +
                ", descri????o='" + description + '\'' +
                ", pre??o=" + price +
                ", categoria='" + category + '\'' +
                '}';
    }


}
