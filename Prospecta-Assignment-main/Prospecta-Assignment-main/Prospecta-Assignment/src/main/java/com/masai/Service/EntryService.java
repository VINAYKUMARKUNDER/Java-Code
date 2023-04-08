package com.masai.Service;

import java.util.List;

import com.masai.DataDto.FilterData;
import com.masai.Model.Entry;

public interface EntryService {
	
	List<FilterData> getAllFilteredEntry( String category);
	 String AddOneEntry(Entry entry);

}
