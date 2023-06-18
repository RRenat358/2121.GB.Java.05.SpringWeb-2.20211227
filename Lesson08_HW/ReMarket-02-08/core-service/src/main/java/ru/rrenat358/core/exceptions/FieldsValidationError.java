package ru.rrenat358.core.exceptions;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class FieldsValidationError {

    private List<String> fieldsValidationErrorMessage;

    public FieldsValidationError(List<String> fieldsValidationErrorMessage) {
        this.fieldsValidationErrorMessage = fieldsValidationErrorMessage;
    }

}
