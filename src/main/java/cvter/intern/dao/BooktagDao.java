package cvter.intern.dao;

import cvter.intern.model.Booktag;

public interface BooktagDao {
    int deleteByPrimaryKey(String id);

    int insert(Booktag record);

    Booktag selectByPrimaryKey(String id);

    Booktag selectByDescription(String description);

    int updateByPrimaryKey(Booktag record);
}