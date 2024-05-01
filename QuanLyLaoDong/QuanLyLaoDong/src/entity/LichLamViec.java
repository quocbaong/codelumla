package entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class LichLamViec implements Serializable{
	String malich;
	NhanVien nhanVien;
	CongViec congViec;
	Date ngayLam;
	Time thoiGianLam;
	
	public LichLamViec(String malich, NhanVien maNV, CongViec maCV, Date ngayLam, Time thoiGianLam) {
		super();
		this.malich = malich;
		this.nhanVien = maNV;
		this.congViec = maCV;
		this.ngayLam = ngayLam;
		this.thoiGianLam = thoiGianLam;
	}
	
	public LichLamViec() {
		super();
	}
	
	public String getMalich() {
		return malich;
	}
	
	public void setMalich(String malich) {
		this.malich = malich;
	}
	
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	
	public CongViec getCongViec() {
		return congViec;
	}
	
	public void setCongViec(CongViec congViec) {
		this.congViec = congViec;
	}
	
	public Date getNgayLam() {
		return ngayLam;
	}
	
	public void setNgayLam(Date ngayLam) {
		this.ngayLam = ngayLam;
	}
	
	public Time getThoiGianLam() {
		return thoiGianLam;
	}
	
	public void setThoiGianLam(Time thoiGianLam) {
		this.thoiGianLam = thoiGianLam;
	}
	
	@Override
	public String toString() {
		return "LichLamViec [malich=" + malich + ", maNV=" + nhanVien + ", maCV=" + congViec + ", ngayLam=" + ngayLam
				+ ", thoiGianLam=" + thoiGianLam + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(malich);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LichLamViec other = (LichLamViec) obj;
		return Objects.equals(malich, other.malich);
	}
}
