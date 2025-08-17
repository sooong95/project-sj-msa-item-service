package song.sj;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import song.sj.entity.ItemCategory;
import song.sj.entity.item.Bottom;
import song.sj.entity.item.Item;
import song.sj.entity.item.Outer;
import song.sj.entity.item.Top;
import song.sj.repository.ItemCategoryRepository;
import song.sj.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitialDataLoader implements CommandLineRunner {

    private final ItemCategoryRepository itemCategoryRepository;
    private final ItemRepository itemRepository;

    @Override
    public void run(String... args) throws Exception {

        if (itemCategoryRepository.findByItemCategoryName("ACCESSORY") == null) {
            itemCategoryRepository.save(ItemCategory.builder()
                    .itemCategoryName("ACCESSORY")
                    .build());
        }
        if (itemCategoryRepository.findByItemCategoryName("BAG") == null) {
            itemCategoryRepository.save(ItemCategory.builder()
                    .itemCategoryName("BAG")
                    .build());
        }if (itemCategoryRepository.findByItemCategoryName("BOTTOM") == null) {
            itemCategoryRepository.save(ItemCategory.builder()
                    .itemCategoryName("BOTTOM")
                    .build());
        }if (itemCategoryRepository.findByItemCategoryName("ETC") == null) {
            itemCategoryRepository.save(ItemCategory.builder()
                    .itemCategoryName("ETC")
                    .build());
        }if (itemCategoryRepository.findByItemCategoryName("OUTER") == null) {
            itemCategoryRepository.save(ItemCategory.builder()
                    .itemCategoryName("OUTER")
                    .build());
        }
        if (itemCategoryRepository.findByItemCategoryName("SHOES") == null) {
            itemCategoryRepository.save(ItemCategory.builder()
                    .itemCategoryName("SHOES")
                    .build());
        }
        if (itemCategoryRepository.findByItemCategoryName("TOP") == null) {
            itemCategoryRepository.save(ItemCategory.builder()
                    .itemCategoryName("TOP")
                    .build());
        }

        if (itemRepository.findByItemName("유니폼") == null) {
            ItemCategory itemCategory = itemCategoryRepository.findByItemCategoryName("TOP");
            Top top = Top.builder().build();
            top.changeItemName("유니폼");
            top.changeDescription("단체 유니폼");
            top.changeSize(110);
            top.changeDesign("디자인");
            top.changeMaterial("천");
            top.changeItemCategory(itemCategory);
            top.changeQuantity(10);
            top.addMember(1L);
            itemRepository.save(top);
        }

        if (itemRepository.findByItemName("청바지") == null) {
            ItemCategory itemCategory = itemCategoryRepository.findByItemCategoryName("BOTTOM");
            Bottom bottom = Bottom.builder().build();
            bottom.changeItemName("청바지");
            bottom.changeDescription("하늘색 청바지");
            bottom.changeSize(110);
            bottom.changeDesign("디자인");
            bottom.changeMaterial("청바지");
            bottom.changeItemCategory(itemCategory);
            bottom.changeQuantity(2);
            bottom.addMember(1L);
            itemRepository.save(bottom);
        }

        if (itemRepository.findByItemName("코트") == null) {
            ItemCategory itemCategory = itemCategoryRepository.findByItemCategoryName("OUTER");
            Outer outer = Outer.builder().build();
            outer.changeItemName("코트");
            outer.changeDescription("파란색 코트");
            outer.changeSize(110);
            outer.changeDesign("디자인");
            outer.changeMaterial("캐시미어");
            outer.changeItemCategory(itemCategory);
            outer.changeQuantity(1);
            outer.addMember(1L);
            itemRepository.save(outer);
        }
    }
}
