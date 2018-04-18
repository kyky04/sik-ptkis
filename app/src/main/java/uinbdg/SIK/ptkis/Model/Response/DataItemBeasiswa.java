package uinbdg.SIK.ptkis.Model.Response;


import com.google.gson.annotations.SerializedName;


public class DataItemBeasiswa {

    @SerializedName("penghasilan")
    private int penghasilan;

    @SerializedName("tanggungan")
    private int tanggungan;

    @SerializedName("kriteria_rumah")
    private String kriteriaRumah;

    @SerializedName("kepimilikan_rumah")
    private String kepimilikanRumah;

    @SerializedName("luas_tanah")
    private int luasTanah;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id_mahasiswa")
    private int idMahasiswa;

    @SerializedName("deleted_at")
    private Object deletedAt;

    @SerializedName("isi_rumah")
    private String isiRumah;

    @SerializedName("jarak_pusat_kota")
    private int jarakPusatKota;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("id")
    private int id;

    @SerializedName("nilai_un")
    private String nilaiUn;

    @SerializedName("sumber_air")
    private String sumberAir;

    @SerializedName("prestasi")
    private String prestasi;

    @SerializedName("mandi_cuci_kakus")
    private String mandiCuciKakus;

    @SerializedName("mahasiswa")
    private DataItemMahasiswa mahasiswa;


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


    public DataItemMahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(DataItemMahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
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

    public double getVectorS() {
        return vectorS;
    }

    public void setVectorS(double vectorS) {
        this.vectorS = vectorS;
    }

    public double getVectorV() {
        return vectorV;
    }

    public void setVectorV(double vectorV) {
        this.vectorV = vectorV;
    }

    public void setPenghasilan(int penghasilan) {
        this.penghasilan = penghasilan;
    }

    public int getPenghasilan() {
        return penghasilan;
    }

    public void setTanggungan(int tanggungan) {
        this.tanggungan = tanggungan;
    }

    public int getTanggungan() {
        return tanggungan;
    }

    public void setKriteriaRumah(String kriteriaRumah) {
        this.kriteriaRumah = kriteriaRumah;
    }

    public String getKriteriaRumah() {
        return kriteriaRumah;
    }

    public void setKepimilikanRumah(String kepimilikanRumah) {
        this.kepimilikanRumah = kepimilikanRumah;
    }

    public String getKepimilikanRumah() {
        return kepimilikanRumah;
    }

    public void setLuasTanah(int luasTanah) {
        this.luasTanah = luasTanah;
    }

    public int getLuasTanah() {
        return luasTanah;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setIdMahasiswa(int idMahasiswa) {
        this.idMahasiswa = idMahasiswa;
    }

    public int getIdMahasiswa() {
        return idMahasiswa;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setIsiRumah(String isiRumah) {
        this.isiRumah = isiRumah;
    }

    public String getIsiRumah() {
        return isiRumah;
    }

    public void setJarakPusatKota(int jarakPusatKota) {
        this.jarakPusatKota = jarakPusatKota;
    }

    public int getJarakPusatKota() {
        return jarakPusatKota;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNilaiUn(String nilaiUn) {
        this.nilaiUn = nilaiUn;
    }

    public String getNilaiUn() {
        return nilaiUn;
    }

    public void setSumberAir(String sumberAir) {
        this.sumberAir = sumberAir;
    }

    public String getSumberAir() {
        return sumberAir;
    }

    public void setPrestasi(String prestasi) {
        this.prestasi = prestasi;
    }

    public String getPrestasi() {
        return prestasi;
    }

    public void setMandiCuciKakus(String mandiCuciKakus) {
        this.mandiCuciKakus = mandiCuciKakus;
    }

    public String getMandiCuciKakus() {
        return mandiCuciKakus;
    }

    @Override
    public String toString() {
        return
                "DataItemBeasiswa{" +
                        "penghasilan = '" + penghasilan + '\'' +
                        ",tanggungan = '" + tanggungan + '\'' +
                        ",kriteria_rumah = '" + kriteriaRumah + '\'' +
                        ",kepimilikan_rumah = '" + kepimilikanRumah + '\'' +
                        ",luas_tanah = '" + luasTanah + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",id_mahasiswa = '" + idMahasiswa + '\'' +
                        ",deleted_at = '" + deletedAt + '\'' +
                        ",isi_rumah = '" + isiRumah + '\'' +
                        ",jarak_pusat_kota = '" + jarakPusatKota + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",id = '" + id + '\'' +
                        ",nilai_un = '" + nilaiUn + '\'' +
                        ",sumber_air = '" + sumberAir + '\'' +
                        ",prestasi = '" + prestasi + '\'' +
                        ",mandi_cuci_kakus = '" + mandiCuciKakus + '\'' +
                        "}";
    }
}