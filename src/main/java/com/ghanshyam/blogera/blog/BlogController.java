package com.ghanshyam.blogera.blog;

import com.ghanshyam.blogera.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BlogController {

    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public List<Blog> findAll() {
        return blogService.getAllBlog();
    }

    @GetMapping("/blogs/{id}")
    public Optional<Blog> getBlog(@PathVariable long id) {
        return blogService.getBlogById(id);
    }

    @PostMapping("/blogs/post")
    public ResponseEntity<Blog> postBlog(@RequestBody Blog blog) {
        blogService.postBlog(blog);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @DeleteMapping("/blogs/delete/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable long id) {
        blogService.deleteBlog(id);
        return new ResponseEntity<>("Blog is deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/blogs/update/{id}")
    public ResponseEntity<String> updateBlog(@PathVariable long id, @RequestBody Blog blog) {
        boolean blogUpdated = blogService.update(id, blog);
        if (blogUpdated) {
            return new ResponseEntity<>("Your blog is successfully updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job not found", HttpStatus.NOT_FOUND);

    }
}
