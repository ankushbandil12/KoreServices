package com.kore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KoreTravelServices {
	
	/*@RequestMapping(value = "/applyTravelRequest", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String applyTravelRequest(@RequestBody String data) throws JSONException {
		JSONObject aimlobj = new JSONObject();
		JSONObject aimlobjReq = new JSONObject(data);
		aimlobj.put("response", "Your request has been raised");
		aimlobj.put("aimlobjReq", aimlobjReq);
		JSONArray ja = new JSONArray();
		ja.put(aimlobj);
		return ja.toString();
	}*/
	
}
