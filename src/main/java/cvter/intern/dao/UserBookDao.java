package cvter.intern.dao;

import cvter.intern.model.Book;
import cvter.intern.model.Panic;
import cvter.intern.model.UserBook;
import cvter.intern.model.UserBookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBookDao {
    UserBook selectByUuidAndBuid(@Param(value = "userUid")String userUid,
                                 @Param(value = "bookUid") String bookUid,
                                 @Param(value = "buyWay") boolean buyWay);

    int countByExample(UserBookExample example);

    int deleteByExample(UserBookExample example);

    int deleteByPrimaryKey(Integer id);

    //插入购买明细
    int insert(UserBook record);

    //int select(UserBook record);

    int insertSelective(cvter.intern.model.UserBook record);

    List<Panic> selectByPaginate(@Param(value = "m") int m, @Param(value = "n") int n);

    UserBook selectByPrimaryKey(String  userUid);

    List<cvter.intern.model.UserBook> selectByUserUid(String userUid);

    cvter.intern.model.UserBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") cvter.intern.model.UserBook record, @Param("example") UserBookExample example);

    int updateByExample(@Param("record") cvter.intern.model.UserBook record, @Param("example") UserBookExample example);

    int updateByPrimaryKeySelective(cvter.intern.model.UserBook record);

    int updateByPrimaryKey(cvter.intern.model.UserBook record);
}