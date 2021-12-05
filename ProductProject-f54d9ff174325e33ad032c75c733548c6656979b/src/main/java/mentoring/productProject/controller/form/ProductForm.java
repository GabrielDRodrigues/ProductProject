package mentoring.productProject.controller.form;

import mentoring.productProject.resource.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductForm {


    private String sku;
    @NotEmpty @NotNull
    private String name;
    @NotEmpty @NotNull
    private String description;
    private Double price;
    @NotEmpty @NotNull
    private String category;

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

    public Product converter() {
        return new Product(sku, name, description, price, category);
    }
}
