package com.ai.rti.report.util;

import java.math.BigInteger;

public class ChlNameToIdUtil {
    public static BigInteger getChlID(String channel_name){
        String idStr;
        switch (channel_name){
            case "厅台": idStr = "1000";
                break;
            case "外呼": idStr = "1001";
                break;
            case "短信": idStr = "1002";
                break;
            case "直销渠道": idStr = "1007";
                break;
            case "客服来电": idStr = "1008";
                break;
            case "短厅": idStr = "1009";
                break;
            case "线上渠道": idStr = "1010";
                break;
            case "装维渠道": idStr = "1012";
                break;
            default:return null;
        }
        return new BigInteger(idStr);
    }
}
