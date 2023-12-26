package com.example.demo.freeboard.dto.request;


import com.example.demo.freeboard.entity.Freeboard;
import com.example.demo.freeboard.entity.FreeboardFile;
import com.example.demo.member.user.entity.User;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreeboardCreateRequestDTO {

    @NotBlank
    private String title;

    @NotBlank
    private String content;



    public Freeboard toEntity(User user) {
        return Freeboard.builder()
                .writer(user.getNickname())
                .content(this.content)
                .title(this.title)
                .user(user)
                .build();
    }

}
