package cvter.intern.dao;

import cvter.intern.model.Booktag;
import cvter.intern.model.BooktagInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BooktagDao {
    int countByExample(BooktagInfoExample example);

    int deleteByExample(BooktagInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(Booktag record);

    int insertSelective(Booktag record);

    List<Booktag> selectByExample(BooktagInfoExample example);

    Booktag selectByPrimaryKey(String id);

    Booktag selectByDescription(String description);

    List<Booktag> selectAll();

    int updateByExampleSelective(@Param("record") Booktag record, @Param("example") BooktagInfoExample example);

    int updateByExample(@Param("record") Booktag record, @Param("example") BooktagInfoExample example);

    int updateByPrimaryKeySelective(Booktag record);

    int updateByPrimaryKey(Booktag record);
}