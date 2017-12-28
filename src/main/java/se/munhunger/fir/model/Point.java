package se.munhunger.fir.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Marcus Münger
 */
@ApiModel(description = "A point on the board")
public class Point {
    @ApiModelProperty(value = "The x co-ordinate of the point. This should be between 0 and 25 inclusive")
    public int x;
    @ApiModelProperty(value = "The y co-ordinate of the point. This should be between 0 and 25 inclusive")
    public int y;

    public Point(){}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @JsonIgnore
    public boolean isValid() {
        return x >= 0 && x <= 25 && y >= 0 && y <= 25;
    }
}
