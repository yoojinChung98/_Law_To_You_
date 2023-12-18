package com.example.demo.freeboard.dto.response;

import com.example.demo.freeboard.entity.Freeboard;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreeListResponseDTO {

    private int count;
    private PageResponseDTO pageInfo;
    private List<FreeboardDetailResponseDTO> freeboards;
}
