package mentoring.productProject.resource;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer sku;
    private String name;
    private String description;
    private Double price;
    private String category;

    public Product(Integer id, Integer sku, String name, String description, Double price, String category) {
        this.id = id;
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

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
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
                ", descrição='" + description + '\'' +
                ", preço=" + price +
                ", categoria='" + category + '\'' +
                '}';
    }


}
