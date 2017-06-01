package cvter.intern.task;

import cvter.intern.dao.SaleDao;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 销售统计
 */
@Service
@EnableScheduling
public class SaleCountTask {


    @Autowired
    private SaleDao saleDao;

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(SaleCountTask.class);

    @Scheduled(cron = "0 48 16 * * ?")   //每天23:00触发
    public void count() {
        logger.info("开始执行图书销售统计");
        //saleDao.insertPart();
    }
}
