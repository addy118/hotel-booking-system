package com.hotelbooking.Controller;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbooking.Entity.Hotels;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

	
	@Operation(summary = "Get list of hotels (Ordered by rating in ascending order)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation",
                    content = { @Content(mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Invalid parameters supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error",
                    content = @Content)})
	@GetMapping(value = "/{cityName}", produces = { "application/json" })
    public ResponseEntity<String> getHotels(@Parameter(description = "city name to filter the list of hotels")  @PathVariable String cityName) {

        return new ResponseEntity<String>("Hello",HttpStatus.OK);
    }
	
//    @Operation(summary = "Create a new Hotel")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "201", description = "Hotel created",
//                    content = { @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = Hotels.class)) }),
//            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
//                    content = @Content),
//            @ApiResponse(responseCode = "404", description = "notebook not found",
//                    content = @Content),
//            @ApiResponse(responseCode = "500", description = "Internal Error",
//                    content = @Content),
//            @ApiResponse(responseCode = "409", description = "Duplicate hotel name",
//                    content = @Content) })
//    @PostMapping
//    public ResponseEntity<EntityModel<Hotels>> createnotebook(@RequestBody Hotels hotels){
//    	
//    }
//    
//    @Operation(summary = "Update a notebook by its id")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "202", description = "notebook updated",
//                    content = { @Content(mediaType = "application/json",
//                            schema = @Schema(implementation = NoteBook.class)) }),
//            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
//                    content = @Content),
//            @ApiResponse(responseCode = "404", description = "notebook not found",
//                    content = @Content),
//            @ApiResponse(responseCode = "500", description = "Internal Error",
//                    content = @Content),
//            @ApiResponse(responseCode = "409", description = "Duplicate notebook name",
//                    content = @Content) })
//    @PatchMapping(value = "/{notebookId}", produces = { "application/json" })
//    public ResponseEntity<EntityModel<NoteBook>> updatenotebook(@Parameter(description = "id of notebook to be updated")  @PathVariable int notebookId, @Parameter(description = "notebook updated information")  @RequestBody NoteBook notebook){
//
//        // Update notebook in the database
//        NoteBook storednotebook = noteBookService.updatenotebook(notebookId,notebook);
//
//        // Check whether the notebook exist and is updated or not
//        if(storednotebook!=null) {
//            // selfLink to api that retrieves the notebook according to HATEOS
//            Link recordSelfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NoteBookController.class)
//                    .getnotebookById(notebook.getID())).withSelfRel();
//            notebook.add(recordSelfLink);
//            // Send updated notebook with 202 status code to client
//            return new ResponseEntity(EntityModel.of(storednotebook), HttpStatus.ACCEPTED);
//        }
//
//        // If no notebook is found send 404 status code as response
//        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
//    }
//
//    // DELETE/api/notebooks/1 (delete a single notebook)
//    @Operation(summary = "Delete a notebook by its id")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "202", description = "notebook deleted",
//                    content = @Content),
//            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
//                    content = @Content),
//            @ApiResponse(responseCode = "404", description = "notebook not found",
//                    content = @Content),
//            @ApiResponse(responseCode = "500", description = "Internal Error",
//                    content = @Content) })
//    @DeleteMapping(value = "/{notebookId}")
//    public ResponseEntity<EntityModel<NoteBook>> deletenotebook(@Parameter(description = "id of notebook to be deleted")  @PathVariable int notebookId){
//
//        // Delete the notebook by its Id and check for the result
//        if(noteBookService.deletenotebook(notebookId))
//            // Sent empty response with 202 status code
//            return new ResponseEntity(null, HttpStatus.ACCEPTED);
//        else
//            // If no notebook is found send 404 status code as response
//            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
//    }
}
