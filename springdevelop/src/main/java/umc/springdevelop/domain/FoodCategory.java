package umc.springdevelop.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.springdevelop.domain.common.BaseEntity;
import umc.springdevelop.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate column4;

    @OneToMany(mappedBy = "foodCategory", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();
}
