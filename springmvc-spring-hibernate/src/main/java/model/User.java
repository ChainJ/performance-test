package model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 01083446 on 2017/8/9.
 */
@Entity
@Table(name = "users")
@Data
@Builder
public class User {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    int id;
    String name;
    int age;
}
