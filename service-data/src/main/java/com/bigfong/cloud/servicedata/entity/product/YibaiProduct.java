package com.bigfong.cloud.servicedata.entity.product;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * yibai_product
 * goods 产品主表
 * </p>
 */
@TableName(value = "yibai_product")
public class YibaiProduct extends Model {

    private static final long serialVersionUID = 1L;

    /**
     * 流水ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("sku")
    private String sku;

    /**
     * 产品类目ID
     */
    @TableField("product_category_id")
    private Integer productCategoryId;

    /**
     * 产品线ID
     */
    @TableField("product_linelist_id")
    private Integer productLinelistId;

    /**
     * 产品品牌id
     */
    @TableField("product_brand_id")
    private Integer productBrandId;

    /**
     * 成本
     */
    @TableField("product_cost")
    private Float productCost;

    /**
     * 产品最后采购价格
     */
    @TableField("last_price")
    private Float lastPrice;

    /**
     * 最后采购供应商(入库时更新)
     */
    @TableField("last_provider_id")
    private Integer lastProviderId;

    /**
     * 供应商类型(1是普通供应商，2为分销商)
     */
    @TableField("provider_type")
    private Integer providerType;

    /**
     * 货币单位
     */
    @TableField("currency")
    private String currency;

    /**
     * 产品状态
     */
    @TableField("product_status")
    private Integer productStatus;

    /**
     * 产品类型
     */
    @TableField("product_type")
    private Integer productType;

    /**
     * 产品重量
     */
    @TableField("product_weight")
    private Float productWeight;

    /**
     * 产品长度
     */
    @TableField("product_length")
    private Float productLength;

    /**
     * 产品宽度
     */
    @TableField("product_width")
    private Float productWidth;

    /**
     * 产品高度
     */
    @TableField("product_height")
    private Float productHeight;

    /**
     * 捆绑销售CODE
     */
    @TableField("product_combine_code")
    private String productCombineCode;

    /**
     * 捆绑销售的数量(所有sku数量之和),生成待采购用
     */
    @TableField("product_combine_num")
    private Integer productCombineNum;

    /**
     * 产品绑定的sku
     */
    @TableField("product_bind_code")
    private String productBindCode;

    /**
     * 产品系列ID
     */
    @TableField("product_line_id")
    private Integer productLineId;

    /**
     * 关键词
     */
    @TableField("keywords")
    private String keywords;

    /**
     * 品检内容
     */
    @TableField("measure_info")
    private String measureInfo;

    /**
     * 是否带附件
     */
    @TableField("product_is_attach")
    private Integer productIsAttach;

    /**
     * 是否备货
     */
    @TableField("product_is_bak")
    private Integer productIsBak;

    /**
     * 备货类型
     */
    @TableField("product_bak_type")
    private Integer productBakType;

    /**
     * 采购交期[到仓]
     */
    @TableField("product_prearrival_days")
    private Integer productPrearrivalDays;

    /**
     * 采购周期
     */
    @TableField("product_bak_days")
    private Integer productBakDays;

    /**
     * 原料类型：1包材 2包装
     */
    @TableField("original_material_type_id")
    private Integer originalMaterialTypeId;

    /**
     * 包材[sku]
     */
    @TableField("product_pack_code")
    private String productPackCode;

    /**
     * 包装[sku]
     */
    @TableField("product_package_code")
    private String productPackageCode;

    /**
     * 包装材料代码
     */
    @TableField("product_package_material_code")
    private String productPackageMaterialCode;

    /**
     * 产品指定包裹的最大数量
     */
    @TableField("product_package_max_nums")
    private Integer productPackageMaxNums;

    /**
     * 是否带库位
     */
    @TableField("product_is_storage")
    private Integer productIsStorage;

    /**
     * 是否带原包装
     */
    @TableField("product_original_package")
    private Integer productOriginalPackage;

    /**
     * 是否新品
     */
    @TableField("product_is_new")
    private Integer productIsNew;

