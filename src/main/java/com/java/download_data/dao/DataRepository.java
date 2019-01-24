package com.java.download_data.dao;

import com.java.download_data.model.DataModel;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DataRepository extends CrudRepository<DataModel,UUID> {
}
