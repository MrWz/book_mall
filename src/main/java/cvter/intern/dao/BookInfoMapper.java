package cvter.intern.dao;

import cvter.intern.model.BookInfo;
import cvter.intern.model.BookInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookInfoMapper {
//    int countByExample(BookInfoExample example);

//    int deleteByExample(BookInfoExample example);

    int deleteByPrimaryKey(String uid);

    int insert(BookInfo record);

//    int insertSelective(BookInfo record);

//    List<BookInfo> selectByExampleWithBLOBs(BookInfoExample example);

//    List<BookInfo> selectByExample(BookInfoExample example);

    //通过Uid查询
    BookInfo selectByPrimaryKey(String uid);

    int updateByExampleSelective(@Param("record") BookInfo record, @Param("example") BookInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") BookInfo record, @Param("example") BookInfoExample example);

    int updateByExample(@Param("record") BookInfo record, @Param("example") BookInfoExample example);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKeyWithBLOBs(BookInfo record);

    int updateByPrimaryKey(BookInfo record);
}