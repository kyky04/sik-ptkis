package uinbdg.SIK.ptkis.Model.Response;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

	@SerializedName("data")
	private DataItemMahasiswa data;

	@SerializedName("status")
	private String status;

	public void setData(DataItemMahasiswa data){
		this.data = data;
	}

	public DataItemMahasiswa getData(){
		return data;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"LoginResponse{" + 
			"data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}