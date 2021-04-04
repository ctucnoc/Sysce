package com.sys.mype.sysce.pe.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String password;
    private String privilege;
    private int personId;
    private String name;
}
