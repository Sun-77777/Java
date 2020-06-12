package xalead.entity;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.common.special.InsertUseGeneratedKeysMapper;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_user")
@Data
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "uid")
    private int id;
    private String user;
    private String pwd;
}
