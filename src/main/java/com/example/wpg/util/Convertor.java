package com.example.wpg.util;

import com.example.wpg.db.tables.pojos.OperatorDO;
import com.example.wpg.model.mo.OperatorMO;
import org.modelmapper.ModelMapper;

public class Convertor {

    private static final ModelMapper MAPPER_INSTANCE = new ModelMapper();

    public static <A, B> B convert(A from, Class<B> toClazz) {
        return MAPPER_INSTANCE.map(from, toClazz);
    }

    public static void main(String[] args) {
        OperatorDO operatorDO = new OperatorDO();
        operatorDO.setId("111");
        operatorDO.setName("aaa");

        OperatorMO operatorMO = convert(operatorDO, OperatorMO.class);
        System.out.println(operatorMO);
    }
}
