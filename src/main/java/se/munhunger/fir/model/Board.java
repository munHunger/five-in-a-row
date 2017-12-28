package se.munhunger.fir.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcus Münger
 */
@ApiModel(description = "A representation of the board")
public class Board {
    @ApiModelProperty(value = "All points laid óut by player 'x'")
    public List<Point> x = new ArrayList<>();
    @ApiModelProperty(value = "All points laid óut by player 'o'")
    public List<Point> o = new ArrayList<>();

    @JsonIgnore
    public int[][] board = new int[25][25];

    public void initArray() {
        for (Point p : x)
            board[p.x][p.y] = 1;
        for (Point p : o)
            board[p.x][p.y] = -1;
    }

    @JsonIgnore
    public boolean isValid(){
        for(Point p : x)
            if(!p.isValid())
                return false;
        for(Point p : o)
            if(!p.isValid())
                return false;
        return true;
    }
}
