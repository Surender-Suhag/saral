package com.test.frmw.saral.dao;

import com.test.frmw.saral.model.ComponentDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbComponentsDao extends JpaRepository<ComponentDetails,String> {
}
