package mentoring.productProject.controller;

import mentoring.productProject.controller.form.ProductForm;
import mentoring.productProject.controller.form.UpdadeProductForm;
import mentoring.productProject.repository.ProductRepository;
import mentoring.productProject.resource.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    //Listagem de Produtos
    @ResponseBody
    @GetMapping
    @Cacheable(value = "productList")
    public Page<ProductDto> ProductList (@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable pageable){

        Page<Product> products = productRepository.findAll(pageable);
        return ProductDto.converter(products);
    }

    //Cadastro
    @PostMapping
    @Transactional
    @CacheEvict(value = "productList",allEntries = true)
    public ResponseEntity<ProductDto> registerProduct(@RequestBody @Valid ProductForm form, UriComponentsBuilder uriComponentsBuilder){
        Product product = form.converter();
        productRepository.save(product);

        URI uri = uriComponentsBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDto(product));
    }

    //Buscar Detalhes
    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> detail (@PathVariable Integer id){
        Optional <Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(new ProductDto(product.get()));
        }
        return ResponseEntity.notFound().build();
    }

    //Atualiar
    @PutMapping("/{id}")
    @Transactional
    @CacheEvict(value = "productList",allEntries = true)
    public ResponseEntity<ProductDto> update (@PathVariable Integer id, @RequestBody @Valid UpdadeProductForm form){
        Product product = form.update (id, productRepository);

        return ResponseEntity.ok(new ProductDto(product));
    }

    //Deletar
    @DeleteMapping ("/{id}")
    @Transactional
    @CacheEvict(value = "productList",allEntries = true)
    public ResponseEntity<?> delete (@PathVariable Integer id){
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
