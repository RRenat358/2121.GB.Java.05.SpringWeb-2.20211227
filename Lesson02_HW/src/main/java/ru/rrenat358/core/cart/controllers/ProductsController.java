package ru.rrenat358.core.cart.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.core.cart.converters.ProductConverter;
import ru.rrenat358.core.dto.ProductDto;
import ru.rrenat358.core.entities.Product;
import ru.rrenat358.core.cart.exceptions.ResourceNotFoundException;
import ru.rrenat358.core.cart.services.ProductsService;
import ru.rrenat358.core.validators.ProductValidator;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;
    private final ProductConverter productConverter;
    private final ProductValidator productValidator;



    //============================================================
    // GET

    // NoUsed
//    @GetMapping("")
//    public List<Product> findAll() {
//        return productsService.findAll();
//    }

    @GetMapping
    public Page<ProductDto> findByFilter(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "namePart", required = false) String namePart,
            @RequestParam(name = "minPrice", required = false) Integer minPrice,
            @RequestParam(name = "maxPrice", required = false) Integer maxPrice
    ) {
        if (page < 1) {
            page = 1;
        }
        return productsService.findByFilter(page, namePart, minPrice, maxPrice)
                .map(product -> productConverter.entityToDto(product));
    }


    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        Product product = productsService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Продукт не найден для ID : " + id));
        return productConverter.entityToDto(product);
    }


    //============================================================
    // POST

    @PostMapping
    public ProductDto saveNewProduct(@RequestBody ProductDto productDto) {
        productValidator.validator(productDto);
        Product product = productConverter.dtoToEntity(productDto);
        product = productsService.saveProduct(product);
        return productConverter.entityToDto(product);
    }

    //============================================================
    // PATCH

    @PatchMapping("/change-price-to-delta")
    public void changePriceToDelta(@RequestParam Long id, @RequestParam Integer delta) {
        productsService.changePriceToDelta(id, delta);
    }

    // NoUsed
    @PatchMapping("/change-price")
    public void changePrice(@RequestParam Long id, @RequestParam Integer newPrice) {
        productsService.changePrice(id, newPrice);
    }

    //============================================================
    // PUT

    //============================================================
    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        Product product = productConverter.dtoToEntity(productDto);
        product = productsService.updateProduct(product);
        return productConverter.entityToDto(product);
    }
    // OR --------------------
//    @PutMapping
//    public ProductDto updateProduct2(@RequestBody ProductDto productDto) {
//        productValidator.validate(productDto);
//        Product product = productsService.update(productDto);
//        return productConverter.entityToDto(product);
//    }
    //============================================================


    //============================================================
    // DELETE

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productsService.deleteById(id);
    }


}
