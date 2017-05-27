package cvter.intern.dao;

import cvter.intern.model.Booktag;
import cvter.intern.model.BooktagInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BooktagDao {
    int countByExample(BooktagInfoExample example);

    int deleteByExample(BooktagInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(Booktag record);

    int insertSelective(Booktag record);

    List<Booktag> selectByExample(BooktagInfoExample example);

    Booktag selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Booktag record, @Param("example") BooktagInfoExample example);

    int updateByExample(@Param("record") Booktag record, @Param("example") BooktagInfoExample example);

    int updateByPrimaryKeySelective(Booktag record);

    int updateByPrimaryKey(Booktag record);
}