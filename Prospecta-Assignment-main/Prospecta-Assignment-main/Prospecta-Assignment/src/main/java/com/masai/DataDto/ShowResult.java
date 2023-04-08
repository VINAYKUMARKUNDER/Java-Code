package com.masai.DataDto;

import java.util.List;

import lombok.Data;

@Data
public class ShowResult {
	
	private Integer count;
	private List<FilterData> filterData;

}
