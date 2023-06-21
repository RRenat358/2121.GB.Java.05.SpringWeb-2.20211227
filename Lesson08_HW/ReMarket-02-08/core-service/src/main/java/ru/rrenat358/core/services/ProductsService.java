package ru.rrenat358.core.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.rrenat358.api.exceptions.ResourceNotFoundException;
import ru.rrenat358.core.entities.Product;
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
            String titlePart,
            Integer minPrice, Integer maxPrice,
            String groupPart
    ) {
        PageRequest pageRequest = PageRequest.of(page - 1, 5);
        Specification<Product> spec = Specification.where(null);

        if (titlePart != null) {
            spec = spec.and(ProductsSpecifications.titleLike(titlePart));
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
        productFind.setTitle(product.getTitle());
        productFind.setPrice(product.getPrice());
        //etc.
        productsRepository.save(productFind); //?? точно нужно
        return productFind;
    }


    //============================================================


}
