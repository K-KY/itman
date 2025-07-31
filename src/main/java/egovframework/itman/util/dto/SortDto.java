package egovframework.itman.util.dto;

import egovframework.itman.util.enums.Sorts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Sort;

@Getter
@AllArgsConstructor
public class SortDto {
    private Sorts sorts;
    private String param;

    public Sort getSorts() {
        if (sorts.equals(Sorts.ASC)) {
            return Sort.by(param).ascending();
        }
        return Sort.by(param).descending();
    }
}
