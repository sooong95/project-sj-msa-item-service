package song.sj.controller.external_controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import song.sj.dto.Result;
import song.sj.dto.external_dto.ItemVerificationDto;
import song.sj.service.external_service.ExternalOrderService;

import java.util.List;

@RestController
@RequestMapping("/external")
@RequiredArgsConstructor
public class ExternalOrderController {

    private final ExternalOrderService itemFeignService;

    @PostMapping("/item-category-name")
    public Result<?> getItemCategoryNameList(@RequestBody List<String> itemCategoryNameList) {
        return itemFeignService.getItemCategoryNameList(itemCategoryNameList);
    }

    @PostMapping("/item-verification")
    public ResponseEntity<Void> verificationItem(@RequestBody List<ItemVerificationDto> itemVerificationDtoList) {

        itemFeignService.verificationItem(itemVerificationDtoList);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/item-info")
    public Result<?> getItemInfo(@RequestBody List<ItemVerificationDto> itemVerificationDtoList) {
        return itemFeignService.getItemInfo(itemVerificationDtoList);
    }
}
