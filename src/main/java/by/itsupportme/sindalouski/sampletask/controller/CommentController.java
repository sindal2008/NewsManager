package by.itsupportme.sindalouski.sampletask.controller;

import by.itsupportme.sindalouski.sampletask.dto.CommentDto;
import by.itsupportme.sindalouski.sampletask.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller

@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    // accepts only JSON
    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    // always return the status of OK
    @ResponseStatus(HttpStatus.OK)
    public void add( /* the form comes in the body of the POST request */  @RequestBody CommentDto commentDto) {
        commentService.addComment(commentDto);
    }
}
