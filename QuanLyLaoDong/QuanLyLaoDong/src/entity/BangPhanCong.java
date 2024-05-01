package entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

public class BangPhanCong implements Serializable{
 
	private static final long serialVersionUID = 1L;
	private String maBPC;
	private NhanVien nhanVien;
	private CongTrinh congTrinh;
	private CongViec congViec;
	private int soNgayCongThamGia;
	private Date ngayBatDau,ngayKetThuc;
	private String ghiChu;
	public BangPhanCong() {
		super();
	}
	public BangPhanCong(String maBPC, NhanVien nhanVien, CongTrinh congTrinh, CongViec congViec, int soNgayCongThamGia,
			Date ngayBatDau, Date ngayKetThuc, String ghiChu) {
		super();
		this.maBPC = maBPC;
		this.nhanVien = nhanVien;
		this.congTrinh = congTrinh;
		this.congViec = congViec;
		this.soNgayCongThamGia = soNgayCongThamGia;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
		this.ghiChu = ghiChu;
	}
	public String getMaBPC() {
		return maBPC;
	}
	public void setMaBPC(String maBPC) {
		this.maBPC = maBPC;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public CongTrinh getCongTrinh() {
		return congTrinh;
	}
	public void setCongTrinh(CongTrinh congTrinh) {
		this.congTrinh = congTrinh;
	}
	public CongViec getCongViec() {
		return congViec;
	}
	public void setCongViec(CongViec congViec) {
		this.congViec = congViec;
	}
	public int getSoNgayCongThamGia() {
		return soNgayCongThamGia;
	}
	public void setSoNgayCongThamGia(int soNgayCongThamGia) {
		this.soNgayCongThamGia = soNgayCongThamGia;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}
	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BangPhanCong [maBPC=" + maBPC + ", nhanVien=" + nhanVien + ", congTrinh=" + congTrinh + ", congViec="
				+ congViec + ", soNgayCongThamGia=" + soNgayCongThamGia + ", ngayBatDau=" + ngayBatDau
				+ ", ngayKetThuc=" + ngayKetThuc + ", ghiChu=" + ghiChu + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maBPC);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BangPhanCong other = (BangPhanCong) obj;
		return Objects.equals(maBPC, other.maBPC);
	}
	
}
