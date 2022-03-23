package com.sias.Bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

/**
 * @author Edgar
 * @create 2022-03-23 12:48
 * @faction:
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Alias("hello")
public class User {
    /*其中下面的属性值也是需要和数据库中的一样的，否则在接收数据的时候，会收不到
    * 原因是不能一一对应，因为从数据库中来的数据，看到了这三个属性，不知道要去
    * 哪一个，这样的话，写的是不行的*/
    private int id;
    private String name;
    private String password;

}
