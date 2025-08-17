package song.sj.entity.item;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "`outer`")
public class Outer extends Item{

    private String productClassification;

    public Outer(String productClassification) {
        this.productClassification = productClassification;
    }
}
