package cvter.intern.dao;

import cvter.intern.model.UserBook;
import cvter.intern.model.UserBookExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserBookDao {
    UserBook selectByUuidAndBuid(@Param(value = "userUid")String userUid,
                                 @Param(value = "bookUid") String bookUid,
                                 @Param(value = "buyWay") boolean buyWay);

    int countByExample(UserBookExample example);

    int deleteByExample(UserBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(cvter.intern.model.UserBook record);

    int insertSelective(cvter.intern.model.UserBook record);

    List<cvter.intern.model.UserBook> selectByUserUid(String userUid);

    cvter.intern.model.UserBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") cvter.intern.model.UserBook record, @Param("example") UserBookExample example);

    int updateByExample(@Param("record") cvter.intern.model.UserBook record, @Param("example") UserBookExample example);

    int updateByPrimaryKeySelective(cvter.intern.model.UserBook record);

    int updateByPrimaryKey(cvter.intern.model.UserBook record);
}