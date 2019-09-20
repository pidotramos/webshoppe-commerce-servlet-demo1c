package com.webshoppe.ecommerce.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public String getFormattedDate() {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-dd-MM");
		return dateFormatter.format(new Date());
	}
}
