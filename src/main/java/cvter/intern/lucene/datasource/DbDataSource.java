package cvter.intern.lucene.datasource;

import cvter.intern.lucene.model.BookIndex;
import cvter.intern.lucene.model.Index;
import cvter.intern.model.BookInfo;
import cvter.intern.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cvter on 2017/5/18.
 */
public class DbDataSource implements DataSource {

    private List<Index> indices;

    public DbDataSource() {
    }

    public DbDataSource(List<Index> indices) {
        this.indices = indices;
    }

    @Override
    public List<Index> getIndexData() {
        return indices;
    }

    @Override
    public void setIndexData(List<Index> indices) {
        this.indices = indices;
    }

    /**
     * 此处从数据库加载book信息
     */
    public void loadDataFromDB() {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        BookService bookService = context.getBean(BookService.class);

        indices = new ArrayList<>();
        List<BookInfo> books = bookService.selectAll(0,1);
        for (int i = 1; i < books.size(); i++) {
            BookInfo bookInfo = books.get(i);
            indices.add(new BookIndex(bookInfo.getUid(), bookInfo.getName(), bookInfo.getAuthor(), bookInfo.getDescription()));
        }
    }
}