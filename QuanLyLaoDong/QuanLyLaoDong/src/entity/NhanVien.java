package entity;

import java.sql.Date;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private Date ngaySinh;
	private boolean gioiTinh;
	private String sdt;
	private String cccd;
	private String diaChiTamTru;
	private String diaCHiThuongTru;
	private String chucVu;
	private PhongBan phongBan;
	
	
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	public NhanVien(String maNV, String tenNV, Date ngaySinh, boolean gioiTinh, String sdt, String cccd,
			String diaChiTamTru, String diaCHiThuongTru, String chucVu, PhongBan phongBan) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.cccd = cccd;
		this.diaChiTamTru = diaChiTamTru;
		this.diaCHiThuongTru = diaCHiThuongTru;
		this.chucVu = chucVu;
		this.phongBan = phongBan;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public String getDiaChiTamTru() {
		return diaChiTamTru;
	}
	public void setDiaChiTamTru(String diaChiTamTru) {
		this.diaChiTamTru = diaChiTamTru;
	}
	public String getDiaCHiThuongTru() {
		return diaCHiThuongTru;
	}
	public void setDiaCHiThuongTru(String diaCHiThuongTru) {
		this.diaCHiThuongTru = diaCHiThuongTru;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public PhongBan getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh
				+ ", sdt=" + sdt + ", cccd=" + cccd + ", diaChiTamTru=" + diaChiTamTru + ", diaCHiThuongTru="
				+ diaCHiThuongTru + ", chucVu=" + chucVu + ", phongBan=" + phongBan + "]";
	}
	
	
}
