package com.masai.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Model.Entry;

public interface EntryRepo extends JpaRepository<Entry, String>{

}
