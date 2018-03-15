package uinbdg.SIK.ptkis.Model.Response;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class UniversitasResponse{

	@SerializedName("data")
	private List<DataItemUniversitas> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemUniversitas> data){
		this.data = data;
	}

	public List<DataItemUniversitas> getData(){
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
			"UniversitasResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}