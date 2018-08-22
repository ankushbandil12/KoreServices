package com.kore;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KoreSupervisorServices {
	
	/*private JdbcTemplate jdbcTemplate;
	static Logger log = Logger.getLogger(KoreSupervisorServices.class.getName());

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@RequestMapping(value = "/checksupervisor", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String checkSupervisor(@RequestBody String data) throws JSONException {
		log.info("Sample log");
		String empId = "";
		String query = " " + empId;
		List<Map<String,Object>> rows = jdbcTemplate.queryForList(query);
		JSONObject aimlobj = new JSONObject();
		JSONObject aimlobjReq = new JSONObject(data);
		String response = null;
		for (Map<String,Object> row : rows) {
			response = "Your supervisor is " + row.get("");
		}
		aimlobj.put("response", response);
		JSONArray ja = new JSONArray();
		ja.put(aimlobj);
		return ja.toString();
	}
	
	
	@RequestMapping(value = "/sample", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String sample() throws JSONException {
		log.info("Sample log");
		JSONObject aimlobj = new JSONObject();
		aimlobj.put("response", "Sample Service Called");
		JSONArray ja = new JSONArray();
		ja.put(aimlobj);
		return ja.toString();
	}*/
	
}
