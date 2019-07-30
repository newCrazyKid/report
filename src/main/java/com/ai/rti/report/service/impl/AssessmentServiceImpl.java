/**
 * 
 */
package com.ai.rti.report.service.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ai.rti.report.entity.CampTable;
import com.ai.rti.report.entity.Target;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.rti.report.mapper.AssessmentMapper;
import com.ai.rti.report.service.AssessmentService;

@Service
public class AssessmentServiceImpl implements AssessmentService {

	@Autowired
	private AssessmentMapper assessmentMapper;

	@Override
	public List<Target> getDataList(BigInteger lan_id, String begin_time, String end_time, String mkt_campaign_name, BigInteger channel_id) {
		return assessmentMapper.getDataList(lan_id, begin_time, end_time, mkt_campaign_name, channel_id);
	}

	@Override
	public List<CampTable> getCampDataList(String gateway_cycle, String mkt_campaign_name, String script_name) {
		return assessmentMapper.getCampDataList(gateway_cycle, mkt_campaign_name, script_name);
	}

	@Override
	public List<Target> getDataById(String mkt_campaign_id) {
		return assessmentMapper.getDataById(mkt_campaign_id);
	}

}
