package uinbdg.SIK.ptkis.Model.Response;


import com.google.gson.annotations.SerializedName;


public class DataItemPendaftar {

	@SerializedName("jurusan_mahasiswa")
	private String jurusanMahasiswa;

	@SerializedName("pendapatan_orangtua")
	private String pendapatanOrangtua;

	@SerializedName("nama_mahasiswa")
	private String namaMahasiswa;

	@SerializedName("ipk")
	private String ipk;

	@SerializedName("prestasi_akademik")
	private String prestasiAkademik;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("id_univ")
	private int idUniv;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("tanggungan_orangtua")
	private String tanggunganOrangtua;

	@SerializedName("nim")
	private String nim;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("semester")
	private String semester;

	@SerializedName("id")
	private int id;

	@SerializedName("kendaraan_pribadi")
	private String kendaraanPribadi;

	public void setJurusanMahasiswa(String jurusanMahasiswa){
		this.jurusanMahasiswa = jurusanMahasiswa;
	}

	public String getJurusanMahasiswa(){
		return jurusanMahasiswa;
	}

	public void setPendapatanOrangtua(String pendapatanOrangtua){
		this.pendapatanOrangtua = pendapatanOrangtua;
	}

	public String getPendapatanOrangtua(){
		return pendapatanOrangtua;
	}

	public void setNamaMahasiswa(String namaMahasiswa){
		this.namaMahasiswa = namaMahasiswa;
	}

	public String getNamaMahasiswa(){
		return namaMahasiswa;
	}

	public void setIpk(String ipk){
		this.ipk = ipk;
	}

	public String getIpk(){
		return ipk;
	}

	public void setPrestasiAkademik(String prestasiAkademik){
		this.prestasiAkademik = prestasiAkademik;
	}

	public String getPrestasiAkademik(){
		return prestasiAkademik;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setIdUniv(int idUniv){
		this.idUniv = idUniv;
	}

	public int getIdUniv(){
		return idUniv;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setTanggunganOrangtua(String tanggunganOrangtua){
		this.tanggunganOrangtua = tanggunganOrangtua;
	}

	public String getTanggunganOrangtua(){
		return tanggunganOrangtua;
	}

	public void setNim(String nim){
		this.nim = nim;
	}

	public String getNim(){
		return nim;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setSemester(String semester){
		this.semester = semester;
	}

	public String getSemester(){
		return semester;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setKendaraanPribadi(String kendaraanPribadi){
		this.kendaraanPribadi = kendaraanPribadi;
	}

	public String getKendaraanPribadi(){
		return kendaraanPribadi;
	}

	@Override
 	public String toString(){
		return 
			"DataItemPendaftar{" +
			"jurusan_mahasiswa = '" + jurusanMahasiswa + '\'' + 
			",pendapatan_orangtua = '" + pendapatanOrangtua + '\'' + 
			",nama_mahasiswa = '" + namaMahasiswa + '\'' + 
			",ipk = '" + ipk + '\'' + 
			",prestasi_akademik = '" + prestasiAkademik + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",id_univ = '" + idUniv + '\'' + 
			",alamat = '" + alamat + '\'' + 
			",tanggungan_orangtua = '" + tanggunganOrangtua + '\'' + 
			",nim = '" + nim + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",semester = '" + semester + '\'' + 
			",id = '" + id + '\'' + 
			",kendaraan_pribadi = '" + kendaraanPribadi + '\'' + 
			"}";
		}
}