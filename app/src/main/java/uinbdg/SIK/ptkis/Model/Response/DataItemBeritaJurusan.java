package uinbdg.SIK.ptkis.Model.Response;


import com.google.gson.annotations.SerializedName;


public class DataItemBeritaJurusan {

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("id_fak")
	private int idFak;

	@SerializedName("id_jur")
	private int idJur;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("kategori")
	private String kategori;

	@SerializedName("id")
	private int id;

	@SerializedName("judul")
	private String judul;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("id_univ")
	private int idUniv;

	@SerializedName("desc")
	private String desc;

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setIdFak(int idFak){
		this.idFak = idFak;
	}

	public int getIdFak(){
		return idFak;
	}

	public void setIdJur(int idJur){
		this.idJur = idJur;
	}

	public int getIdJur(){
		return idJur;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setKategori(String kategori){
		this.kategori = kategori;
	}

	public String getKategori(){
		return kategori;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
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

	public void setDesc(String desc){
		this.desc = desc;
	}

	public String getDesc(){
		return desc;
	}

	@Override
 	public String toString(){
		return 
			"DataItemBeritaJurusan{" +
			"updated_at = '" + updatedAt + '\'' + 
			",id_fak = '" + idFak + '\'' + 
			",id_jur = '" + idJur + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",kategori = '" + kategori + '\'' + 
			",id = '" + id + '\'' + 
			",judul = '" + judul + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",id_univ = '" + idUniv + '\'' + 
			",desc = '" + desc + '\'' + 
			"}";
		}
}