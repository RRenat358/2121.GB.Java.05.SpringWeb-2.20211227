package ru.rrenat358.core.validators;

import org.springframework.stereotype.Component;
import ru.rrenat358.core.ProductDto;
import ru.rrenat358.core.cart.exceptions.FieldValidationException;

import java.util.ArrayList;
import java.util.List;


@Component
public class ProductValidator {

    public void validator(ProductDto productDto) {

        List<String> errorMessages = new ArrayList<>();

        if (productDto.getName().trim().isEmpty()) {
            errorMessages.add("Имя отсутствует !!!");
        }
        if (productDto.getPrice() < 0) {
            errorMessages.add("Цена < 0 !!!");
        }


        if (!errorMessages.isEmpty()) {
            throw new FieldValidationException(errorMessages);
        }


    }



}
