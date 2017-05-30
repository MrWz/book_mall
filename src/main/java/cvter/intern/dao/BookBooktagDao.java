package cvter.intern.dao;

import cvter.intern.model.BookBooktag;
import cvter.intern.model.BookBooktagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookBooktagDao {
    int countByExample(BookBooktagExample example);

    int deleteByExample(BookBooktagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BookBooktag record);

    int insertSelective(BookBooktag record);

    List<BookBooktag> selectByExample(BookBooktagExample example);

    BookBooktag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BookBooktag record, @Param("example") BookBooktagExample example);

    int updateByExample(@Param("record") BookBooktag record, @Param("example") BookBooktagExample example);

    int updateByPrimaryKeySelective(BookBooktag record);

    int updateByPrimaryKey(BookBooktag record);
}