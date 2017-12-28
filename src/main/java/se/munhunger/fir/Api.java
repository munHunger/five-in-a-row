package se.munhunger.fir;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import se.munhunger.fir.model.Board;
import se.munhunger.fir.model.ErrorMessage;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Marcus Münger
 */
@Path("/")
@io.swagger.annotations.Api(value = "Five in a row API")
public class Api {
    @POST
    @Path("/solve")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiOperation(value = "Solves the current board by adding a point")
    @ApiResponses({@ApiResponse(code = HttpServletResponse.SC_OK, message = "An updated board, where the server played the player with the least amount of points, or 'x' if even"),
                          @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "The input board was incorrect")})
    public Response solveBoard(@ApiParam(value = "The current board") Board board) {
        if(Math.abs(board.o.size() - board.x.size()) > 1)
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorMessage("Invalid board", "One player has 2 or more points than the other")).build();
        if(!board.isValid())
            return Response.status(Response.Status.BAD_REQUEST).entity(new ErrorMessage("Invalid board", "A point if outside the bounds of 0 and 25 inclusive")).build();
        Solver.solve(board);
        return Response.ok(board).build();
    }
}
