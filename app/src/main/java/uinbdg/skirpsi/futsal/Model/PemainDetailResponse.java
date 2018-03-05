package uinbdg.skirpsi.futsal.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PemainDetailResponse {

	@SerializedName("data")
	private List<DataItemPemain> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemPemain> data){
		this.data = data;
	}

	public List<DataItemPemain> getData(){
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
			"PemainResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}