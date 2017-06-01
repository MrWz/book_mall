package cvter.intern.lucene.datasource;

import cvter.intern.lucene.model.BookIndex;
import cvter.intern.model.Book;
import cvter.intern.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 构建图书检索数据源接口的实现类 - 从数据库获取数据
 */
public class DbDataSource implements DataSource {

//    @Resource
//    private BookService bookService;

    private List<BookIndex> indices;

    public DbDataSource() {
    }

    public DbDataSource(List<BookIndex> indices) {
        this.indices = indices;
    }

    @Override
    public List<BookIndex> getIndexData() {
        return indices;
    }

    @Override
    public void setIndexData(List<BookIndex> indices) {
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
