package song.sj.dto.feign_dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemCategoryDto {

    private Long itemCategoryId;
    private String itemCategoryName;
}
