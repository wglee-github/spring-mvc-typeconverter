package hello.typeconverter;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.MyNumberFormatter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addFormatters(FormatterRegistry registry) {
		// 컨버터가 포맷터보다 우선순위 높기때문에 같은 기능을 하는 컨버터 주석처리  
//		registry.addConverter(new IntegerToStringConverter());
//		registry.addConverter(new StringToIntegerConverter());
		registry.addConverter(new IpPortToStringConverter());
		registry.addConverter(new StringToIpPortConverter());
		
		registry.addFormatter(new MyNumberFormatter());
	}

	
}
