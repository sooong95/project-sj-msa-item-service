package song.sj.service.external_service;

import song.sj.dto.Result;
import song.sj.dto.external_dto.ItemInfoDto;
import song.sj.dto.feign_dto.ItemCategoryDto;
import song.sj.dto.external_dto.ItemVerificationDto;

import java.util.List;

public interface ExternalOrderService {

    Result<List<ItemCategoryDto>> getItemCategoryNameList(List<String> itemCategoryName);

    void verificationItem(List<ItemVerificationDto> itemVerificationDtoList);

    Result<List<ItemInfoDto>> getItemInfo(List<ItemVerificationDto> itemVerificationDtoList);
}
