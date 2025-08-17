package song.sj.dto.external_dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemInfoDto {

    private Long itemId;
    private String itemName;
    private String description;
    private int quantity;
    private List<String> itemImagesUrl;
}
