package cvter.intern.service.impl;

import cvter.intern.dao.SaleDao;
import cvter.intern.model.Sale;
import cvter.intern.model.SaleSum;
import cvter.intern.model.UserBook;
import cvter.intern.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by cvter on 2017/5/30.
 */
@Service
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDao saleDao;
    @Override
    public int save(Sale sale) {
        return saleDao.insert(sale);
    }

    @Override
    public int deleteByUid(String uid) {
        return saleDao.deleteByPrimaryKey(uid);
    }

    @Override
    public int update(Sale sale) {
        return saleDao.updateByPrimaryKey(sale);
    }

    @Override
    public Sale selectByUid(String uid) {
        return saleDao.selectByPrimaryKey(uid);
    }

    @Override
    public List<SaleSum> saleTable() {
        int insert=saleDao.insertPart();
        if(insert!=0){
            List<SaleSum> list=saleDao.saleSum();
            for(int i=0;i<list.size();i++){
                System.out.println("++++++++++++++++++++++++++");
                System.out.println(list.get(i).getBook_uid()+" "+list.get(i).getNums()+""+list.get(i).getTotal_price());
            }
            List<Sale> listSale=saleDao.selectAll();
            Date date=new Date();
            for(int i=0;i<listSale.size();i++){
                listSale.get(i).setDeleted(true);
                listSale.get(i).setUpdateTime(date);
                saleDao.updateByPrimaryKey(listSale.get(i));
            }
            return list;
        }
        return null;
    }

    @Override
    public List<Sale> selectAll() {
        return saleDao.selectAll();
    }
}
