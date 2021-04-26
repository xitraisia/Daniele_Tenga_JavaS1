package com.trilogyed.commentqueueconsumer;

import com.trilogyed.commentqueueconsumer.comments.Comment;
import com.trilogyed.commentqueueconsumer.feign.CommentService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentListener {

    @Autowired
    private CommentService client;

    public CommentListener(CommentService client) {
        this.client = client;
    }

    @RabbitListener(queues = CommentQueueConsumerApplication.QUEUE_NAME)
    public void receiveComment(Comment comment) {
        //Feign Client is used here, if checks have to be refined
        if (comment.getCommentId() != 0) {
            client.createComment(comment);
        }
    }

}
