package com.example.wpg.repo;

import com.example.wpg.db.tables.records.OperatorRecord;
import com.example.wpg.model.mo.OperatorMO;
import jakarta.annotation.Resource;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.wpg.db.Tables.OPERATOR;

@Repository
public class OperatorRepo {

    @Resource
    DSLContext context;

    public void insert(OperatorMO newOperator) {
        OperatorRecord operatorRecord = new OperatorRecord();
        operatorRecord.setId(newOperator.getId());
        operatorRecord.setName(newOperator.getName());
        operatorRecord.setTel(newOperator.getTel());
        operatorRecord.setAddr(newOperator.getAddr());

        context.insertInto(OPERATOR).set(operatorRecord).execute();
    }

    public List<String> listId() {
        return context.selectFrom(OPERATOR).fetch(OPERATOR.ID);
    }
}
