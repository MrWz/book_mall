package cvter.intern.service;

import cvter.intern.model.Discount;

import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
public interface DiscountService {
    int save(Discount record);

    int update(Discount record);

    Discount selectByUID(String uid);

    int deleteByUid(String uid);

    List<Discount> selectAll();
}
