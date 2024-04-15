package com.Myapp.Productservice_pratice.inheritanceExample.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_ta")

public class TA extends User {
    private String startTime;
    private String endTime;
}
