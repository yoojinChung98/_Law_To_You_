package com.example.demo.answer.entity;


import com.example.demo.consulting.entity.Consulting;
import com.example.demo.member.lawyer.entity.Lawyer;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@ToString(exclude = {"lawyer", "consulting"})
@EqualsAndHashCode(of = "answerNum")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerNum;

    @Column(nullable = false)
    @Builder.Default
    private int adopt = 0;

    @Column(nullable = false)
    private String shortAns;

    private String detailAns;

    @Column(nullable = false)
    private String writer;

    @CreationTimestamp
    private LocalDateTime regDate;

    @Column(nullable = false)
    private int reqHammer;

    // 작성자 - 변호사 이름 조회
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lawyer_id")
    private Lawyer lawyer;

    // 온라인 상담
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consult_num")
    private Consulting consulting;
    
    // 답변 첨부파일
    @Builder.Default
    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnswerFile> answerFiles = new ArrayList<>();

}