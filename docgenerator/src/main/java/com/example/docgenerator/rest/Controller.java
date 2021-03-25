package com.example.docgenerator.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.docgenerator.bean.TemplateInformation;
import com.example.docgenerator.generator.DocxGenerator;
import com.example.docgenerator.service.DocGeneratorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class Controller {

	private final DocGeneratorService generator;


	@GetMapping(value = "/pdf/{name}")
	@ResponseBody
	public ResponseEntity<byte[]> examplePdf(@PathVariable("name") String name, @RequestParam("salutation") String salutation,
			@RequestParam("goodbye") String goodBye) {
		TemplateInformation user = new TemplateInformation();
		user.setName(name);
		user.setSalutation(salutation);
		user.setGoodbye(goodBye);
		byte[] result;

		try {
			result = generator.generatePDF(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=message.pdf");
		return new ResponseEntity<byte[]>(result,headers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/word/{name}")
	@ResponseBody
	public ResponseEntity<byte[]> exampleWord(@PathVariable("name") String name, @RequestParam("salutation") String salutation,
			@RequestParam("goodbye") String goodBye) {
		TemplateInformation user = new TemplateInformation();
		user.setName(name);
		user.setSalutation(salutation);
		user.setGoodbye(goodBye);
		byte[] result;

		try {
			result = generator.generateWord(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename=message.doc");
		return new ResponseEntity<byte[]>(result,headers, HttpStatus.OK);
	}

}
