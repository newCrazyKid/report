package com.ai.rti.report.controller;

import com.ai.rti.report.entity.CampTable;
import com.ai.rti.report.entity.Target;
import com.ai.rti.report.service.AssessmentService;
import com.ai.rti.report.util.AreaNameToIdUtil;
import com.ai.rti.report.util.ChlNameToIdUtil;
import com.ai.rti.svc.privilege.IUserSession;
import com.ai.rti.svc.privilege.PrivilegeManager;
import org.apache.poi.hssf.usermodel.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("/assessment")
public class QueryController {
    @Autowired
    private AssessmentService assessmentService;

    @RequestMapping("/report")
    public String echarts(){
        return "assessmentReport";
    }

    @ResponseBody
    @RequestMapping(value = "/getDataList", produces = "application/json;chartset=utf-8", method = RequestMethod.POST)
    public Map<String, Object> getDataList(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        String area_name = request.getParameter("area_name");
        String begin_time = request.getParameter("begin_time");
        String end_time = request.getParameter("end_time");
        String mkt_campaign_name = request.getParameter("mkt_campaign_name");
        String channel_name = request.getParameter("channel_name");

        BigInteger lanID = AreaNameToIdUtil.getAreaID(area_name);
        BigInteger chlID = ChlNameToIdUtil.getChlID(channel_name);
        //input标签为text类型时，接收到的是空字符串
        begin_time = begin_time.length() == 0 ? null : begin_time;
        end_time = end_time.length() == 0 ? null : end_time;
        mkt_campaign_name = mkt_campaign_name.length() == 0 ? null : mkt_campaign_name;

        System.out.println(lanID + "|" + begin_time + "|" + end_time + "|" + mkt_campaign_name + "|" + chlID);

        List<Target> list = assessmentService.getDataList(lanID, begin_time, end_time, mkt_campaign_name, chlID);

        System.out.println("list.size():" + list.size());
        System.out.println("=========list:\n" + list);
        Map<String, Object> map = new HashMap<>();

        //只显示时间周期为period天的数据
        int period = 30;
        int num = list.size();
        if (num > period){
            List<Target> newList = new ArrayList<>();
            for (int i = num - period; i < num; i++){
                newList.add(list.get(i));
            }
            map.put("data", newList);
            return map;
        }

        map.put("data", list);
        return map;
    }

    @RequestMapping("/campreport")
    public String campTable(){
        return "campReport";
    }

    @ResponseBody
    @RequestMapping(value = "/getCampDataList", produces = "application/json;charset=utf-8", method = {RequestMethod.POST, RequestMethod.GET})
    public List<CampTable> getCampDataList(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");

        String gateway_cycle = request.getParameter("gateway_cycle");
        String mkt_campaign_name = request.getParameter("mkt_campaign_name");
        String script_name = request.getParameter("script_name");

        //input标签为text类型时，接收到的是空字符串
        gateway_cycle = gateway_cycle.length() == 0 ? null : gateway_cycle;
        mkt_campaign_name = mkt_campaign_name.length() == 0 ? null : mkt_campaign_name;
        script_name = script_name.length() == 0 ? null : script_name;

//        System.out.println(gateway_cycle + "|" + mkt_campaign_name + "|" + script_name);
        List<CampTable> list = assessmentService.getCampDataList(gateway_cycle, mkt_campaign_name, script_name);

        System.out.println("====================list.size():" + list.size());
//        System.out.println("=========list:\n" + list);

        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/exportToExcel", method = RequestMethod.POST)
    public Map<String, String> exportToExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<CampTable> campDataList = getCampDataList(request, response);

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet= workbook.createSheet("营服报表");
        String fileName = "/home/coc/web/xjl/camp_report.xls";

        //excel表头
        String[] headers = {"账期", "服务场景ID", "服务场景名称", "短信模板ID", "短信模板名称", "事件编码",
                "发送短信数", "提交网关数", "发送成功数", "触达率"};
        HSSFRow row = sheet.createRow(0);//添加表头
        HSSFCell[] cellArr = new HSSFCell[headers.length];
        for (int i = 0; i < headers.length; i++) {
            cellArr[i] = row.createCell(i);
            cellArr[i].setCellValue(headers[i]);
        }
        int rowNum = 1;
        for (CampTable campTable : campDataList) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(campTable.getGateway_cycle());
            row1.createCell(1).setCellValue(campTable.getMkt_campaign_id().toString());
            row1.createCell(2).setCellValue(campTable.getMkt_campaign_name());
            row1.createCell(3).setCellValue(campTable.getContent_tpl_id());
            row1.createCell(4).setCellValue(campTable.getScript_name());
            row1.createCell(5).setCellValue(campTable.getEvent_code());
            row1.createCell(6).setCellValue(campTable.getSend_sms_total());
            row1.createCell(7).setCellValue(campTable.getGateway_succ_commit());
            row1.createCell(8).setCellValue(campTable.getSuccess_send());
            row1.createCell(9).setCellValue(campTable.getSuccess_send_ratio());
            rowNum++;
        }

        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);
        fos.flush();
        fos.close();


        Map<String, String> map = new HashMap<>();
        map.put("data", "Excel导出成功！");
        return map;
    }

    protected Long getDepTd() {
        IUserSession userSession = PrivilegeManager.getInstance().getUserSession();
        return userSession.getOrgId();
    }

    @Test
    public void testCreate(){

    }

}
