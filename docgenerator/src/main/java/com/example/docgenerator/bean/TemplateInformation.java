package com.example.docgenerator.bean;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TemplateInformation {

	@NotEmpty
	private String name;

	@NotEmpty
	private String goodbye;

	@NotEmpty
	private String salutation;

}