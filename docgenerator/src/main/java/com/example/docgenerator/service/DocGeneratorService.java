package com.example.docgenerator.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.docgenerator.bean.TemplateInformation;
import com.example.docgenerator.generator.DocxGenerator;

@Service
public class DocGeneratorService {

	public byte[] generatePDF(TemplateInformation userInformation) throws Exception {
		Map<String, Object> variables = new HashMap();
		variables.put("user", userInformation.getName());
	    variables.put("salutation", userInformation.getSalutation());
	    variables.put("goodbye", userInformation.getGoodbye());
	    
	    String templateName = "template.ftl";
		return DocxGenerator.generatePDF(templateName, variables);
	}

	public byte[] generateWord(TemplateInformation userInformation) throws Exception {
		Map<String, Object> variables = new HashMap();
		variables.put("user", userInformation.getName());
	    variables.put("salutation", userInformation.getSalutation());
	    variables.put("goodbye", userInformation.getGoodbye());
	    
	    String templateName = "template.ftl";
		return DocxGenerator.generateWord(templateName, variables);
	}
	
}
