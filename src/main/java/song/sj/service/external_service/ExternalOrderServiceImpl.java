package song.sj.service.external_service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import song.sj.dto.Result;
import song.sj.dto.external_dto.ItemInfoDto;
import song.sj.dto.feign_dto.ItemCategoryDto;
import song.sj.dto.external_dto.ItemVerificationDto;
import song.sj.entity.ItemCategory;
import song.sj.entity.item.Item;
import song.sj.repository.ItemCategoryRepository;
import song.sj.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ExternalOrderServiceImpl implements ExternalOrderService {

    private static final Logger log = LoggerFactory.getLogger(ExternalOrderServiceImpl.class);
    private final ItemCategoryRepository itemCategoryRepository;
    private final ItemRepository itemRepository;

    @Override
    public Result<List<ItemCategoryDto>> getItemCategoryNameList(List<String> itemCategoryName) {

        List<ItemCategoryDto> itemCategoryDtoList = itemCategoryName.stream().map(n -> {
            ItemCategory itemCategory = itemCategoryRepository.findByItemCategoryName(n);
            return ItemCategoryDto.builder()
                    .itemCategoryId(itemCategory.getId())
                    .itemCategoryName(itemCategory.getItemCategoryName())
                    .build();
        }).toList();

        return new Result<>(itemCategoryDtoList.size(), itemCategoryDtoList);
    }

    @Override
    public void verificationItem(List<ItemVerificationDto> itemVerificationDtoList) {

        for (ItemVerificationDto itemVerificationDto : itemVerificationDtoList) {

            Item item = itemRepository.findById(itemVerificationDto.getItemId()).orElseThrow(() ->
                    new IllegalArgumentException("존재하지 않는 상품입니다.")
            );

            if (itemVerificationDto.getQuantity() > item.getQuantity()) {
                throw new IllegalArgumentException("등록하신 수량 보다 요청 수량이 초과하였습니다.");
            }
        }
    }

    @Override
    public Result<List<ItemInfoDto>> getItemInfo(List<ItemVerificationDto> itemVerificationDtoList) {

        List<ItemInfoDto> itemInfoDtoList = new ArrayList<>();

        verificationItem(itemVerificationDtoList);

        for (ItemVerificationDto item : itemVerificationDtoList) {
            Item findItem = itemRepository.findById(item.getItemId()).orElseThrow();
            itemInfoDtoList.add(new ItemInfoDto(findItem.getId(), findItem.getItemName(),
                    findItem.getDescription(),
                    item.getQuantity(), null));
            log.info("아이디 = {} 아이템 이름 = {}, 수량 = {}", findItem.getId(), findItem.getItemName(), item.getQuantity());
        }

        return new Result<>(itemInfoDtoList.size(), itemInfoDtoList);
    }
}
