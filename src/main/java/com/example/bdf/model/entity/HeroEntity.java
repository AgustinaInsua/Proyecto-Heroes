package com.example.bdf.model.entity;


import lombok.*;

import javax.persistence.*;

import java.util.List;




@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hero")
public class HeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column (nullable = false)
    private String name;

    @Column (nullable = false)
    private String city;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="enemy_id", referencedColumnName = "id")
    private EnemyDE enemy;

    @ManyToOne
    @JoinColumn(name="universe_id", referencedColumnName = "id")
    private UniverseDE universe;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "hero")
    private List<Hero_PowerDE> powers;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="alter_Ego_id", referencedColumnName = "id")
    private AlterEgoDE alterEgo;

    @ManyToOne
    @JoinColumn(name="gender_id", referencedColumnName = "id")
    private GenderDE gender;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="partner_id", referencedColumnName = "id")
    private PartnerDE partner;

    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name="weaknesses_id", referencedColumnName = "id")
    private List<WeaknessDE> weaknesses;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID", referencedColumnName = "id")
    private TypeDE type;

}
