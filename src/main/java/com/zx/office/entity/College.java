package com.zx.office.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class College {
    private int collegeId;
    private String collegeName;
    private List<Professional> professionalList;
}
