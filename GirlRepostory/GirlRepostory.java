package com.imooc.GirlRepostory;

import com.imooc.dimain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2018/3/4.
 */
public interface GirlRepostory extends JpaRepository<Girl,Integer> {

    public List<Girl> findGirlByAge(Integer age);
}
