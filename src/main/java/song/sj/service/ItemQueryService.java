package song.sj.service;

import song.sj.dto.Result;
import song.sj.dto.item.FindItemDto;
import song.sj.dto.item.ImageDto;
import song.sj.dto.item.ItemSearchConditionDto;
import song.sj.dto.item.SearchItemDto;

import java.util.List;

public interface ItemQueryService {

    Result<List<SearchItemDto>> searchItems(ItemSearchConditionDto dto);

    FindItemDto findItem(Long id);

    Result<List<ImageDto>> findItemImage(Long id);
}
