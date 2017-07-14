package com.dateitem.model;

import java.util.List;


	public interface DateItemDAO_interface {
		void add(DateItem dateItem);
		void update(DateItem dateItem);
		void delete(int dateItemNo);
		DateItem findByPk(int dateItemNo);
		List<DateItem> getAll();
	}
	

