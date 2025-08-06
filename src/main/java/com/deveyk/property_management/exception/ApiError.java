package com.deveyk.property_management.exception;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<T> {

    private String id;

    private Date errorTime;

   // private Map<String, List<String>> errors;

    private T errors;

}
