package com.tugasakhir.foodordersystem.repository.order;

import com.tugasakhir.foodordersystem.entity.order.Pesanan;
import com.tugasakhir.foodordersystem.entity.order.RiwayatTransaksiPemesanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RiwayatTransaksiPemesananRepository extends JpaRepository<RiwayatTransaksiPemesanan, String>, JpaSpecificationExecutor<RiwayatTransaksiPemesanan> {

}
