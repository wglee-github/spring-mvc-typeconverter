package hello.typeconverter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import hello.typeconverter.type.IpPort;

class conversionServiceTest {

	@Test
	void conversionService() {
		// 등록
		DefaultConversionService conversionService = new DefaultConversionService();
		conversionService.addConverter(new IntegerToStringConverter());
		conversionService.addConverter(new StringToIntegerConverter());
		conversionService.addConverter(new IpPortToStringConverter());
		conversionService.addConverter(new StringToIpPortConverter());
		
		// 사용
		Integer integerValue = conversionService.convert("10", Integer.class);
		String stringValue = conversionService.convert(10, String.class);
		String stringIpPort = conversionService.convert(new IpPort("127.0.0.1",8080), String.class);
		IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
		
		assertThat(integerValue).isEqualTo(10);
		assertThat(stringValue).isEqualTo("10");
		assertThat(stringIpPort).isEqualTo("127.0.0.1:8080");
		assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1",8080));
	}

}
