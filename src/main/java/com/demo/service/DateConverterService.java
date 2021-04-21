package com.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateConverterService {
	public final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	public LocalDate formatStringDate(String date) {
		return LocalDate.parse(date, formatter);
	}
}
