package com.tomasky.bill.dao;

import com.tomasky.bill.model.InnConfig;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by X on 2016/9/14.
 */
@Repository
public interface InnConfigRepo extends CrudRepository<InnConfig, Long> {
    InnConfig save(InnConfig config);
    InnConfig findByInnId(Long innId);
}
