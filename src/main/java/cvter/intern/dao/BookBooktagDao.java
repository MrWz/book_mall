package cvter.intern.dao;

import cvter.intern.model.BookBooktag;

public interface BookBooktagDao {

    int deleteByPrimaryKey(Integer id);

    int insert(BookBooktag record);

    BookBooktag selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(BookBooktag record);
}