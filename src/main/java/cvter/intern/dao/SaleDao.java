package cvter.intern.dao;

import cvter.intern.model.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SaleDao {
    int countByExample(SaleExample example);

    int deleteByExample(SaleExample example);

    int deleteByPrimaryKey(String uid);

    int insert(Sale record);

    int insertSelective(Sale record);

    List<Sale> selectAll();

    List<Sale> selectByExample(SaleExample example);

    int insertPart();

    List<SaleSum> saleSum();

    Sale selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") Sale record, @Param("example") SaleExample example);

    int updateByExample(@Param("record") Sale record, @Param("example") SaleExample example);

    int updateByPrimaryKeySelective(Sale record);

    int updateByPrimaryKey(Sale record);
}