package app.dal.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ROLES", schema = "PUBLIC", catalog = "PUBLIC", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class Roles implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
    private String name;
    private String description;
    private Set<UsersRoles> usersRoleses = new HashSet<UsersRoles>(0);
    
	public Roles() {
	}
	
	public Roles(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Roles(int id, String name, String description, Set<UsersRoles> usersRoleses) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.usersRoleses = usersRoleses;
	}
 
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
    	this.id = id;
    }
 
    @Column(name = "NAME", unique = true, nullable = false, length = 64)
    public String getName() {
        return this.name;
    }
    
	public void setName(String name) {
		this.name = name;
	}
 
    @Column(name = "DESCRIPTION", length = 256)
    public String getDescription() {
        return this.description;
    }

	public void setDescription(String description) {
		this.description = description;
	}
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    public Set<UsersRoles> getUsersRoleses() {
        return this.usersRoleses;
    }
    
	public void setUsersRoleses(Set<UsersRoles> usersRoleses) {
		this.usersRoleses = usersRoleses;
	}
}