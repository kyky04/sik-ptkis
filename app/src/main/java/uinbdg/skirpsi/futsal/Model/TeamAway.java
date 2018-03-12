package uinbdg.skirpsi.futsal.Model;


import com.google.gson.annotations.SerializedName;


public class TeamAway{

	@SerializedName("nama")
	private String nama;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("id_user")
	private int idUser;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("id_lapang")
	private int idLapang;

	@SerializedName("lapang")
	private Lapang lapang;

	@SerializedName("jadwal")
	private DataItemJadwal jadwal;

	public DataItemJadwal getJadwal() {
		return jadwal;
	}

	public void setJadwal(DataItemJadwal jadwal) {
		this.jadwal = jadwal;
	}

	public Lapang getLapang() {
		return lapang;
	}

	public void setLapang(Lapang lapang) {
		this.lapang = lapang;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setIdUser(int idUser){
		this.idUser = idUser;
	}

	public int getIdUser(){
		return idUser;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setIdLapang(int idLapang){
		this.idLapang = idLapang;
	}

	public int getIdLapang(){
		return idLapang;
	}

	@Override
 	public String toString(){
		return 
			"TeamAway{" + 
			"nama = '" + nama + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",id_lapang = '" + idLapang + '\'' + 
			"}";
		}
}