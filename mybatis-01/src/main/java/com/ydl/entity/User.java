package com.ydl.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User  implements Serializable {

    public static final Long serialVersionUID = 1L;

    private Integer id;
    private String username;
    private String password;

}
