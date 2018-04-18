package uinbdg.SIK.ptkis.Model.Response;


import com.google.gson.annotations.SerializedName;


public class DataItemPendaftar {

	@SerializedName("id")
	private Integer id;

	@SerializedName("nilai_un")
	private String nilaiUn;

	@SerializedName("bobotPenghasilan")
	private Integer penghasilan;

	@SerializedName("tanggungan")
	private Integer tanggungan;

	@SerializedName("prestasi")
	private String prestasi;

	@SerializedName("kriteria_rumah")
	private String kriteriaRumah;

	@SerializedName("kepimilikan_rumah")
	private String kepimilikanRumah;

	@SerializedName("isi_rumah")
	private String isiRumah;

	@SerializedName("mandi_cuci_kakus")
	private String mandiCuciKakus;

	@SerializedName("luas_tanah")
	private Integer luasTanah;

	@SerializedName("jarak_pusat_kota")
	private Integer jarakPusatKota;

	@SerializedName("sumber_air")
	private String sumberAir;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("id_mahasiswa")
	private Integer idMahasiswa;


	private Integer bobotNilaiUn;
	private Integer bobotPrestasi;
	private Integer jumlahTanggungan;
	private Integer bobotPenghasilan;
	private Integer bobotKriteriaRumah;
	private Integer bobotKepemilikanRumah;
	private Integer bobotIsiRumah;
	private Integer bobotMandiCuciKakus;
	private Integer bobotLuasTanah;
	private Integer bobotJarakPusatKota;
	private Integer bobotSumberAir;

	private double vectorS;
	private double vectorV;

	public double getVectorV() {
		return vectorV;
	}

	public void setVectorV(double vectorV) {
		this.vectorV = vectorV;
	}

	public double getVectorS() {
		return vectorS;
	}

	public void setVectorS(double vectorS) {
		this.vectorS = vectorS;
	}


	public Integer getBobotNilaiUn() {
		return bobotNilaiUn;
	}

	public void setBobotNilaiUn(Integer bobotNilaiUn) {
		this.bobotNilaiUn = bobotNilaiUn;
	}

	public Integer getBobotPrestasi() {
		return bobotPrestasi;
	}

	public void setBobotPrestasi(Integer bobotPrestasi) {
		this.bobotPrestasi = bobotPrestasi;
	}

	public Integer getJumlahTanggungan() {
		return jumlahTanggungan;
	}

	public void setJumlahTanggungan(Integer jumlahTanggungan) {
		this.jumlahTanggungan = jumlahTanggungan;
	}

	public Integer getBobotPenghasilan() {
		return bobotPenghasilan;
	}

	public void setBobotPenghasilan(Integer bobotPenghasilan) {
		this.bobotPenghasilan = bobotPenghasilan;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNilaiUn() {
		return nilaiUn;
	}

	public void setNilaiUn(String nilaiUn) {
		this.nilaiUn = nilaiUn;
	}

	public Integer getPenghasilan() {
		return penghasilan;
	}

	public void setPenghasilan(Integer penghasilan) {
		this.penghasilan = penghasilan;
	}

	public Integer getTanggungan() {
		return tanggungan;
	}

	public void setTanggungan(Integer tanggungan) {
		this.tanggungan = tanggungan;
	}

	public String getPrestasi() {
		return prestasi;
	}

	public void setPrestasi(String prestasi) {
		this.prestasi = prestasi;
	}

	public String getKriteriaRumah() {
		return kriteriaRumah;
	}

	public void setKriteriaRumah(String kriteriaRumah) {
		this.kriteriaRumah = kriteriaRumah;
	}

	public String getKepimilikanRumah() {
		return kepimilikanRumah;
	}

	public void setKepimilikanRumah(String kepimilikanRumah) {
		this.kepimilikanRumah = kepimilikanRumah;
	}

	public String getIsiRumah() {
		return isiRumah;
	}

	public void setIsiRumah(String isiRumah) {
		this.isiRumah = isiRumah;
	}

	public String getMandiCuciKakus() {
		return mandiCuciKakus;
	}

	public void setMandiCuciKakus(String mandiCuciKakus) {
		this.mandiCuciKakus = mandiCuciKakus;
	}

	public Integer getLuasTanah() {
		return luasTanah;
	}

	public void setLuasTanah(Integer luasTanah) {
		this.luasTanah = luasTanah;
	}

	public Integer getJarakPusatKota() {
		return jarakPusatKota;
	}

	public void setJarakPusatKota(Integer jarakPusatKota) {
		this.jarakPusatKota = jarakPusatKota;
	}

	public String getSumberAir() {
		return sumberAir;
	}

	public void setSumberAir(String sumberAir) {
		this.sumberAir = sumberAir;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Object getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Object deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Integer getIdMahasiswa() {
		return idMahasiswa;
	}

	public void setIdMahasiswa(Integer idMahasiswa) {
		this.idMahasiswa = idMahasiswa;
	}

	public Integer getBobotKriteriaRumah() {
		return bobotKriteriaRumah;
	}

	public void setBobotKriteriaRumah(Integer bobotKriteriaRumah) {
		this.bobotKriteriaRumah = bobotKriteriaRumah;
	}

	public Integer getBobotKepemilikanRumah() {
		return bobotKepemilikanRumah;
	}

	public void setBobotKepemilikanRumah(Integer bobotKepemilikanRumah) {
		this.bobotKepemilikanRumah = bobotKepemilikanRumah;
	}

	public Integer getBobotIsiRumah() {
		return bobotIsiRumah;
	}

	public void setBobotIsiRumah(Integer bobotIsiRumah) {
		this.bobotIsiRumah = bobotIsiRumah;
	}

	public Integer getBobotMandiCuciKakus() {
		return bobotMandiCuciKakus;
	}

	public void setBobotMandiCuciKakus(Integer bobotMandiCuciKakus) {
		this.bobotMandiCuciKakus = bobotMandiCuciKakus;
	}

	public Integer getBobotLuasTanah() {
		return bobotLuasTanah;
	}

	public void setBobotLuasTanah(Integer bobotLuasTanah) {
		this.bobotLuasTanah = bobotLuasTanah;
	}

	public Integer getBobotJarakPusatKota() {
		return bobotJarakPusatKota;
	}

	public void setBobotJarakPusatKota(Integer bobotJarakPusatKota) {
		this.bobotJarakPusatKota = bobotJarakPusatKota;
	}

	public Integer getBobotSumberAir() {
		return bobotSumberAir;
	}

	public void setBobotSumberAir(Integer bobotSumberAir) {
		this.bobotSumberAir = bobotSumberAir;
	}
}