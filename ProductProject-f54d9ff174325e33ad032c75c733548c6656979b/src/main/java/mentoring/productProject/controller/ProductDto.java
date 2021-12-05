package mentoring.productProject.controller;

import mentoring.productProject.resource.Product;
import org.springframework.data.domain.Page;

public class ProductDto {

    private Integer id;
    private String sku;
    private String name;
    private String description;
    private Double price;
    private String category;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.sku = product.getSku();
        this.name = product.getName();
        this.description = product.getDescription(this.description);
        this.price = product.getPrice(this.price);
        this.category = product.getCategory();

    }

    public static Page<ProductDto> converter(Page<Product> products) {
        return products.map(ProductDto::new);
    }

    public Integer getId() {
        return id;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
