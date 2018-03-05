package uinbdg.skirpsi.futsal.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class KompetisiResponse{

	@SerializedName("data")
	private List<DataItemKompetisi> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemKompetisi> data){
		this.data = data;
	}

	public List<DataItemKompetisi> getData(){
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
			"KompetisiResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}