    /**
     * 0: 普通 1: 多属性单品 2: 多属性组合
     */
    @TableField("product_is_multi")
    private Integer productIsMulti;

    @TableField("provider_level_id")
    private Integer providerLevelId;

    /**
     * 创建人
     */
    @TableField("create_user_id")
    private Integer createUserId;

    /**
     * 修改人
     */
    @TableField("modify_user_id")
    private Integer modifyUserId;

    /**
     * 创建时间
     */
    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField("modify_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyTime;

    /**
     * 中文链接
     */
    @TableField("product_cn_link")
    private String productCnLink;

    /**
     * 英文链接
     */
    @TableField("product_en_link")
    private String productEnLink;

    /**
     * 生成sku的标志
     */
    @TableField("sku_mark")
    private Integer skuMark;

    /**
     * 来货包装方式
     */
    @TableField("product_to_way_package")
    private Integer productToWayPackage;

    /**
     * 停售原因
     */
    @TableField("stock_reason")
    private String stockReason;

    /**
     * 产品贴标加工
     */
    @TableField("product_label_proces")
    private String productLabelProces;

    /**
     * 包装产品长度
     */
    @TableField("pack_product_length")
    private Float packProductLength;

    /**
     * 包装产品宽度
     */
    @TableField("pack_product_width")
    private Float packProductWidth;

    /**
     * 包装产品高度
     */
    @TableField("pack_product_height")
    private Float packProductHeight;

    /**
     * 毛重
     */
    @TableField("gross_product_weight")
    private Float grossProductWeight;

    /**
     * 是否推送到 wms 1推送，0未推送
     */
    @TableField("is_to_mid")
    private Integer isToMid;

    /**
     * 最后推送时间
     */
    @TableField("to_mid_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime toMidTime;

    /**
     * 1常规，2快速
     */
    @TableField("state_type")
    private Integer stateType;

    /**
     * 开发审核时间
     */
    @TableField("checked_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkedTime;

    /**
     * 图片路径
     */
    @TableField("uploadimgs")
    private String uploadimgs;

    /**
     * 标签
     */
    @TableField("label")
    private String label;

    /**
     * 买样备注
     */
    @TableField("buycomp_note")
    private String buycompNote;

    /**
     * 质检备注
     */
    @TableField("quality_note")
    private String qualityNote;

    /**
     * 热销度，0低，1中，2高
     */
    @TableField("hot_rank")
    private Integer hotRank;

    /**
     * 最小采购量
     */
    @TableField("min_purchase")
    private Integer minPurchase;

    /**
     * 询价人ID
     */
    @TableField("inquirer_id")
    private Integer inquirerId;

    /**
     * 采购人ID
     */
    @TableField("purchase_id")
    private Integer purchaseId;

    /**
     * SKU别名
     */
    @TableField("aliases_name")
    private String aliasesName;

    /**
     * 是否带说明书, 0否,1是
     */
    @TableField("instructions")
    private Integer instructions;

    /**
     * 质检标准
     */
    @TableField("quality_standard")
    private String qualityStandard;

    /**
     * 品检标签
     */
    @TableField("quality_lable")
    private Integer qualityLable;

    /**
     * 质检备注
     */
    @TableField("quality_remark")
    private String qualityRemark;

    /**
     * 图片备注
     */
    @TableField("image_remark")
    private String imageRemark;

    /**
     * 买样类型0购买1免费2借用
     */
    @TableField("buy_sample_type")
    private Integer buySampleType;

    /**
     * 参考价
     */
    @TableField("reference_price")
    private BigDecimal referencePrice;

    /**
     * 用途（英文）
     */
    @TableField("use_en")
    private String useEn;

    /**
     * 用途（中文）
     */
    @TableField("use_cn")
    private String useCn;

    /**
     * 材质（英文）
     */
    @TableField("material_en")
    private String materialEn;

    /**
     * 材质(中文)
     */
    @TableField("material_cn")
    private String materialCn;

    /**
     * 物流备注
     */
    @TableField("logistics_note")
    private String logisticsNote;

    /**
     * 配货中文名称（简称）
     */
    @TableField("picking_name")
    private String pickingName;

    @TableField("picking_ename")
    private String pickingEname;

    /**
     * 海关编码(HS Code)
     */
    @TableField("customs_code")
    private String customsCode;

    /**
     * 进口申报英文名
     */
    @TableField("declare_ename")
    private String declareEname;

    /**
     * 进口申报中文名
     */
    @TableField("declare_cname")
    private String declareCname;

    /**
     * 申报货值
     */
    @TableField("declare_price")
    private BigDecimal declarePrice;

    /**
     * 产品关税税率
     */
    @TableField("tariff")
    private Float tariff;

    /**
     * 产品出口退税税率
     */
    @TableField("tax_rate")
    private Float taxRate;

    /**
     * 平台分配备注
     */
    @TableField("onlie_remark")
    private String onlieRemark;

    /**
     * 开发来源
     */
    @TableField("source")
    private Integer source;

    @TableField("drop_shipping")
    private Integer dropShipping;

    @TableField("drop_shipping_sku")
    private Integer dropShippingSku;

    /**
     * 4高风险，3中度风险，2可能有风险，1无风险
     */
    @TableField("logistics_risk")
    private Integer logisticsRisk;

    /**
     * 进口海关编码
     */
    @TableField("customs_code2")
    private String customsCode2;

    /**
     * 申报单位
     */
    @TableField("declare_unit")
    private String declareUnit;

    /**
     * 出口申报英文名
     */
    @TableField("export_ename")
    private String exportEname;

    /**
     * 出口申报中文名
     */
    @TableField("export_cname")
    private String exportCname;

    /**
     * 型号
     */
    @TableField("product_model")
    private String productModel;

    /**
     * 规格
     */
    @TableField("specifications")
    private String specifications;

    /**
     * 工作原理
     */
    @TableField("product_principle")
    private String productPrinciple;

    /**
     * 是否推送(0未推送1已推送)
     */
    @TableField("is_push")
    private Integer isPush;

    /**
     * 申报要素
     */
    @TableField("declare")
    private String declare;

    /**
     * 出口型号
     */
    @TableField("product_model_out")
    private String productModelOut;

    /**
     * 0是不检查,1是检查
     */
    @TableField("is_inspection")
    private Integer isInspection;

    /**
     * 财务编码
     */
    @TableField("finance_code")
    private String financeCode;

    /**
     * 整箱数量
     */
    @TableField("full_container")
    private Integer fullContainer;

    /**
     * 整箱长度
     */
    @TableField("full_container_length")
    private Float fullContainerLength;

    /**
     * 整箱宽度
     */
    @TableField("full_container_width")
    private Float fullContainerWidth;

    /**
     * 整箱高度
     */
    @TableField("full_container_height")
    private Float fullContainerHeight;

    /**
     * 最新价格
     */
    @TableField("new_price")
    private Float newPrice;

    /**
     * 平均采购价
     */
    @TableField("avg_price")
    private Float avgPrice;

    /**
     * 平均运费
     */
    @TableField("ship_cost")
    private Float shipCost;

    /**
     * 抽检标准
     */
    @TableField("quality_random")
    private Integer qualityRandom;

    /**
     * 允收级别
     */
    @TableField("quality_level")
    private Integer qualityLevel;

    /**
     * 包装类型
     */
    @TableField("package_types")
    private Integer packageTypes;

    /**
     * 进口申报要素
     */
    @TableField("declare_factor")
    private String declareFactor;

    /**
     * 进口申报链接
     */
    @TableField("declare_link")
    private String declareLink;

    /**
     * (粉末/液体/膏体)含量
     */
    @TableField("component")
    private Float component;

    /**
     * 1未审核，2已审核
     */
    @TableField("logistics_status")
    private Integer logisticsStatus;

    /**
     * 采购员
     */
    @TableField("buyer")
    private String buyer;

    @TableField("push_logistics")
    private Integer pushLogistics;

    /**
     * 发货包装，1快递袋，2气泡袋，3葫芦袋,4气柱袋，5卷芯棒
     */
    @TableField("product_package_code_new")
    private Integer productPackageCodeNew;

    /**
     * 国内发货地
     */
    @TableField("delivery_place")
    private Integer deliveryPlace;

    /**
     * 供货状态
     */
    @TableField("provider_status")
    private Integer providerStatus;

    /**
     * 拍照样审核反馈
     */
    @TableField("photograph_auditing_remark")
    private String photographAuditingRemark;

    /**
     * 拍照样审版反馈
     */
    @TableField("photograph_edition_remark")
    private String photographEditionRemark;

    /**
     * 是否是季节性产品
     */
    @TableField("seasonal_product")
    private Integer seasonalProduct;

    /**
     * 是否是节日性产品
     */
    @TableField("holiday_product")
    private Integer holidayProduct;

    /**
     * 是否已抓取库存信息
     */
    @TableField("is_ware")
    private Integer isWare;

    /**
     * 是否精品 1是
     */
    @TableField("is_boutique")
    private Integer isBoutique;

    /**
     * 开票点
     */
    @TableField("ticketed_point")
    private Float ticketedPoint;

    /**
     * 推荐人
     */
    @TableField("refere")
    private Integer refere;

    /**
     * 销售类型
     */
    @TableField("sale_type")
    private Integer saleType;

    /**
     * 产品包装尺寸
     */
    @TableField("packing_size_selection")
    private String packingSizeSelection;

    /**
     * 试卖编辑备注
     */
    @TableField("sale_remark")
    private String saleRemark;

    /**
     * 折扣率
     */
    @TableField("discount_rate")
    private Integer discountRate;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Integer getProductLinelistId() {
        return productLinelistId;
    }

    public void setProductLinelistId(Integer productLinelistId) {
        this.productLinelistId = productLinelistId;
    }

    public Integer getProductBrandId() {
        return productBrandId;
    }

    public void setProductBrandId(Integer productBrandId) {
        this.productBrandId = productBrandId;
    }

    public Float getProductCost() {
        return productCost;
    }

    public void setProductCost(Float productCost) {
        this.productCost = productCost;
    }

    public Float getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Float lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Integer getLastProviderId() {
        return lastProviderId;
    }

    public void setLastProviderId(Integer lastProviderId) {
        this.lastProviderId = lastProviderId;
    }

    public Integer getProviderType() {
        return providerType;
    }

    public void setProviderType(Integer providerType) {
        this.providerType = providerType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Float getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(Float productWeight) {
        this.productWeight = productWeight;
    }

    public Float getProductLength() {
        return productLength;
    }

    public void setProductLength(Float productLength) {
        this.productLength = productLength;
    }

    public Float getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(Float productWidth) {
        this.productWidth = productWidth;
    }

    public Float getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(Float productHeight) {
        this.productHeight = productHeight;
    }

    public String getProductCombineCode() {
        return productCombineCode;
    }

    public void setProductCombineCode(String productCombineCode) {
        this.productCombineCode = productCombineCode;
    }

    public Integer getProductCombineNum() {
        return productCombineNum;
    }

    public void setProductCombineNum(Integer productCombineNum) {
        this.productCombineNum = productCombineNum;
    }

    public String getProductBindCode() {
        return productBindCode;
    }

    public void setProductBindCode(String productBindCode) {
        this.productBindCode = productBindCode;
    }

    public Integer getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(Integer productLineId) {
        this.productLineId = productLineId;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getMeasureInfo() {
        return measureInfo;
    }

    public void setMeasureInfo(String measureInfo) {
        this.measureInfo = measureInfo;
    }

    public Integer getProductIsAttach() {
        return productIsAttach;
    }

    public void setProductIsAttach(Integer productIsAttach) {
        this.productIsAttach = productIsAttach;
    }

    public Integer getProductIsBak() {
        return productIsBak;
    }

    public void setProductIsBak(Integer productIsBak) {
        this.productIsBak = productIsBak;
    }

    public Integer getProductBakType() {
        return productBakType;
    }

    public void setProductBakType(Integer productBakType) {
        this.productBakType = productBakType;
    }

    public Integer getProductPrearrivalDays() {
        return productPrearrivalDays;
    }

    public void setProductPrearrivalDays(Integer productPrearrivalDays) {
        this.productPrearrivalDays = productPrearrivalDays;
    }

    public Integer getProductBakDays() {
        return productBakDays;
    }

    public void setProductBakDays(Integer productBakDays) {
        this.productBakDays = productBakDays;
    }

    public Integer getOriginalMaterialTypeId() {
        return originalMaterialTypeId;
    }

    public void setOriginalMaterialTypeId(Integer originalMaterialTypeId) {
        this.originalMaterialTypeId = originalMaterialTypeId;
    }

    public String getProductPackCode() {
        return productPackCode;
    }

    public void setProductPackCode(String productPackCode) {
        this.productPackCode = productPackCode;
    }

    public String getProductPackageCode() {
        return productPackageCode;
    }

    public void setProductPackageCode(String productPackageCode) {
        this.productPackageCode = productPackageCode;
    }

    public String getProductPackageMaterialCode() {
        return productPackageMaterialCode;
    }

    public void setProductPackageMaterialCode(String productPackageMaterialCode) {
        this.productPackageMaterialCode = productPackageMaterialCode;
    }

    public Integer getProductPackageMaxNums() {
        return productPackageMaxNums;
    }

    public void setProductPackageMaxNums(Integer productPackageMaxNums) {
        this.productPackageMaxNums = productPackageMaxNums;
    }

    public Integer getProductIsStorage() {
        return productIsStorage;
    }

    public void setProductIsStorage(Integer productIsStorage) {
        this.productIsStorage = productIsStorage;
    }

    public Integer getProductOriginalPackage() {
        return productOriginalPackage;
    }

    public void setProductOriginalPackage(Integer productOriginalPackage) {
        this.productOriginalPackage = productOriginalPackage;
    }

    public Integer getProductIsNew() {
        return productIsNew;
    }

    public void setProductIsNew(Integer productIsNew) {
        this.productIsNew = productIsNew;
    }

    public Integer getProductIsMulti() {
        return productIsMulti;
    }

    public void setProductIsMulti(Integer productIsMulti) {
        this.productIsMulti = productIsMulti;
    }

    public Integer getProviderLevelId() {
        return providerLevelId;
    }

    public void setProviderLevelId(Integer providerLevelId) {
        this.providerLevelId = providerLevelId;
    }

    public Integer getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getProductCnLink() {
        return productCnLink;
    }

    public void setProductCnLink(String productCnLink) {
        this.productCnLink = productCnLink;
    }

    public String getProductEnLink() {
        return productEnLink;
    }

    public void setProductEnLink(String productEnLink) {
        this.productEnLink = productEnLink;
    }

    public Integer getSkuMark() {
        return skuMark;
    }

    public void setSkuMark(Integer skuMark) {
        this.skuMark = skuMark;
    }

    public Integer getProductToWayPackage() {
        return productToWayPackage;
    }

    public void setProductToWayPackage(Integer productToWayPackage) {
        this.productToWayPackage = productToWayPackage;
    }

    public String getStockReason() {
        return stockReason;
    }

    public void setStockReason(String stockReason) {
        this.stockReason = stockReason;
    }

    public String getProductLabelProces() {
        return productLabelProces;
    }

    public void setProductLabelProces(String productLabelProces) {
        this.productLabelProces = productLabelProces;
    }

    public Float getPackProductLength() {
        return packProductLength;
    }

    public void setPackProductLength(Float packProductLength) {
        this.packProductLength = packProductLength;
    }

    public Float getPackProductWidth() {
        return packProductWidth;
    }

    public void setPackProductWidth(Float packProductWidth) {
        this.packProductWidth = packProductWidth;
    }

    public Float getPackProductHeight() {
        return packProductHeight;
    }

    public void setPackProductHeight(Float packProductHeight) {
        this.packProductHeight = packProductHeight;
    }

    public Float getGrossProductWeight() {
        return grossProductWeight;
    }

    public void setGrossProductWeight(Float grossProductWeight) {
        this.grossProductWeight = grossProductWeight;
    }

    public Integer getIsToMid() {
        return isToMid;
    }

    public void setIsToMid(Integer isToMid) {
        this.isToMid = isToMid;
    }

    public LocalDateTime getToMidTime() {
        return toMidTime;
    }

    public void setToMidTime(LocalDateTime toMidTime) {
        this.toMidTime = toMidTime;
    }

    public Integer getStateType() {
        return stateType;
    }

    public void setStateType(Integer stateType) {
        this.stateType = stateType;
    }

    public LocalDateTime getCheckedTime() {
        return checkedTime;
    }

    public void setCheckedTime(LocalDateTime checkedTime) {
        this.checkedTime = checkedTime;
    }

    public String getUploadimgs() {
        return uploadimgs;
    }

    public void setUploadimgs(String uploadimgs) {
        this.uploadimgs = uploadimgs;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getBuycompNote() {
        return buycompNote;
    }

    public void setBuycompNote(String buycompNote) {
        this.buycompNote = buycompNote;
    }

    public String getQualityNote() {
        return qualityNote;
    }

    public void setQualityNote(String qualityNote) {
        this.qualityNote = qualityNote;
    }

    public Integer getHotRank() {
        return hotRank;
    }

    public void setHotRank(Integer hotRank) {
        this.hotRank = hotRank;
    }

    public Integer getMinPurchase() {
        return minPurchase;
    }

    public void setMinPurchase(Integer minPurchase) {
        this.minPurchase = minPurchase;
    }

    public Integer getInquirerId() {
        return inquirerId;
    }

    public void setInquirerId(Integer inquirerId) {
        this.inquirerId = inquirerId;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getAliasesName() {
        return aliasesName;
    }

    public void setAliasesName(String aliasesName) {
        this.aliasesName = aliasesName;
    }

    public Integer getInstructions() {
        return instructions;
    }

    public void setInstructions(Integer instructions) {
        this.instructions = instructions;
    }

    public String getQualityStandard() {
        return qualityStandard;
    }

    public void setQualityStandard(String qualityStandard) {
        this.qualityStandard = qualityStandard;
    }

    public Integer getQualityLable() {
        return qualityLable;
    }

    public void setQualityLable(Integer qualityLable) {
        this.qualityLable = qualityLable;
    }

    public String getQualityRemark() {
        return qualityRemark;
    }

    public void setQualityRemark(String qualityRemark) {
        this.qualityRemark = qualityRemark;
    }

    public String getImageRemark() {
        return imageRemark;
    }

    public void setImageRemark(String imageRemark) {
        this.imageRemark = imageRemark;
    }

    public Integer getBuySampleType() {
        return buySampleType;
    }

    public void setBuySampleType(Integer buySampleType) {
        this.buySampleType = buySampleType;
    }

    public BigDecimal getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(BigDecimal referencePrice) {
        this.referencePrice = referencePrice;
    }

    public String getUseEn() {
        return useEn;
    }

    public void setUseEn(String useEn) {
        this.useEn = useEn;
    }

    public String getUseCn() {
        return useCn;
    }

    public void setUseCn(String useCn) {
        this.useCn = useCn;
    }

    public String getMaterialEn() {
        return materialEn;
    }

    public void setMaterialEn(String materialEn) {
        this.materialEn = materialEn;
    }

    public String getMaterialCn() {
        return materialCn;
    }

    public void setMaterialCn(String materialCn) {
        this.materialCn = materialCn;
    }

    public String getLogisticsNote() {
        return logisticsNote;
    }

    public void setLogisticsNote(String logisticsNote) {
        this.logisticsNote = logisticsNote;
    }

    public String getPickingName() {
        return pickingName;
    }

    public void setPickingName(String pickingName) {
        this.pickingName = pickingName;
    }

    public String getPickingEname() {
        return pickingEname;
    }

    public void setPickingEname(String pickingEname) {
        this.pickingEname = pickingEname;
    }

    public String getCustomsCode() {
        return customsCode;
    }

    public void setCustomsCode(String customsCode) {
        this.customsCode = customsCode;
    }

    public String getDeclareEname() {
        return declareEname;
    }

    public void setDeclareEname(String declareEname) {
        this.declareEname = declareEname;
    }

    public String getDeclareCname() {
        return declareCname;
    }

    public void setDeclareCname(String declareCname) {
        this.declareCname = declareCname;
    }

    public BigDecimal getDeclarePrice() {
        return declarePrice;
    }

    public void setDeclarePrice(BigDecimal declarePrice) {
        this.declarePrice = declarePrice;
    }

    public Float getTariff() {
        return tariff;
    }

    public void setTariff(Float tariff) {
        this.tariff = tariff;
    }

    public Float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Float taxRate) {
        this.taxRate = taxRate;
    }

    public String getOnlieRemark() {
        return onlieRemark;
    }

    public void setOnlieRemark(String onlieRemark) {
        this.onlieRemark = onlieRemark;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Integer getDropShipping() {
        return dropShipping;
    }

    public void setDropShipping(Integer dropShipping) {
        this.dropShipping = dropShipping;
    }

    public Integer getDropShippingSku() {
        return dropShippingSku;
    }

    public void setDropShippingSku(Integer dropShippingSku) {
        this.dropShippingSku = dropShippingSku;
    }

    public Integer getLogisticsRisk() {
        return logisticsRisk;
    }

    public void setLogisticsRisk(Integer logisticsRisk) {
        this.logisticsRisk = logisticsRisk;
    }

    public String getCustomsCode2() {
        return customsCode2;
    }

    public void setCustomsCode2(String customsCode2) {
        this.customsCode2 = customsCode2;
    }

    public String getDeclareUnit() {
        return declareUnit;
    }

    public void setDeclareUnit(String declareUnit) {
        this.declareUnit = declareUnit;
    }

    public String getExportEname() {
        return exportEname;
    }

    public void setExportEname(String exportEname) {
        this.exportEname = exportEname;
    }

    public String getExportCname() {
        return exportCname;
    }

    public void setExportCname(String exportCname) {
        this.exportCname = exportCname;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getProductPrinciple() {
        return productPrinciple;
    }

    public void setProductPrinciple(String productPrinciple) {
        this.productPrinciple = productPrinciple;
    }

    public Integer getIsPush() {
        return isPush;
    }

    public void setIsPush(Integer isPush) {
        this.isPush = isPush;
    }

    public String getDeclare() {
        return declare;
    }

    public void setDeclare(String declare) {
        this.declare = declare;
    }

    public String getProductModelOut() {
        return productModelOut;
    }

    public void setProductModelOut(String productModelOut) {
        this.productModelOut = productModelOut;
    }

    public Integer getIsInspection() {
        return isInspection;
    }

    public void setIsInspection(Integer isInspection) {
        this.isInspection = isInspection;
    }

    public String getFinanceCode() {
        return financeCode;
    }

    public void setFinanceCode(String financeCode) {
        this.financeCode = financeCode;
    }

    public Integer getFullContainer() {
        return fullContainer;
    }

    public void setFullContainer(Integer fullContainer) {
        this.fullContainer = fullContainer;
    }

    public Float getFullContainerLength() {
        return fullContainerLength;
    }

    public void setFullContainerLength(Float fullContainerLength) {
        this.fullContainerLength = fullContainerLength;
    }

    public Float getFullContainerWidth() {
        return fullContainerWidth;
    }

    public void setFullContainerWidth(Float fullContainerWidth) {
        this.fullContainerWidth = fullContainerWidth;
    }

    public Float getFullContainerHeight() {
        return fullContainerHeight;
    }

    public void setFullContainerHeight(Float fullContainerHeight) {
        this.fullContainerHeight = fullContainerHeight;
    }

    public Float getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Float newPrice) {
        this.newPrice = newPrice;
    }

    public Float getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Float avgPrice) {
        this.avgPrice = avgPrice;
    }

    public Float getShipCost() {
        return shipCost;
    }

    public void setShipCost(Float shipCost) {
        this.shipCost = shipCost;
    }

    public Integer getQualityRandom() {
        return qualityRandom;
    }

    public void setQualityRandom(Integer qualityRandom) {
        this.qualityRandom = qualityRandom;
    }

    public Integer getQualityLevel() {
        return qualityLevel;
    }

    public void setQualityLevel(Integer qualityLevel) {
        this.qualityLevel = qualityLevel;
    }

    public Integer getPackageTypes() {
        return packageTypes;
    }

    public void setPackageTypes(Integer packageTypes) {
        this.packageTypes = packageTypes;
    }

    public String getDeclareFactor() {
        return declareFactor;
    }

    public void setDeclareFactor(String declareFactor) {
        this.declareFactor = declareFactor;
    }

    public String getDeclareLink() {
        return declareLink;
    }

    public void setDeclareLink(String declareLink) {
        this.declareLink = declareLink;
    }

    public Float getComponent() {
        return component;
    }

    public void setComponent(Float component) {
        this.component = component;
    }

    public Integer getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(Integer logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Integer getPushLogistics() {
        return pushLogistics;
    }

    public void setPushLogistics(Integer pushLogistics) {
        this.pushLogistics = pushLogistics;
    }

    public Integer getProductPackageCodeNew() {
        return productPackageCodeNew;
    }

    public void setProductPackageCodeNew(Integer productPackageCodeNew) {
        this.productPackageCodeNew = productPackageCodeNew;
    }

    public Integer getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(Integer deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public Integer getProviderStatus() {
        return providerStatus;
    }

    public void setProviderStatus(Integer providerStatus) {
        this.providerStatus = providerStatus;
    }

    public String getPhotographAuditingRemark() {
        return photographAuditingRemark;
    }

    public void setPhotographAuditingRemark(String photographAuditingRemark) {
        this.photographAuditingRemark = photographAuditingRemark;
    }

    public String getPhotographEditionRemark() {
        return photographEditionRemark;
    }

    public void setPhotographEditionRemark(String photographEditionRemark) {
        this.photographEditionRemark = photographEditionRemark;
    }

    public Integer getSeasonalProduct() {
        return seasonalProduct;
    }

    public void setSeasonalProduct(Integer seasonalProduct) {
        this.seasonalProduct = seasonalProduct;
    }

    public Integer getHolidayProduct() {
        return holidayProduct;
    }

    public void setHolidayProduct(Integer holidayProduct) {
        this.holidayProduct = holidayProduct;
    }

    public Integer getIsWare() {
        return isWare;
    }

    public void setIsWare(Integer isWare) {
        this.isWare = isWare;
    }

    public Integer getIsBoutique() {
        return isBoutique;
    }

    public void setIsBoutique(Integer isBoutique) {
        this.isBoutique = isBoutique;
    }

    public Float getTicketedPoint() {
        return ticketedPoint;
    }

    public void setTicketedPoint(Float ticketedPoint) {
        this.ticketedPoint = ticketedPoint;
    }

    public Integer getRefere() {
        return refere;
    }

    public void setRefere(Integer refere) {
        this.refere = refere;
    }

    public Integer getSaleType() {
        return saleType;
    }

    public void setSaleType(Integer saleType) {
        this.saleType = saleType;
    }

    public String getPackingSizeSelection() {
        return packingSizeSelection;
    }

    public void setPackingSizeSelection(String packingSizeSelection) {
        this.packingSizeSelection = packingSizeSelection;
    }

    public String getSaleRemark() {
        return saleRemark;
    }

    public void setSaleRemark(String saleRemark) {
        this.saleRemark = saleRemark;
    }

    public Integer getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Integer discountRate) {
        this.discountRate = discountRate;
    }

}
