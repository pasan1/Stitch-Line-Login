package com.stitchline.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements UserRoleData{
    @Field(name = "nic")
    @Indexed(unique = true)
    private String nic;
    @Field(name = "empNo")
    @Indexed(unique = true)
    private String empNo;
}
