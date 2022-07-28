package com.sparta.blog.service;

import com.sparta.blog.domain.Blog;
import com.sparta.blog.domain.BlogRepository;
import com.sparta.blog.domain.BlogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional
    public Long update(Long id, BlogRequestDto requestDto) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("no,id")
        );
        blog.update(requestDto);
        return blog.getId();
    }
    public boolean check(Long id,int password){
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("no,id")
        );
        int savepassword = blog.getPassword();
        return Objects.equals(savepassword, password);
    }
}