package com.hascode.tutorial;

public class FormattedDate {
	private final long id;
	private final String dateString;
	private final String pattern;

	public FormattedDate(final long id, final String pattern, final String dateString) {
		this.id = id;
		this.pattern = pattern;
		this.dateString = dateString;
	}

	public long getId() {
		return id;
	}

	public String getPattern() {
		return pattern;
	}

	public String getDate() {
		return dateString;
	}
}
