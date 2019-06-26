package io.rugvedmarathe.springbootvalidations.vo;

import lombok.Data;

@Data
public class GenericResponse {

    private String status;
    private Object data;
}
