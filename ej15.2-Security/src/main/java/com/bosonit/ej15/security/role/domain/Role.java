package com.bosonit.ej15.security.role.domain;

import com.bosonit.ej15.security.role.infraestructure.dto.RoleDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_role", nullable = false)
    private Long idRole;
    private String roleName;

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public Role(RoleDTO roleDTO) {
        setIdRole(roleDTO.getIdRole());
        setRoleName(roleDTO.getRoleName());
    }
}
