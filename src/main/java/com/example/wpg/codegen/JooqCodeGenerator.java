package com.example.wpg.codegen;

import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;

public class JooqCodeGenerator {

    public static void main(String[] args) throws Exception {

        Generate generateConfig = new Generate();
        generateConfig.setPojos(true);

        Configuration configuration = new Configuration()
                .withJdbc(new Jdbc()
                        .withDriver("org.postgresql.Driver")
                        .withUrl("jdbc:postgresql://localhost:5432/postgres")
                        .withUser("postgres")
                        .withPassword("pg1234"))
                .withGenerator(new Generator()
                        .withGenerate(generateConfig)
                        .withStrategy(new Strategy().withName("com.example.wpg.codegen.CustomGeneratorStrategy"))
                        .withDatabase(new Database()
                                .withName("org.jooq.meta.postgres.PostgresDatabase")
                                .withIncludes(".*")
                                .withExcludes("")
                                .withInputSchema("wpg"))
                        .withTarget(new Target()
                                .withPackageName("com.example.wpg.db")
                                .withDirectory("target/generated-sources/jooq")));

        GenerationTool.generate(configuration);
    }
}
