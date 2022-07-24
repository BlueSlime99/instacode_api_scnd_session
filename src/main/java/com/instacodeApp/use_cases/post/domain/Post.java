package com.instacodeApp.use_cases.post.domain;

import com.instacodeApp.use_cases.comment.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "caption", nullable = false)
    private String caption;

    @Column(name = "code", nullable = false, length = 65555)
    private String code;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "likes")
    private int likeCount;

    @OneToMany(mappedBy = "post")
    private Set<Comment> comments = new HashSet<>();
}
