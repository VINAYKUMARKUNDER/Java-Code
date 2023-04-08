package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.DataDto.FilterData;
import com.masai.DataDto.ShowResult;
import com.masai.Model.Entry;
import com.masai.Service.EntryService;

@RestController
public class EntryController {

	@Autowired
	private EntryService entryService;
	
	
	@GetMapping("/entries/{category}")
	public ResponseEntity<ShowResult>  getAllFilterResult(@PathVariable("category")  String Category){
		List<FilterData> allFilteredEntry = entryService.getAllFilteredEntry(Category);
		
		ShowResult show = new ShowResult();
		show.setCount(allFilteredEntry.size());
		show.setFilterData(allFilteredEntry);
		return new ResponseEntity<ShowResult>(show, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/entries")
	public ResponseEntity<String> addEntry(@RequestBody Entry en) {
			String msg = entryService.AddOneEntry(en);
			return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
}
