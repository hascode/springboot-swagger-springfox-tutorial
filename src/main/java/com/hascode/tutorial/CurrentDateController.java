package com.hascode.tutorial;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrentDateController {

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/currentdate/{pattern}")
	public FormattedDate greeting(@PathVariable final String pattern) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);

		return new FormattedDate(counter.incrementAndGet(), pattern, fmt.format(LocalDateTime.now()));
	}
}