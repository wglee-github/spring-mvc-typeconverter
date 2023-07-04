package hello.typeconverter.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import hello.typeconverter.type.IpPort;
import lombok.Data;

@Controller
public class ConverterController {

	@GetMapping("/converter-view")
	public String converterView(Model model) {
		model.addAttribute("number", 10000);
		model.addAttribute("ipPort", new IpPort("127.0.0.1", 8080));
		return "converter-view";
	}
	
	@GetMapping("/converter/edit")
	public String converterForm(Model model) {
		IpPort ipPort = new IpPort("127.0.0.1", 8080);
		Form form = new Form(ipPort, "사용자");
		model.addAttribute("form", form);
		
		List<Form> list1 = new ArrayList<>();
		list1.add(new Form(new IpPort("127.0.0.1", 8081), "A사용자"));
		list1.add(new Form(new IpPort("127.0.0.2", 8082), "B사용자"));
		List<Form> list2 = new ArrayList<>();
		list2.add(new Form(new IpPort("127.0.0.3", 8083), "C사용자"));
		list2.add(new Form(new IpPort("127.0.0.4", 8084), "D사용자"));
		List<Form> list3 = new ArrayList<>();
		list3.add(new Form(new IpPort("127.0.0.5", 8085), "E사용자"));
		list3.add(new Form(new IpPort("127.0.0.6", 8085), "F사용자"));
		
		Map<String, List<Form>> map = new HashMap<>();
		map.put("A", list1);
		map.put("B", list2);
		map.put("C", list3);
		
		model.addAttribute("map", map);
		
		return "converter-form";
	}
	
	@PostMapping("/converter/edit")
	public String convertEdit(@ModelAttribute Form form, Model model) {
		IpPort ipPort = form.getIpPort();
		model.addAttribute("ipPort", ipPort);
		return "converter-view";
	}
	
	@Data
	static class Form{
		private IpPort ipPort;
		private String name;
		
		public Form(IpPort ipPort, String name) {
			this.ipPort = ipPort;
			this.name = name;
		}
		
		
	}
}
