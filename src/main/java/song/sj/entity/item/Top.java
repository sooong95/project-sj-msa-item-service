package song.sj.entity.item;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Top extends Item {

    private String productClassification;

    public Top(String productClassification) {
        this.productClassification = productClassification;
    }
}
