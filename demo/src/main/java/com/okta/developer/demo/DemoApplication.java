package com.okta.developer.demo;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	@Bean
	ApplicationRunner init(StudentRepository studentRepository
						   ) {
		return args -> {
			Stream.of("B5903146", "B5906741","B5908622","B5913114","B5921263").forEach(id -> {
				Student s = new Student();
				s.setCardid(id);
				if(id.equals("B5903146")){
					s.setNametitle("นาย");
					s.setFirstname("อนันตกิจ");
					s.setLastname("ดวงดี");
					studentRepository.save(s);
				}
				else if(id.equals("B5906741")){
					s.setNametitle("นาย");
					s.setFirstname("มนัสนันท์");
					s.setLastname("กิตติชินภัทร");
					studentRepository.save(s);
				}
				else if(id.equals("B5908622")){
					s.setNametitle("นางสาว");
					s.setFirstname("รัตนามณี");
					s.setLastname("จงสืบสิทธิ");
					studentRepository.save(s);
				}
				else if(id.equals("B5913114")){
					s.setNametitle("นาย");
					s.setFirstname("นิธิกร");
					s.setLastname("ชำนาญกุล");
					studentRepository.save(s);
				}
				else if(id.equals("B5921263")){
					s.setNametitle("นาย");
					s.setFirstname("ชัยวัฒน์");
					s.setLastname("ลือเรือง");
					studentRepository.save(s);
				}
				
			});
			studentRepository.findAll().forEach(System.out::println);
		};
	
	}


}

