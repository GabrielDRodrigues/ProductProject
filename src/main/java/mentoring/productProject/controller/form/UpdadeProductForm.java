package mentoring.productProject.controller.form;

import mentoring.productProject.repository.ProductRepository;
import mentoring.productProject.resource.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdadeProductForm {

    @NotEmpty
    @NotNull
    private String description;
    private Double price;

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

    public Product update(Integer id, ProductRepository productRepository) {
        Product product = productRepository.getById(id);
        product.getPrice(this.price);
        product.getDescription(this.description);

        return product;
    }
}
