package dao;

import model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by JiangCheng on 2017/8/10.
 */
public interface UserMapper {
    @Select("SELECT id, name, age FROM user WHERE id = #{id}")
    User findOne(int id);

    @Select("SELECT id, name, age FROM user LIMIT #{offset},#{limit}")
    List<User> findList(int offset, int limit);

    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    void add(User user);

    @Update("UPDATE user SET name = #{name}, age = #{age} WHERE id = #{id}")
    void update(User user);
}
