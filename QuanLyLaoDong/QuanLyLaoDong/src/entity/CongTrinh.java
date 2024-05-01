package entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class CongTrinh implements Serializable{
	private String maCT;
	private String tenCT;
	private String diaDiem;
	private Date ngayCapPhep;
	private Date ngayKhoiCong;
	private Date ngayHT;
	
	public CongTrinh(String maCT) {
		super();
		this.maCT = maCT;
	}
	
	public CongTrinh(String maCT, String tenCT, String diaDiem, Date ngayCapPhep, Date ngayKhoiCong,
			Date ngayHT) {
		super();
		this.maCT = maCT;
		this.tenCT = tenCT;
		this.diaDiem = diaDiem;
		this.ngayCapPhep = ngayCapPhep;
		this.ngayKhoiCong = ngayKhoiCong;
		this.ngayHT = ngayHT;
	}
	
	public CongTrinh() {
		super();
	}
	
	public String getMaCT() {
		return maCT;
	}
	
	public void setMaCT(String maCT) {
		this.maCT = maCT;
	}
	
	public String getTenCT() {
		return tenCT;
	} 
	
	public void setTenCT(String tenCT) {
		this.tenCT = tenCT;
	}
	
	public String getDiaDiem() {
		return diaDiem;
	}
	
	public void setDiaDiem(String diaDiem) {
		this.diaDiem = diaDiem;
	}
	
	public Date getNgayCapPhep() {
		return ngayCapPhep;
	}
	
	public void setNgayCapPhep(Date ngayCapPhep) {
		this.ngayCapPhep = ngayCapPhep;
	}
	
	public Date getNgayKhoiCong() {
		return ngayKhoiCong;
	}
	
	public void setNgayKhoiCong(Date ngayKhoiCong) {
		this.ngayKhoiCong = ngayKhoiCong;
	}
	
	public Date getNgayHT() {
		return ngayHT;
	}
	
	public void setNgayHT(Date ngayHT) {
		this.ngayHT = ngayHT;
	}
	
	@Override
	public String toString() {
		return "CongTrinh [maCT=" + maCT + ", tenCT=" + tenCT + ", diaDiem=" + diaDiem + ", ngayCapPhep=" + ngayCapPhep
				+ ", ngayKhoiCong=" + ngayKhoiCong + ", ngayHT=" + ngayHT + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maCT);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CongTrinh other = (CongTrinh) obj;
		return Objects.equals(maCT, other.maCT);
	}
}
