package com.myshop.yura.service;

import com.myshop.yura.DAO.CommentsDAO;
import com.myshop.yura.entity.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsDAO commentsDAO;

    @Transactional
    public void addComment(Comments comment) {
        commentsDAO.addComment(comment);
    }

    @Transactional
    public void removeComment(long id) {
        commentsDAO.removeComment(id);
    }

    @Transactional
    public List<Comments> getByLotName(String lot_name) {
        return commentsDAO.getByLotName(lot_name);
    }
}
