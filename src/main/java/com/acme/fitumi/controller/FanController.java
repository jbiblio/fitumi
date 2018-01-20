package com.acme.fitumi.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.acme.fitumi.model.Customer;
import com.acme.fitumi.repository.CustomerRepository;

@Controller
@RequestMapping("/fans")
public class FanController {
	private static final Log log = LogFactory.getLog(FanController.class);
	@Autowired
	private CustomerRepository repository;

	@RequestMapping(method = RequestMethod.GET)
	public String getFans(Model model) {

		try {
			Customer fans = new Customer("Michael", "Holtermann");
			repository.save(fans);

			List<Customer> all = repository.findAll();

			model.addAttribute("fans", all);

			return "fans";
		} catch (Exception exc) {
			log.error(exc.getMessage(), exc);
			return "fans";
		}
	}
}
