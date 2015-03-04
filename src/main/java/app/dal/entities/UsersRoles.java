package app.dal.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS_ROLES", schema = "PUBLIC", catalog = "PUBLIC")
public class UsersRoles implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private UsersRolesId id;
    private Users users;
    private Roles roles;
    
	public UsersRoles() {
	}

	public UsersRoles(UsersRolesId id, Users users, Roles roles) {
		this.id = id;
		this.users = users;
		this.roles = roles;
	}
 
    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "userId", column = @Column(name = "USER_ID", nullable = false)),
            @AttributeOverride(name = "roleId", column = @Column(name = "ROLE_ID", nullable = false)) })
    public UsersRolesId getId() {
        return this.id;
    }
    
	public void setId(UsersRolesId id) {
		this.id = id;
	}
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false, insertable = false, updatable = false)
    public Users getUsers() {
        return this.users;
    }
    
	public void setUsers(Users users) {
		this.users = users;
	}
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID", nullable = false, insertable = false, updatable = false)
    public Roles getRoles() {
        return this.roles;
    }
    
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
}
