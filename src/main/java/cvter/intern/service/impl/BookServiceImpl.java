package cvter.intern.service.impl;

import cvter.intern.dao.BookInfoMapper;
import cvter.intern.model.BookInfo;
import cvter.intern.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cvter on 2017/5/17.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BookServiceImpl implements BookService {

    @Resource
    private BookInfoMapper bookInfoMapper;

    public BookServiceImpl() {
        super();
    }

    /**
     * 增加记录
     */
    public int save(BookInfo bookInfo) {
        return bookInfoMapper.insert(bookInfo);
    }

    /**
     * 删除记录
     */
    public int deleteByUid(String uid) {
        return bookInfoMapper.deleteByPrimaryKey(uid);
    }

    /**
     * 更新记录
     */
    public int update(BookInfo bookInfo) {
        return bookInfoMapper.updateByPrimaryKey(bookInfo);
    }

    /**
     * 查询
     */
    public BookInfo selectByUid(String uid) {
        return bookInfoMapper.selectByPrimaryKey(uid);
    }

    /**
     * 查询全部记录，采用分表查询
     */
    public List<BookInfo> selectAll(int m,int n) {
        return bookInfoMapper.selectAll(m,n);
    }
}
