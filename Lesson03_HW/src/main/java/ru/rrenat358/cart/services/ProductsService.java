package ru.rrenat358.cart.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.rrenat358.core.dto.ProductDto;
import ru.rrenat358.core.entities.Product;
import ru.rrenat358.cart.exceptions.ResourceNotFoundException;
import ru.rrenat358.core.repositories.ProductsRepository;
import ru.rrenat358.core.repositories.specifications.ProductsSpecifications;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductsService {

    private final ProductsRepository productsRepository;


    public Page<Product> findByFilter(
            Integer page,
            String namePart,
            Integer minPrice, Integer maxPrice,
            String groupPart
    ) {
        PageRequest pageRequest = PageRequest.of(page - 1, 5);
        Specification<Product> spec = Specification.where(null);

        if (namePart != null) {
            spec = spec.and(ProductsSpecifications.nameLike(namePart));
        }
        if (minPrice != null) {
            spec = spec.and(ProductsSpecifications.priceGreaterOrEqualsThan(minPrice));
        }
        if (maxPrice != null) {
            spec = spec.and(ProductsSpecifications.priceLessThanOrEqualsThan(maxPrice));
        }
        if (groupPart != null) {
            spec = spec.and(ProductsSpecifications.groupLike(groupPart));
        }

//        log.info("--- findByFilter -------------------");
        return productsRepository.findAll(spec, pageRequest);
    }


    // NoUsed
    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productsRepository.findById(id);
    }

    @Transactional
    public void changePriceToDelta(Long id, Integer delta) {
        productsRepository.changePriceToDelta(id, delta);
    }

    // NoUsed
    @Transactional
    public void changePrice(Long id, Integer newPrice) {
        productsRepository.changePrice(id, newPrice);
    }

    public Product saveProduct(Product product) {
        return productsRepository.save(product);
    }

    public void deleteById(Long id) {
        productsRepository.deleteById(id);
    }


    //============================================================
    @Transactional
    public Product updateProduct(Product product) {
        Product productFind = productsRepository.findById(product.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Продукт не найден для ID : " + product.getId()));
        productFind.setName(product.getName());
        productFind.setPrice(product.getPrice());
        //etc.
        productsRepository.save(productFind);
        return productFind;
    }

    // OR ------------------
    @Transactional
    public Product updateProduct2(ProductDto productDto) {
        Product product = productsRepository.findById(productDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Невозможно обновить продукта, не найден в базе, id: " + productDto.getId()));
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        return product;
    }
    //============================================================


}
