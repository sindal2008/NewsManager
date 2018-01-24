package by.itsupportme.sindalouski.sampletask.service;


import by.itsupportme.sindalouski.sampletask.dto.CommentDto;
import by.itsupportme.sindalouski.sampletask.entity.Comment;
import by.itsupportme.sindalouski.sampletask.repository.CommentRepository;
import by.itsupportme.sindalouski.sampletask.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;
    private ItemRepository itemRepository;


    public CommentServiceImpl(CommentRepository commentRepository,
                              ItemRepository itemRepository) {
        this.commentRepository = commentRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public void addComment(CommentDto commentDto) {

        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setItem(itemRepository.findOne(commentDto.getItemId()));
        comment.setCreateDate(LocalDateTime.now());
        commentRepository.save(comment);
    }
}
