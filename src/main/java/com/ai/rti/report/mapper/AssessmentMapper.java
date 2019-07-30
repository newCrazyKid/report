package com.ai.rti.report.mapper;

import java.math.BigInteger;
import java.util.List;

import com.ai.rti.report.entity.CampTable;
import com.ai.rti.report.entity.Target;
import org.apache.ibatis.annotations.Param;

public interface AssessmentMapper {

	List<Target> getDataList(@Param(value="lan_id") BigInteger lan_id,
									@Param(value="begin_time") String begin_time,
									@Param(value="end_time") String end_time,
									@Param(value="mkt_campaign_name") String mkt_campaign_name,
									@Param(value="channel_id") BigInteger channel_id);

	List<CampTable> getCampDataList(@Param(value="gateway_cycle") String gateway_cycle,
									@Param(value="mkt_campaign_name") String mkt_campaign_name,
									@Param(value="script_name") String script_name);

	List<Target> getDataById(@Param(value="mkt_campaign_id") String mkt_campaign_id);

}
