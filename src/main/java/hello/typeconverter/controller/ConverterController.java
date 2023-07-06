package hello.typeconverter.controller;

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
