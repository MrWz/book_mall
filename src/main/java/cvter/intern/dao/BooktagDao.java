package cvter.intern.dao;

import cvter.intern.model.Booktag;

import java.util.List;

public interface BooktagDao {
    int deleteByPrimaryKey(String id);

    int insert(Booktag record);

    Booktag selectByPrimaryKey(String id);

    Booktag selectByDescription(String description);

    List<Booktag> selectAll();

    int updateByPrimaryKey(Booktag record);
}