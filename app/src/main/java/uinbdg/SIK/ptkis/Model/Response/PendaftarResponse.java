package uinbdg.SIK.ptkis.Model.Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class PendaftarResponse{

	@SerializedName("data")
	private List<DataItemPendaftar> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemPendaftar> data){
		this.data = data;
	}

	public List<DataItemPendaftar> getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"PendaftarResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}