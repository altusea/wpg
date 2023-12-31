package com.example.wpg.repo;

import com.example.wpg.db.tables.records.OperatorRecord;
import com.example.wpg.model.mo.OperatorMO;
import jakarta.annotation.Resource;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.wpg.db.Tables.OPERATOR;

@Repository
public class OperatorRepo {

    @Resource
    DSLContext context;

    public void insert(OperatorMO newOperator) {
        OperatorRecord operatorRecord = new OperatorRecord();
        operatorRecord.setId(newOperator.id());
        operatorRecord.setName(newOperator.name());
        operatorRecord.setTel(newOperator.tel());
        operatorRecord.setAddr(newOperator.addr());

        context.insertInto(OPERATOR).set(operatorRecord).execute();
    }

    public void upsert(OperatorMO newOperator) {
        OperatorRecord operatorRecord = new OperatorRecord();
        operatorRecord.setId(newOperator.id());
        operatorRecord.setName(newOperator.name());
        operatorRecord.setTel(newOperator.tel());
        operatorRecord.setAddr(newOperator.addr());

        context.insertInto(OPERATOR).set(operatorRecord)
                .onConflict(OPERATOR.ID).doUpdate()
                .set(OPERATOR.NAME, newOperator.name())
                .set(OPERATOR.TEL, newOperator.tel())
                .set(OPERATOR.ADDR, newOperator.addr())
                .execute();
    }

    public List<String> listId() {
        return context
                .select(OPERATOR.ID)
                .from(OPERATOR)
                .fetch().stream().map(Record1::value1).toList();
    }

    public void deleteById(String id) {
        context.delete(OPERATOR).where(OPERATOR.ID.eq(id)).execute();
    }
}
