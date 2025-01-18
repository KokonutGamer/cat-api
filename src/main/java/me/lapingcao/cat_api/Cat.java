package me.lapingcao.cat_api;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Cat {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    @NonNull private String name;
    @NonNull private Breed breed;
    @NonNull private Integer age;
    @NonNull private Integer weight;

}