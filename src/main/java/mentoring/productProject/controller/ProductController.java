package mentoring.productProject.controller;

import mentoring.productProject.resource.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @RequestMapping("/product")
    @ResponseBody
    public List<ProductDto> ProductList (){
     Product product = new Product(15,521,"Carro", "Honda Civic",25000.90,"Automovel");

     return ProductDto.converter(Arrays.asList(product,product,product));
    }

}
