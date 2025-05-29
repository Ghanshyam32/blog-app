package com.ghanshyam.blogera.service;

import com.ghanshyam.blogera.Repository.BlogRepository;
import com.ghanshyam.blogera.blog.Blog;
import org.springframework.beans.factory.annotation.Autowired;
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

    public String postBlog(Blog blog) {
        blogRepository.save(blog);
        return "Your blog is successfully published!";
    }

    public List<Blog> getAllBlog() {
        return blogRepository.findAll();
    }

    public void deleteBlog(long id) {
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
