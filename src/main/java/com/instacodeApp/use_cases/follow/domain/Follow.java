package com.instacodeApp.use_cases.follow.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "follow")
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "followerUserName", nullable = false)
    private String followerUserName;

    @Column(name = "followedUserName", nullable = false)
    private String followedUserName;
}
