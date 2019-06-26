package io.rugvedmarathe.springbootvalidations.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
class ErrorResponse {
    private String source;
    private String detailedMessage;
}
