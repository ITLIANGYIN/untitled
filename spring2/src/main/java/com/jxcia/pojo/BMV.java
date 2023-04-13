package com.jxcia.pojo;

import com.jxcia.dao.ICar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class BMV implements ICar {
    private String brand;
}
