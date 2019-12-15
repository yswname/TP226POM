package cn.com.demo.sm.mapper;

import cn.com.demo.sm.entity.SpProduct;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SpProductMapper {
    @Delete({
        "delete from sp_product",
        "where pr_id = #{prId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer prId);

    @Insert({
        "insert into sp_product (pr_id, pr_price, ",
        "pr_title, pr_simple_desc, ",
        "pr_ct_id, pr_attrs, ",
        "pr_detail_desc)",
        "values (#{prId,jdbcType=INTEGER}, #{prPrice,jdbcType=DOUBLE}, ",
        "#{prTitle,jdbcType=VARCHAR}, #{prSimpleDesc,jdbcType=VARCHAR}, ",
        "#{prCtId,jdbcType=INTEGER}, #{prAttrs,jdbcType=LONGVARCHAR}, ",
        "#{prDetailDesc,jdbcType=LONGVARCHAR})"
    })
    int insert(SpProduct record);

    @InsertProvider(type=SpProductSqlProvider.class, method="insertSelective")
    int insertSelective(SpProduct record);

    @Select({
        "select",
        "pr_id, pr_price, pr_title, pr_simple_desc, pr_ct_id, pr_attrs, pr_detail_desc",
        "from sp_product",
        "where pr_id = #{prId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="pr_id", property="prId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pr_price", property="prPrice", jdbcType=JdbcType.DOUBLE),
        @Result(column="pr_title", property="prTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="pr_simple_desc", property="prSimpleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="pr_ct_id", property="prCtId", jdbcType=JdbcType.INTEGER),
        @Result(column="pr_attrs", property="prAttrs", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="pr_detail_desc", property="prDetailDesc", jdbcType=JdbcType.LONGVARCHAR)
    })
    SpProduct selectByPrimaryKey(Integer prId);

    @UpdateProvider(type=SpProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpProduct record);

    @Update({
        "update sp_product",
        "set pr_price = #{prPrice,jdbcType=DOUBLE},",
          "pr_title = #{prTitle,jdbcType=VARCHAR},",
          "pr_simple_desc = #{prSimpleDesc,jdbcType=VARCHAR},",
          "pr_ct_id = #{prCtId,jdbcType=INTEGER},",
          "pr_attrs = #{prAttrs,jdbcType=LONGVARCHAR},",
          "pr_detail_desc = #{prDetailDesc,jdbcType=LONGVARCHAR}",
        "where pr_id = #{prId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(SpProduct record);

    @Update({
        "update sp_product",
        "set pr_price = #{prPrice,jdbcType=DOUBLE},",
          "pr_title = #{prTitle,jdbcType=VARCHAR},",
          "pr_simple_desc = #{prSimpleDesc,jdbcType=VARCHAR},",
          "pr_ct_id = #{prCtId,jdbcType=INTEGER}",
        "where pr_id = #{prId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SpProduct record);
}