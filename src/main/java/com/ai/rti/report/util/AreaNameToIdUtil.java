package com.ai.rti.report.util;

import java.math.BigInteger;

public class AreaNameToIdUtil {
    public static BigInteger getAreaID(String area_name){
        String idStr;
        switch (area_name){
            case "北京": idStr = "1";
                break;
            case "海淀北电信局": idStr = "2600000000";
                break;
            case "南区电信局": idStr = "3100000000";
                break;
            case "北区电信局": idStr = "2800000000";
                break;
            case "东区电信局": idStr = "2900000000";
                break;
            case "西区电信局": idStr = "3000000000";
                break;
            case "大兴电信局": idStr = "3102000000";
                break;
            case "顺义电信局": idStr = "2905000000";
                break;
            case "平谷电信局": idStr = "2904000000";
                break;
            case "密云电信局": idStr = "2903000000";
                break;
            case "怀柔电信局": idStr = "2902000000";
                break;
            case "通州郊区（县）电信局": idStr = "2700000000";
                break;
            case "延庆电信局": idStr = "2803000000";
                break;
            case "昌平电信局": idStr = "2802000000";
                break;
            case "房山电信局": idStr = "3002000000";
                break;
            case "门头沟电信局": idStr = "3003000000";
                break;
            case "企业信息化部": idStr = "2500000000";
                break;
            case "市场部": idStr = "2100000000";
                break;
            case "客户服务部（号百运营中心）": idStr = "2400000000";
                break;
            case "系统集成部": idStr = "3000002922";
                break;
            case "服务质量监督部": idStr = "5200000000";
                break;
            default:return null;
        }
        return new BigInteger(idStr);
    }
}
