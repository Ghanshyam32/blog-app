package com.ghanshyam.blogera.Repository;

import com.ghanshyam.blogera.blog.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {
}
