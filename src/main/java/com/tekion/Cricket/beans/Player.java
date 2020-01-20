package com.tekion.Cricket.beans;

import com.tekion.Cricket.util.Role;
import lombok.Data;

@Data
public class Player {
    private String name;
    private String DOB;
    private Role role;

}
