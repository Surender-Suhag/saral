package com.test.frmw.saral.dao;

import com.test.frmw.saral.model.ParameterDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DbParameterDao extends JpaRepository<ParameterDetails,Long> {
}
