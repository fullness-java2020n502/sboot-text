package com.fullnesssboot2.text.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PriceValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return ItemForm.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		ItemForm form = (ItemForm)target;
		if (form.getCategoryId()!= null && form.getPrice() != null) {
			if (form.getCategoryId()==1&&form.getPrice()>3000) {
				errors.reject("jp.co.fullness.java.SpringMVCExercise.exercise07.validator.message");
			}
		}
	}
}
