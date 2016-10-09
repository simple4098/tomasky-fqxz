package com.tomasky.fqxz.dao;

import com.tomasky.fqxz.model.XzBaseinfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XzBaseinfoRepo extends CrudRepository<XzBaseinfo, Long> {

    XzBaseinfo findById(Long id);  //等同于  select * from X x where x.id = ?

}
