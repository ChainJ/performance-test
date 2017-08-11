package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by JiangCheng on 2017/8/10.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    private int id;
    private String name;
    private int age;

    public static User generateUser() {
        return User.builder()
                .name(RandomStringUtils.randomAlphabetic(10))
                .age(Integer.valueOf(RandomStringUtils.randomNumeric(2)))
                .build();
    }
}
