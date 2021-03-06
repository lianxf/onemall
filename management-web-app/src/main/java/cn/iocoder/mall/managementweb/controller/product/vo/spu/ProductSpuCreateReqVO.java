package cn.iocoder.mall.managementweb.controller.product.vo.spu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel("商品 SPU 创建 Request VO")
@Data
public class ProductSpuCreateReqVO {

    /**
     * SKU 信息
     */
    @Data
    @Accessors(chain = true)
    public static class Sku {

        /**
         * 规格值数组
         */
        @NotNull(message = "规格值数组不能为空")
        private List<Integer> attrValueIds;
        /**
         * 价格，单位：分
         */
        @NotNull(message = "价格不能为空")
        @Min(value = 1L, message = "最小价格为 1")
        private Integer price;
        /**
         * 库存数量
         */
        @NotNull(message = "库存数量不能为空")
        @Min(value = 1L, message = "最小库存为 1")
        private Integer quantity;

    }

    @ApiModelProperty(value = "SPU 名字", required = true)
    @NotEmpty(message = "SPU 名字不能为空")
    private String name;
    @ApiModelProperty(value = "卖点", required = true)
    @NotEmpty(message = "卖点不能为空")
    private String sellPoint;
    @ApiModelProperty(value = "描述", required = true)
    @NotEmpty(message = "描述不能为空")
    private String description;
    @ApiModelProperty(value = "分类编号", required = true)
    @NotNull(message = "分类编号不能为空")
    private Integer cid;
    @ApiModelProperty(value = "商品主图地址", required = true)
    @NotEmpty(message = "商品主图地址不能为空")
    private List<String> picUrls;
    @ApiModelProperty(value = "是否上架商品", required = true)
    @NotNull(message = "是否上架商品不能为空")
    private Boolean visible;

    // ========== SKU =========

    /**
     * SKU 数组
     */
    @NotNull(message = "SKU 不能为空")
    @Valid
    private List<Sku> skus;

}
