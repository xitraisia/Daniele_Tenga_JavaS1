package com.trilogyed.stwitter.feign;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "comment-service")
public interface CommentService {

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public Comment createComment(@RequestBody Comment comment);
}