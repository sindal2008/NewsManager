package by.itsupportme.sindalouski.sampletask.repository;

import by.itsupportme.sindalouski.sampletask.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
}
