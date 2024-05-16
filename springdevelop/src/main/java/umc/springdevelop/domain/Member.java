package umc.springdevelop.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.springdevelop.domain.common.BaseEntity;
import umc.springdevelop.domain.enums.Gender;
import umc.springdevelop.domain.enums.MemberStatus;
import umc.springdevelop.domain.enums.SocialType;
import umc.springdevelop.domain.mapping.MemberAgree;
import umc.springdevelop.domain.mapping.MemberMission;
import umc.springdevelop.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, length = 40)
    private String address;

    @Column(nullable = false, length = 40)
    private String specAddress;


    @Enumerated(EnumType.STRING)  //enum타입을 ordinal을 사용한다면 데베에 enum의 순서가 저장되는데 만약 springboot에서 enum 순서 바꾸면 에러
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15)")
    private MemberStatus status;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10) DEFAULT 'ACTIVE'")
    private SocialType socialType;

    private LocalDate inactiveDate;

    @Column(nullable = false, length = 50)
    private String email;

    private Integer point;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

}
