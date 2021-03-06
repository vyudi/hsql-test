package app.dal.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS", schema = "PUBLIC", catalog = "PUBLIC")
public class Users implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
    private String firstName;
    private String lastName;
    private boolean isDisabled;
    private boolean isDeleted;
    private Set<UsersRoles> usersRoleses = new HashSet<UsersRoles>(0);
    
	public Users() {
	}

	public Users(boolean isDisabled, boolean isDeleted) {
		this.isDisabled = isDisabled;
		this.isDeleted = isDeleted;
	}

	public Users(String firstName, String lastName, boolean isDisabled, boolean isDeleted,
			Set<UsersRoles> usersRoleses) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.isDisabled = isDisabled;
		this.isDeleted = isDeleted;
		this.usersRoleses = usersRoleses;
	}
 
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }
    
	public void setId(Integer id) {
		this.id = id;
	}
 
    @Column(name = "FIRST_NAME", length = 128)
    public String getFirstName() {
        return this.firstName;
    }
    
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
 
    @Column(name = "LAST_NAME", length = 128)
    public String getLastName() {
        return this.lastName;
    }
    
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 
    @Column(name = "IS_DISABLED", nullable = false)
    public boolean isIsDisabled() {
        return this.isDisabled;
    }
    
	public void setIsDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}
 
    @Column(name = "IS_DELETED", nullable = false)
    public boolean isIsDeleted() {
        return this.isDeleted;
    }
    
	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
 
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    public Set<UsersRoles> getUsersRoleses() {
        return this.usersRoleses;
    }
    
	public void setUsersRoleses(Set<UsersRoles> usersRoleses) {
		this.usersRoleses = usersRoleses;
	}
}