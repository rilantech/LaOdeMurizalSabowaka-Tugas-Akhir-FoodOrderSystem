package com.tugasakhir.foodordersystem.repository.master;

import com.tugasakhir.foodordersystem.entity.managementuser.User;
import com.tugasakhir.foodordersystem.entity.master.MenuMakanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MenuMakananRepository extends JpaRepository<MenuMakanan, String>, JpaSpecificationExecutor<MenuMakanan> {

}
