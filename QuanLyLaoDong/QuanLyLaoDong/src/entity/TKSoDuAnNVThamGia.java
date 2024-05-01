package entity;

public class TKSoDuAnNVThamGia {
	private String maNV;
	private String tenNV;
	private int soDuAn;
	public TKSoDuAnNVThamGia(String maNV, String tenNV, int soDuAn) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.soDuAn = soDuAn;
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
	public int getSoDuAn() {
		return soDuAn;
	}
	public void setSoDuAn(int soDuAn) {
		this.soDuAn = soDuAn;
	}
	
	
	
}
