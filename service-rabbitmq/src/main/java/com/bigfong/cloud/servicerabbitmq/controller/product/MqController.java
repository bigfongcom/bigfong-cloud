package com.bigfong.cloud.servicerabbitmq.controller.product;

import com.bigfong.cloud.servicerabbitmq.sender.DirectSender;
import com.bigfong.cloud.servicerabbitmq.sender.FanoutSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MqController {

    @Autowired
    private DirectSender sender;

    @Autowired
    private FanoutSender fanoutSender;

    @GetMapping("/test")
    public String test(){
        String msg = "%5B%7B%22id%22%3A14%2C%22sku%22%3A%22GS00001%22%2C%22product_category_id%22%3A4%2C%22product_cost%22%3A13%2C%22last_price%22%3A13%2C%22product_status%22%3A18%2C%22product_type%22%3A1%2C%22product_weight%22%3A29%2C%22product_length%22%3A10%2C%22product_width%22%3A10%2C%22product_height%22%3A10%2C%22measure_info%22%3Anull%2C%22product_is_attach%22%3A0%2C%22product_prearrival_days%22%3A0%2C%22product_bak_days%22%3A0%2C%22original_material_type_id%22%3A0%2C%22product_pack_code%22%3Anull%2C%22product_package_code%22%3Anull%2C%22product_original_package%22%3A0%2C%22product_is_multi%22%3A0%2C%22modify_user_id%22%3A1%2C%22create_user_id%22%3A%22%E7%8E%8B%E8%8E%B9%22%2C%22modify_time%22%3A%222017-12-12+18%3A26%3A19%22%2C%22create_time%22%3A%222016-08-27+11%3A00%3A48%22%2C%22product_cn_link%22%3A%22https%3A%5C%2F%5C%2Fitem.taobao.com%5C%2Fitem.htm%3Fspm%3Da230r.1.14.15.W0jDQi%26id%3D529113674701%26ns%3D1%26abbucket%3D12%23detail%22%2C%22product_en_link%22%3A%22http%3A%5C%2F%5C%2Fwww.ebay.com%5C%2Fitm%5C%2F15mm-Mini-Full-Metal-GearBox-DC5V-12V-2-Phase-4-Wire-Gear-Reducer-Stepper-Motor-%5C%2F322132475955%3Fhash%3Ditem4b00978033%3Ag%3At9UAAOSwdj9XTqpJ%2Cwww.ebay.co.uk%5C%2Fitm%5C%2F15mm-Full-Metal-GearBox-DC5V-12V-2-Phase-4-Wire-Gear-Reducer-Stepper-Motor-232-1-%5C%2F222137373798%3Fhash%3Ditem33b86b5466%3Ag%3As20AAOSwgtJXTq0f%22%2C%22product_to_way_package%22%3A%22%E6%9A%82%E6%97%A0%E5%8C%85%E8%A3%85%22%2C%22stock_reason%22%3Anull%2C%22pack_product_length%22%3A10%2C%22pack_product_width%22%3A10%2C%22pack_product_height%22%3A10%2C%22gross_product_weight%22%3A17%2C%22uploadimgs%22%3A%22%5B%5C%221472266825937.jpg%5C%22%5D%22%2C%22label%22%3A%22%2C%2C%22%2C%22buycomp_note%22%3Anull%2C%22quality_note%22%3Anull%2C%22min_purchase%22%3A1%2C%22inquirer_id%22%3Anull%2C%22purchase_id%22%3Anull%2C%22aliases_name%22%3Anull%2C%22instructions%22%3A0%2C%22quality_standard%22%3Anull%2C%22quality_lable%22%3Anull%2C%22quality_remark%22%3Anull%2C%22image_remark%22%3Anull%2C%22use_en%22%3Anull%2C%22use_cn%22%3Anull%2C%22material_en%22%3Anull%2C%22material_cn%22%3Anull%2C%22reference_price%22%3A26.55%2C%22picking_name%22%3A%22%E6%95%B0%E6%8D%AE%E7%BA%BF%22%2C%22picking_ename%22%3Anull%2C%22customs_code%22%3Anull%2C%22declare_ename%22%3A%22Data+lines%22%2C%22declare_cname%22%3A%22%E6%95%B0%E6%8D%AE%E7%BA%BF%22%2C%22declare_price%22%3A0%2C%22tariff%22%3A0%2C%22tax_rate%22%3A0%2C%22onlie_remark%22%3Anull%2C%22product_linelist_id%22%3A546%7D%2C%7B%22id%22%3A19%2C%22sku%22%3A%22GS00002-03%22%2C%22product_category_id%22%3A4%2C%22product_cost%22%3A13%2C%22last_price%22%3A13%2C%22product_status%22%3A4%2C%22product_type%22%3A1%2C%22product_weight%22%3A132%2C%22product_length%22%3A10%2C%22product_width%22%3A10%2C%22product_height%22%3A10%2C%22measure_info%22%3Anull%2C%22product_is_attach%22%3A0%2C%22product_prearrival_days%22%3A0%2C%22product_bak_days%22%3A0%2C%22original_material_type_id%22%3A0%2C%22product_pack_code%22%3Anull%2C%22product_package_code%22%3Anull%2C%22product_original_package%22%3A0%2C%22product_is_multi%22%3A1%2C%22modify_user_id%22%3A1397%2C%22create_user_id%22%3A%22%E7%8E%8B%E8%8E%B9%22%2C%22modify_time%22%3A%222017-12-07+14%3A43%3A35%22%2C%22create_time%22%3A%222016-08-27+11%3A10%3A57%22%2C%22product_cn_link%22%3A%22https%3A%5C%2F%5C%2Fitem.taobao.com%5C%2Fitem.htm%3Fspm%3Da230r.1.14.45.TugRNL%26id%3D523010642647%26ns%3D1%26abbucket%3D2%23detail%22%2C%22product_en_link%22%3A%22http%3A%5C%2F%5C%2Fwww.ebay.com%5C%2Fitm%5C%2F72-Hole-Autoclave-Sterilizer-Case-Dental-Aluminium-Endo-Files-Holder-Box-New-%5C%2F322122425935%3Fhash%3Ditem4afffe264f%3Ag%3AwvQAAOSwa81XRsBa%2Chttp%3A%5C%2F%5C%2Fwww.ebay.com%5C%2Fitm%5C%2FAluminium-Autoclave-Sterilizer-Case-Dental-Endo-Files-Holder-Box-72-Hole-New-%5C%2F322122426996%3Fhash%3Ditem4afffe2a74%3Ag%3ATKUAAOSwagdXRsC5%22%2C%22product_to_way_package%22%3A%22%E6%9A%82%E6%97%A0%E5%8C%85%E8%A3%85%22%2C%22stock_reason%22%3Anull%2C%22pack_product_length%22%3A10%2C%22pack_product_width%22%3A10%2C%22pack_product_height%22%3A10%2C%22gross_product_weight%22%3A120%2C%22uploadimgs%22%3A%22%5B%5C%221472267451542.jpg%5C%22%5D%22%2C%22label%22%3A%22%2C%2C%22%2C%22buycomp_note%22%3Anull%2C%22quality_note%22%3Anull%2C%22min_purchase%22%3A1%2C%22inquirer_id%22%3Anull%2C%22purchase_id%22%3Anull%2C%22aliases_name%22%3Anull%2C%22instructions%22%3A0%2C%22quality_standard%22%3Anull%2C%22quality_lable%22%3Anull%2C%22quality_remark%22%3Anull%2C%22image_remark%22%3Anull%2C%22use_en%22%3Anull%2C%22use_cn%22%3Anull%2C%22material_en%22%3Anull%2C%22material_cn%22%3Anull%2C%22reference_price%22%3A45.78%2C%22picking_name%22%3A%22%E5%A1%91%E6%96%99%E7%9B%92%22%2C%22picking_ename%22%3Anull%2C%22customs_code%22%3Anull%2C%22declare_ename%22%3A%22plastic+box%22%2C%22declare_cname%22%3A%22%E5%A1%91%E6%96%99%E7%9B%92%22%2C%22declare_price%22%3A0%2C%22tariff%22%3A0%2C%22tax_rate%22%3A0%2C%22onlie_remark%22%3A%22%E9%80%9F%E5%8D%96%E9%80%9A%EF%BC%9A%E4%B8%8D%E4%B8%8A%22%2C%22product_linelist_id%22%3A370%7D%5D";
        sender.send(msg);
        return "test";
    }


    @GetMapping("/test/{msg}")
    public String test2(@PathVariable("msg") String msg){
        sender.send(msg);
        return msg;
    }


    @GetMapping("/fanoutTest/{msg}")
    public String fanoutTest(@PathVariable("msg") String msg){
        fanoutSender.send(msg);
        return msg;
    }
}
