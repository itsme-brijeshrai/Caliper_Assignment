package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Firm;
@Repository
public interface FirmDao extends JpaRepository<Firm, Integer>{

}
