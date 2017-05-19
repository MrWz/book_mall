package cvter.intern.service;

import cvter.intern.model.DiscountInfo;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface DiscountService {
    int save(DiscountInfo record);

    int update(DiscountInfo record);

    DiscountInfo selectByUID(String uid);

    int deleteByUid(String uid);

    List<DiscountInfo> selectAll();
}
