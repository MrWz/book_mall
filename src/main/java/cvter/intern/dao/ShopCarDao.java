package cvter.intern.dao;

import cvter.intern.model.ShopCar;
import cvter.intern.model.ShopCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopCarDao {
    ShopCar selectByUuidAndBuid(@Param(value = "userUid") String userUid,
                                @Param(value = "bookUid") String bookUid,
                                @Param(value = "deleted") boolean deleted);

    List<ShopCar> selectByUseUid(@Param(value = "userUid") String userUid,
                                 @Param(value = "deleted") boolean deleted);

    int countByExample(ShopCarExample example);

    int deleteByExample(ShopCarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopCar record);

    int insertSelective(ShopCar record);

    List<ShopCar> selectByExample(ShopCarExample example);

    int updateByExampleSelective(@Param("record") ShopCar record, @Param("example") ShopCarExample example);

    int updateByExample(@Param("record") ShopCar record, @Param("example") ShopCarExample example);

    int updateByPrimaryKeySelective(ShopCar record);

    int updateByPrimaryKey(ShopCar record);
}