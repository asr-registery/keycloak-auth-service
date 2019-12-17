package af.asr.keycloakauthservice.data.dto;

import java.io.Serializable;
import java.util.List;


public class RolesListDto implements Serializable {
	private static final long serialVersionUID = -5863653796023079898L;

	List<Role> roles;

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
