package com.masai.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.masai.DataDto.FilterData;
import com.masai.DataDto.ResultDto;
import com.masai.Model.Entry;
import com.masai.Repo.EntryRepo;
import com.masai.Service.EntryService;

@Service
public class EntryServiceImpl implements EntryService {

	@Autowired
	private EntryRepo entryRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<FilterData> getAllFilteredEntry(String category) {

		ResultDto result = restTemplate.getForObject("https://api.publicapis.org/entries", ResultDto.class);

		List<FilterData> list = new ArrayList<>();

		for (Entry e : result.getEntries()) {

			if (e.getCategory().contains(category)) {
				System.out.println();
			}

			if (e.getCategory().toLowerCase().contains(category.toLowerCase())) {
				FilterData f = new FilterData();

				f.setDescription(e.getDescription());
				f.setTitle(e.getTitle());
				list.add(f);
			}
		}
		return list;
	}

	@Override
	public String AddOneEntry(Entry entry) {
		ResultDto result = restTemplate.getForObject("https://api.publicapis.org/entries", ResultDto.class);

		List<Entry> entries = result.getEntries();

		entries.add(entry);
		
		for (Entry e : entries) {
			entryRepo.save(e);
		}

		return "Data Add Suessfully";
	}

}
