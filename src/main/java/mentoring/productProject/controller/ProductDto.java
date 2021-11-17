package mentoring.productProject.controller;

import mentoring.productProject.resource.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductDto {

    private Integer id;
    private Integer sku;
    private String name;
    private String description;
    private Double price;
    private String category;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.sku = product.getSku();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.category = product.getCategory();

    }

    public static List<ProductDto> converter(List<Product> products) {
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public Integer getSku() {
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
