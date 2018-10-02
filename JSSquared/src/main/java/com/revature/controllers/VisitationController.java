package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Visitation;
import com.revature.data.VisitationHibernate;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value = "/visit")

public class VisitationController {

	@Autowired
	private VisitationHibernate vh;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Visitation> processViewAllCasesRequest(HttpSession s) {
		List<Visitation> visitList = new ArrayList<>();
		visitList = vh.getAll();
		System.out.println(visitList);
	    return visitList;
	    }
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody List<Visitation> addCourtDate(@RequestBody Visitation v) {
		System.out.println(v);
		vh.save(v);
		return vh.getAll();
	    }
	
	@RequestMapping(method = RequestMethod.PUT)
	public @ResponseBody List<Visitation> updateCourtDate(@RequestBody Visitation v) {
		vh.update(v);
		return vh.getAll();
	    }
}
