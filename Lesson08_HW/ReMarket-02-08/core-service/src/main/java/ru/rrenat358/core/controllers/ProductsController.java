package ru.rrenat358.core.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.rrenat358.api.core.ProductDto;
import ru.rrenat358.api.exceptions.ResourceNotFoundException;
import ru.rrenat358.core.converters.ProductConverter;
import ru.rrenat358.core.entities.Product;
import ru.rrenat358.core.services.ProductsService;
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


    @GetMapping
    public Page<ProductDto> findByFilter(
            @RequestParam(name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "titlePart", required = false) String titlePart,
            @RequestParam(name = "minPrice", required = false) Integer minPrice,
            @RequestParam(name = "maxPrice", required = false) Integer maxPrice,
            @RequestParam(name = "groupPart", required = false) String groupPart
    ) {
        if (page < 1) {
            page = 1;
        }
        return productsService.findByFilter(page, titlePart, minPrice, maxPrice, groupPart)
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
        productValidator.validate(productDto);
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
        productValidator.validate(productDto);
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
