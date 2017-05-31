package cvter.intern.service.impl;

import cvter.intern.dao.BooktagDao;
import cvter.intern.model.Booktag;
import cvter.intern.service.BooktagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cvter on 2017/5/27.
 */
@Service
public class BooktagServiceImpl implements BooktagService {

    @Autowired
    private BooktagDao booktagDao;

    @Override
    public int save(Booktag booktag) {
        return booktagDao.insert(booktag);
    }

    @Override
    public int deleteByUid(String uid) {
        return booktagDao.deleteByPrimaryKey(uid);
    }

    @Override
    public int update(Booktag booktag) {
        return booktagDao.updateByPrimaryKey(booktag);
    }

    @Override
    public Booktag selectByUid(String uid) {
        return booktagDao.selectByPrimaryKey(uid);
    }

    @Override
    public List<Booktag> selectAll() {
        return booktagDao.selectAll();
    }
}
