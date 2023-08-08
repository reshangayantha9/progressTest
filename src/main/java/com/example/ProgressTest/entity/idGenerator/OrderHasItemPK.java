package com.example.ProgressTest.entity.idGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHasItemPK implements Serializable {

    private String order;
    private int item;
}
