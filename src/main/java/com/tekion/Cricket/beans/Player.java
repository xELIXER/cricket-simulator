package com.tekion.Cricket.beans;

import com.tekion.Cricket.util.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Player {
    private String name;
    private String DOB;
    private Role role;
    private int rating[];
}
