package ru.rrenat358.core.converters;

import org.springframework.stereotype.Component;
import ru.rrenat358.api.core.ProductDto;
import ru.rrenat358.core.entities.Product;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {

    //============================================================
    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice());
    }

    //============================================================
    public List<Product> dtoToEntityList(List<ProductDto> productDtoList) {
        List<Product> productList = productDtoList
                .stream()
                .map(productDto -> {
                    Product product = new Product();
                    product.setId(productDto.getId());
                    product.setTitle(productDto.getTitle());
                    product.setPrice(productDto.getPrice());
                    return product;
                })
                .collect(Collectors.toList());
        return productList;
    }

    public List<ProductDto> entityToDtoList(List<Product> productList) {
        List<ProductDto> productDtoList = productList
                .stream()
                .map(product -> {
                    ProductDto productDto = new ProductDto();
                    productDto.setId(product.getId());
                    productDto.setTitle(product.getTitle());
                    productDto.setPrice(product.getPrice());
                    return productDto;
                })
                .collect(Collectors.toList());
        return productDtoList;
    }

    //============================================================


}
