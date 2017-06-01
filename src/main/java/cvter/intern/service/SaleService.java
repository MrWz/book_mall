package cvter.intern.service;

import cvter.intern.model.Role;
import cvter.intern.model.Sale;
import cvter.intern.model.SaleSum;
import cvter.intern.model.UserBook;

import java.util.List;

/**
 * Created by cvter on 2017/5/30.
 */
public interface SaleService {
    void save(List<SaleSum> listSale);

    int deleteByUid(String uid);

    int update(Sale sale);

    Sale selectByUid(String uid);

    List<SaleSum> saleTable();

    List<Sale> selectAll();
}
