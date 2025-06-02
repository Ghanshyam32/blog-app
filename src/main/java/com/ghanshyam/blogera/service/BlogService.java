package com.ghanshyam.blogera.service;

import com.ghanshyam.blogera.Repository.BlogRepository;
import com.ghanshyam.blogera.UnauthorizedAccessException;
import com.ghanshyam.blogera.blog.Blog;
import com.ghanshyam.blogera.dto.PostRequest;
import com.ghanshyam.blogera.dto.PostResponse;
import com.ghanshyam.blogera.user.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    private BlogRepository blogRepository;
    Long nextId = 1L;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Optional<Blog> getBlogById(long id) {
        return blogRepository.findById(id);
    }

    public void createBlog(PostRequest postRequest) {
        Blog blog = new Blog();
        blog.setTitle(postRequest.getTitle());
        blog.setContent(postRequest.getContent());

        AppUser user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        blog.setAuthor(user); //fetch actual user form JWT
        blogRepository.save(blog);
    }

    public List<PostResponse> getAllBlog() {
        return blogRepository.findAll().stream().map(blog -> {
            PostResponse response = new PostResponse();
            response.setId(blog.getId());
            response.setTitle(blog.getTitle());
            response.setContent(blog.getContent());
            response.setAuthorUsername(blog.getAuthor().getUsername());
            return response;
        }).toList();
    }

    public void deleteBlog(long id) {
        AppUser user = (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Blog blog = blogRepository.findById(id).orElseThrow(() -> new RuntimeException("Blog not found"));

        if (!blog.getAuthor().getUsername().equals(user.getUsername())) {
            throw new UnauthorizedAccessException("You're not allowed to delete the post!");
        }
        blogRepository.deleteById(id);
    }

    public boolean update(long id, Blog updatedBlog) {
        Optional<Blog> blog1 = blogRepository.findById(id);
        if (blog1.isPresent()) {
            Blog blog = blog1.get();
            blog.setTitle(updatedBlog.getTitle());
            blog.setContent(updatedBlog.getContent());
            blog.setAuthor(updatedBlog.getAuthor());
            blogRepository.save(blog);
            return true;
        }
        return false;
    }

}
