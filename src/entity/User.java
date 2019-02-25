package entity;

import java.util.List;

import javax.validation.constraints.NotNull;

import validation.ValidEmail;

public class User extends Entity {

    private static final long serialVersionUID = 1L;

    private String real_name;

    @ValidEmail
    @NotNull
    private String email;

    private String password;
    
    private String phone_number;
    
    private List<Role> role;
    
	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

    

}
