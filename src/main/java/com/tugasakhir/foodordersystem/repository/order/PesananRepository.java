package com.tugasakhir.foodordersystem.repository.order;

import com.tugasakhir.foodordersystem.entity.order.Pesanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PesananRepository extends JpaRepository<Pesanan, String>, JpaSpecificationExecutor<Pesanan> {

}
