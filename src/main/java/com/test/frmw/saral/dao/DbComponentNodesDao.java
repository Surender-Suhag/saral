package com.test.frmw.saral.dao;

import com.test.frmw.saral.model.ComponentDetails;
import com.test.frmw.saral.model.ComponentNodeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DbComponentNodesDao extends JpaRepository<ComponentNodeDetails,String> {
    @Query("from ComponentNodeDetails as comp where comp.parentNode is null")
    ComponentNodeDetails findRootElement();
}
