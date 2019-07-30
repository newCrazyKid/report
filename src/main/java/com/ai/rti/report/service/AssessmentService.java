/**
 * 
 */
package com.ai.rti.report.service;

import com.ai.rti.report.entity.CampTable;
import com.ai.rti.report.entity.Target;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface AssessmentService {

	List<Target> getDataList(BigInteger lan_id, String begin_time, String end_time, String mkt_campaign_name, BigInteger channel_id);

	List<CampTable> getCampDataList(String gateway_cycle, String mkt_campaign_name, String script_name);

	List<Target> getDataById(String mkt_campaign_id);
}
