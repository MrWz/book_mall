package cvter.intern.lucene.datasource;

import cvter.intern.lucene.model.BookIndex;
import cvter.intern.lucene.model.Index;
import cvter.intern.model.Book;
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

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        BookService bookService = context.getBean(BookService.class);

        indices = new ArrayList<>();
        List<Book> books = bookService.selectAll();
        for (int i = 1; i < books.size(); i++) {
            Book book = books.get(i);
            indices.add(new BookIndex(book.getUid(), book.getName(), book.getAuthor(), book.getDescription()));
        }
    }
}
