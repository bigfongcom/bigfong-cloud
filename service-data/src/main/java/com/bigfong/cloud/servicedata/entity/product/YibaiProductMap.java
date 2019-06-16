package com.bigfong.cloud.servicedata.entity.product;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class YibaiProductMap {
    /**
     * 产品ID
     */
    private Integer id;
    /**
     * SKU
     */
    private String sku;
    /**
     * 产品状态
     */
    private Integer productStatus;
    /**
     * 产品分类ID
     */
    private Integer productCategoryId;
    /**
     * 产品线ID
     */
    private Integer productLinelistId;
    /**
     * 成本
     */
    private Float productCost;
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
     * 包装SKU
     */
    private String productPackageCode;
    /**
     * 0: 普通 1: 多属性单品 2: 多属性组合
     */
    private Boolean productIsMulti;
    /**
     * 是否新品
     */
    private Boolean productIsNew;
    /**
     * 中文链接
     */
    private String productCnLink;
    /**
     * 英文链接
     */
    private String productEnLink;
    /**
     * 海关编码(HS Code）
     */
    private String customsCode;
    /**
     * 进口申报英文名
     */
    private String declareEname;
    /**
     * 申报中文名
     */
    private String declareCname;
    /**
     * 申报价格
     */
    private BigDecimal declarePrice;
    /**
     * 产品关税税率
     */
    private Float tariff;
    /**
     * 产品出口退税税率
     */
    private Float taxRate;
    /**
     * 开发来源
     */
    private Integer source;
    /**
     * 进口海关编码
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
     * 出口申报中文名
     */
    private String exportCname;
    /**
     * 型号
     */
    private String productModel;

    /**
     * 买样类型0购买1免费2借用
     */
    private int buySampleType;
    /**
     * 是否精品 1是
     */
    private int isBoutique;
    /**
     * 包装产品长度
     */
    private float packProductLength;
    /**
     * 包装产品宽度
     */
    private float packProductWidth;
    /**
     * 包装产品高度
     */
    private float packProductHeight;
    /**
     * 产品包装尺寸？？
     */
    private String packingSizeSelection;
    /**
     * 最小采购量
     */
    private int minPurchase;
    /**
     * 产品品牌id
     */
    private int productBrandId;
    /**
     * 产品重量
     */
    private float productWeight;
    /**
     * 来货包装方式
     */
    private int productToWayPackage;
    /**
     * 材质(英文)
     */
    private String materialEn;
    /**
     * 材质(中文)
     */
    private String materialCn;
    /**
     * 用途（英文）
     */
    private String useEn;
    /**
     * 用途（中文）
     */
    private String useCn;
    /**
     * 工作原理
     */
    private String productPrinciple;

    /**
     * 参考价
     */
    private BigDecimal referencePrice;
    /**
     * 毛重
     */
    private float grossProductWeight;
    /**
     * 买样备注
     */
    private String buycompNote;
    /**
     * 产品线
     */
    private String pathName;

    /**
     * 来样包装类型
     */
    private String packName;
    /**
     * 品牌
     */
    private String brandName;
    /**
     * 产品说明书
     */
    private String productInstructions;
    /**
     * 产品包装清单
     */
    private String packingList;
    /**
     * 产品中文名称
     */
    private String productName;
    /**
     * 侵权名称
     */
    private String name;

    /**
     * 供应商名称
     */
    private String provideName;

    /**
     * 供应商编码
     */
    private String providerCode;

    /**
     * 基础属性
     */
    //private List<String> basicAttr;

    /**
     * 特殊属性
     */
    //private List<String> specialAttr;

    /**
     * 图片路径
     */
    private List<StringBuilder> uploadimgs;


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

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
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

    public Float getProductCost() {
        return productCost;
    }

    public void setProductCost(Float productCost) {
        this.productCost = productCost;
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

    public String getProductPackageCode() {
        return productPackageCode;
    }

    public void setProductPackageCode(String productPackageCode) {
        this.productPackageCode = productPackageCode;
    }

    public Boolean getProductIsMulti() {
        return productIsMulti;
    }

    public void setProductIsMulti(Boolean productIsMulti) {
        this.productIsMulti = productIsMulti;
    }

    public Boolean getProductIsNew() {
        return productIsNew;
    }

    public void setProductIsNew(Boolean productIsNew) {
        this.productIsNew = productIsNew;
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

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
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

    public int getBuySampleType() {
        return buySampleType;
    }

    public void setBuySampleType(int buySampleType) {
        this.buySampleType = buySampleType;
    }

    public int getIsBoutique() {
        return isBoutique;
    }

    public void setIsBoutique(int isBoutique) {
        this.isBoutique = isBoutique;
    }

    public float getPackProductLength() {
        return packProductLength;
    }

    public void setPackProductLength(float packProductLength) {
        this.packProductLength = packProductLength;
    }

    public float getPackProductWidth() {
        return packProductWidth;
    }

    public void setPackProductWidth(float packProductWidth) {
        this.packProductWidth = packProductWidth;
    }

    public float getPackProductHeight() {
        return packProductHeight;
    }

    public void setPackProductHeight(float packProductHeight) {
        this.packProductHeight = packProductHeight;
    }

    public String getPackingSizeSelection() {
        return packingSizeSelection;
    }

    public void setPackingSizeSelection(String packingSizeSelection) {
        this.packingSizeSelection = packingSizeSelection;
    }

    public int getMinPurchase() {
        return minPurchase;
    }

    public void setMinPurchase(int minPurchase) {
        this.minPurchase = minPurchase;
    }

    public int getProductBrandId() {
        return productBrandId;
    }

    public void setProductBrandId(int productBrandId) {
        this.productBrandId = productBrandId;
    }

    public float getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(float productWeight) {
        this.productWeight = productWeight;
    }

    public int getProductToWayPackage() {
        return productToWayPackage;
    }

    public void setProductToWayPackage(int productToWayPackage) {
        this.productToWayPackage = productToWayPackage;
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

    public String getProductPrinciple() {
        return productPrinciple;
    }

    public void setProductPrinciple(String productPrinciple) {
        this.productPrinciple = productPrinciple;
    }

    public BigDecimal getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(BigDecimal referencePrice) {
        this.referencePrice = referencePrice;
    }

    public float getGrossProductWeight() {
        return grossProductWeight;
    }

    public void setGrossProductWeight(float grossProductWeight) {
        this.grossProductWeight = grossProductWeight;
    }

    public String getBuycompNote() {
        return buycompNote;
    }

    public void setBuycompNote(String buycompNote) {
        this.buycompNote = buycompNote;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public String getBandName() {
        return brandName;
    }

    public void setBandName(String bandName) {
        this.brandName = bandName;
    }

    public String getProductInstructions() {
        return productInstructions;
    }

    public void setProductInstructions(String productInstructions) {
        this.productInstructions = productInstructions;
    }

    public String getPackingList() {
        return packingList;
    }

    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvideName() {
        return provideName;
    }

    public void setProvideName(String provideName) {
        this.provideName = provideName;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    /*public List<String> getBasicAttr() {
        return basicAttr;
    }

    public void setBasicAttr(List<String> basicAttr) {
        this.basicAttr = basicAttr;
    }

    public List<String> getSpecialAttr() {
        return specialAttr;
    }

    public void setSpecialAttr(List<String> specialAttr) {
        this.specialAttr = specialAttr;
    }*/

    public List<StringBuilder> getUploadimgs() {
        return uploadimgs;
    }

    public void setUploadimgs(List<StringBuilder> uploadimgs) {
        this.uploadimgs = uploadimgs;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
