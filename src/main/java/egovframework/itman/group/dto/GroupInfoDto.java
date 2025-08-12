package egovframework.itman.group.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GroupInfoDto {
    private Long groupSeq;
    private String groupName;
//    private Integer assets;
    private Integer departs;
    private Integer employees;


    @Override
    public String toString() {
        return "GroupInfoDto{" +
                "groupSeq=" + groupSeq +
                ", groupName='" + groupName +
//                ", assets=" + assets +
                ", departs=" + departs +
                ", employees=" + employees +
                '}';
    }
}
