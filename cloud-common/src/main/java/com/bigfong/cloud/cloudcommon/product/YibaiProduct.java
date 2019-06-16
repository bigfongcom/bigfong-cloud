package com.bigfong.cloud.cloudcommon.product;


import com.bigfong.cloud.cloudcommon.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * yibai_product
 * goods 产品主表
 * </p>
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class YibaiProduct extends BaseEntity<YibaiProduct> implements Serializable {
    /**
     * 	流水ID
     */
    private Integer id;
    /**
     * sku
     */
    private String sku;
    /**
     * 产品类目ID
     */
    private Integer productCategoryId;
    /**
     * 产品线ID
     */
    private Integer productLinelistId;
    /**
     * 产品品牌id
     */
    private Integer productBrandId;
    /**
     * 成本
     */
    private Float productCost;
    /**
     * 产品最后采购价格
     */
    private Float lastPrice;
    /**
     * 最后采购供应商(入库时更新)
     */
    private Integer lastProviderId;
    /**
     * 供应商类型(1是普通供应商，2为分销商)
     */
    private Byte providerType;
    /**
     * 	货币单位
     */
    private  String currency;
    /**
     * 产品状态
     */
    private Byte productStatus;
    /**
     * 产品类型
     */
    private Byte productType;
    /**
     * 产品重量
     */
    private Float productWeight;
    /**
     * 产品长度
     */
    private Float productLength;
    /**
     * 产品宽度
     */
    private Float productWidth;
    /**
     * 产品高度
     */
    private Float productHeight;
    /**
     * 捆绑销售CODE
     */
    private String productCombineCode;
    /**
     * 	捆绑销售的数量(所有sku数量之和),生成待采购用
     */
    private Byte productCombineNum;
    /**
     * 产品绑定的sku
     */
    private String productBindCode;
    /**
     * 产品系列ID
      */
    private Integer productLineId;
    /**
     * 关键词
     */
    private String keywords;
    /**
     * 	品检内容
     */
    private String measureInfo;
    /**
     * 是否带附件
     */
    private Byte productIsAttach;
    /**
     * 是否备货
     */
    private Byte productIsBak;
    /**
     * 备货类型
     */
    private Byte productBakType;
    /**
     * 采购交期[到仓]
     */
    private Short productPrearrivalDays;
    /**
     * 采购周期
     */
    private Short productBakDays;
    /**
     * 原料类型：1包材 2包装
     */
    private Short originalMaterialTypeId;
    /**
     * 包材[sku]
     */
    private String productPackCode;
    /**
     * 	包装[sku]
     */
    private String productPackageCode;
    /**
     * 包装材料代码
     */
    private String productPackageMaterialCode;
    /**
     * 产品指定包裹的最大数量
     */
    private Short productPackageMaxNums;
    /**
     * 是否带库位
     */
    private Byte productIsStorage;
    /**
     * 是否带原包装
     */
    private Byte productOriginalPackage;
    /**
     * 	是否新品
     */
    private Byte productIsNew;
    /**
     * 	0: 普通 1: 多属性单品 2: 多属性组合
     */
    private Byte productIsMulti;
    /**
     *
     */
    private Integer providerLevelId;
    /**
     * 创建人
     */
    private Integer createUserId;
    /**
     * 修改人
     */
    private Integer modifyUserId;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 修改时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyTime;
    /**
     * 中文链接
     */
    private String productCnLink;
    /**
     * 英文链接
     */
    private String productEnLink;
    /**
     * 生成sku的标志
     */
    private Byte skuMark;
    /**
     * 来货包装方式
     */
    private Integer productToWayPackage;
    /**
     * 停售原因
     */
    private String stockReason;
    /**
     * 产品贴标加工
     */
    private String productLabelProces;
    /**
     * 包装产品长度
     */
    private Float packProductLength;
    /**
     * 包装产品宽度
     */
    private Float packProductWidth;
    /**
     * 包装产品高度
     */
    private Float packProductHeight;
    /**
     *
     */
    private Float grossProductWeight;
    /**
     * 是否推送到 wms 1推送，0未推送
     */
    private Byte isToMid;
    /**
     * 最后推送时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime toMidTime;
    /**
     * 1常规，2快速
     */
    private Byte stateType;
    /**
     * 开发审核时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkedTime;
    /**
     * 	图片路径
     */
    private String uploadimgs;
    /**
     * 标签
     */
    private String label;
    /**
     * 买样备注
     */
    private String buycompNote;
    /**
     * 质检备注
     */
    private String qualityNote;
    /**
     * 热销度，0低，1中，2高
     */
    private Byte hotRank;
    /**
     * 最小采购量
     */
    private Integer minPurchase;
    /**
     * 	询价人ID
     */
    private Integer inquirerId;
    /**
     * 采购人ID
     */
    private Integer purchaseId;
    /**
     * SKU别名
     */
    private String aliasesName;
    /**
     * 是否带说明书, 0否,1是
     */
    private Byte instructions;
    /**
     * 质检标准
     */
    private String qualityStandard;
    /**
     * 品检标签
     */
    private Byte qualityLable;
    /**
     * 质检备注
     */
    private String qualityRemark;
    /**
     * 	图片备注
     */
    private String imageRemark;
    /**
     * 买样类型0购买1免费2借用
     */
    private Byte buySampleType;
    /**
     * 参考价
     */
    private BigDecimal referencePrice;
    /**
     * 用途（英文）
     */
    private String useEn;
    /**
     * 	用途（中文）
     */
    private String useCn;
    /**
     * 材质（英文）
     */
    private String materialEn;
    /**
     * 材质(中文)
     */
    private String materialCn;
    /**
     * 物流备注
     */
    private String logisticsNote;
    /**
     * 配货中文名称（简称）
     */
    private String pickingName;
    /**
     *
     */
    private String pickingEname;
    /**
     * 海关编码(HS Code)
     */
    private String customsCode;
    /**
     * 进口申报英文名
     */
    private String declareEname;
    /**
     * 进口申报中文名
     */
    private String declareCname;
    /**
     * 申报货值
     */
    private BigDecimal declarePrice;
    /**
     * 产品关税税率
     */
    private Float tariff;
    /**
     * 	产品出口退税税率
     */
    private Float taxRate;
    /**
     * 平台分配备注
     */
    private String onlieRemark;
    /**
     * 开发来源
     */
    private Byte source;
    /**
     *
     */
    private Byte dropShipping;
    /**
     *
     */
    private Byte dropShippingSku;
    /**
     * 4高风险，3中度风险，2可能有风险，1无风险
     */
    private Byte logisticsRisk;
    /**
     * 	进口海关编码
     */
    private String customsCode2;
    /**
     * 申报单位
     */
    private String declareUnit;
    /**
     * 出口申报英文名
     */
    private String exportEname;
    /**
     * 	出口申报中文名
     */
    private String exportCname;
    /**
     * 	型号
     */
    private String productModel;
    /**
     * 规格
     */
    private String specifications;
    /**
     * 工作原理
     */
    private String productPrinciple;
    /**
     * 是否推送(0未推送1已推送)
     */
    private Byte isPush;
    /**
     * 申报要素
     */
    private String declare;
    /**
     * 出口型号
     */
    private String productModelOut;
    /**
     * 	0是不检查,1是检查
     */
    private Byte isInspection;
    /**
     * 财务编码
     */
    private String financeCode;
    /**
     * 	整箱数量
     */
    private Integer fullContainer;
    /**
     * 整箱长度
     */
    private Float fullContainerLength;
    /**
     * 整箱宽度
     */
    private Float fullContainerWidth;
    /**
     * 整箱高度
     */
    private Float fullContainerHeight;
    /**
     * 最新价格
     */
    private Float newPrice;
    /**
     * 平均采购价
     */
    private Float avgPrice;
    /**
     * 平均运费
     */
    private Float shipCost;
    /**
     * 抽检标准
     */
    private Byte qualityRandom;
    /**
     * 允收级别
     */
    private Byte qualityLevel;
    /**
     * 包装类型
     */
    private Byte packageTypes;
    /**
     * 进口申报要素
     */
    private String declareFactor;
    /**
     * 进口申报链接
     */
    private String declareLink;
    /**
     * (粉末/液体/膏体)含量
     */
    private Float component;
    /**
     * 1未审核，2已审核
     */
    private Byte logisticsStatus;
    /**
     * 采购员
     */
    private String buyer;
    /**
     *
     */
    private Byte pushLogistics;
    /**
     * 	发货包装，1快递袋，2气泡袋，3葫芦袋,4气柱袋，5卷芯棒
     */
    private Byte productPackageCodeNew;
    /**
     * 国内发货地
     */
    private Byte deliveryPlace;
    /**
     * 	供货状态
     */
    private Byte providerStatus;
    /**
     * 拍照样审核反馈
     */
    private String photographAuditingRemark;
    /**
     * 拍照样审版反馈
     */
    private String photographEditionRemark;
    /**
     * 是否是季节性产品
     */
    private Byte seasonalProduct;
    /**
     * 是否是节日性产品
     */
    private Byte holidayProduct;
    /**
     * 是否已抓取库存信息
     */
    private Byte isWare;
    /**
     * 是否精品 1是
     */
    private Byte isBoutique;
    /**
     * 开票点
     */
    private Float ticketedPoint;
    /**
     * 	推荐人
     */
    private Integer  refere;
    /**
     * 销售类型
     */
    private Byte saleType;
    /**
     * 产品包装尺寸
     */
    private String packingSizeSelection;
    /**
     * 试卖编辑备注
     */
    private String saleRemark;
    /**
     * \折扣率
     */
    private Integer discountRate;

    /**
     * 试卖编辑备注
     */
    private String productFeature;

    /***
     * 采购数据
     */
    //private PurchaseData purchaseData;

    /**
     * 产品线
     */
    //private YibaiProductLineList productLineList;

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

    public Byte getProviderType() {
        return providerType;
    }

    public void setProviderType(Byte providerType) {
        this.providerType = providerType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Byte getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Byte productStatus) {
        this.productStatus = productStatus;
    }

    public Byte getProductType() {
        return productType;
    }

    public void setProductType(Byte productType) {
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

    public Byte getProductCombineNum() {
        return productCombineNum;
    }

    public void setProductCombineNum(Byte productCombineNum) {
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

    public Byte getProductIsAttach() {
        return productIsAttach;
    }

    public void setProductIsAttach(Byte productIsAttach) {
        this.productIsAttach = productIsAttach;
    }

    public Byte getProductIsBak() {
        return productIsBak;
    }

    public void setProductIsBak(Byte productIsBak) {
        this.productIsBak = productIsBak;
    }

    public Byte getProductBakType() {
        return productBakType;
    }

    public void setProductBakType(Byte productBakType) {
        this.productBakType = productBakType;
    }

    public Short getProductPrearrivalDays() {
        return productPrearrivalDays;
    }

    public void setProductPrearrivalDays(Short productPrearrivalDays) {
        this.productPrearrivalDays = productPrearrivalDays;
    }

    public Short getProductBakDays() {
        return productBakDays;
    }

    public void setProductBakDays(Short productBakDays) {
        this.productBakDays = productBakDays;
    }

    public Short getOriginalMaterialTypeId() {
        return originalMaterialTypeId;
    }

    public void setOriginalMaterialTypeId(Short originalMaterialTypeId) {
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

    public Short getProductPackageMaxNums() {
        return productPackageMaxNums;
    }

    public void setProductPackageMaxNums(Short productPackageMaxNums) {
        this.productPackageMaxNums = productPackageMaxNums;
    }

    public Byte getProductIsStorage() {
        return productIsStorage;
    }

    public void setProductIsStorage(Byte productIsStorage) {
        this.productIsStorage = productIsStorage;
    }

    public Byte getProductOriginalPackage() {
        return productOriginalPackage;
    }

    public void setProductOriginalPackage(Byte productOriginalPackage) {
        this.productOriginalPackage = productOriginalPackage;
    }

    public Byte getProductIsNew() {
        return productIsNew;
    }

    public void setProductIsNew(Byte productIsNew) {
        this.productIsNew = productIsNew;
    }

    public Byte getProductIsMulti() {
        return productIsMulti;
    }

    public void setProductIsMulti(Byte productIsMulti) {
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

    public Byte getSkuMark() {
        return skuMark;
    }

    public void setSkuMark(Byte skuMark) {
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

    public Byte getIsToMid() {
        return isToMid;
    }

    public void setIsToMid(Byte isToMid) {
        this.isToMid = isToMid;
    }

    public LocalDateTime getToMidTime() {
        return toMidTime;
    }

    public void setToMidTime(LocalDateTime toMidTime) {
        this.toMidTime = toMidTime;
    }

    public Byte getStateType() {
        return stateType;
    }

    public void setStateType(Byte stateType) {
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

    public Byte getHotRank() {
        return hotRank;
    }

    public void setHotRank(Byte hotRank) {
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

    public Byte getInstructions() {
        return instructions;
    }

    public void setInstructions(Byte instructions) {
        this.instructions = instructions;
    }

    public String getQualityStandard() {
        return qualityStandard;
    }

    public void setQualityStandard(String qualityStandard) {
        this.qualityStandard = qualityStandard;
    }

    public Byte getQualityLable() {
        return qualityLable;
    }

    public void setQualityLable(Byte qualityLable) {
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

    public Byte getBuySampleType() {
        return buySampleType;
    }

    public void setBuySampleType(Byte buySampleType) {
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

    public Byte getSource() {
        return source;
    }

    public void setSource(Byte source) {
        this.source = source;
    }

    public Byte getDropShipping() {
        return dropShipping;
    }

    public void setDropShipping(Byte dropShipping) {
        this.dropShipping = dropShipping;
    }

    public Byte getDropShippingSku() {
        return dropShippingSku;
    }

    public void setDropShippingSku(Byte dropShippingSku) {
        this.dropShippingSku = dropShippingSku;
    }

    public Byte getLogisticsRisk() {
        return logisticsRisk;
    }

    public void setLogisticsRisk(Byte logisticsRisk) {
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

    public Byte getIsPush() {
        return isPush;
    }

    public void setIsPush(Byte isPush) {
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

    public Byte getIsInspection() {
        return isInspection;
    }

    public void setIsInspection(Byte isInspection) {
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

    public Byte getQualityRandom() {
        return qualityRandom;
    }

    public void setQualityRandom(Byte qualityRandom) {
        this.qualityRandom = qualityRandom;
    }

    public Byte getQualityLevel() {
        return qualityLevel;
    }

    public void setQualityLevel(Byte qualityLevel) {
        this.qualityLevel = qualityLevel;
    }

    public Byte getPackageTypes() {
        return packageTypes;
    }

    public void setPackageTypes(Byte packageTypes) {
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

    public Byte getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(Byte logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public Byte getPushLogistics() {
        return pushLogistics;
    }

    public void setPushLogistics(Byte pushLogistics) {
        this.pushLogistics = pushLogistics;
    }

    public Byte getProductPackageCodeNew() {
        return productPackageCodeNew;
    }

    public void setProductPackageCodeNew(Byte productPackageCodeNew) {
        this.productPackageCodeNew = productPackageCodeNew;
    }

    public Byte getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(Byte deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public Byte getProviderStatus() {
        return providerStatus;
    }

    public void setProviderStatus(Byte providerStatus) {
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

    public Byte getSeasonalProduct() {
        return seasonalProduct;
    }

    public void setSeasonalProduct(Byte seasonalProduct) {
        this.seasonalProduct = seasonalProduct;
    }

    public Byte getHolidayProduct() {
        return holidayProduct;
    }

    public void setHolidayProduct(Byte holidayProduct) {
        this.holidayProduct = holidayProduct;
    }

    public Byte getIsWare() {
        return isWare;
    }

    public void setIsWare(Byte isWare) {
        this.isWare = isWare;
    }

    public Byte getIsBoutique() {
        return isBoutique;
    }

    public void setIsBoutique(Byte isBoutique) {
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

    public Byte getSaleType() {
        return saleType;
    }

    public void setSaleType(Byte saleType) {
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

    public String getProductFeature() {
        return productFeature;
    }

    public void setProductFeature(String productFeature) {
        this.productFeature = productFeature;
    }

    /*    public YibaiProductLineList getProductLineList() {
        return productLineList;
    }

    public void setProductLineList(YibaiProductLineList productLineList) {
        this.productLineList = productLineList;
    }

    public PurchaseData getPurchaseData() {
        return purchaseData;
    }

    public void setPurchaseData(PurchaseData purchaseData) {
        this.purchaseData = purchaseData;
    }*/
}
