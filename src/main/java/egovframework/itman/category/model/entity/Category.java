package egovframework.itman.category.model.entity;

import egovframework.itman.category.dto.CategoryDto;
import egovframework.itman.group.model.entity.ManageGroup;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Getter
@Builder(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categorySeq;

    private String categoryName;

    private String tagColor;

    private Boolean enabled;

    private Boolean del;

    @JoinColumn(name = "grp_seq")
    @ManyToOne(fetch = FetchType.LAZY)
    private ManageGroup group;

    public void change(CategoryDto.Request categoryDto) {
        this.categoryName = categoryDto.getName();
        this.tagColor = categoryDto.getDescription();
        this.enabled = categoryDto.getEnabled();
        this.del = categoryDto.getDel();
    }

    public void changeEnable(CategoryDto.Request categoryDto) {
        this.enabled = Optional.ofNullable(categoryDto.getEnabled()).orElse(true);
    }

}
