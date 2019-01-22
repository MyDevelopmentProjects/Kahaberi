package ge.unknown.data.dto;

/**
 * Created by MJaniko on 10/26/2016.
 */
public class RoleDTO extends SuperDTO {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}