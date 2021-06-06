package com.example.workshop.resources;

import com.example.workshop.domain.Post;
import com.example.workshop.domain.User;
import com.example.workshop.dto.UserDTO;
import com.example.workshop.resources.util.URL;
import com.example.workshop.services.PostService;
import com.example.workshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/posts")
public class PostResource {

    @Autowired
    private PostService service;

    //@RequestMapping(method = RequestMethod.GET )


    @GetMapping(value="/{id}" )
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value="/titlesearch" )
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text",defaultValue = "")String text){
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }







}
