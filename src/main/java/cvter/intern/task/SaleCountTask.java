package cvter.intern.task;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 销售统计
 */
@Service
@EnableScheduling
public class SaleCountTask {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(SaleCountTask.class);

    @Scheduled(cron = "0 0 23 * * ?")   //每天23:00触发
    public void count() {
        logger.info("开始执行图书销售统计");
    }

}
