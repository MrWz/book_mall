package cvter.intern.lucene;

import cvter.intern.model.BookInfo;
import cvter.intern.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cvter on 2017/5/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class IndexManagerTest {

    @Autowired
    BookService bookService;

    private static Logger logger = LoggerFactory.getLogger(IndexManagerTest.class);

    private static DataSource dataSource;
    private static List<BookIndex> bookData;
    private static IndexManager indexManager = IndexManager.getInstance();

    static {

        bookData = new ArrayList<BookIndex>();
        bookData.add(new BookIndex("1", "mary jetty", "author", "标签以后的文summary稿在【文件列表】时间（Ctrl+Alt+F）里会按照标签分类，用户可以同时使用键盘或者鼠标浏览查看，或者在【文件列表】的搜索文本框内搜索标题关键字过滤文稿，如下图所示："));
        bookData.add(new BookIndex("2", "jetty xiaohu fafa", "author", "随即进入summary时间独立的阅读模式界面，我们在版面渲染上的每一个细节：字体，字号，行间距，前背景色都倾注了大量的时间，努力提升阅读的体验和品质"));
        bookData.add(new BookIndex("3", "fafa jetty jetty", "author", "在您使用 Cmd Markdow时间n 记录，创作，整理，阅读文稿的同时，我们不仅希望它是一个有力的工具，更希望您的思想和知识通过这个平台，连同优质的阅读体验，将他们分享给有相同志趣的人，进而鼓励更多的人来到这里记录分享他们的思想和知识，尝试点击 (Ctrl+Alt+P) 发布这份文档给好友吧！"));
        bookData.add(new BookIndex("4", "mary marry lory", "author", "再summary时间一次感谢您花费时间阅读这份欢迎稿，点击  (Ctrl+Alt+N) 开始撰写新的文稿吧！祝您在这里记录、阅读、分享愉快！"));
        bookData.add(new BookIndex("5", "name summary", "author", "发布：将当前的文稿生成时间固定链接，在网络上发布，分享"));
        bookData.add(new BookIndex("5", "summary name summary", "author", "i love summary"));
    }

    @Test
    public void testWithDb() {
        bookData = new ArrayList<BookIndex>();
        List<BookInfo> books = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            BookInfo tmp = bookService.selectByUid(i + "");
            bookData.add(new BookIndex(tmp.getUid(), tmp.getName(), tmp.getAuthor(), tmp.getDescription()));
        }
        indexManager.clearIndex();
        dataSource = new DBDataSource(bookData);

        indexManager.createIndex(dataSource);
        List<BookIndex> list = indexManager.searchIndexTopN("文学", BookIndex.SUMMARY, 3);
        for (BookIndex b :
                list) {
            logger.info(b.toString());
        }
        System.out.println(list.size());
    }

    @Test
    public void createIndex() throws Exception {

        dataSource = new DBDataSource(bookData);

        indexManager.createIndex(dataSource);

    }

    @Test
    public void searchIndex() throws Exception {
        List<BookIndex> list = indexManager.searchIndex("时间", "summary");
        for (BookIndex b :
                list) {
            logger.info(b.toString());
        }
        System.out.println(list.size());
    }

    @Test
    public void searchIndexTopN() throws Exception {
        List<BookIndex> list = indexManager.searchIndexTopN("时间", "summary", 3);
        for (BookIndex b :
                list) {
            logger.info(b.toString());
        }
        System.out.println(list.size());
    }

    @Test
    public void searchIndexPaginated() throws Exception {
        List<BookIndex> list = indexManager.searchIndexPaginated("时间", "summary", 1, 3);
        for (BookIndex b :
                list) {
            logger.info(b.toString());
        }
        System.out.println(list.size());
    }

    @Test
    public void clearIndex() throws Exception {
        indexManager.clearIndex();
    }
}