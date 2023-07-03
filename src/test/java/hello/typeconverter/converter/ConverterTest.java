package hello.typeconverter.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import hello.typeconverter.type.IpPort;

class ConverterTest {

	@Test
	void stringToInteger() {
		StringToIntegerConverter converter = new StringToIntegerConverter();
		Integer result = converter.convert("10");
		
		assertThat(result).isEqualTo(10);
	}

	
	@Test
	void integerToString() {
		IntegerToStringConverter converter = new IntegerToStringConverter();
		String result = converter.convert(10);
		assertThat(result).isEqualTo("10");
	}
	
	@Test
	void stringToIpPort() {
		StringToIpPortConverter converter = new StringToIpPortConverter();
		String source = "127.0.0.1:8080";
		assertThat(converter.convert(source)).isEqualTo(new IpPort("127.0.0.1", 8080));
	}
	
	@Test
	void ipPortToString(){
		IpPortToStringConverter converter = new IpPortToStringConverter();
		IpPort ipPort = new IpPort("127.0.0.1", 8080);
		String converterIpPort = converter.convert(ipPort);
		assertThat(converterIpPort).isEqualTo("127.0.0.1:8080");
	}
}
