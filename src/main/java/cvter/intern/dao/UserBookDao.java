package cvter.intern.dao;

import cvter.intern.model.SaleSum;
import cvter.intern.model.UserBook;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserBookDao {
    UserBook selectByUuidAndBuid(@Param(value="userUid") String userUid,
                                 @Param(value="bookUid") String bookUid,
                                 @Param(value="buyWay") boolean buyWay);

    int deleteByPrimaryKey(Integer id);

    List<SaleSum> saleSum(@Param(value = "today")Date today);

    //插入购买明细
    int insert(UserBook record);

    int insertSelective(cvter.intern.model.UserBook record);

    UserBook selectByPrimaryKey(String userUid);

    List<cvter.intern.model.UserBook> selectByUserUid(String userUid);

    cvter.intern.model.UserBook selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(cvter.intern.model.UserBook record);
}