package egovframework.itman.group.model.entity;

import egovframework.itman.user.model.entity.User;
import egovframework.itman.util.entity.BaseTimeEntity;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder(access = AccessLevel.PROTECTED)
@Entity
public class ManageGroup extends BaseTimeEntity {

    /// group가 예약어라 grp로 줄임
    @Id
    @Column(name = "grp_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupSeq;

    @Column(name = "grp_name")
    private String groupName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seq")
    private User user;

    @Column
    private boolean del;

    public boolean isMine(UserDetails user) {
        return this.user.getUserEmail().equals(user.getUsername());
    }
}