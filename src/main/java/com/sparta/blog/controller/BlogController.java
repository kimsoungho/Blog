package com.sparta.blog.controller;

import com.sparta.blog.domain.Blog;
import com.sparta.blog.domain.BlogRepository;
import com.sparta.blog.domain.BlogRequestDto;
import com.sparta.blog.domain.PasswordDto;
import com.sparta.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogController {

    private final BlogRepository BlogRepository;
    private final BlogService BlogService;


    @GetMapping("/api/blog")
    public List<Blog> getBlog() {
        return BlogRepository.findAllByOrderByModifiedAtDesc();
    }

    @PostMapping("/api/blog")
    public Blog createMemo(@RequestBody BlogRequestDto requestDto) {
        Blog blog = new Blog(requestDto);
        return BlogRepository.save(blog);
    }

    @DeleteMapping("/api/blog/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        BlogRepository.deleteById(id);
        return id;
    }
    @PostMapping
    public boolean check(@PathVariable Long id, @RequestBody PasswordDto passwordDto) {
        return BlogService.check(id, passwordDto.getPassword());
    }
}
