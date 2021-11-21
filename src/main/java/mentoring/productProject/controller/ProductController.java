package mentoring.productProject.controller;

import mentoring.productProject.controller.form.ProductForm;
import mentoring.productProject.controller.form.UpdadeProductForm;
import mentoring.productProject.repository.ProductRepository;
import mentoring.productProject.resource.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @ResponseBody
    @GetMapping
    public List<ProductDto> ProductList (){
        List<Product> products = productRepository.findAll();
        return ProductDto.converter(products);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ProductDto> registerProduct(@RequestBody @Valid ProductForm form, UriComponentsBuilder uriComponentsBuilder){
        Product product = form.converter();
        productRepository.save(product);

        URI uri = uriComponentsBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDto(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> detail (@PathVariable Integer id){
        Optional <Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(new ProductDto(product.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProductDto> update (@PathVariable Integer id, @RequestBody @Valid UpdadeProductForm form){
        Product product = form.update (id, productRepository);

        return ResponseEntity.ok(new ProductDto(product));
    }

    @DeleteMapping ("/{id}")
    @Transactional
    public ResponseEntity<?> remove (@PathVariable Integer id){
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
