package com.masai.DataDto;

import java.util.List;

import com.masai.Model.Entry;

import lombok.Data;


@Data
public class ResultDto {
	
	private Integer count;
	private List<Entry> entries;

}
