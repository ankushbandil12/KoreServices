package com.kore;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KoreLeaveServices {
	
	@RequestMapping(value = "/flexileavebalance", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String flexiLeaveBalance(@RequestBody String data) throws JSONException {
		JSONObject aimlobj = new JSONObject();
		JSONObject aimlobjReq = new JSONObject(data);
		aimlobj.put("response", "You have 2 flexi leaves.");
		aimlobj.put("aimlobjReq", aimlobjReq);
		JSONArray ja = new JSONArray();
		ja.put(aimlobj);
		return ja.toString();
	}
	
	@RequestMapping(value = "/casualleavebalance", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String casualLeaveBalance(@RequestBody String data, HttpServletRequest req,
			HttpServletResponse res) throws JSONException {
		JSONObject aimlobj = new JSONObject();
		JSONObject aimlobjReq = new JSONObject(data);
		aimlobj.put("response", "You have 5 casual leaves.");
		aimlobj.put("aimlobjReq", aimlobjReq);
		JSONArray ja = new JSONArray();
		ja.put(aimlobj);
		return ja.toString();
	}
	
	@RequestMapping(value = "/earnedleavebalance", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String earnedLeaveBalance(@RequestBody String data) throws JSONException {
		JSONObject aimlobj = new JSONObject();
		JSONObject aimlobjReq = new JSONObject(data);
		aimlobj.put("response", "You have 12 earned leaves.");
		aimlobj.put("aimlobjReq", aimlobjReq);
		JSONArray ja = new JSONArray();
		ja.put(aimlobj);
		return ja.toString();
	}
	
	@RequestMapping(value = "/applyleave", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String applyLeave(@RequestBody String data) throws JSONException {
		JSONObject aimlobj = new JSONObject();
		JSONObject aimlobjReq = new JSONObject(data);
		aimlobj.put("response", "Your Leave has been applied and waiting for approval from your supervisor.");
		aimlobj.put("aimlobjReq", aimlobjReq);
		JSONArray ja = new JSONArray();
		ja.put(aimlobj);
		return ja.toString();
	}
	
	@RequestMapping(value = "/applyTravelRequest", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String applyTravelRequest(@RequestBody String data, HttpServletRequest req,
			HttpServletResponse res) throws JSONException {
		JSONObject aimlobj = new JSONObject();
		JSONObject aimlobjReq = new JSONObject(data);
		String str = req.getParameter("data");
		aimlobj.put("response", "Your request has been raised");
		aimlobj.put("aimlobjReq", aimlobjReq);
		aimlobj.put("params", str);
		JSONArray ja = new JSONArray();
		ja.put(aimlobj);
		return ja.toString();
	}
	
	@RequestMapping(value = "/fillTimesheet", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String fillTimesheet(@RequestBody String data, HttpServletRequest req,
			HttpServletResponse res) throws JSONException {
		JSONObject aimlobj = new JSONObject();
		JSONObject aimlobjReq = new JSONObject(data);
		String str = req.getParameter("data");
		aimlobj.put("response", "Timesheet successfully filled.");
		aimlobj.put("aimlobjReq", aimlobjReq);
		//aimlobj.put("params", str);
		JSONArray ja = new JSONArray();
		ja.put(aimlobj);
		return ja.toString();
	}
	
	@RequestMapping(value = "/getMyTasks", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String getMyTasks(@RequestBody String data, HttpServletRequest req,
			HttpServletResponse res) throws JSONException {
		JSONObject aimlobj = new JSONObject();
		JSONObject aimlobjReq = new JSONObject(data);
		List<String> taskList = new ArrayList<String>();
		String email = aimlobjReq.getString("emailId");
		
		if (email.equalsIgnoreCase("ankush.bandil@tcs.com")) {
			taskList.add("Task A");
			taskList.add("Task B");
			taskList.add("Task C");
		} else if (email.equalsIgnoreCase("madhura.girdhar@tcs.com")) {
			taskList.add("Task A");
			taskList.add("Task B");
			taskList.add("Task C");
			taskList.add("Task D");
		} else {
			taskList.add("Task A");
			taskList.add("Task B");
			taskList.add("Task C");
			taskList.add("Task D");
			taskList.add("Task E");
		}
		//String str = req.getParameter("data");
		aimlobj.put("response", "Timesheet successfully filled.");
		aimlobj.put("aimlobjReq", aimlobjReq);
		aimlobj.put("taskList", taskList);
		//aimlobj.put("params", str);
		JSONArray ja = new JSONArray();
		ja.put(aimlobj);
		return ja.toString();
	}
}
