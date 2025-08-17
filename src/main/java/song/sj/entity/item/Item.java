package song.sj.entity.item;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.util.StringUtils;
import song.sj.TimeStamp;
import song.sj.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public abstract class Item extends TimeStamp {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "item_id")
    private Long id;

    private String itemName;
    private String material;
    private int size;
    private int quantity;
    private String design;
    private String description;

    private Long memberId;

    @JoinColumn(name = "item_category_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ItemCategory itemCategory;

    @OneToMany(mappedBy = "item")
    private List<ItemImages> itemImages = new ArrayList<>();

    private Long orderItemId;

    private List<Long> itemBillIdList = new ArrayList<>();

    public void addItemCategory(ItemCategory itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void addImage(ItemImages images) {
        if (Objects.nonNull(images)) {
            this.itemImages.add(images);
            images.controlItem(this);
        }
    }

    public void deleteImage(ItemImages images) {
        if (Objects.nonNull(images)) {
            this.itemImages.remove(images);
            images.controlItem(this);
        }
    }

    public void addMember(Long memberId) {
        if (Objects.nonNull(memberId)) this.memberId = memberId;
    }

    public void changeQuantity(int quantity) {

        this.quantity += quantity;

        if (this.quantity <= 0) {
            throw new IllegalArgumentException("수량은 한 개 이상이어야 합니다.");
        }
    }

    public void changeItemName(String itemName) {
        if (StringUtils.hasText(itemName)) this.itemName = itemName;
    }

    public void changeMaterial(String material) {
        if (StringUtils.hasText(material)) this.material = material;
    }

    public void changeSize(int size) {
        Optional.ofNullable(size).filter(s -> s >0).ifPresent(s -> this.size = s);
    }

    public void changeDesign(String design) {
        if (StringUtils.hasText(design)) this.design = design;
    }

    public void changeDescription(String description) {
        if (StringUtils.hasText(description)) this.description = description;
    }

    public void changeItemCategory(ItemCategory itemCategory) {
        if (Objects.nonNull(itemCategory)) {
            this.itemCategory = itemCategory;
        }
    }
}
