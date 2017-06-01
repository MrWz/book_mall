package cvter.intern.dao;

import cvter.intern.model.ShopCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCarDao {
    ShopCar selectByUuidAndBuid(@Param(value="userUid") String userUid,
                                @Param(value="bookUid") String bookUid,
                                @Param(value="deleted") boolean deleted);

    List<ShopCar> selectByUseUid(@Param(value="userUid") String userUid,
                                 @Param(value="deleted") boolean deleted);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopCar record);

    int updateByPrimaryKey(ShopCar record);
}