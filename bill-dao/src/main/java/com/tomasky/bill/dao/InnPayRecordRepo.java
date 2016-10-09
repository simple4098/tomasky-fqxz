package com.tomasky.bill.dao;

import com.tomasky.bill.model.InnPayRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by X on 2016/9/7.
 */
@Repository
public interface InnPayRecordRepo extends CrudRepository<InnPayRecord, Long> {
}
