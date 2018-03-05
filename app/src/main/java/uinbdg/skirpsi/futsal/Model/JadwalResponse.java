package uinbdg.skirpsi.futsal.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class JadwalResponse{

	@SerializedName("data")
	private List<DataItemJadwal> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemJadwal> data){
		this.data = data;
	}

	public List<DataItemJadwal> getData(){
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
			"JadwalResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}