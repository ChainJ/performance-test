package model;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * Created by JiangCheng on 2017/8/10.
 */
@Data
@Builder
public class User {
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
