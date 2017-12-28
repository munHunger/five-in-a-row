package se.munhunger.fir.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Marcus Münger
 */
@ApiModel(description = "A description of an error")
public class ErrorMessage {
    @ApiModelProperty(value = "The short description of the error")
    public String error;
    @ApiModelProperty(value = "A more detailed description of the error")
    public String message;

    public ErrorMessage(){}

    public ErrorMessage(String error, String message) {
        this.error = error;
        this.message = message;
    }
}
