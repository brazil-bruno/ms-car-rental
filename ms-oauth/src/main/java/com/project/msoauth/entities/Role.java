package com.project.msoauth.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    private Long id;
    private String roleName;

}
